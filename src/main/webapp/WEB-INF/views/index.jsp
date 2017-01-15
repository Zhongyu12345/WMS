<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript">
    var index_layout;
    var index_tabs;
    var layout_west_tree;

    $(function() {
        var a = '${mesint}';
        if(a!=1){
       		window.location.href = '${path }/notice/message';
        }

        index_layout = $('#index_layout').layout({
            fit : true
        });
        index_tabs = $('#index_tabs').tabs({
            fit : true,
            border : false,
            tools : [{
                iconCls : 'icon-home',
                handler : function() {
                    index_tabs.tabs('select', 0);
                }
            }, {
                iconCls : 'icon-refresh',
                handler : function() {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    var tab = index_tabs.tabs('getTab', index);
                    var options = tab.panel('options');
                    if (options.content) {
                        index_tabs.tabs('update', {
                            tab: tab,
                            options: {
                                content: options.content
                            }
                        });
                    } else {
                        tab.panel('refresh', options.href);
                    }
                }
            }, {
                iconCls : 'icon-del',
                handler : function() {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    var tab = index_tabs.tabs('getTab', index);
                    if (tab.panel('options').closable) {
                        index_tabs.tabs('close', index);
                    }
                }
            } ]
        });
        
        layout_west_tree = $('#layout_west_tree').tree({
            url : '${path }/resource/tree',
            parentField : 'pid',
            lines : true,
            expanded:false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
           
                    addTab({
                        title : node.text,
                        url : url,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                
                    addTab({
                        title : node.text,
                        url : url,
                        iconCls : node.iconCls
                    });
                }
            }
        });
    });

    function addTab(params) {
        var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
        var t = $('#index_tabs');
        var opts = {
            title : params.title,
            closable : true,
            iconCls : params.iconCls,
            content : iframe,
            border : false,
            fit : true
        };
        if (t.tabs('exists', opts.title)) {
            t.tabs('select', opts.title);
        } else {
            t.tabs('add', opts);
        }
    }

    function logout(){
        $.messager.confirm('提示','确定要退出?',function(r){
            if (r){
                progressLoad();
                $.post('${path }/logout', function(result) {
                    if(result.success){
                        progressClose();
                        window.location.href='${path }';
                    }
                }, 'json');
            }
        });
    }

    function editUserPwd() {
        parent.$.modalDialog({
            title : '修改密码',
            width : 300,
            height : 250,
            href : '${path }/user/editPwdPage',
            buttons : [ {
                text : '确定',
                handler : function() {
                    var f = parent.$.modalDialog.handler.find('#editUserPwdForm');
                    f.submit();
                }
            } ]
        });
    }

</script>
</head>
<body>
    <div id="loading" style="position: fixed;top: -50%;left: -50%;width: 200%;height: 200%;background: #fff;z-index: 100;overflow: hidden;">
        <img src="${staticPath }/static/style/images/ajax-loader.gif" style="position: absolute;top: 0;left: 0;right: 0;bottom: 0;margin: auto;"/>
    </div>
    <div id="index_layout" style="background:red;">
        <div data-options="region:'north',border:false" style=" overflow: hidden; ">
            <div>
                <span style="float: right; padding-right: 20px; color: #333">
                      欢迎<font color="red"><b><shiro:principal></shiro:principal></b></font>&nbsp;&nbsp;
                    <shiro:hasPermission name="/user/editPwdPage">
                        <a href="javascript:void(0)" onclick="editUserPwd()" class="easyui-linkbutton" plain="true" icon="icon-edit" >修改密码</a>
                    </shiro:hasPermission>&nbsp;&nbsp;
                    <a href="javascript:void(0)" onclick="logout()" class="easyui-linkbutton" plain="true" icon="icon-clear">安全退出</a>
                    <br />
                    上次登录时间:${time}
                </span>
                <div>
                	<span class="header" style="float: left"></span>
                </div>
                <div style="width:700px;float:left;padding-top:5px;">
			    	<marquee vspace="5px" direction="left" width="100%" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="4" scrolldelay="1" style="font:bold 20px '黑体';color:red;">
			    		<img src="${staticPath }/static/style/images/b143f09fd2aa8bbc5462805be70cf44e.gif" style="height:35px;"/>&nbsp;
			    		 最新公告  内容:${notice.text}          发布时间:${notice.stringtime};
			    	</marquee>
			    </div>
            </div>
        </div>
        <div data-options="region:'west',split:true" title="菜单" style="width:200px; overflow: hidden;overflow-y:auto; padding:0px">
            <div class="well well-small" style="padding: 5px 5px 5px 5px;">
                <ul id="layout_west_tree"></ul>
            </div>
        </div>
        <div data-options="region:'center'" style="overflow: hidden;">
            <div id="index_tabs" style="overflow: hidden;">
                <div title="首页" data-options="iconCls:'l-btn-icon icon-home',border:false" style="overflow: hidden;">
                    <div>
                        <div style="float: right;">
                            <iframe allowtransparency="true" frameborder="0" width="185" height="74" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=1&z=1&t=0&v=0&d=1&bd=0&k=000000&f=&q=1&e=1&a=1&c=54511&w=185&h=74&align=center"></iframe>
                        </div>
                        <div style="padding-top: 100px;padding-left: 70px;">
                            <div style="float:left;letter-spacing:3px;font-size:17px;width:40%;text-indent: 2em;padding-left: 30px;">
                                仓储管理是整个供应链管理体系中非常重要的环节，随着电商行业的不断发展，越来越多的商家开始重视仓库的管理效率，选择一套合适的仓储管理系统就是管好电商仓库的一个必要条件。
                                管易EC-WMS产品是一款专门针对电子商务行业的仓储管理软件，可以集中管理线上线下库存，支持多仓库、多货主等不同的业务模式，支持多部门、多角色协同办公，支持RF手持设备作业，
                                可以精确跟踪货物从入库到出库的整个过程。依靠灵活多变的收获策略、补货策略、批次策略、分配策略、波茨策略和出库策略，管易EC-WMS从老产品的记录型系统全面提升为专业的指导型系统，
                                可以满足电商企业精细化的库存管理需求，提升仓储操作的工作效率。
                            </div>
                            <div style="float:right;height:300px;padding-right: 50px;">
                                <img alt="" src="${staticPath }/static/style/images/p_wms.png">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div data-options="region:'south',border:false" style="height: 30px;line-height:30px; overflow: hidden;text-align: center;background-color: #eee" >Copyright © 2017 技术支持 <a href="http://www.htit-china.com/" target="_blank">宏图软件教育</a></div>
    </div>

    <!--[if lte IE 7]>
    <div id="ie6-warning"><p>您正在使用 低版本浏览器，在本页面可能会导致部分功能无法使用。建议您升级到 <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">Internet Explorer 8</a> 或以下浏览器：
    <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> / <a href="http://www.google.com/chrome/?hl=zh-CN" target="_blank">Chrome</a> / <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> / <a href="http://www.operachina.com/" target="_blank">Opera</a></p></div>
    <![endif]-->

    <style>
        /*ie6提示*/
        #ie6-warning{width:100%;position:absolute;top:0;left:0;background:#fae692;padding:5px 0;font-size:12px}
        #ie6-warning p{width:960px;margin:0 auto;}
    </style>
</body>
</html>