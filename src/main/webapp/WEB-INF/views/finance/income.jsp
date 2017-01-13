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
            url : '${path }/income/dataGrid',
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
                width : '120',
                title : '收入原因',
                field : 'icause',
                sortable : true
            }, {
                width : '120',
                title : '收入时间',
                field : 'itime',
                sortable : true,
                
            },{
                width : '120',
                title : '相关单据',
                field : 'iabout',
                sortable : true
            }, {
                width : '100',
                title : '需收入',
                field : 'icount',
                sortable : true,
            }, {
                width : '100',
                title : '已收入',
                field : 'iincome',
                sortable : true,
            },{
                width : '100',
                title : '未收入',
                field : 'ibalance',
                sortable : true,
            },{
                field : 'action',
                title : '操作',
                width : 80,
                formatter : function(value, row, index) {
                    var str = '';
	                        <shiro:hasPermission name="/tariff/delete">
	                            str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" style="height:25px;" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.iid);
	                        </shiro:hasPermission>
                    return str;
                }
            }] ],
            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
            },
            toolbar : '#toolbar'
        });
    });
    
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
                $.post('${path }/income/delete', {
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
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>姓名:</th>
                    <td><input name="name" placeholder="请输入用户姓名"/></td>
                    <th>创建时间:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
        
    </div>
    <div data-options="region:'center',border:true,title:'收入统计'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
</body>
</html>