<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>盘点差异表</title>

<script type="text/javascript" src="${staticPath }/static/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
	$(function () {
	    
	});

    function searchFun() {
    	var order = document.getElementById("order").value;
    	$.ajax({
    		mothod : 'post',
    		url :'${path}/check/selectc?checknum='+order,
    		success :function(data) {
    			var chart = $('#container').highcharts({
    		        data: {
    		            table: 'datatable'
    		        }, 
    		        chart: {
    		            type: 'column'
    		        },
    		        title: {
    		            text: '盘点差异统计表'
    		        },
    		        credits: { 
    		        	enabled: false //不显示LOGO 
    		        },
    		        yAxis: {
    		            allowDecimals: false,
    		            title: {
    		                text: '数量'
    		            }
    		        },
    		        tooltip: {
    		            formatter: function () {
    		                return '<b>' + this.series.name + '</b><br/>' +
    		                    this.point.y + ' ' + this.point.name.toLowerCase();
    		            }
    		        }
    		    });
    		}
    	});
    }
    function cleanFun() {
        $('#searchForm input').val('');
        window.location.reload();
    }
   
</script>		
</head>
<body>
<script src="${staticPath }/static/js/highcharts.js"></script>
<script src="${staticPath }/static/js/data.js"></script>
<script src="${staticPath }/static/js/exporting.js"></script>

    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>盘点单号:</th>
                    <td>
                    <input type="text" id="order" name="checknum" placeholder="请输入单号"/>
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	
	<table id="datatable">
	    <thead>
	        <tr>
	            <th></th>
	            <th>账上数量</th>
	            <th>实际数量</th>
	            <th>差异数</th>
	        </tr>
	    </thead>
	    <tbody>
	   <c:forEach items="${makeInventory}" var="m">
	        <tr>
	            <th>${m.miName }</th>
	            <td>${m.miNum }</td>
	            <td>${m.miActual }</td>
	            <td>2</td>
	        </tr>
	    </c:forEach>
	        <!-- <tr>
	            <th>Pears</th>
	            <td>2.0</td>
	            <td>1.0</td>
	            <td>20</td>
	        </tr>
	        <tr>
	            <th>Plums</th>
	            <td>500</td>
	            <td>11</td>
	            <td>6</td>
	        </tr>
	        <tr>
	            <th>Bananas</th>
	            <td>1</td>
	            <td>1</td>
	            <td>0</td>
	        </tr>
	        <tr>
	            <th>Oranges</th>
	            <td>2</td>
	            <td>4</td>
	            <td>2</td>
	        </tr> -->
	    </tbody>
	</table>
</body>
</html>
