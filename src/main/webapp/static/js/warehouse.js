/**
 * 仓库下拉框JS
 * Created by ZhongYu on 2016/12/27.
 */
var contextPath = '';

$("#selectCombobox").combobox({
    url: contextPath + "/godown/godownComboBox",
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