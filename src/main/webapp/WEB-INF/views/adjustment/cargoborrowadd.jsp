<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {

        $('#roleIds').combotree({
            url: '${path }/role/tree',
            multiple: true,
            required: true,
            panelHeight : 'auto'
        });

        $('#cargoborrwAddForm').form({
            url : '${path }/borrow/add',
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
        <form id="cargoborrwAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input name="cbName" type="text" placeholder="请输入货物名称" class="easyui-validatebox"  data-options="required:true,novalidate:true" value=""></td>
                    <td>货物型号</td>
                    <td><input name="cbSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""></td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td><input name="cbNum" type="text" class="easyui-numberbox" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""></td>
                    <td>借用人</td>
                    <td><input name="cbNames" type="text" placeholder="请选择借用人姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""/></td>
                </tr>
                <tr>
                    <td>日期</td>
                    <td><input name="cbTime" placeholder="请选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>原因</td>
                    <td colspan="3"><textarea rows="3" cols="30" name="cbCause" style="width: 240px;height: 50px;"></textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>