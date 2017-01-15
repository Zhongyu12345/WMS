<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#tariffAddForm').form({
            url : '${path }/tariff/add',
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
                    parent.$.messager.alert('提示', result.msg, 'warning');
                }
            }
        });
    });
    
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="tariffAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>收费原因</td>
                    <td><input name="cause" type="text" placeholder="请输入收费原因" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""></td>
                </tr>
                <tr>
                	<td>重量范围（输入值以内）</td>
                    <td><input name="scope" type="number" placeholder="请输入重量值" class="easyui-validatebox" data-options="required:true,novalidate:true"></td>
                </tr>
                <tr>
                    <td>金额</td>
                    <td><input name="money" type="number" placeholder="请输入金额" class="easyui-validatebox" data-options="required:true,novalidate:true"></td>
                </tr>
                <tr>
                    <td>单位（例如:元/kg）</td>
                    <td><input name="unit" type="text" placeholder="请输入单位" class="easyui-validatebox" data-options="required:true,novalidate:true"></td>
                </tr>
            </table>
        </form>
    </div>
</div>