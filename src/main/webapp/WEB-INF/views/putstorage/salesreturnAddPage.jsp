<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< Updated upstream
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
			alert(srCause);
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
				if (data.result) {
=======
<title>收货入库确认</title>
    <script type="text/javascript">   
    
    function save(){
    	 /* $('#godownEntryForm').form({
             url : '${path }/putstorage/save',
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
                 } else {
                     parent.$.messager.alert('提示', result.msg, 'warning');
                 }
             }
         }); */
    	
    	
    	if ($("#godownEntryForm").form("validate")) { // 验证整个表单里的所有validatabox是否通过验证
			var gName = $("#gName").val();
			var gSupplierid = $("#gSupplierid").val();
			var gSippingno = $("#gSippingno").val();
			var gStorerid = $("#gStorerid").val();
			var gWhid = $("#gWhid").val();
			var gNum = $("#gNum").val();
			var gCrossflag = $("#gCrossflag").val();
			var gDirectflag = $("#gDirectflag").val();
			var gPhone = $("#gPhone").val();
			var gAdminid = $("#gAdminid").val();
			var gSkumodel = $("#gSkumodel").val();
			var gTime = $("#gTime").datetimebox("getValue");
			$.post('${path }/putstorage/save', {
				"gName" : gName,
				"gSupplierid":gSupplierid,
				"gSippingno":gSippingno,
				"gStorerid":gStorerid,
				"gWhid":gWhid,
				"gNum":gNum,
				"gCrossflag":gCrossflag,
				"gDirectflag":gDirectflag,
				"gPhone":gPhone,
				"gAdminid":gAdminid,
				"gSkumodel":gSkumodel,
				"gTime":gTime
			}, function(data) {
				if (data.success) {
>>>>>>> Stashed changes
					alert("true");
					$.messager.alert("提示", data.msg, "info", function() {
						alert("sssss");
					});
				} else {
<<<<<<< Updated upstream
					$('#salesreturnForm input').val('');
					$('#srCause').textbox('setValue','');
					$.messager.alert('提示','添加成功');
=======
					$.messger.alert("提示", data.msg, "info");
>>>>>>> Stashed changes
				}
			});
		}
    }
    
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<<<<<<< Updated upstream
	<div id="salesreturn" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px ;solid :red;">
		<div id="mytitle" style="background:#ddd;padding:5px;">退货单</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="salesreturnForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="srName" name="srName" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="srSipping" name="srSipping" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text" id="srSkumodel" name="srSkumodel" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true" /></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="srStorerid"  name="srStorerid" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true" /></td>
	                	<th>退货体积:</th>
	                	<td><input type="text" validtype="intOrFloat" id="srVolume"  name="srVolume" placeholder="请输入退货体积" class="easyui-validatebox" data-options="required:true" /></td>
	                	<th>仓库编号:</th>
	                	<td><input type="text"  id="srWhid"  name="srWhid" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true" /></td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" validtype="mobile" id="srPhone" name="srPhone" placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true" /></td>
	                	<th>退货时间:</th>
	                    <td><input placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})"   readonly="readonly" id="srTime" name="srTime" /></td>
	                    <th>退货数量:</th>
	                    <td><input type="text" id="srNum" validtype="integer" name="srNum" placeholder="请输入退货数量" class="easyui-validatebox" data-options="required:true" /></td>
	                </tr>
	                <tr>
	                	<th>退货原因:</th>
	                    <td colspan="5"><input style="width:100%;height:50px;" id="srCause" name="srCause" type="text" validtype="unnormal" class="easyui-textbox" data-options="multiline:true" placeholder="请输入退货原因" ></td>
=======
	<div id="GodownEntry" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">入库计划</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="godownEntryForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="gName" name="gName" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>供应商:</th>
	                    <td><input type="text" id="gSupplierid" name="gSupplierid" /></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="gSippingno" name="gSippingno" /></td>
	                    <th>入库编码:</th>
	                    <td><input type="text" id="gWhid" name="gWhid" /></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="gStorerid"  name="gStorerid" /></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="gNum" name="gNum" /></td>
	                    <th>是否越库:</th>
	                    <td><input type="text"  id="gCrossflag" name="gCrossflag" /></td>
	                    <th>是否整进整出:</th>
	                    <td><input type="text"  id="gDirectflag" name="gDirectflag" /></td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" id="gPhone" name="gPhone" /></td>
	                	<th>入库计划时间:</th>
	                    <td><input class="easyui-datetimebox" id="gTime" name="gTime" /></td>
	                    <th>管理员编号:</th>
	                    <td><input type="text" id="gAdminid" name="gAdminid" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="gSkumodel" name="gSkumodel" /></td>
	                </tr>
	            </table>
	        </form>
	    </div></div>
	</div>

	<div id="receiving" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:200px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">实际入库</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="receivingForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="rName"  name="rName" placeholder="请输入货物名称"/></td>
	                    <th>供应商:</th>
	                    <td><input type="text"  id="rSupplierid"  name="rSupplierid" /></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text"  id="rSippingno"  name="rSippingno" /></td>
	                    <th>入库编码:</th>
	                    <td><input type="text"  id="rWhid"  name="rWhid" /></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="rStorerid" name="rStorerid" /></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="rNum" name="rNum" /></td>
	                    <th>是否越库:</th>
	                    <td><input type="text"  id="rCrossflag"  name="rCrossflag" /></td>
	                    <th>是否整进整出:</th>
	                    <td><input type="text"  id="rDirectflag"  name="rDirectflag" /></td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text"  id="rPhone" name="rPhone" /></td>
	                	<th>入库时间:</th>
	                    <td><input class="easyui-datetimebox"  id="rTime" name="rTime" /></td>
	                    <th>管理员编号:</th>
	                    <td><input type="text"  id="rAdminid" name="rAdminid" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="rSkumodel"  name="rSkumodel" /></td>
	                </tr>
	                <tr>
	                	<th>是否全部到货:</th>
	                	<td><input type="text"  id="rPartflag"  name="rPartflag" /></td>
>>>>>>> Stashed changes
	                </tr>
	            </table>
	        </form>
	    </div></div>
<<<<<<< Updated upstream
	    
	    <div>
			<a href="javascript:void(0);" style="margin-left: 800px;" class="easyui-linkbutton" onclick="save();">确认</a>
		</div>
	</div>

	
=======
	</div>
	
	<div>
		<a href="javascript:void(0);" class="easyui-linkbutton" onclick="save();">确认</a>
	</div>
>>>>>>> Stashed changes
</body>
</html>