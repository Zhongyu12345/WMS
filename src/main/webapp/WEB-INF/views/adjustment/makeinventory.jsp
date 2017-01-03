<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>货物盘点单管理</title>
    <script type="text/javascript">

        var dataGrid;
        var organizationTree;

        $(function() {
            dataGrid = $('#dataGrid').datagrid({
                url : '${path }/make/select',
                fit : true,
                striped : true,
                rownumbers : true,
                pagination : true,
                singleSelect : true,
                height : '27',
                idField : 'miId',
                sortName : 'id',
                sortOrder : 'asc',
                pageSize : 20,
                pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
                columns : [ [ {
                    width : '90',
                    title : '货物名称',
                    field : 'miName',
                    sortable : true
                }, {
                    width : '70',
                    title : '货物型号',
                    field : 'miSkumodel',
                    sortable : true
                },{
                    width : '100',
                    title : '盘点数量',
                    field : 'miNum',
                    sortable : true
                },{
                    width : '100',
                    title : '实际盘点数量',
                    field : 'miActual',
                    sortable : true
                },{
                    width : '100',
                    title : '盘点人',
                    field : 'miNames',
                    sortable : true
                },{
                    width : '70',
                    title : '仓库编号',
                    field : 'miWhid',
                    sortable : true
                },{
                    width : '130',
                    title : '盘点时间',
                    field : 'miTime',
                    sortable : true
                },{
                    field : 'action',
                    title : '操作',
                    width : 130,
                    formatter : function(value, row, index) {
                        var str = '';
                        <shiro:hasPermission name="/user/edit">
                        str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.miId);
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/user/delete">
                        str += '&nbsp;&nbsp;';
                        str += $.formatString('<a style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.miId);
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
                width : 500,
                height : 300,
                href : '${path }/cargo/cargoeditpage?id=' + id,
                buttons : [ {
                    text : '确定',
                    handler : function() {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#CargoEditForm');
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
            parent.$.messager.confirm('询问', '您是否要删除当前数据？', function(b) {
                if (b) {
                    $.post('${path }/make/deletepk', {
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
                <th>货物型号:</th>
                <td><input name="miSkumodel" placeholder="请输入货物型号"/></td>
                <th>创建时间:</th>
                <td>
                    <input name="createState" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div data-options="region:'center',border:true,title:'货物表'" >
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="toolbar" style="display: none;">
    <shiro:hasPermission name="/cargo/insert">
        <form action="ReadExcle" method="post" enctype="multipart/form-data">
            <input type="file" name="file" />
            <input type="submit" value="确定" />
        </form>
    </shiro:hasPermission>
</div>
</body>
</html>