<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务统计</title>
<script type="text/javascript">
	$(function() {
	
		$('#years').combobox({
			url:'${path}/income/YearCombobox',
			editable:false,
			valueField:'yearId',
			textField:'year',
		});
		
	})
	function searchFun(){
		var n = $("#years").combobox("getValue");
		$.ajax({
    		mothod : 'post',
    		dataType : 'json',
    		url :'${path}/income/searchPage?year='+n,
    		success :function(data) {
    			for(var a=0;a<3;a++){
	    			document.getElementById("ione"+a).innerHTML = (data[a].one);
	    			document.getElementById("itwo"+a).innerHTML = (data[a].two);
	    			document.getElementById("ithree"+a).innerHTML = (data[a].three);
	    			document.getElementById("ifour"+a).innerHTML = (data[a].four);
	    			document.getElementById("ifive"+a).innerHTML = (data[a].five);
	    			document.getElementById("isix"+a).innerHTML = (data[a].six);
	    			document.getElementById("iseven"+a).innerHTML = (data[a].seven);
	    			document.getElementById("ieight"+a).innerHTML = (data[a].eight);
	    			document.getElementById("inine"+a).innerHTML = (data[a].nine);
	    			document.getElementById("iten"+a).innerHTML = (data[a].ten);
	    			document.getElementById("ieleven"+a).innerHTML = (data[a].eleven);
	    			document.getElementById("itwelve"+a).innerHTML = (data[a].twelve);
	    			document.getElementById("icount"+a).innerHTML = (data[a].count);
    			}
    		}
    	});
	}
</script>
</head>
<style>
	table.gridtable{
	font-family:verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width:1px;
	border-color:#666666;
	border-collapse:collapse;
	align:center;
	width:100%;
	}
	table.gridtable th{
	border-width:1px;
	padding:8px;
	border-style:solid;
	border-color:#666666;
	background-color:#dedede;
	}
	table.gridtable td{
	border-width:1px;
	padding:8px;
	border-style:solid;
	border-color:#666666;
	background-color:#ffffff;
	}
</style>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>年份:</th>
                    <td>
                    	<input name="years" id="years" class="easyui-combobox" value="2017"/>
                    </td>
                    <td>
                  		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    
    <div style="width:auto;height:500px;margin-top:100px;">
    <h1 style="font-size:30px;margin-left:40%;align:center;">年收支财务统计</h1>
    	<table class="gridtable">
    		<tr>
    			<th>月份</th>
    			<td>一月份</td><td>二月份</td><td>三月份</td><td>四月份</td><td>五月份</td><td>六月份</td>
    			<td>七月份</td><td>八月份</td><td>九月份</td><td>十月份</td><td>十一月份</td><td>十二月份</td><td>总额（元）</td>
    		</tr>
    		<tr>
    			<th>收入</th>
    			<td><div id="ione0"></div></td><td><div id="itwo0"></div></td><td><div id="ithree0"></div></td><td><div id="ifour0"></div></td><td><div id="ifive0"></div></td><td><div id="isix0"></div></td>
    			<td><div id="iseven0"></div></td><td><div id="ieight0"></div></td><td><div id="inine0"></div></td><td><div id="iten0"></div></td><td><div id="ieleven0"></div></td><td><div id="itwelve0"></div></td><td><div id="icount0"></div></td>
    		</tr>
    		<tr>
    			<th>支出</th>
    			<td><div id="ione1"></div></td><td><div id="itwo1"></div></td><td><div id="ithree1"></div></td><td><div id="ifour1"></div></td><td><div id="ifive1"></div></td><td><div id="isix1"></div></td>
    			<td><div id="iseven1"></div></td><td><div id="ieight1"></div></td><td><div id="inine1"></div></td><td><div id="iten1"></div></td><td><div id="ieleven1"></div></td><td><div id="itwelve1"></div></td><td><div id="icount1"></div></td>
    		</tr>
    		<tr>
    			<th>小计</th>
    			<td><div id="ione2"></div></td><td><div id="itwo2"></div></td><td><div id="ithree2"></div></td><td><div id="ifour2"></div></td><td><div id="ifive2"></div></td><td><div id="isix2"></div></td>
    			<td><div id="iseven2"></div></td><td><div id="ieight2"></div></td><td><div id="inine2"></div></td><td><div id="iten2"></div></td><td><div id="ieleven2"></div></td><td><div id="itwelve2"></div></td><td><div id="icount2"></div></td>
    		</tr>
    	</table>
    </div>
</body>
</html>