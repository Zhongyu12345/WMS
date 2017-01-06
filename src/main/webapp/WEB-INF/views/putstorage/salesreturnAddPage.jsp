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
    $(function(){
    	$("#selectCombobox").combobox({
    	    url:"${path}/godown/godownComboBox",
    	    method: 'get',
    	    editable:false,
    	    valueField: 'id',
    	    textField: 'text',
    	    panelHeight: 'auto',
    	    onLoadSuccess: function () {
    	        var data = $('#selectCombobox').combobox('getData');
    	        if (data.length > 0) {
    	            $("#selectCombobox").combobox('select', data[0].id);
    	        }
    	    }
    	});
    });
    
    function save(){
    	if ($("#salesreturnForm").form('enableValidation').form("validate")) { // 验证整个表单里的所有validatabox是否通过验证
			var srName = $("#srName").val();
			var srSipping = $("#srSipping").val();
			var srSkumodel = $("#srSkumodel").val();
			var srStorerid = $("#srStorerid").val();
			var srVolume = $("#srVolume").val();
			var srWhid = $("#selectCombobox").combobox("getValue");
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
				if (data.result) {
					$.messager.alert('提示','添加失败');
				} else {
					$('#salesreturnForm input').val('');
					$('#srCause').textbox('setValue','');
					$.messager.alert('提示','添加成功');
				}
			});
		}
    }
    
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div style="height:30px;padding:20px;">
		<form action="${path }/salesreturn/readExcle" method="post" enctype="multipart/form-data" >
			<input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择入库计划单...'" >
			<input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入计划单" />
		</form>
	</div>
	<div id="salesreturn" class="easyui-draggable easyui-resizable" data-options="handle:'#mytitle'" style="width:100%;height:150px;border:2px ;solid :red;">
		<div id="mytitle" style="background:#ddd;padding:5px;">退货单</div>
		<div style="padding:20px"><div data-options="region:'center',border:true" style="height: 100%; overflow: hidden;background-color: #fff">
	        <form id="salesreturnForm" method="post">
	            <table>
	                <tr>
	                    <th>货物名称:</th>
	                    <td><input type="text" id="srName" name="srName" value="${salesreturn.srName }" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,novalidate:true"/></td>
	                    <th>客户托单号:</th>
	                    <td><input type="text" id="srSipping" name="srSipping" value="${salesreturn.srSipping }" placeholder="请输入客户托单号" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                    <th>货物型号:</th>
	                    <td><input type="text" id="srSkumodel" name="srSkumodel" value="${salesreturn.srSkumodel }" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                </tr>
	                <tr>
	                	<th>货主:</th>
	                	<td><input type="text"  id="srStorerid"  name="srStorerid" value="${salesreturn.srStorerid }" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                	<th>退货体积:</th>
	                	<td><input type="text" validtype="intOrFloat" id="srVolume"  value="${salesreturn.srVolume }" name="srVolume" placeholder="请输入退货体积" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                	<th>仓库:</th>
                    	<td><input name="srWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,novalidate:true" /></td>
	                </tr>
	                <tr>
	                	<th>号码:</th>
	                	<td><input type="text" validtype="mobile" id="srPhone" name="srPhone" value="${salesreturn.srPhone }" placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                	<th>退货时间:</th>
	                    <td><input placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate pattern="yyyy-MM-dd " value="${salesreturn.srTime}" />"    readonly="readonly" id="srTime" name="srTime" /></td>
	                    <th>退货数量:</th>
	                    <td><input type="text" id="srNum" validtype="integer" name="srNum" value="${salesreturn.srNum }" placeholder="请输入退货数量" class="easyui-validatebox" data-options="required:true,novalidate:true" /></td>
	                </tr>
	                <tr>
	                	<th>退货原因:</th>
	                    <td colspan="5"><input style="width:100%;height:50px;" id="srCause" name="srCause" value="${salesreturn.srCause }" type="text" validtype="unnormal" class="easyui-textbox" data-options="multiline:true,novalidate:true" placeholder="请输入退货原因" ></td>
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