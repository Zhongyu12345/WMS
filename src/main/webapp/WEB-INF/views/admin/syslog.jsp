<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日志管理</title>
    <script type="text/javascript">
        var dataGrid;
        $(function () {
            dataGrid = $('#dataGrid').datagrid({
                url: '${path }/sysLog/dataGrid',
                fit: true,
                striped: true,
                pagination: true,
                singleSelect: true,
                idField: 'id',
                pageSize: 20,
                pageList: [10, 20, 30, 40, 50, 100, 200, 300, 400, 500],
                columns: [[{
                    width: '80',
                    title: '登录名',
                    field: 'loginName',
                    sortable: true
                }, {
                    width: '80',
                    title: '用户名',
                    field: 'roleName'
                }, {
                    width: '100',
                    title: 'IP地址',
                    field: 'clientIp',
                    sortable: true
                }, {
                    width: '800',
                    title: '内容',
                    field: 'optContent'
                }, {
                    width: '200',
                    title: '创建时间',
                    field: 'createTime'
                }]]
            });
        });
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',border:false">
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
</body>
</html>