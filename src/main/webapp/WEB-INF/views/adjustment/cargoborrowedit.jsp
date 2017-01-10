<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#cargoborrwEditForm').form({
            url : '${path }/borrow/add?status='+0,
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
                }
            }
        });
    });
</script>
<div>
    <form id="cargoborrwEditForm" method="post">
        <table class="grid">
            <tr>
                <td>货物名称</td>
                <td><input name="cbName" type="text" class="easyui-validatebox"  data-options="required:true,novalidate:true" readonly value="${cargoBorrow.cbName}"></td>
                <td>货物型号</td>
                <td><input name="cbSkumodel" type="text" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly value="${cargoBorrow.cbSkumodel}"></td>
            </tr>
            <tr>
                <td>归还数量</td>
                <td><input name="cbNum" type="text" class="easyui-numberbox" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargoBorrow.cbNum}"></td>
                <td>归还人</td>
                <td><input name="cbNames" type="text" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly value="${cargoBorrow.cbNames}"/></td>
            </tr>
            <tr>
                <td>归还日期</td>
                <td><input name="cbEndtime" class="easyui-validatebox" placeholder="请选择日期" data-options="required:true,novalidate:true" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
                <td></td>
                <td><input name="cbId" type="hidden" value="${cargoBorrow.cbId}"></td>
            </tr>
        </table>
    </form>
</div>
