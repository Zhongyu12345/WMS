<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {

        $('#CargoEditForm').form({
            url : '${path }/cargo/update',
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
        <form id="CargoEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input name="cName" type="text" class="easyui-validatebox"  data-options="required:true,novalidate:true" value="${cargo.cName}"></td>
                    <td>货主</td>
                    <td><input name="cStorerid" type="text" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cStorerid}"></td>
                </tr>
                <tr>
                    <td>供应商</td>
                    <td><input  name="cSupplierid" type="text"  class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cSupplierid}"></td>
                    <td>仓库编码</td>
                    <td><input name="cWhid" type="text" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cWhid}"></td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td><input name="cNum" type="text" class="easyui-numberbox" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cNum}"></td>
                    <td>总货毛重</td>
                    <td><input name="cTotalweight" type="text" class="easyui-numberbox" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cTotalweight}"></td>
                </tr>
                <tr>
                    <td>总货体积</td>
                    <td><input name="cTotalvolume" type="text" class="easyui-numberbox" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cTotalvolume}"></td>
                    <td>入库时间</td>
                    <td><input name="cReceivedate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cargo.cReceivedate}" />"  onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>货物型号</td>
                    <td><input name="cSkumodel" type="text" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${cargo.cSkumodel}"></td>
                    <td></td>
                    <td><input name="cId" type="text" hidden value="${cargo.cId}">
                </tr>
            </table>
        </form>
    </div>
</div>