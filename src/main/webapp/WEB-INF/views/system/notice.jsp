<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>公告栏</title>s
    <script type="text/javascript">
        var dataGrid;

    $(function(){
        dataGrid = $('#dataGrid').datagrid({
            url : '${path }/notice/select',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            sortName : 'ntime',
            sortOrder : 'asc',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '80',
                title : '发布人',
                align:'center',
                field : 'users',
                sortable: true,
                formatter: function (value) {
                    var roles = [];
                    for(var i = 0; i< value.length; i++) {
                        roles.push(value[i].loginName);
                    }
                    return(roles.join('\n'));
                }
            }, {
                width : '120',
                title : '公告内容',
                field : 'text',
                align:'center',
                sortable : true
            },{
                width : '130',
                title : '发布时间',
                field : 'ntime',
                sortable : true,
                align:'center',
                formatter: formatDatebox
            },   {
                field : 'nstatus',
                align:'center',
                title : '状态',
                width : 40,
                formatter : function(value, row, index) {
                    switch (value) {
                        case 0:
                            return '上架';
                        case 1:
                            return '下架';

                    }
                }
            }, {

        field : 'action',
        title : '操作',
                align:'center',
                width : '130',
                    formatter : function(value, row, index) {
                        var str = '';``
                        <shiro:hasPermission name="/notice/edit">
                        str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" style="height:24px;" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.nid);
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/notice/delete">
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" style="height:24px;" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.nid);
                        </shiro:hasPermission>
                        return str;
                    }
                }] ],

            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                $('.user-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
            },
            toolbar : '#toolbar'
        })
    })



        function addFun() {
            parent.$.modalDialog({
                title : '添加',
                width : 500,
                height : 300,
                href : '${path }/notice/addPage',
                buttons : [{
                    text : '确定',
                    handler : function() {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#noticeAddForm');
                        {
                            f.submit();
                        }
                    }
                }]
            });
        }

    function editFun(id) {
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '${path }/notice/editPage?id=' + id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#noticeEditForm');
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
            parent.$.messager.confirm('询问', '您是否要删除当前公告？', function(b) {
                if (b) {
                    progressLoad();
                    $.post('${path }/notice/delete', {
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
<body  class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:true,title:'公告栏'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
        <shiro:hasPermission name="/user/add">
            <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
        </shiro:hasPermission>

    </div>
</body>
</html>
