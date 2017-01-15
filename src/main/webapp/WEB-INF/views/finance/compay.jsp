<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户总览</title>
</head>
<style>
	.hourse{
		width:400px;
		height:400px;
		background:url(../static/style/images/hourse.jpg) no-repeat 5px 5px;
	}
</style>
<body>
	<h1 style="font-size:30px;margin-left:40%;align:center;">公司总金</h1>
	<div class="hourse">
		<table>
			<tr><td style="height:195px;"></td></tr>
			<tr>
				<td style="width:70px;"></td>
				<td style="font-size:21px;">本金</td>
				<td style="font-size:21px;">${compay.camoney }元</td>
			</tr>
			<tr>
				<td style="width:70px;"></td>
				<td style="font-size:21px;">总金</td>
				<td style="font-size:21px;">${compay.cacount }元</td>
			</tr>
		</table>
	</div>
</body>
</html>