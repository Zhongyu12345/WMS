<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#cargoborrwAddForm').form({
            url : '${path }/borrow/add?status='+1,
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('enableValidation').form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.messager.alert('提示', result.msg, 'warning');
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    parent.$.modalDialog.handler.dialog('close');
                }else{
                    parent.$.messager.alert('提示', result.msg, 'warning');
                }
            }
        });
        
    });

    var SelectDataGrid;
    function selectData() {
        $("#selectData").window("open");
        SelectDataGrid = $('#SelectDataGrid').datagrid({
            url : '${path }/cargo/select',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            height : '27',
            idField : 'cId',
            sortName : 'id',
            sortOrder : 'asc',
            pageSize : 10,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '90',
                title : '货物名称',
                field : 'cName',
                sortable : true
            },{
                width : '120',
                title : '客户托单号',
                field : 'cShippingno',
                sortable : true
            },{
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
                width : '70',
                title : '货物型号',
                field : 'cSkumodel',
                sortable : true
            },{
                field : 'action',
                title : '操作',
                width : 60,
                formatter : function(value, row, index) {
                    var str = '';
                    <shiro:hasPermission name="/borrow/edit">
                        str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-ok\'" onclick="yes(\'{0}\');" >确定</a>');
                    </shiro:hasPermission>
                    return str;
                }
            }] ],
            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-edit').linkbutton({text:'确定',plain:true});
            },
        });
    }

    var SelectUserGrid;
    function selectUser(){
        $("#SelectUser").window("open");
        SelectUserGrid = $('#SelectUserGrid').datagrid({
            url : '${path }/borrow/user',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            sortName : 'createTime',
            sortOrder : 'asc',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '80',
                title : '登录名',
                field : 'loginName',
                sortable : true
            },{
                width : '80',
                title : '姓名',
                field : 'name',
                sortable : true
            },{
                width : '40',
                title : '性别',
                field : 'sex',
                sortable : true
            },{
                width : '40',
                title : '年龄',
                field : 'age',
                sortable : true
            },{
                width : '120',
                title : '电话',
                field : 'phone',
                sortable : true
            },{
                field : 'action',
                title : '操作',
                width : 60,
                formatter : function(value, row, index) {
                    var str = '';
                    <shiro:hasPermission name="/borrow/edit">
                    str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-ok\'" onclick="useryes(\'{0}\');" >确定</a>');
                    </shiro:hasPermission>
                    return str;
                }
            }]],
            onLoadSuccess:function(data){
                $('.user-easyui-linkbutton-edit').linkbutton({text:'确定',plain:true});
            },
        });
    }

    function useryes() {
        var userrow=$("#SelectUserGrid").datagrid("getSelected");
        $("#cbNames").val(userrow.name);
        $("#SelectUser").window("close");
    }

    function yes() {
        var row=$("#SelectDataGrid").datagrid("getSelected");
        $("#cbId").val(row.cId);
        $("#cbName").val(row.cName);
        $("#cbSkumodel").val(row.cSkumodel);
        $("#selectData").window("close");
    }

    /*货物----------*/
    function searchFun() {
        SelectDataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }

    function cleanFun() {
        $('#searchForm input').val('');
        SelectDataGrid.datagrid('load', {});
    }

    /*用户--------*/
    function UsersearchFun() {
        SelectUserGrid.datagrid('load', $.serializeObject($('#usersearchForm')));
    }

    function cleanFun() {
        $('#usersearchForm input').val('');
        SelectUserGrid.datagrid('load', {});
    }

    $.extend($.fn.validatebox.defaults.rules, {
        cbNum: {
            validator: function () {
                var row=$("#SelectDataGrid").datagrid("getSelected");
                var num = row.cNum;
                var cbNum = $("#cbNum").val();
                if(cbNum <= num){
                    return true;
                }
            },
            message: '您输入的数量超过了库存的最大数量'
        }
    });

</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="cargoborrwAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>货物名称</td>
                    <td><input id="cbName" name="cbName" type="text" onclick="selectData();" readonly="readonly"  placeholder="请输入货物名称" class="easyui-validatebox"  data-options="required:true,novalidate:true" value=""></td>
                    <td>货物型号</td>
                    <td><input name="cbSkumodel" id="cbSkumodel" type="text" readonly placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""></td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td><input id="cbNum" name="cbNum" type="text" validType="cbNum[]" class="easyui-numberbox" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""></td>
                    <td>借用人</td>
                    <td><input id="cbNames" name="cbNames" onclick="selectUser();"  readonly="readonly" type="text" placeholder="请选择借用人姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""/></td>
                </tr>
                <tr>
                    <td>日期</td>
                    <td><input name="cbTime" placeholder="请选择时间" class="easyui-validatebox" data-options="required:true,novalidate:true" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
                    <td></td>
                    <td><input id="cbId" name="cbId"  type="hidden"/></td>
                </tr>
                <tr>
                    <td>原因</td>
                    <td colspan="3"><textarea rows="3" cols="30" name="cbCause" class="easyui-validatebox" data-options="required:true,novalidate:true" style="width: 240px;height: 50px;"></textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div id="selectData" class="easyui-window" style="width:660px;height:300px;" title="货品表" data-options="closable:true, closed:true">
    <form id="searchForm">
        <table>
            <tr>
                <th>货物型号:</th>
                <td><input name="cSkumodel" placeholder="请输入货物型号"/></td>
                <td>
                  <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>
     <table id="SelectDataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="SelectUser" class="easyui-window" style="width:470px;height:300px;" title="用户信息表" data-options="closable:true, closed:true">
    <form id="usersearchForm">
        <table>
            <tr>
                <th>姓名:</th>
                <td><input name="name" placeholder="请输入姓名"/></td>
                <td>
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="UsersearchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>
    <table id="SelectUserGrid" data-options="fit:true,border:false"></table>
</div>
