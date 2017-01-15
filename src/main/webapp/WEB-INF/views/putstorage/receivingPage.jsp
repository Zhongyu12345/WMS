<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收货单管理</title>
    <script type="text/javascript">

    var dataGrid;
    $(function() {
       		dataGrid = $('#dataGrid').datagrid({
            url : '${path }/receiving/select',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            height : '27',
            idField : 'id',
            sortName : 'id',
            sortOrder : 'asc',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            frozenColumns : [ [ {
                width : '80',
                title : '货物名称',
                align:'center',
                field : 'rName',
                sortable : true
            }, {
                width : '80',
                title : '货物型号',
                align:'center',
                field : 'rSkumodel',
                sortable : true
            },  ] ],
            columns:[[{
				    width : '80',
				    title : '货主',
				    align:'center',
				    field : 'rStorerid',
				    sortable : true
				},{
				    width : '100',
				    title : '货主号码',
				    align:'center',
				    field : 'rPhone',
				    sortable : true
				},  {
				    width : '100',
				    title : '供应商',
				    align:'center',
				    field : 'rSupplierid',
				    sortable : true,
				}, {
				    width : '80',
				    title : '客户托单号',
				    align:'center',
				    field : 'rSippingno',
				    sortable : true
				},{
				    width : '80',
				    title : '仓库',
				    align:'center',
				    field: 'godowns',
	                sortable: true,
	                formatter: function (value) {
	                    var roles = [];
	                    for(var i = 0; i< value.length; i++) {
	                        roles.push(value[i].goWhid);
	                    }
	                    return(roles.join('\n'));
	                }
				}, {
				    width : '80',
				    title : '入库数量<a style="color:blue;">(个)</a>',
				    align:'center',
				    field : 'rNumber',
				    sortable : true
				}, {
				    width : '80',
				    title : '入库重量<a style="color:blue;">(/kg)</a>',
				    align:'center',
				    field : 'rHeavy',
				    sortable : true
				}, {
				    width : '80',
				    title : '入库体积<a style="color:blue;">(m³)</a>',
				    align:'center',
				    field : 'rNum',
				    sortable : true
				}, {
				    width : '60',
				    title : '是否越库',
				    align:'center',
				    field : 'rCrossflag',
				    sortable : true,
				    formatter : function(value, row, index) {
				        switch (value) {
				        case '0':
				            return '<a style="color:red;">越库</a>';
				        case '1':
				            return '不越库';
				        }
				    }
				},  {
				    width : '60',
				    title : '是否整进',
				    align:'center',
				    field : 'rDirectflag',
				    sortable : true,
				    formatter : function(value, row, index) {
				        switch (value) {
				        case '0':
				            return "整进";
				        case '1':
				            return "不整进";
				        }
				    }
				},  {
				    width : '120',
				    title : '入库时间',
				    align:'center',
				    field : 'rTime',
				    sortable : true,
				    formatter: formatDatebox
				},  {
				    width : '70',
				    title : '管理员',
				    align:'center',
				    field : 'users',
				    sortable : true,
				    formatter: function (value) {
	                    var roles = [];
	                    for(var i = 0; i< value.length; i++) {
	                        roles.push(value[i].loginName);
	                    }
	                    return(roles.join('\n'));
	                }
				},    {
	                field : 'action',
	                title : '操作',
	                align:'center',
	                width : 230,
	                formatter : function(value, row, index) {
	                    var str = '';
	                        <shiro:hasPermission name="/receiving/update">
	                            str += $.formatString('<a  style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.rId);
	                        </shiro:hasPermission>
	                        <shiro:hasPermission name="/receiving/delete">
	                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
	                            str += $.formatString('<a style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.rId);
	                        </shiro:hasPermission>
	                        if(row.rCrossflag == '0'){
                        	<shiro:hasPermission name="/receiving/excel">
	                        	str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
	                            str += $.formatString('<a  style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-folder" data-options="plain:true,iconCls:\'icon-folder\'" onclick="excelFun(\'{0}\');" >生成越库单</a>', row.rId);
	                        </shiro:hasPermission>
	                        }
	                    return str;
	                }
	            }
            ]],
            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.user-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                $('.user-easyui-linkbutton-folder').linkbutton({text:'生成越库单',plain:true,iconCls:'icon-folder'});
            },
            toolbar : '#toolbar'
        });
    }); 
    
    function excelFun(id){
    	  window.location.href = '${path }/receiving/toexcel?id='+id;
    }
   
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前记录？', function(b) {
            if (b) {
                var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
                if (currentUserId != id) {
                    progressLoad();
                    $.post('${path }/receiving/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            dataGrid.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                } else {
                    parent.$.messager.show({
                        title : '提示',
                        msg : '不可以删除自己！'
                    });
                }
            }
        });
    }
    
    function editFun(id) {
        if (id == undefined) {
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 540,
            height : 350,
            href : '${path }/receiving/editPage?id=' + id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#receivingEditForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function searchFun() {
        dataGrid.datagrid('load',  $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        $('#a ').val(''); 
        $('#b').combobox('setValue'," ");
        $('#c').combobox('setValue'," ");
        dataGrid.datagrid('load', {});
    }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:true" style="height: 70px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>货物名称:</th>
                    <td><input id="a" name="rName" placeholder="请输入货物名称"/></td>
                    <th>货物型号:</th>
                    <td><input id="a" name="rSkumodel" placeholder="请输入货物型号"/></td>
                    <th>入库时间:</th>
                    <td>
	                    <input id="a" name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input id="a"  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    </td>
                </tr>
                 <tr>
                    <th>供应商:</th>
                    <td><input id="a" name="rSupplierid" placeholder="请输入供应商名称"/></td>
                    <th>是否越库:</th>
                    <td>
                    	<select id="b"  name="rCrossflag" class="easyui-combobox" data-options="width:80,height:24,editable:false,panelHeight:'auto'">
                    		<option value=" " selected="selected" >请选择</option>
                            <option value="0">越库</option>
                            <option value="1">不越库</option>
                    	</select>
                    </td>
                    <th>是否整进:</th>
                    <td>
                    	<select id="c" name="rDirectflag" class="easyui-combobox" data-options="width:80,height:24,editable:false,panelHeight:'auto'">
                    		<option value=" " selected="selected">请选择</option>
                            <option value="0">整进</option>
                            <option value="1">不整进</option>
                    	</select>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'货单列表'" >
        <table id="dataGrid" data-options="fit:true,border:true"></table>
    </div>
    
</body>
</html>