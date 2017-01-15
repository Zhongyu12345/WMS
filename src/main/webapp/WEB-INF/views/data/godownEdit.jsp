<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#godownEditForm').form({
            url : '${path }/godown/edit',
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
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="godownEditForm" method="post">
            
            <table class="grid">
                <tr>
                    <td>扩充容积</td>
                    <td>
                    	<input name="goId" type="hidden" value="${godown.goId}">
                    	<input name="goVolume" type="hidden" value="${godown.goVolume}">
                    	<input name="goRdvolume" type="hidden" value="${godown.goRdvolume}">
                    	<input name="add" type="number" placeholder="请输入需扩充容积" class="easyui-validatebox" data-options="required:true,novalidate:true">&nbsp;m³
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>