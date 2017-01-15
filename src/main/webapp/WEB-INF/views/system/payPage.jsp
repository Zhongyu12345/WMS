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
                url : '${path }/pay/select',
                fit : true,
                striped : true,
                rownumbers : true,
                pagination : true,
                singleSelect : true,
                height : '27',
                idField : 'pid',
                sortName : 'pid',
                sortOrder : 'asc',
                pageSize : 20,
                pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
                frozenColumns : [ [ {
                    width : '80',
                    title : '支出原因',
                    align:'center',
                    field : 'pcause',
                    sortable : true
                }, {
                    width : '80',
                    title : '支出时间',
                    field : 'ptime',
                    align:'center',
                    sortable : true,
                    formatter: formatDatebox
                },  ] ],
                columns:[[{
                    width : '80',
                    title : '支出金额',
                    field : 'ppay',
                    align:'center',
                    sortable : true
                },  {
                    field : 'action',
                    title : '操作',
                    align:'center',
                    width : 115,
                    formatter : function(value, row, index) {
                        var str = '';
                        <shiro:hasPermission name="/pay/delete">
                        str += '&nbsp;&nbsp;';
                        str += $.formatString('<a style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.pid);
                        </shiro:hasPermission>
                        return str;
                    }
                }
                ]],
                onLoadSuccess:function(data){
                    $('.user-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
                },
                toolbar : '#toolbar'
            });
        });

        function addFun() {
            parent.$.modalDialog({
                title : '添加',
                width : 500,
                height : 300,
                href : '${path }/pay/addPage',
                buttons : [{
                    text : '确定',
                    handler : function() {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#payAddForm');
                        {
                            f.submit();
                        }
                    }
                }]
            });
        }

        function deleteFun(id) {
            if (id == undefined) {//点击右键菜单才会触发这个
                var rows = dataGrid.datagrid('getSelections');
                id = rows[0].id;
            } else {//点击操作里面的删除图标会触发这个
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }
            parent.$.messager.confirm('询问', '您是否要删除当前支出记录？', function(b) {
                if (b) {
                    progressLoad();
                    $.post('${path }/pay/delete', {
                        id : id
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
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',border:true,title:'支出列表'" >
    <table id="dataGrid" data-options="fit:true,border:true"></table>
</div>
<div id="toolbar" style="display: none;">
    <shiro:hasPermission name="/user/add">
        <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
    </shiro:hasPermission>
</div>
</body>
</html>