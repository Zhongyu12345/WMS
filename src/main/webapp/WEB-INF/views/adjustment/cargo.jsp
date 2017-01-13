<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>货品表</title>
    <script type="text/javascript">

        var dataGrid;
        var organizationTree;

        $(function() {
            dataGrid = $('#dataGrid').datagrid({
                url : '${path }/cargo/select',
                fit : true,
                striped : true,
                rownumbers : true,
                pagination : true,
                singleSelect : false,
                height : '27',
                idField : 'cId',
                sortName : 'id',
                sortOrder : 'asc',
                pageSize : 20,
                pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
                columns : [ [ {
                    width : '90',
                    title : '货物名称',
                    field : 'cName',
                    sortable : true
                }, {
                    width : '70',
                    title : '货主',
                    field : 'cStorerid',
                    sortable : true
                }, {
                    width : '100',
                    title : '货主号码',
                    field : 'cPhone',
                    sortable : true
                },{
                    width : '100',
                    title : '供应商',
                    field : 'cSupplierid',
                    sortable : true
                },  {
                    width : '120',
                    title : '客户托单号',
                    field : 'cShippingno',
                    sortable : true
                }, {
                    width : '70',
                    title : '仓库编码',
                    field : 'godowns',
                    sortable : true,
                    formatter: function (value) {
                        var roles = [];
                        for(var i = 0; i< value.length; i++) {
                            roles.push(value[i].goWhid);
                        }
                        return(roles.join('\n'));
                    }
                },{
                    width : '80',
                    title : '数量<a style="color:blue;">(个)</a>',
                    field : 'cNum',
                    sortable : true
                },{
                    width : '90',
                    title : '总货毛重<a style="color:blue;">(/kg)</a>',
                    field : 'cTotalweight',
                    sortable : true
                },{
                    width : '90',
                    title : '总货体积<a style="color:blue;">(m³)</a>',
                    field : 'cTotalvolume',
                    sortable : true
                },{
                    width : '150',
                    title : '入库时间',
                    field : 'cReceivedate',
                    sortable : true,
                    formatter: formatDatebox
                },{
                    width : '70',
                    title : '货物型号',
                    field : 'cSkumodel',
                    sortable : true
                },{
                    field : 'action',
                    title : '操作',
                    width : 130,
                    formatter : function(value, row, index) {
                        var str = '';
                        <shiro:hasPermission name="/user/edit">
                          str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.cId);
                        </shiro:hasPermission>
                        <shiro:hasPermission name="/user/delete">
                            str += '&nbsp;&nbsp;';
                            str += $.formatString('<a style="height:24px;" href="javascript:void(0)" class="user-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-del\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.cId);
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
           var rows = dataGrid.datagrid('getSelections');
           if(rows != null && rows != ""){
               var data = [];
               for(var i=0;i<rows.length;i++){
                   if(rows.length >0){
                       data.push(rows[i].cId);
                       data.push(rows[i].cName);
                       data.push(rows[i].cWhid);
                       data.push(rows[i].cSkumodel);
                       data.push("");
                       data.push("");
                   }
               }
               window.location.href = '${path }/make/ToDiskExcel?data='+data;
           }else{
               parent.$.messager.alert('提示',"请选择您要导出的数据", 'info');
           }
        }

        function addAllo() {
            var rows = $("#dataGrid").datagrid('getSelected');
            if(rows != null && rows != ""){
                var cName = rows.cName;
                var cStorerid = rows.cStorerid;
                var cSupplierid = rows.cSupplierid;
                var cWhid = rows.cWhid;
                var cNum = rows.cNum;
                var cTotalweight = rows.cTotalweight;
                var cTotalvolume = rows.cTotalvolume;
                var cSkumodel = rows.cSkumodel;
                var cPhone = rows.cPhone;
                window.location.href = '${path }/cargo/ToDiskExcelAll?cName='
                    +cName+'&cStorerid='+cStorerid+'&cSupplierid='+cSupplierid
                    +'&cWhid='+cWhid+'&cNum='+cNum+'&cTotalweight='+cTotalweight
                    +'&cTotalvolume='+cTotalvolume+'&cSkumodel='+cSkumodel+"&cPhone="+cPhone;
            }else{
                parent.$.messager.alert('提示',"请选择您要导出的数据", 'info');
            }
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
                    $.post('${path }/cargo/deletepk', {
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
                <td><input name="cSkumodel" placeholder="请输入货物型号"/></td>
                <th>创建时间:</th>
                <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>

</div>
<div data-options="region:'center',border:true,title:'货物表'" >
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="toolbar" style="display: none;padding:5px;">
    <shiro:hasPermission name="/cargo/insert">
        <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-folder'">打印盘点货物单</a>
        <a onclick="addAllo();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-folder'">打印货物出库单</a>
    </shiro:hasPermission>
</div>
</body>
</html>