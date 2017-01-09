<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>越库出货单导入</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div style="height:30px;padding:20px;">
    <form action="${path }/crossDatabase/readExcle" method="post" enctype="multipart/form-data" >
        <input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择越库出货单...'" >
        <input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入越库出货单" />
    </form>

    <form id="crossDatabaseImportForm" method="post">
        <table class="grid">
            <tr>
                <td>货物名称</td>
                <td><input name="cdName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdName}"></td>
                <td>货物型号</td>
                <td><input name="cdSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdSkumodel}"></td>
            </tr>
            <tr>
                <td>发货数量</td>
                <td><input name="cdNum" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdNum}"></td>
                <td>仓库</td>
                <td><input name="cdWhid" type="text" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdWhid}"></td>
                <!--
                <td><input name="aoWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,validType:'length[1,10]',novalidate:true" /></td>
                -->
            </tr>
            <tr>
                <td>货物体积</td>
                <td><input name="cdVolume" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdVolume}"></td>
                <td>发货单号</td>
                <td><input name="cdOddnumbers" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.cdOddnumbers}"></td>
            </tr>
            <tr>
                <td>发货时间</td>
                <td><input name="byTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${crossDatabase.cdTime}" />"/></td>
                <td>发货重量</td>
                <td><input name="totalweigh" type="text" placeholder="请输入发货重量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.totalweigh}"></td>
            </tr>
            <tr>
                <td>货主</td>
                <td><input name="store" type="text" placeholder="请输入货主" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.store}"></td>
                <td>货主号码</td>
                <td><input name="phone" type="text" placeholder="请输入货主号码" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${crossDatabase.phone}"></td>
            </tr>
        </table>
    </form>
    <div>
        <a href="javascript:void(0);" style="margin-left: 800px;" class="easyui-linkbutton" onclick="add();">确认</a>
    </div>
</div>

    <script>
        $("#selectCombobox").combobox({
            url: "${path }/godown/godownComboBox",
            method: 'get',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            onLoadSuccess: function () {
                var data = $('#selectCombobox').combobox('getData');
                if (data.length > 0) {
                    $("#selectCombobox").combobox('select', data[0].id);
                }
            }
        });

        function add() {
            var formParam = $("#crossDatabaseImportForm").serialize();
            $.ajax({
                type: 'post',
                url: '${path }/crossDatabase/crossDatabase.php',
                data: formParam,
                cache: false,
                dataType: 'json',
                success: function () {
                    window.location.href = "${path }/crossDatabase/crossDatabase.html";
                }
            });
        }

        $(function(){
            $('input[type=text]').validatebox();
            $("#selectCombobox").combobox('setValue','${crossDatabase.cdWhid}');
        });
    </script>
</body>
</html>