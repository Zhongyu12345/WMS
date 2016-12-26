<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>盘点差异表</title>

<script type="text/javascript" src="${staticPath }/static/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
	$(function () {
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
	});

    function searchFun() {
        window.location.reload();
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
                    <input type="text" name="checknum" placeholder="请输入单号"/>
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
	        <tr>
	            <th>Apples</th>
	            <td>3</td>
	            <td>4</td>
	            <td>1</td>
	        </tr>
	        <tr>
	            <th>Pears</th>
	            <td>2</td>
	            <td>0</td>
	            <td>2</td>
	        </tr>
	        <tr>
	            <th>Plums</th>
	            <td>5</td>
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
	        </tr>
	    </tbody>
	</table>
</body>
</html>
