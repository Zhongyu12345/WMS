/**
 * 仓库下拉框JS
 * Created by ZhongYu on 2016/12/27.
 */

$("#selectCombobox").combobox({
    url: getRootPath() + "/godown/godownComboBox",
    method: 'get',
    valueField: 'id',
    textField: 'text',
    panelHeight: 'auto',
    editable:false,
    onLoadSuccess: function () {
        var data = $('#selectCombobox').combobox('getData');
        if (data.length > 0) {
            $("#selectCombobox").combobox('select', data[0].id);
        }
    }
});

function getRootPath() {  
    var pathName = window.location.pathname.substring(1);  
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';  
}




