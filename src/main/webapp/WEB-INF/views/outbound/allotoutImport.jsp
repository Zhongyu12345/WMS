<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>导入调拨单</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div style="height:30px;padding:20px;">
    <form action="${path }/allotout/readExcle" method="post" enctype="multipart/form-data" >
        <input class="easyui-filebox" id="file" name="file" style="width:250px;" data-options="prompt:'请选择调拨单...'" >
        <input class="easyui-linkbutton" style="width:100px;height:24px;" type="submit" value="导入调拨单" />
    </form>

    <form id="allotoutImportForm" method="post">
        <table class="grid">
            <tr>
                <td>货物名称</td>
                <td><input name="aoName" type="text" placeholder="请输入货物名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${allotout.aoName}"></td>
                <td>货物型号</td>
                <td><input name="aoSkumodel" type="text" placeholder="请输入货物型号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${allotout.aoSkumodel}"></td>
            </tr>
            <tr>
                <td>调拨数量</td>
                <td><input name="aoNum" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${allotout.aoNum}"></td>
                <td>仓库编号</td>
                <td><input name="aoWhid" type="text" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${allotout.aoWhid}"></td>
                <!--
                <td><input name="aoWhid" id="selectCombobox" class="easyui-combobox"  data-options="required:true,validType:'length[1,10]',novalidate:true" /></td>
                -->
            </tr>
            <tr>
                <td>货物体积</td>
                <td><input name="aoVolume" type="text" placeholder="请输入货物体积" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${allotout.aoVolume}"></td>
                <td>调拨单号</td>
                <td><input name="aoSippingno" type="text" placeholder="请输入调拨数量" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]',novalidate:true" value="${allotout.aoSippingno}"></td>
            </tr>
            <tr>
                <td>调拨时间</td>
                <td><input name="byTime" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${allotout.aoTime}" />"/></td>
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
            var formParam = $("#allotoutImportForm").serialize();
            $.ajax({
                type: 'post',
                url: '${path }/allotout/allotout.php',
                data: formParam,
                cache: false,
                dataType: 'json',
                success: function () {
                    window.location.href = "${path }/allotout/allotout.html";
                }
            });
        }

        $(function(){
            $('input[type=text]').validatebox();
            $("#selectCombobox").combobox('setValue','${allotout.aoWhid}');
        });
    </script>
</body>
</html>