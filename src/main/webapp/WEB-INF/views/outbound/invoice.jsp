<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>普通发货单</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
    <form id="searchForm">
        <table>
            <tr>
                <th>货物名称:</th>
                <td><input name="name" placeholder="请输入货物名称"/></td>
                <th>调整时间:</th>
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
<div data-options="region:'center',border:true,title:'直接发货单列表'">
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="toolbar" style="display: none;">
    <shiro:hasPermission name="/invoice/import">
        <a href="${path }/invoice/importInvoice.html" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-folder'">导入出库单</a>
    </shiro:hasPermission>
</div>
<script>
    var dataGrid;
    $(function () {
        dataGrid = $('#dataGrid').datagrid({
            url: '${path }/invoice/dataGrid',
            fit: true,
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            height: '25',
            idField: 'inId',
            sortName: 'inId',
            sortOrder: 'asc',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100, 200, 300, 400, 500],
            columns: [[{
                width: '100',
                title: '货物名称',
                field: 'inName',
                sortable: true
            }, {
                width: '80',
                title: '货主',
                field: 'store',
                sortable: true
            }, {
                width: '120',
                title: '货主号码',
                field: 'phone',
                sortable: true
            },{
                width: '100',
                title: '货物型号',
                field: 'inSkumodel',
                sortable: true
            }, {
                width: '80',
                title: '发货数量',
                field: 'inNum',
                sortable: true
            }, {
                width: '70',
                title: '仓库',
                field: 'inWhid',
                sortable: true,
            }, {
                width: '130',
                title: '发货单号',
                field: 'inOddnumber',
                sortable: true
            }, {
                width: '100',
                title: '出库时间',
                field: 'inTime',
                sortable: true,
                formatter: formatDatebox
            }, {
                width: '80',
                title: '货物体积',
                field: 'inVolume',
                sortable: true
            },  {
                width: '80',
                title: '货物毛重',
                field: 'totalweigh',
                sortable: true
            }, {
                field: 'action',
                title: '操作',
                width: 150,
                formatter: function (value, row, index) {
                    var str = '';
                    <shiro:hasPermission name="/crossDatabase/update">
                    if(row.status == 0){
                        str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'" onclick="editFun(\'{0}\');" >确认发货</a>', row.inId);
                    }else{
                        str += $.formatString('<span style="height: 24px; color:red;" href="javascript:void(0)" class="user-easyui-linkbutton-oked">已发货</span>');
                    }
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/crossDatabase/delete">
                    str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                    str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.inId);
                    </shiro:hasPermission>
                    return str;
                }
            }]],
            onLoadSuccess: function (data) {
                $('.user-easyui-linkbutton-ok').linkbutton({text: '确认发货', plain: true, iconCls: 'icon-ok'});
                $('.user-easyui-linkbutton-oked').linkbutton({text: '已发货', plain: true, iconCls: 'icon-ok'});
                $('.user-easyui-linkbutton-del').linkbutton({text: '删除', plain: true, iconCls: 'icon-del'});
            },
            toolbar: '#toolbar'
        });
    });

    <!-- \\\\\\\\\\ 添加操作 \\\\\\\\\\ -->
    function addFun() {
        parent.$.modalDialog({
            title: '添加直接出库单',
            width: 500,
            height: 222,
            href: '${path }/invoice/getAddPage',
            buttons: [{
                text: '确认提交',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#invoiceAddForm');
                    f.submit();
                }
            }]
        });
    }

    <!-- \\\\\\\\\\ 删除操作 \\\\\\\\\\ -->
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前单号?', function (b) {
            if (b) {
                progressLoad();
                $.post('${path }/invoice/invoice/delete', {
                    id: id
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
    <!-- \\\\\\\\\\ 编辑操作 \\\\\\\\\\ -->
    function editFun(id) {
        if (id == undefined) {
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '修改直接出库单',
            width: 500,
            height: 300,
            href: '${path }/invoice/getEditPage?id=' + id,
            buttons: [{
                text: '确认提交',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#invoiceEditForm');
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
</body>
</html>