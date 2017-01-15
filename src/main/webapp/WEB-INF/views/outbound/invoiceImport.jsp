<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>直接出库单导入</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div style="height:30px;padding:20px;">
    <form action="${path }/invoice/ReadExcel" method="post" enctype="multipart/form-data" >
        <input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择直接出库单...'" >
        <input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入直接出库单" />
    </form>

    <form id="invoiceImportForm" method="post">
        <table class="grid">
            <tr>
                <td>货物名称</td>
                <td><input name="inName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.inName}"></td>
                <td>货物型号</td>
                <td><input name="inSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.inSkumodel}"></td>
            </tr>
            <tr>
                <td>货主</td>
                <td><input name="store" type="text" placeholder="请输入货主姓名" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.store}"></td>
                <td>货主号码</td>
                <td><input name="phone" type="text" placeholder="请输入货主号码" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.phone}"></td>
            </tr>
            <tr>
                <td>调拨数量</td>
                <td><input name="inNum" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.inNum}"></td>
                <td>仓库</td>
                <td><input name="inWhid" type="text" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.inWhid}"></td>
            </tr>
            <tr>
                <td>货物体积</td>
                <td><input name="inVolume" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.inVolume}"></td>
                <td>调拨单号</td>
                <td><input name="inOddnumber" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.inOddnumber}"></td>
            </tr>
            <tr>
                <td>货物毛重</td>
                <td><input name="totalweigh" type="text" placeholder="请输入货物毛重" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${invoice.totalweigh}"></td>
                <td>调拨时间</td>
                <td><input name="byTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${invoice.inTime}" />"/></td>
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
            var formParam = $("#invoiceImportForm").serialize();
            $.ajax({
                type: 'post',
                url: '${path }/invoice/invoice.php',
                data: formParam,
                cache: false,
                dataType: 'json',
                success: function () {
                    window.location.href = "${path }/invoice/invoice.html";
                }
            });
        }

        $(function(){
            $('input[type=text]').validatebox();
            $("#selectCombobox").combobox('setValue','${invoice.inWhid}');
        });
    </script>
</body>
</html>