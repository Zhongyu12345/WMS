<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript">
    $(function() {
    	
    	$("#selectCombobox").combobox({
    	    url:"${path}/godown/godownComboBox",
    	    method: 'get',
    	    valueField: 'id',
    	    editable:false,
    	    textField: 'text',
    	    panelHeight: 'auto',
    	    onLoadSuccess: function () {
    	        var data = $('#selectCombobox').combobox('getData');
    	        if (data.length > 0) {
    	            $("#selectCombobox").combobox('select', '${user.rWhid}');
    	        }
    	    }
    	});
        $('#receivingEditForm').form({
            url : '${path }/receiving/update',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('enableValidation').form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    parent.$.modalDialog.handler.dialog('close');
                    parent.$.messager.alert('提示', result.msg, 'info');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });
        $("#rCrossflag").val('${user.rCrossflag}');
        $("#rDirectflag").val('${user.rDirectflag}');
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false" >
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px; ">
        <form id="receivingEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input name="rId" type="hidden"  value="${user.rId}">
                    <input name="rName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rName}"></td>
                    <td>货主</td>
                    <td><input name="rStorerid" type="text" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rStorerid}"></td>
                </tr>
                <tr>
                    <td>货物型号</td>
                    <td><input name="rSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rSkumodel}" /></td>
                    <td>货主号码</td>
                    <td><input name="rPhone" type="text" validtype="mobile" placeholder="请输入货主号码" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rPhone}"></td>
                </tr>
                <tr>
                    <td>供应商</td>
                    <td><input name="rSupplierid" type="text" placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rSupplierid}" /></td>
                    <td>客户托单号</td>
                    <td><input name="rSippingno" type="text" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rSippingno}"></td>
                </tr>
                 <tr>
                    <td>仓库</td>
                    <td>
                    <input name="oldWhid" type="hidden"  value="${user.rWhid}">
                    <input name="rWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
                    <td>入库体积</td>
                    <input name="oldVolume" type="hidden"  value="${user.rNum}">
                    <td><input name="rNum" type="text" validtype="intOrFloat" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.rNum}"></td>
                </tr>
                 <tr>
                    <td>是否越库</td>
                    <td>
                    <input name="oldCrossflag" type="hidden"  value="${user.rCrossflag}">
                    <select id="rCrossflag" name="rCrossflag" value="${user.rCrossflag}" class="easyui-combobox" data-options="width:80,height:22,editable:false,panelHeight:'auto'">
                            <option value="0">越库</option>
                            <option value="1">不越库</option>
                    </select></td>
                    <td>是否整进</td>
                    <td><select id="rDirectflag" name="rDirectflag" value="${user.rDirectflag}" class="easyui-combobox" data-options="width:80,height:22,editable:false,panelHeight:'auto'">
                            <option value="0">整进</option>
                            <option value="1">不整进</option>
                    </select></td>
                </tr>
                 <tr>
                    <td>入库时间</td>
                    <td>
                    <input name="time" style="whith:100%" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${user.rTime}" />" readonly="readonly" />
                    <td>管理员</td>
                    <td><input name="adminname" type="text" readonly="readonly" placeholder="请输入管理员" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${user.adminname}"></td>
                </tr>
            </table>
        </form>
    </div>
</div>