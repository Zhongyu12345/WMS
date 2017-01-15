<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>出货管理</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
    <form id="searchForm">
        <table>
            <tr>
                <th>发货时间:</th>
                <td>
                    <input name="startTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"/>
                    至
                    <input name="endTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"/>
                    <a href="javascript:void(0);" class="easyui-linkbutton" required data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
                    <a href="javascript:void(0);" class="easyui-linkbutton" required data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div data-options="region:'center',border:true,title:'出货单列表'">
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="toolbar" style="display: none;">
    <shiro:hasPermission name="/shipment/import">
        <a href="${path }/shipment/importShipment.html" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-folder'">导入出货单</a>
    </shiro:hasPermission>
</div>

<script>
    var dataGrid;
    $(function () {
        dataGrid = $('#dataGrid').datagrid({
            url: '${path }/shipment/dataGrid',
            fit: true,
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            height: '25',
            idField: 'shId',
            sortName: 'shTime',
            sortOrder: 'asc',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100, 200, 300, 400, 500],
            frozenColumns :[[{
                width: '80',
                title: '货主',
                field: 'shStoreid',
                align:'center',
                sortable: true
            }, {
                width: '79',
                title: '型号',
                align:'center',
                field: 'shSkumodel',
                sortable: true
            },  ] ],
            columns:[[{
                width: '100',
                title: '号码',
                align:'center',
                field: 'shPhone',
                sortable: true
            }, {
                width: '150',
                title: '客户托单号',
                align:'center',
                field: 'shSippingno',
                sortable: true
            }, {
                width: '80',
                title: '仓库',
                align:'center',
                field: 'shWhid',
                sortable: true,
            }, {
                width: '60',
                title: '损坏数量',
                align:'center',
                field: 'shDamage',
                sortable: true
            }, {
                width: '130',
                title: '损坏原因',
                align:'center',
                field: 'shCause',
                sortable: true
            }, {
            	width: '80',
                title: '实际出货时间',
                align:'center',
                field: 'shTime',
                sortable: true,
                formatter: formatDatebox
            }, {
                width: '79',
                title: '实际出货数量',
                align:'center',
                field: 'shShnum',
                sortable: true
            }, {
                width: '79',
                title: '发货毛重',
                align:'center',
                field: 'shTotalweigh',
                sortable: true
            }, {
                width: '79',
                title: '发货体积',
                align:'center',
                field: 'shTotalvolume',
                sortable: true
            }, {
                field: 'action',
                title: '操作',
                align:'center',
                width: '220',
                formatter: function (value, row, index) {
                    var str = '';
                    <shiro:hasPermission name="/shipment/update">
                    	if(row.status == 0){
                   			str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >已收货</a>', row.shId);
                   			str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                   			str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit2" data-options="plain:true,iconCls:\'icon-edit\'" onclick="importFun(\'{0}\');" >退货</a>', row.shId);
                    	}else if(row.status == 1){
                   			str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit1" data-options="plain:true,iconCls:\'icon-edit\'" onclick="moneyFun(\'{0}\');" >付款</a>', row.shId);
                    	}else if(row.status == 2){
                   			str += $.formatString('<a style="height: 24px; color: red;" href="javascript:void(0)" class="user-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'">已付款</a>', row.shId);
                    	}else if(row.status == 3){
                   			str += $.formatString('<a style="height: 24px; color: red;" href="javascript:void(0)" class="user-easyui-linkbutton-ok2" data-options="plain:true,iconCls:\'icon-ok\'">已退货</a>', row.shId);
                    	}
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/shipment/delete">
	                    str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
	                    str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.shId);
                    </shiro:hasPermission>
                    return str;
                }
            }]],
            onLoadSuccess: function (data) {
                $('.user-easyui-linkbutton-edit').linkbutton({text: '已收货', plain: true, iconCls: 'icon-edit'});
                $('.user-easyui-linkbutton-edit1').linkbutton({text: '付款', plain: true, iconCls: 'icon-edit'});
                $('.user-easyui-linkbutton-ok').linkbutton({text: '已付款', plain: true, iconCls: 'icon-ok'});
                $('.user-easyui-linkbutton-edit2').linkbutton({text: '退货', plain: true, iconCls: 'icon-edit'});
                $('.user-easyui-linkbutton-ok2').linkbutton({text: '已退货', plain: true, iconCls: 'icon-ok'});
                $('.user-easyui-linkbutton-del').linkbutton({text: '删除', plain: true, iconCls: 'icon-del'});
            },
            toolbar: '#toolbar'
        });
    });

    <!-- \\\\\\\\\\ 添加操作 \\\\\\\\\\ -->
    function addFun() {
        parent.$.modalDialog({
            title : '添加出货单',
            width: 520,
            height: 325,
            href : '${path }/shipment/shipment/insert',
            buttons : [ {
                text : '确认提交',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#shipmentAddForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function importFun(id){
    	$("#addWin").window("open"); // close关闭
    	$("#shids").val(id);
    }
    
    function ok(i){
    	var b=0;
    	if(i == 1){
    		var id = $("#shids").val();
        	var yuanyin = $("#yuanying").textbox('getValue');
        	window.location.href = '${path }/shipment/toexcel?id='+id+'&yuanyin='+yuanyin;
        	$("#addWin").window("close");
        	b =1;
    	}else{
    		b = 0;
    	}
    	if(b==1){
    		setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
    			window.location.reload();
    	    	},1000);
    	}
    }

    <!-- \\\\\\\\\\ 删除操作 \\\\\\\\\\ -->
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前单号？', function (b) {
            if (b) {
                progressLoad();
                $.post('${path }/shipment/shipment/delete', {
                    id: id,
                    'status': rows[0].status
                }, function (result) {
                    if (result.success) {
                        parent.$.messager.alert('提示', result.msg, 'info');
                        dataGrid.datagrid('reload');
                    }
                    progressClose();
                }, 'JSON');
            }
        });
    }

    /* 已收货 */
    function editFun(id){
    	if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '确定执行当前操作？', function (b) {
            if (b) {
                progressLoad();
                $.post('${path }/shipment/getEditPage', {
                    id: id,
                }, function (result) {
                    if (result.success) {
                        parent.$.messager.alert('提示', result.msg, 'info');
                        dataGrid.datagrid('reload');
                    }
                    progressClose();
                }, 'JSON');
            }
        });
    }
    
    <!-- \\\\\\\\\\ 付款操作 \\\\\\\\\\ -->
    function moneyFun(id) {
    	var rows= dataGrid.datagrid('getSelections');
        parent.$.modalDialog({
            title: '费用清单',
            width: 380,
            height: 300,
            href: '${path }/shipment/moneyPage?id=' + id+'&shTotalweigh='+rows[0].shTotalweigh,
            buttons: [{
                text: '确认支付',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#shipmentMoneyForm');
                    f.submit();
                }
            }]
        });
    }

    <!-- \\\\\\\\\\ 搜索操作 \\\\\\\\\\ -->
    function searchFun() {
        dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }

    <!-- \\\\\\\\\\ 清理操作 \\\\\\\\\\ -->
    function cleanFun() {
        $('#searchForm input').val('');
        dataGrid.datagrid('load', {});
    }

</script>
<div id="addWin" class="easyui-window WinDisplay" title="提示" data-options="iconCls:'icon-edit', closable:true, closed:true"  style="width:350px;height:200px;">
			<table >
				<tr>
					<td >请输入退货原因:</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="1">
					<input style="width:100%;height:50px;" id="yuanying"  type="text" validtype="unnormal" class="easyui-textbox" data-options="multiline:true,novalidate:true" placeholder="请输入退货原因" >
						<input type="hidden"  id="shids" />
						<a href="javascript:void(0);"  class="easyui-linkbutton" onclick="ok(1);">确认退货</a>
					</td>
				</tr>
			</table>
</body>
</html>