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
    $(function(){
    	$("#selectCombobox").combobox({
    	    url:"${path}/godown/godownComboBoxs?volume=${godown.gNum}",
    	    method: 'get',
    	    valueField: 'id',
    	    editable:false,
    	    textField: 'text',
    	    panelHeight: 'auto',
    	    onLoadSuccess: function () {
    	        var data = $('#selectCombobox').combobox('getData');
    	        if (data.length > 0) {
    	            $("#selectCombobox").combobox('select', data[0].id);
    	        }
    	    }
    	});
    	$('input[type=text]').validatebox();
    	 $("#gCrossflag").combobox('setValue','${godown.gCrossflag}');
         $("#gDirectflag").combobox('setValue','${godown.gDirectflag}');
         $("#rCrossflag").combobox('setValue','${godown.gCrossflag}');
         $("#rDirectflag").combobox('setValue','${godown.gDirectflag}');
    });
    
    function save(){
    	if ($("#godownEntryForm").form('enableValidation').form("validate") && $("#receivingForm").form('enableValidation').form("validate") ) { // 验证整个表单里的所有validatabox是否通过验证
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
			var rWhid = $("#selectCombobox").combobox("getValue");
			var rNum = $("#rNum").val();
			var rCrossflag = $("#rCrossflag").combobox("getValue");
			var rDirectflag = $("#rDirectflag").combobox("getValue");
			var rPhone = $("#rPhone").val();
			var rAdminid = $("#adminname").val();
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
				"adminname":rAdminid,
				"rSkumodel":rSkumodel,
				"srTime":rTime
			}, function(data) {
					if (data.result) {
						 $.messager.alert('提示','添加失败');
					} else {
						$('#godownEntryForm input').val('');
						$('#receivingForm input').val('');
						$("#gCrossflag").combobox('setValue',' ');
				         $("#gDirectflag").combobox('setValue',' ');
				         $("#rCrossflag").combobox('setValue',' ');
				         $("#rDirectflag").combobox('setValue',' ');
				         
				         $("#selectCombobox").combobox({
				     	    url:"${path}/godown/godownComboBox",
				     	    method: 'get',
				     	    valueField: 'id',
				     	   editable:false,
				     	    textField: 'text',
				     	    panelHeight: 'auto',
				     	    onLoadSuccess: function () {
				     	        var data = $('#selectCombobox').combobox('getData');
				     	        if (data.length > 0) {
				     	            $("#selectCombobox").combobox('select', data[0].id);
				     	        }
				     	    }
				     	});
				         $.messager.alert('提示','添加成功');
					}
				});
		}
}
    
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	 <div style="height:30px;padding:20px;">
		<form action="${path }/putstorage/readExcle" method="post" enctype="multipart/form-data" >
			<input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择入库计划单...'" >
			<input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入计划单" />
		</form>
	</div>
	<div id="GodownEntry" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">入库计划</div>
		<div style="padding:5px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="godownEntryForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="gName" name="gName" value="${godown.gName }" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="gSkumodel" name="gSkumodel" value="${godown.gSkumodel }" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="gSippingno" name="gSippingno" value="${godown.gSippingno }" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                    <%-- <th>入库编码:</th>
	                    <td><input type="text" id="gWhid" name="gWhid" value="${godown.gWhid }" placeholder="请输入入库编码" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                     --%>
	                    <th>是否越库:</th>
	                    <td>
	                    	<select id="gCrossflag" name="gCrossflag"  class="easyui-combobox" data-options="width:80,height:20,editable:false,panelHeight:'auto'" readonly="readonly" >
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">越库</option>
	                            <option value="1">不越库</option>
                   			 </select></td>
              			<th>是否整进整出:</th>
	                    <td>
	                    	<select id="gDirectflag" name="gDirectflag" class="easyui-combobox" data-options="width:80,height:20,editable:false,panelHeight:'auto'" readonly="readonly" >
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">整进</option>
	                            <option value="1">不整进</option>
                   			 </select>
                   		</td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="gStorerid"  name="gStorerid"  value="${godown.gStorerid }" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                	<th>入库数量:</th>
	                    <td><input type="text"  id="gNumber" name="gNumber" validtype="integer" value="${godown.gNumber }" placeholder="请输入入库数量" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                    <th>入库重量:</th>
	                    <td><input type="text"  id="gHeavy" name="gHeavy" validtype="intOrFloat" value="${godown.gHeavy }" placeholder="请输入入库重量" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="gNum" name="gNum" validtype="intOrFloat" value="${godown.gNum }" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" id="gPhone" name="gPhone" validtype="mobile" value="${godown.gPhone }" placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                	<th>供应商:</th>
	                    <td><input type="text" id="gSupplierid" name="gSupplierid" value="${godown.gSupplierid }" placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                    <%-- <th>管理员编号:</th>
	                    <td><input type="text" id="gAdminid" name="gAdminid" value="${godown.gAdminid }" placeholder="请输入管理员编号" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                	 --%>
	                	<th>入库计划时间:</th>
	                    <td><input id="gTime" name="gTime"   placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"  value="<fmt:formatDate pattern="yyyy-MM-dd " value="${godown.gTime}" />" readonly="readonly" /></td>
	                </tr>
	            </table>
	        </form>
	    </div></div>
	</div>

	<div id="receiving" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px solid :red">
		<div id="mytitle" style="background:#ddd;padding:5px;">实际入库</div>
		<div style="padding:5px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="receivingForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="rName"  name="rName" value="${godown.gName }"  placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                    <th>货物型号:</th>
	                    <td><input type="text"  id="rSkumodel"  value="${godown.gSkumodel }"  name="rSkumodel" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                   	<th>客户托单号:</th>
	                    <td><input type="text"  id="rSippingno"  name="rSippingno" value="${godown.gSippingno }"  placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                    <th>仓库:</th>
	                    <td><input name="rWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
	                    <th>是否越库:</th>
	                    <td>
	                    	<select id="rCrossflag" name="rCrossflag"  class="easyui-combobox" data-options="width:80,height:20,editable:false,panelHeight:'auto'">
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">越库</option>
	                            <option value="1">不越库</option>
                   			 </select></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="rStorerid" name="rStorerid" value="${godown.gStorerid }"  placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                	<th>入库数量:</th>
	                    <td><input type="text"  id="rNumber" name="rNumber" validtype="integer"  placeholder="请输入入库数量" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                    <th>入库重量:</th>
	                    <td><input type="text"  id="rHeavy" name="rHeavy" validtype="intOrFloat"  placeholder="请输入入库重量" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                	<th>入库体积:</th>
	                    <td><input type="text"  id="rNum" name="rNum"  validtype="intOrFloat" placeholder="请输入入库体积" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                    <th>是否整进整出:</th>
	                    <td>
	                    	<select id="rDirectflag" name="rDirectflag"   class="easyui-combobox" data-options="width:80,height:20,editable:false,panelHeight:'auto'">
	                    	<option value=" " selected="selected">请选择</option>
	                            <option value="0">整进</option>
	                            <option value="1">不整进</option>
                   			 </select>
                   		</td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text"  id="rPhone" validtype="mobile" name="rPhone" value="${godown.gPhone }"  placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                	 <th>供应商:</th>
	                    <td><input type="text"  id="rSupplierid"  name="rSupplierid" value="${godown.gSupplierid }"  placeholder="请输入供应商" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                	<th>管理员:</th>
	                    <td><input type="text"  id="adminname" value='<shiro:principal></shiro:principal>'  name="adminname" placeholder="请输入管理员编号" class="easyui-validatebox" data-options="required:true,novalidate:true" readonly="readonly" /></td>
	                    <th>入库时间:</th>
	                    <td><input id="rTime" name="rTime" validtype="date" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" data-options="required:true,novalidate:true"   readonly="readonly" /></td>
	                    
	                </tr>
	            </table>
	        </form>
	    </div></div>
	    <div>
			<a href="javascript:void(0);" style="margin-left: 800px;" class="easyui-linkbutton" onclick="save();">确认</a>
		</div>
	</div>
	
	
</body>
</html>