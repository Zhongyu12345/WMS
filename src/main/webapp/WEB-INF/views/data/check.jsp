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
	
	var ochart; 
	var options;
	
	
	options ={
	        chart: {
	        	renderTo: 'container',
	            type: 'column'
	        },
	        title: {
	            text: '盘点差异统计表',
	            	style: {  
	                    margin: '10px 100px 0 0', // center it  
	                    font: 'normal 25px Verdana, sans-serif'//设置标题字体的样式  
	                } 
	        },
	        credits: { 
	        	enabled: false //不显示LOGO 
	        },
	        xAxis: {
                categories: ['账上数量','盘点数量','差异数量']
            },
	        yAxis: {
	            allowDecimals: false,
	            title: {
	                text: '数量'
	            }
	        },
	        tooltip: {
	        	pointFormat: '{series.name}: <b>{point.y:.1f} </b>',
                shared: false,//节点数据框共享
                enabled: true,//每个节点显示数据框
                formatter: function() {//格式化每个节点数据框
                    return '<b>'+ this.series.name +'</b>数量: <b>'+ this.y;
                }
	        },
	        series: []
	    };
	
    function searchFun() {
    	var order = document.getElementById("order").value;
    	ochart = new Highcharts.Chart(options);
    	$.ajax({
    		mothod : 'post',
    		dataType : 'json',
    		url :'${path}/check/selectc?checknum='+order,
    		success :function(data) {
    			for(var i in data){  
    	            var oseries ={
    	            	name : data[i].miName,
    	            	data : eval("[" + parseInt(data[i].miNum) + ","+parseInt(data[i].miActual)+","+
    	            	              (parseInt(data[i].miActual)-parseInt(data[i].miNum))+"]")
    	            };
    	            ochart.addSeries(oseries);     
    			}
    		}
    	});
    	ochart.hideLoading();
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
	
</body>
</html>
