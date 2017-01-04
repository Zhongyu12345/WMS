<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="${staticPath }/static/js/warehouse.js" charset="utf-8"></script>
<script type="text/javascript">
    $(function () {
        $('#shipmentAddForm').form({
            url: '${path }/shipment/shipment',
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
        <form id="shipmentAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>货主</td>
                    <td><input name="shStoreid" type="text" placeholder="请输入货主" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                    <td>实际出货时间</td>
                    <td><input name="addtime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>号码</td>
                    <td><input name="shPhone" type="text" placeholder="请输入号码" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                </tr>
                <tr>
                    <td>仓库</td>
                    <td><input name="shWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
                    <td>损坏数量</td>
                    <td><input name="shDamage" type="number" placeholder="请输入损坏数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                </tr>
                <tr>
                    <td>损坏原因</td>
                    <td colspan="3"><textarea rows="3" cols="40" name="shCause" style="width: 397px;height: 50px;"></textarea></td>
                </tr>
                <tr>
                    <td>型号</td>
                    <td><input name="shSkumodel" type="text" placeholder="请输入型号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                    <td>实际出货数量</td>
                    <td><input name="shShnum" type="text" placeholder="请输入实际出货数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                </tr>
                <tr>
                    <td>发货毛重</td>
                    <td><input name="shTotalweigh" type="text" placeholder="请输入发货毛重" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                    <td>发货体积</td>
                    <td><input name="shTotalvolume" type="text" placeholder="请输入发货体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true"></td>
                </tr>
            </table>
        </form>
    </div>
</div>