<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript" src="${staticPath }/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript">
    $(function() {
        $('#noticeEditForm').form({
            url : '${path }/notice/edit',
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
                    parent.$.messager.alert('提示', result.msg, 'info');
                    window.location.href = '${path }/notice/message';
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });

        $("#nstatus").val('${notice.nstatus}');
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="noticeEditForm" method="post">
            
            <table class="grid">
                <tr>
                    <td>状态</td>
                    <td><select name="nstatus" id="nstatus"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="0">上架</option>
                        <option value="1">下架</option>
                    </select></td>
                    <td>发布时间</td>
                    <td>
                        <input name="ntime" style="whith:100%" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${notice.ntime}" />" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <input name="nid" type="hidden"  value="${notice.nid}">
                    <input name="userid" type="hidden"  value="${notice.userid}">
                    <td>公告内容</td>
                    <td colspan="5"><input style="width:94%;height:50px;" id="text" name="text" value="${notice.text}" type="text" validtype="unnormal" class="easyui-textbox" data-options="multiline:true,novalidate:true" placeholder="请输入公告内容" ></td>
                </tr>
            </table>
        </form>
    </div>
</div>

