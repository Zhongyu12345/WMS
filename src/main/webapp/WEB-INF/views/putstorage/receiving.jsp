<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<div>
		<form action="${path }/putstorage/readExcle" method="post" enctype="multipart/form-data" >
			<input type="file" id="file" name="file"/>
			<input type="submit" value="上传" />
		</form>
	</div>
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