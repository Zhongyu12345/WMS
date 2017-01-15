<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#payAddForm').form({
            url : '${path }/pay/add',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
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
        <form id="payAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>支出时间:</td>
                    <td>
                        <input type="text" name="ptime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>支出金额:</td>
                    <td><input type="text" name="ppay" placeholder="支出金额"/></td>
                </tr>
                <tr>
                    <td>支出原因:</td>
                    <td colspan="5"><textarea name="pcause" rows="" cols="" ></textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>
