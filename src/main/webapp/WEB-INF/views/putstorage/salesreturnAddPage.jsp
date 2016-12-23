<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退货单</title>
    <script type="text/javascript">   
    
    function save(){
    	if ($("#salesreturnForm").form("validate")) { // 验证整个表单里的所有validatabox是否通过验证
			var srName = $("#srName").val();
			var srSipping = $("#srSipping").val();
			var srSkumodel = $("#srSkumodel").val();
			var srStorerid = $("#srStorerid").val();
			var srVolume = $("#srVolume").val();
			var srWhid = $("#srWhid").val();
			var srPhone = $("#srPhone").val();
			var srNum = $("#srNum").val();
			var srCause = $("#srCause").val();
			var srTime = $("#srTime").val();
			$.post('${path }/salesreturn/save', {
				"srName" : srName,
				"srSipping":srSipping,
				"srSkumodel":srSkumodel,
				"srStorerid":srStorerid,
				"srVolume":srVolume,
				"srWhid":srWhid,
				"srPhone":srPhone,
				"srNum":srNum,
				"srCause":srCause,
				"time":srTime
			}, function(data) {
				if (data.success) {
					alert("true");
					$.messager.alert("提示", data.msg, "info", function() {
						alert("sssss");
					});
				} else {
					$.messger.alert("提示", data.msg, "info");
				}
			});
		}
    }
    
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="salesreturn" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">退货单</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="salesreturnForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="srName" name="srName" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="srSipping" name="srSipping" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text" id="srSkumodel" name="srSkumodel" /></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="srStorerid"  name="srStorerid" /></td>
	                	<th>退货体积:</th>
	                	<td><input type="text"  id="srVolume"  name="srVolume" /></td>
	                	<th>仓库编号:</th>
	                	<td><input type="text"  id="srWhid"  name="srWhid" /></td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" id="srPhone" name="srPhone" /></td>
	                	<th>退货时间:</th>
	                    <td><input placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})"   readonly="readonly" id="srTime" name="srTime" /></td>
	                    <th>退货数量:</th>
	                    <td><input type="text" id="srNum" name="srNum" /></td>
	                    <th>退货原因:</th>
	                    <td><input type="text"  id="srCause" name="srCause" /></td>
	                </tr>
	            </table>
	        </form>
	    </div></div>
	</div>

	<div>
		<a href="javascript:void(0);" class="easyui-linkbutton" onclick="save();">确认</a>
	</div>
</body>
</html>