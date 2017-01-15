<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>价目表</title>
    <script type="text/javascript">

    var dataGrid;
    var organizationTree;
    $(function() {

        dataGrid = $('#dataGrid').datagrid({
            url : '${path }/tariff/dataGrid',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            sortName : 'id',
            sortOrder : 'asc',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '80',
                title : '收费标题',
                field : 'cause',
                sortable : true
            }, {
                width : '150',
                title : '(小于)重量范围（kg）',
                field : 'scope',
                sortable : true,
                
            },{
                width : '80',
                title : '金额',
                field : 'money',
                sortable : true
            }, {
                width : '120',
                title : '收费单位',
                field : 'unit',
                sortable : true,
            },{
                field : 'action',
                title : '操作',
                width : 130,
                formatter : function(value, row, index) {
                    var str = '';
                        	<shiro:hasPermission name="/tariff/edit">
                            	str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" style="height:25px;" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.id);
                        	</shiro:hasPermission>
	                        <shiro:hasPermission name="/tariff/delete">
                        		str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
	                            str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" style="height:25px;" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.id);
	                        </shiro:hasPermission>
                    return str;
                }
            }] ],
            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.user-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
            },
            toolbar : '#toolbar'
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 400,
            height : 250,
            href : '${path }/tariff/addPage',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#tariffAddForm');
                    f.submit();
                }
            } ]
        });
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
                progressLoad();
                var rows = dataGrid.datagrid('getSelections');
                $.post('${path }/tariff/delete', {
                    id : id,
                }, function(result) {
                    if (result.success) {
                        parent.$.messager.alert('提示', result.msg, 'info');
                        dataGrid.datagrid('reload');
                    }
                    progressClose();
                }, 'JSON');
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
            width : 400,
            height : 250,
            href : '${path }/tariff/editPage?id=' + id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#tariffEditForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function searchFun() {
        dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        $('#searchForm input').val('');
        dataGrid.datagrid('load', {});
    }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:true,title:'价目表'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
        <shiro:hasPermission name="/tariff/add">
            <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
        </shiro:hasPermission>
        <table>
        	<tr>
        		<td width="50px"></td>
        		<th style="color:red;">收费说明:   </th>
        		
        	</tr>
        	<tr>
        		<td width="50px"></td>
        		<td width="80px"></td>
        		<td style="color:red;">当货物的体积重量大于实际重量则用体积重量作为收费标准，体积计算公式:单位为cm³的货物体积/5000，并且货物重量在不同范围的也有不同收收费标准。</td>
        	</tr>
        	<tr>
        		<td width="50px"></td>
        		<td width="80px"></td>
        		<td style="color:red;">重量超过5000kg储存费用是8.8元/天，管理费是20元/天。</td>
        	</tr>
        </table>
    </div>
</body>
</html>