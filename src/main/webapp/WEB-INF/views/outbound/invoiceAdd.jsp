<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="${staticPath }/static/js/warehouse.js" charset="utf-8"></script>
<script type="text/javascript">
    $(function () {
        $('#invoiceAddForm').form({
            url: '${path }/invoice/invoice',
            onSubmit: function () {
                progressLoad();
                var isValid = $(this).form('enableValidation').form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success: function (result) {
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
        <form id="invoiceAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input name="inName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"/></td>
                    <td>货物型号</td>
                    <td><input name="inSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"/></td>
                </tr>
                <tr>
                    <td>发货数量</td>
                    <td><input name="inNum" type="text" placeholder="请输入发货数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                    <td>仓库编号</td>
                    <!--
                    <td><input name="inWhid" type="text" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"/></td>
                    -->
                    <td><input name="inWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
                </tr>
                <tr>
                    <td>发货时间</td>
                    <td><input name="byTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"/></td>
                    <td>货物体积</td>
                    <td><input name="inVolume" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                </tr>
            </table>
        </form>
    </div>
</div>