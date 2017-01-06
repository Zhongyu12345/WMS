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
    	            $("#selectCombobox").combobox('select', '${salesreturn.srWhid}');
    	        }
    	    }
    	});
    	
        $('#salesreturnEditForm').form({
            url : '${path }/salesreturn/update',
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
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false" >
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px; ">
        <form id="salesreturnEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input name="srId" type="hidden"  value="${salesreturn.srId}">
                    <input name="srName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srName}"></td>
                    <td>货主</td>
                    <td><input name="srStorerid" type="text" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srStorerid}"></td>
                </tr>
                <tr>
                    <td>货物型号</td>
                    <td><input name="srSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srSkumodel}" /></td>
                    <td>货主号码</td>
                    <td><input name="srPhone" type="text" validtype="mobile" placeholder="请输入货主号码" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srPhone}"></td>
                </tr>
                <tr>
                    <td>客户托单号</td>
                    <td><input name="srSipping" type="text" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srSipping}"></td>
                    <td>退货数量</td>
                    <td><input name="srNum" type="text" validtype="integer" placeholder="请输入退货数量" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srNum}" /></td>
                </tr>
                 <tr>
                    <td>仓库</td>
                    <td>
                    <input name="oldWhid" type="hidden"  value="${salesreturn.srWhid}">
                    <input name="srWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
                    <td>退货体积</td>
                    <td>
                    <input name="oldVolume" type="hidden"  value="${salesreturn.srVolume}">
                    <input name="srVolume" type="text" validtype="intOrFloat" placeholder="请输入退货体积" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${salesreturn.srVolume}"></td>
                </tr>
                 <tr>
                    <td>退货时间</td>
                    <td>
                    <input name="time" style="whith:100%" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${salesreturn.srTime}" />" readonly="readonly" />
                </tr>
                <tr>
                 	<td>退货原因</td>
                    <td colspan="3"><input style="width:100%;height:100%" name="srCause" type="text" validtype="unnormal" class="easyui-textbox" data-options="multiline:true,novalidate:true" placeholder="请输入退货原因"  value="${salesreturn.srCause}"></td>
                </tr>
            </table>
        </form>
    </div>
</div>