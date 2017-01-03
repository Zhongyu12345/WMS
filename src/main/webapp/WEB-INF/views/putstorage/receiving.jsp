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
<<<<<<< Updated upstream
    $(function(){
    	$('input[type=text]').validatebox();
    	 $("#gCrossflag").combobox('setValue','${godown.gCrossflag}');
         $("#gDirectflag").combobox('setValue','${godown.gDirectflag}');
         $("#rCrossflag").combobox('setValue','${godown.gCrossflag}');
         $("#rDirectflag").combobox('setValue','${godown.gDirectflag}');
    });
    
    function save(){
    	if ($("#godownEntryForm").form("validate") && $("#receivingForm").form("validate") ) { // 验证整个表单里的所有validatabox是否通过验证
=======
    
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
>>>>>>> Stashed changes
			var gName = $("#gName").val();
			var gSupplierid = $("#gSupplierid").val();
			var gSippingno = $("#gSippingno").val();
			var gStorerid = $("#gStorerid").val();
			var gWhid = $("#gWhid").val();
			var gNum = $("#gNum").val();
<<<<<<< Updated upstream
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
=======
			var gCrossflag = $("#gCrossflag").val();
			var gDirectflag = $("#gDirectflag").val();
			var gPhone = $("#gPhone").val();
			var gAdminid = $("#gAdminid").val();
			var gSkumodel = $("#gSkumodel").val();
			var gTime = $("#gTime").datetimebox("getValue");
>>>>>>> Stashed changes
			$.post('${path }/putstorage/save', {
				"gName" : gName,
				"gSupplierid":gSupplierid,
				"gSippingno":gSippingno,
				"gStorerid":gStorerid,
				"gWhid":gWhid,
				"gNum":gNum,
<<<<<<< Updated upstream
				"gNumber":gNumber,
				"gHeavy":gHeavy,
=======
>>>>>>> Stashed changes
				"gCrossflag":gCrossflag,
				"gDirectflag":gDirectflag,
				"gPhone":gPhone,
				"gAdminid":gAdminid,
				"gSkumodel":gSkumodel,
<<<<<<< Updated upstream
				"sgTime":gTime,
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
				"srTime":rTime
			}, function(data) {
					if (data.result) {
						$.messager.alert("提示", data.result.msg, "info", function() {
							alert("ok1");
						});
					} else {
						$('#godownEntryForm input').val('');
						$('#receivingForm input').val('');
						$("#gCrossflag").combobox('setValue',' ');
				         $("#gDirectflag").combobox('setValue',' ');
				         $("#rCrossflag").combobox('setValue',' ');
				         $("#rDirectflag").combobox('setValue',' ');
				         $.messager.alert('提示','添加成功');
						
					}
				});
		}
}
=======
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
>>>>>>> Stashed changes
    
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<<<<<<< Updated upstream
	 <div style="height:30px;padding:20px;">
		<form action="${path }/putstorage/readExcle" method="post" enctype="multipart/form-data" >
			<input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择入库计划单...'" >
			<input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入计划单" />
=======
	<div>
		<form action="${path }/putstorage/readExcle" method="post" enctype="multipart/form-data" >
			<input type="file" id="file" name="file"/>
			<input type="submit" value="上传" />
>>>>>>> Stashed changes
		</form>
	</div>
	<div id="GodownEntry" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">入库计划</div>
<<<<<<< Updated upstream
		<div style="padding:5px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
=======
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
>>>>>>> Stashed changes
	        <form id="godownEntryForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
<<<<<<< Updated upstream
	                    <td><input type="text" id="gName" name="gName" value="${godown.gName }" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="gSkumodel" name="gSkumodel" value="${godown.gSkumodel }" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="gSippingno" name="gSippingno" value="${godown.gSippingno }" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库编码:</th>
	                    <td><input type="text" id="gWhid" name="gWhid" value="${godown.gWhid }" placeholder="请输入入库编码" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>是否越库:</th>
	                    <td>
	                    	<select id="gCrossflag" name="gCrossflag"  class="easyui-combobox" data-options="width:80,height:24,editable:false,panelHeight:'auto'">
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">越库</option>
	                            <option value="1">不越库</option>
                   			 </select></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="gStorerid"  name="gStorerid"  value="${godown.gStorerid }" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库数量:</th>
	                    <td><input type="text"  id="gNumber" name="gNumber" validtype="integer" value="${godown.gNumber }" placeholder="请输入入库数量" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库重量:</th>
	                    <td><input type="text"  id="gHeavy" name="gHeavy" validtype="intOrFloat" value="${godown.gHeavy }" placeholder="请输入入库重量" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="gNum" name="gNum" validtype="intOrFloat" value="${godown.gNum }" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true"/></td>
	                    
	                    <th>是否整进整出:</th>
	                    <td>
	                    	<select id="gDirectflag" name="gDirectflag" class="easyui-combobox" data-options="width:80,height:24,editable:false,panelHeight:'auto'">
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">整进</option>
	                            <option value="1">不整进</option>
                   			 </select>
                   		</td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" id="gPhone" name="gPhone" validtype="mobile" value="${godown.gPhone }" placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>供应商:</th>
	                    <td><input type="text" id="gSupplierid" name="gSupplierid" value="${godown.gSupplierid }" placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>管理员编号:</th>
	                    <td><input type="text" id="gAdminid" name="gAdminid" value="${godown.gAdminid }" placeholder="请输入管理员编号" class="easyui-validatebox" data-options="required:true" /></td>
	                	<th>入库计划时间:</th>
	                    <td><input id="gTime" name="gTime"   placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd " value="${godown.gTime}" />" readonly="readonly" /></td>
=======
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
>>>>>>> Stashed changes
	                </tr>
	            </table>
	        </form>
	    </div></div>
	</div>

<<<<<<< Updated upstream
	<div id="receiving" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">实际入库</div>
		<div style="padding:5px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
=======
	<div id="receiving" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:200px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">实际入库</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
>>>>>>> Stashed changes
	        <form id="receivingForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
<<<<<<< Updated upstream
	                    <td><input type="text" id="rName"  name="rName" value="${godown.gName }"  placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="rSkumodel"  value="${godown.gSkumodel }"  name="rSkumodel" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true"/></td>
	                   	<th>客户托单号:</th>
	                    <td><input type="text"  id="rSippingno"  name="rSippingno" value="${godown.gSippingno }"  placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库编码:</th>
	                    <td><input type="text"  id="rWhid"  name="rWhid" value="${godown.gWhid }"  placeholder="请输入入库编码" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>是否越库:</th>
	                    <td>
	                    	<select id="rCrossflag" name="rCrossflag"  class="easyui-combobox" data-options="width:80,height:24,editable:false,panelHeight:'auto'">
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">越库</option>
	                            <option value="1">不越库</option>
                   			 </select></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="rStorerid" name="rStorerid" value="${godown.gStorerid }"  placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库数量:</th>
	                    <td><input type="text"  id="rNumber" name="rNumber" validtype="integer"  placeholder="请输入入库数量" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>入库重量:</th>
	                    <td><input type="text"  id="rHeavy" name="rHeavy" validtype="intOrFloat"  placeholder="请输入入库重量" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="rNum" name="rNum"  validtype="intOrFloat" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true"/></td>
	                    <th>是否整进整出:</th>
	                    <td>
	                    	<select id="rDirectflag" name="rDirectflag"   class="easyui-combobox" data-options="width:80,height:24,editable:false,panelHeight:'auto'">
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">整进</option>
	                            <option value="1">不整进</option>
                   			 </select>
                   		</td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text"  id="rPhone" validtype="mobile" name="rPhone" value="${godown.gPhone }"  placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true"/></td>
	                	 <th>供应商:</th>
	                    <td><input type="text"  id="rSupplierid"  name="rSupplierid" value="${godown.gSupplierid }"  placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true"/></td>
	                	<th>管理员编号:</th>
	                    <td><input type="text"  id="rAdminid" value="${godown.gAdminid }"  name="rAdminid" placeholder="请输入管理员编号" class="easyui-validatebox" data-options="required:true" /></td>
	                    <th>入库时间:</th>
	                    <td><input id="rTime" name="rTime" validtype="date" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss '})" data-options="required:true"   readonly="readonly" /></td>
	                    
=======
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