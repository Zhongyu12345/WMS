<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
    <script type="text/javascript">

    var dataGrid;

    $(function() {

        dataGrid = $('#dataGrid').datagrid({
            url : '${path }/salesreturn/select',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            height : '27',
            idField : 'id',
            sortName : 'createTime',
            sortOrder : 'asc',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '100',
                title : '货物名称',
                align:'center',
                field : 'srName',
                sortable : true
            }, {
                width : '100',
                title : '客户托单号',
                align:'center',
                field : 'srSipping',
                sortable : true
            } , {
                width : '80',
                title : '客户',
                align:'center',
                field : 'srStorerid',
                sortable : true
            } , {
                width : '90',
                title : '客户电话',
                align:'center',
                field : 'srPhone',
                sortable : true
            } ,{
                width : '100',
                title : '货物型号',
                align:'center',
                field : 'srSkumodel',
                sortable : true
            } ,{
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
            } , {
                width : '80',
                title : '退货数量<a style="color:blue;">(个)</a>',
                align:'center',
                field : 'srNum',
                sortable : true
            } ,  {
                width : '80',
                title : '退货体积<a style="color:blue;">(m³)</a>',
                align:'center',
                field : 'srVolume',
                sortable : true
            } ,  {
                width : '100',
                title : '退货原因',
                align:'center',
                field : 'srCause',
                sortable : true
            } ,   {
                width : '120',
                title : '退货时间',
                align:'center',
                field : 'srTime',
                sortable : true,
                formatter: formatDatebox
            } ,    {
                field : 'action',
                title : '操作',
                align:'center',
                width : 130,
                formatter : function(value, row, index) {
                    var str = '';
                        <shiro:hasPermission name="/salesreturn/edit">
                            str += $.formatString('<a  style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.srId);
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/salesreturn/delete">
                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                            str += $.formatString('<a  style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.srId);
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
    
    
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前用户？', function(b) {
            if (b) {
                var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
                if (currentUserId != id) {
                    progressLoad();
                    $.post('${path }/salesreturn/delete', {
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
            width : 500,
            height : 300,
            href : '${path }/salesreturn/editPage?id=' + id,
            buttons : [ {
                text : '确定',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#salesreturnEditForm');
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
    <div data-options="region:'north',border:true" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>货物名称:</th>
                    <td><input name="srName" placeholder="请输入货物名称"/></td>
                    <th>客户托单号:</th>
                    <td><input name="srSipping" placeholder="请输入托单号"/></td>
                    <th>退货时间:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'退货列表'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
</body>
</html>