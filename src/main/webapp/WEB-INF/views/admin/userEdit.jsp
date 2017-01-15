<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        var roleIds = ${roleIds };
        $('#roleIds').combotree({
            url : '${path }/role/tree',
            parentField : 'pid',
            lines : true,
            panelHeight : 'auto',
            multiple : true,
            required : true,
            cascadeCheck : false,
            value : roleIds
        });

        $('#userEditForm').form({
            url : '${path }/user/edit',
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
        $("#sex").val('${user.sex}');
        $("#userType").val('${user.userType}');
        $("#status").val('${user.status}');
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="userEditForm" method="post">
            
            <table class="grid">
                <tr>
                    <td>登录名</td>
                    <td><input name="id" type="hidden"  value="${user.id}">
                    <input name="loginName" type="text" placeholder="请输入登录名称" class="easyui-validatebox" data-options="required:true" value="${user.loginName}"></td>
                    <td>姓名</td>
                    <td><input name="name" type="text" placeholder="请输入姓名" class="easyui-validatebox" data-options="required:true" value="${user.name}"></td>
                </tr>
                <tr>
                    <!-- <td>密码</td>
                    <td><input type="text" name="password"/></td> -->
                    <td>性别</td>
                    <td><select name="sex" id="sex"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0">男</option>
                            <option value="1">女</option>
                    </select></td>
                    <td>电话</td>
                    <td>
                        <input type="text" name="phone" class="easyui-numberbox" value="${user.phone}"/>
                    </td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="age" value="${user.age}" class="easyui-numberbox"/></td>
                    <td>用户类型</td>
                    <td><select id="userType" name="userType"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0">管理员</option>
                            <option value="1">用户</option>
                    </select></td>
                </tr>
                <tr>
                    <td>角色</td>
                    <td><input  id="roleIds" name="roleIds" style="width: 140px; height: 29px;"/></td>
                    <td>用户类型</td>
                    <td><select id="state" name="status" value="${user.status}" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0">正常</option>
                            <option value="1">停用</option>
                    </select></td>
                </tr>
                
            </table>
        </form>
    </div>
</div>