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
    	if ($("#godownEntryForm").form("validate") && $("#receivingForm").form("validate") ) { // 验证整个表单里的所有validatabox是否通过验证
			var gName = $("#gName").val();
			var gSupplierid = $("#gSupplierid").val();
			var gSippingno = $("#gSippingno").val();
			var gStorerid = $("#gStorerid").val();
			var gWhid = $("#gWhid").val();
			var gNum = $("#gNum").val();
			var gCrossflag = $("#gCrossflag").combobox("getValue");
			var gDirectflag = $("#gDirectflag").combobox("getValue");
			var gPhone = $("#gPhone").val();
			var gAdminid = $("#gAdminid").val();
			var gSkumodel = $("#gSkumodel").val();
			var gTime = $("#gTime").val();
			var gNumber = $("#gNumber").val();
			var gHeavy = $("#gHeavy").val();
			
			var rName = $("#rName").val();
			var rSupplierid = $("#rSupplierid").val();
			var rSippingno = $("#rSippingno").val();
			var rStorerid = $("#rStorerid").val();
			var rWhid = $("#rWhid").val();
			var rNum = $("#rNum").val();
			var rCrossflag = $("#rCrossflag").combobox("getValue");
			var rDirectflag = $("#rDirectflag").combobox("getValue");
			var rPhone = $("#rPhone").val();
			var rAdminid = $("#rAdminid").val();
			var rSkumodel = $("#rSkumodel").val();
			var rTime = $("#rTime").val();
			var rNumber = $("#rNumber").val();
			var rHeavy = $("#rHeavy").val();
			$.post('${path }/putstorage/save', {
				"gName" : gName,
				"gSupplierid":gSupplierid,
				"gSippingno":gSippingno,
				"gStorerid":gStorerid,
				"gWhid":gWhid,
				"gNum":gNum,
				"gNumber":gNumber,
				"gHeavy":gHeavy,
				"gCrossflag":gCrossflag,
				"gDirectflag":gDirectflag,
				"gPhone":gPhone,
				"gAdminid":gAdminid,
				"gSkumodel":gSkumodel,
				"gTime":gTime,
				"rName" : rName,
				"rSupplierid":rSupplierid,
				"rSippingno":rSippingno,
				"rStorerid":rStorerid,
				"rWhid":rWhid,
				"rNum":rNum,
				"rNumber":rNumber,
				"rHeavy":rHeavy,
				"rCrossflag":rCrossflag,
				"rDirectflag":rDirectflag,
				"rPhone":rPhone,
				"rAdminid":rAdminid,
				"rSkumodel":rSkumodel,
				"rTime":rTime
			}, function(data) {
				if (data.result.success) {
					alert("true");
					$.messager.alert("提示", data.result.msg, "info", function() {
						alert("sssss");
					});
				} else {
					$.messger.alert("提示", data.result.msg, "info");
				}
			});
		}
}
    
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<%-- <div>
		<form action="${path }/putstorage/readExcle" method="post" enctype="multipart/form-data" >
			<input type="file" id="file" name="file"/>
			<input type="submit" value="上传" />
		</form>
	</div> --%>
	<div id="GodownEntry" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:250px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">入库计划</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="godownEntryForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="gName" name="gName" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>供应商:</th>
	                    <td><input type="text" id="gSupplierid" name="gSupplierid" placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="gSippingno" name="gSippingno" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库编码:</th>
	                    <td><input type="text" id="gWhid" name="gWhid" placeholder="请输入入库编码" class="easyui-validatebox" data-options="required:true"/></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="gStorerid"  name="gStorerid" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库数量:</th>
	                    <td><input type="text"  id="gNumber" name="gNumber" placeholder="请输入入库数量" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库重量:</th>
	                    <td><input type="text"  id="gHeavy" name="gHeavy" placeholder="请输入入库重量" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="gNum" name="gNum" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>是否越库:</th>
	                    <td>
	                    	<select id="gCrossflag" name="gCrossflag"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	                            <option value="0">越库</option>
	                            <option value="1">不越库</option>
                   			 </select></td>
	                    <th>是否整进整出:</th>
	                    <td>
	                    	<select id="gDirectflag" name="gDirectflag"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	                            <option value="0">整进</option>
	                            <option value="1">不整进</option>
                   			 </select>
                   		</td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" id="gPhone" name="gPhone" placeholder="请输入号码" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库计划时间:</th>
	                    <td><input id="gTime" name="gTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})"   readonly="readonly" /></td>
	                    <th>管理员编号:</th>
	                    <td><input type="text" id="gAdminid" name="gAdminid" placeholder="请输入管理员编号" class="easyui-validatebox" data-options="required:true" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="gSkumodel" name="gSkumodel" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true"/></td>
	                </tr>
	            </table>
	        </form>
	    </div></div>
	</div>

	<div id="receiving" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:250px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">实际入库</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="receivingForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="rName"  name="rName" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>供应商:</th>
	                    <td><input type="text"  id="rSupplierid"  name="rSupplierid" placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text"  id="rSippingno"  name="rSippingno" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库编码:</th>
	                    <td><input type="text"  id="rWhid"  name="rWhid" placeholder="请输入入库编码" class="easyui-validatebox" data-options="required:true"/></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="rStorerid" name="rStorerid" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库数量:</th>
	                    <td><input type="text"  id="rNumber" name="rNumber" placeholder="请输入入库数量" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库重量:</th>
	                    <td><input type="text"  id="rHeavy" name="rHeavy" placeholder="请输入入库重量" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="rNum" name="rNum" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>是否越库:</th>
	                    <td>
	                    	<select id="rCrossflag" name="rCrossflag"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	                            <option value="0">越库</option>
	                            <option value="1">不越库</option>
                   			 </select></td>
	                    <th>是否整进整出:</th>
	                    <td>
	                    	<select id="rDirectflag" name="rDirectflag"  class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	                            <option value="0">整进</option>
	                            <option value="1">不整进</option>
                   			 </select>
                   		</td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text"  id="rPhone" name="rPhone" placeholder="请输入号码" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库时间:</th>
	                    <td><input id="rTime" name="rTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})"   readonly="readonly" /></td>
	                    <th>管理员编号:</th>
	                    <td><input type="text"  id="rAdminid" name="rAdminid" placeholder="请输入管理员编号" class="easyui-validatebox" data-options="required:true" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="rSkumodel"  name="rSkumodel" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true"/></td>
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