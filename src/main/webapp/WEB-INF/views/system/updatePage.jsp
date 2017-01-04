<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<script type="text/javascript">
 function updateUser() {
     parent.$.modalDialog({
         title : '编辑',
         width : 300,
         height : 400,
         href : '${path }/user/updatePage',
         buttons : [ {
             text : '确定',
             handler : function() {
                 var f = parent.$.modalDialog.handler.find('#userUpdateForm');
                 f.submit();
             }
         } ]
     });
 }
</script>
</head>
<body>
    <table class="datagrid">
	    <tr>
	        <td>登录名</td>
			<td></td>
	        <td><input name="id" type="hidden"  value="${user.id}">
	        <input name="loginName" type="text" class="easyui-textbox" value="${user.loginName}" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly></td>
	   	</tr>
	    <tr>
	        <td>姓名</td>
			<td></td>
	        <td><input name="name" type="text" class="easyui-textbox" value="${user.name}" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly></td>
	    </tr>
	    <tr>
	        <!-- <td>密码</td>
	        <td><input type="text" name="password"/></td> -->
	        <td>性别</td>
			<td></td>
	        <td><select name="sex" id="sex"  class="easyui-combobox" value="${user.sex}" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly>
	                <option value="0">男</option>
	                <option value="1">女</option>
	        </select></td>
	    </tr>
	    <tr>
	        <td>年龄</td>
			<td></td>
	        <td><input type="text" name="age" value="${user.age}" class="easyui-numberbox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly/></td>
	    </tr>
	    <tr>
	        <td>电话</td>
			<td></td>
	        <td>
	            <input type="text" name="phone" class="easyui-numberbox" value="${user.phone}" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly/>
	        </td>
	    <tr>
	        <td>用户类型</td>
			<td></td>
	        <td><select id="userType" name="userType" value="${user.userType}" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly>
	                <option value="0">管理员</option>
	                <option value="1">用户</option>
	        </select></td>
	    </tr>
	    <tr>
	        <td>用户类型</td>
			<td></td>
	        <td><select id="status" name="status" value="${user.status}" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" readonly>
	                <option value="0">正常</option>
	                <option value="1">停用</option>
	        </select></td>
	    </tr>
	    <tr>
			<td></td>
      		<td><a href="#" class="easyui-linkbutton" onclick="updateUser();">编辑</a></td>
  		</tr>
	</table>
</body>
</html>