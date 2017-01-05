<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>出货单导入</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div style="height:30px;padding:20px;">
    <form action="${path }/shipment/readExcle" method="post" enctype="multipart/form-data" >
        <input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择出货单...'" >
        <input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入出货单" />
    </form>

    <form id="shipmentImportForm" method="post">
        <table class="grid">
            <tr>
                <td>货主</td>
                <td><input name="shStoreid" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shStoreid}"></td>
                <td>时间</td>
                <td><input name="byTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${shipment.shTime}" />"/></td>
            </tr>
            <tr>
                <td>号码</td>
                <td><input name="shPhone" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shPhone}"></td>
                <td>单号</td>
                <td><input name="shSippingno" type="text" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shSippingno}"></td>
            </tr>
            <tr>
                <td>仓库</td>
                <td><input name="shWhid" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shWhid}"></td>
                <td>损坏数量</td>
                <td><input name="shDamage" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shDamage}"></td>
            </tr>
            <tr>
                <td>型号</td>
                <td><input name="shSkumodel" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shSkumodel}"></td>
                <td>实际数量</td>
                <td><input name="shShnum" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shShnum}"></td>
            </tr>
            <tr>
                <td>毛重</td>
                <td><input name="shTotalweigh" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shTotalweigh}"></td>
                <td>体积</td>
                <td><input name="shTotalvolume" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${shipment.shTotalvolume}"></td>
            </tr>
            <tr>
                <td>损坏原因</td>
                <td colspan="3"><textarea rows="3" cols="40" name="shCause" style="width: 397px;height: 50px;">${shipment.shCause}</textarea></td>
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
            var formParam = $("#shipmentImportForm").serialize();
            $.ajax({
                type: 'post',
                url: '${path }/shipment/shipment.php',
                data: formParam,
                cache: false,
                dataType: 'json',
                success: function () {
                    window.location.href = "/shipment/shipment.html";
                }
            });
        }

        $(function(){
            $('input[type=text]').validatebox();
            $("#selectCombobox").combobox('setValue','${shipment.shWhid}');
        });
    </script>
</body>
</html>