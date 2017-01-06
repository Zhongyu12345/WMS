<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript">
    $(function() {
    	
    	$("#selectCombobox").combobox({
    	    url:"${path}/godown/godownComboBox",
    	    method: 'get',
    	    valueField: 'id',
    	    textField: 'text',
    	    editable:false,
    	    panelHeight: 'auto',
    	    onLoadSuccess: function () {
    	        var data = $('#selectCombobox').combobox('getData');
    	        if (data.length > 0) {
    	            $("#selectCombobox").combobox('select', '${allotput.apWhid}');
    	        }
    	    }
    	});
    	
    	
        $('#allotputEditForm').form({
            url : '${path }/allotput/update',
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
        <form id="allotputEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input name="apId" type="hidden"  value="${allotput.apId}">
                    <input name="apName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${allotput.apName}"></td>
                    <td>货物型号</td>
                    <td><input name="apSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${allotput.apSkumodel}" /></td>
                </tr>
                 <tr>
                    <td>调拨数量</td>
                    <td><input name="apNum" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${allotput.apNum}" /></td>
                    <td>货物体积</td>
                    <td>
                    <input name="oldVolume" type="hidden"  value="${allotput.apVolume}">
                    <input name="apVolume" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${allotput.apVolume}"></td>
                </tr>
                <tr>
                    <td>仓库编号</td>
                    <td>
                    <input name="oldWhid" type="hidden"  value="${allotput.apWhid}">
                    <input name="apWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
                    <td>调拨单号</td>
                    <td><input name="apSipping" type="text" placeholder="请输入调拨单号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${allotput.apSipping}"></td>
                </tr>
                 <tr>
                    <td>调拨时间</td>
                    <td>
                    <input name="time" style="whith:100%" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})"  value="<fmt:formatDate pattern="yyyy-MM-dd " value="${allotput.apTime}" />" readonly="readonly" />
                </tr>
            </table>
        </form>
    </div>
</div>