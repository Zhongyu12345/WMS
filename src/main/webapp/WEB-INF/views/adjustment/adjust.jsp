<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>

    <meta http-equiv="X-UA-Compatible" content="edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>调整出入库单查询</title>
    <script type="text/javascript">

        var dataGrid;
        var organizationTree;

        $(function() {

            dataGrid = $('#dataGrid').datagrid({
                url : '${path }/adjust/select',
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
                columns : [ [ {
                    width : '80',
                    title : '货物名称',
                    align:'center',
                    field : 'jName',
                    sortable : true
                }, {
                    width : '100',
                    title : '货物编号',
                    align:'center',
                    field : 'jSkumodel',
                    sortable : true
                },{
                    width : '80',
                    align:'center',
                    title : '调整数量<a style="color:blue;">(个)</a>',
                    field : 'jNum',
                    sortable : true
                },  {
                    width : '50',
                    align:'center',
                    title : '调整人',
                    field : 'jNames',
                    sortable : true
                }, {
                    width : '180',
                    align:'center',
                    title : '调整原因',
                    field : 'jCause',
                    sortable : true
                },{
                    width : '150',
                    align:'center',
                    title : '调整时间',
                    field : 'jTime',
                    sortable : true,
                    formatter: formatDatebox
                },{
                    width : '100',
                    align:'center',
                    title : '调入仓库',
                    field : 'godowns',
                    sortable : true,
                    formatter: function (value) {
                        var roles = [];
                        for(var i = 0; i< value.length; i++) {
                            roles.push(value[i].goWhid);
                        }
                        return(roles.join('\n'));
                    }
                }, {
                        width : '80',
                        title : '货物体积<a style="color:blue;">(m³)</a>',
                        field : 'jVolum',
                        align:'center',
                        sortable : true
                },{
                        field : 'action',
                        title : '操作',
                        width : 130,
                        formatter : function(value, row, index) {
                            var str = '';
                            <shiro:hasPermission name="/adjust/delete">
                            str += '&nbsp;&nbsp;';
                            str += $.formatString('<a style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.jId);
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
            parent.$.messager.confirm('询问', '您是否要删除当前行数据？', function(b) {
                if (b) {
                    var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
                    if (currentUserId != id) {
                        progressLoad();
                        $.post('${path }/adjust/delete', {
                            id : id
                        }, function(result) {
                            if (result.success) {
                                parent.$.messager.alert('提示', result.msg, 'info');
                                dataGrid.datagrid('reload');
                            }
                            progressClose();
                        }, 'JSON');
                    }
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
                <th>货物编号:</th>
                <td><input name="jSkumodel" placeholder="请输入货物编号"/></td>
                <th>调整时间:</th>
                <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div data-options="region:'center',border:true,title:'货物调整出入表'" >
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
</body>
</html>