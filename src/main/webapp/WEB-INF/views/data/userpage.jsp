<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/basejs.jsp" %>
<script type="text/javascript">
	var dataGrid;
	$(function() {
	
	    dataGrid = $('#dataGrid').datagrid({
	        url : '${path }/user/dataGrid',
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
	        }, {
	            width : '80',
	            title : '姓名',
	            field : 'name',
	            sortable : true
	        },{
	            width : '130',
	            title : '创建时间',
	            field : 'createTime',
	            sortable : true
	        },  {
	            width : '40',
	            title : '性别',
	            field : 'sex',
	            sortable : true,
	            formatter : function(value, row, index) {
	                switch (value) {
	                case 0:
	                    return '男';
	                case 1:
	                    return '女';
	                }
	            }
	        }, {
	            width : '40',
	            title : '年龄',
	            field : 'age',
	            sortable : true
	        },{
	            width : '120',
	            title : '电话',
	            field : 'phone',
	            sortable : true
	        }, 
	        {
	            width : '200',
	            title : '角色',
	            field : 'rolesList',
	            sortable : true,
	            formatter : function(value, row, index) {
	                var roles = [];
	                for(var i = 0; i< value.length; i++) {
	                    roles.push(value[i].name);  
	                }
	                return(roles.join('\n'));
	            }
	        }, {
	            width : '60',
	            title : '用户类型',
	            field : 'userType',
	            sortable : true,
	            formatter : function(value, row, index) {
	                if(value == 0) {
	                    return "管理员";
	                }else if(value == 1) {
	                    return "用户";
	                }
	                return "未知类型";
	            }
	        },{
	            width : '60',
	            title : '状态',
	            field : 'status',
	            sortable : true,
	            formatter : function(value, row, index) {
	                switch (value) {
	                case 0:
	                    return '正常';
	                case 1:
	                    return '停用';
	                }
	            }
	        } , {
	            field : 'action',
	            title : '操作',
	            width : 130,
	            formatter : function(value, row, index) {
	                var str = '';
	                    <shiro:hasPermission name="/user/edit">
	                        str += $.formatString('<a style="height: 24px;" href="javascript:void(0)" style="height:25px;" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.id);
	                    </shiro:hasPermission>
	                    <shiro:hasPermission name="/user/delete">
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
	    });
	});
	
	function searchFun() {
	    dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
	    $('#searchForm input').val('');
	    dataGrid.datagrid('load', {});
	}
</script>
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
    <div data-options="region:'center',border:true,title:'用户列表'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
</body>