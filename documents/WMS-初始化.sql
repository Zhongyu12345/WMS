/*
Navicat MySQL Data Transfer

Source Server         : 111
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-12-15 19:26:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(32) DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `resource_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '权限管理', '', '系统管理', 'icon-company', null, '0', '0', '0', '2016-12-15 10:54:47');
INSERT INTO `resource` VALUES ('2', '入库管理', null, '入库管理', 'icon-company', null, '0', '0', '0', '2016-12-15 11:01:14');
INSERT INTO `resource` VALUES ('3', '在库管理', null, '在库管理', 'icon-company', null, '0', '0', '0', '2016-12-15 11:08:53');
INSERT INTO `resource` VALUES ('4', '出库管理', null, '出库管理', 'icon-company', null, '0', '0', '0', '2016-12-15 11:09:43');
INSERT INTO `resource` VALUES ('5', '流通加工出库', null, '流通加工出库', 'icon-company', null, '0', '0', '0', '2016-12-15 11:10:33');
INSERT INTO `resource` VALUES ('6', '财务管理', null, '财务管理', 'icon-company', null, '0', '0', '0', '2016-12-15 11:10:55');
INSERT INTO `resource` VALUES ('7', '数据报表', null, '数据报表', 'icon-company', null, '0', '0', '0', '2016-12-15 11:11:25');
INSERT INTO `resource` VALUES ('8', '系统管理', null, '系统管理', 'icon-company', null, '0', '0', '0', '2016-12-15 11:11:54');
INSERT INTO `resource` VALUES ('9', '收货入库确认', null, '收货入库确认', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:14:47');
INSERT INTO `resource` VALUES ('10', '收货单管理', null, '收货单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:15:27');
INSERT INTO `resource` VALUES ('11', '调拨单入库管理', null, '调拨单入库管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:18:03');
INSERT INTO `resource` VALUES ('12', '调拨入库单管理', null, '调拨入库单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:18:36');
INSERT INTO `resource` VALUES ('13', '新增退货单管理', null, '新增退货单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:19:20');
INSERT INTO `resource` VALUES ('14', '退货入库单管理', null, '退货入库单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:20:10');
INSERT INTO `resource` VALUES ('15', '新增调整入库单', null, '新增调整入库单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:21:42');
INSERT INTO `resource` VALUES ('16', '新增调整出库单', null, '新增调整出库单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:22:21');
INSERT INTO `resource` VALUES ('17', '库存调整单查询', null, '库存调整单查询', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:23:12');
INSERT INTO `resource` VALUES ('18', '货品借出登记', null, '货品借出登记', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:23:58');
INSERT INTO `resource` VALUES ('19', '货品归还登记', null, '货品归还登记', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:24:31');
INSERT INTO `resource` VALUES ('20', '借出货品查询', null, '借出货品查询', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:24:55');
INSERT INTO `resource` VALUES ('21', '盘点单管理', null, '盘点单管理', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:25:22');
INSERT INTO `resource` VALUES ('22', '打印空白盘点单', null, '打印空白盘点单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:26:02');
INSERT INTO `resource` VALUES ('23', '新增调拨单', null, '新增调拨单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:26:28');
INSERT INTO `resource` VALUES ('24', '新增出货单', null, '新增出货单', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:27:02');
INSERT INTO `resource` VALUES ('25', '出货单管理', null, '出货单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:27:29');
INSERT INTO `resource` VALUES ('26', '调拨单出库管理', null, '调拨单出库管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:28:14');
INSERT INTO `resource` VALUES ('27', '调拨出库单管理', null, '调拨出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:28:50');
INSERT INTO `resource` VALUES ('28', '新增越货出库单', null, '新增越货出库单', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:29:38');
INSERT INTO `resource` VALUES ('29', '越货出库单管理', null, '越货出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:30:35');
INSERT INTO `resource` VALUES ('30', '新增直接出库单', null, '新增直接出库单', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:31:16');
INSERT INTO `resource` VALUES ('31', '直接出库单管理', null, '直接出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:31:47');
INSERT INTO `resource` VALUES ('32', '新增货品加工BOM方案', null, '新增货品加工BOM方案', 'menu_icon_datadeal', '5', '0', '0', '0', '2016-12-15 11:32:38');
INSERT INTO `resource` VALUES ('33', '加工方案管理', null, '加工方案管理', 'menu_icon_datadeal', '5', '0', '0', '0', '2016-12-15 11:33:55');
INSERT INTO `resource` VALUES ('34', '账户总览', null, '账户总览', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:34:55');
INSERT INTO `resource` VALUES ('35', '财务日结表', null, '财务日结表', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:35:23');
INSERT INTO `resource` VALUES ('36', '财务支出统计表', null, '财务支出统计表', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:36:06');
INSERT INTO `resource` VALUES ('37', '新增员工薪资单', null, '新增员工薪资单', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:37:17');
INSERT INTO `resource` VALUES ('38', '薪资单管理', null, '薪资单管理', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:37:48');
INSERT INTO `resource` VALUES ('39', '新增收入', null, '新增收入', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:38:29');
INSERT INTO `resource` VALUES ('40', '新增支出', null, '新增支出', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:38:46');
INSERT INTO `resource` VALUES ('41', '入库计划报表', null, '入库计划报表', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:39:27');
INSERT INTO `resource` VALUES ('42', '实际收货报表', null, '实际收货报表', 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-15 11:40:07');
INSERT INTO `resource` VALUES ('43', '入库计划差异报表', null, '入库计划差异报表', 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-15 11:41:16');
INSERT INTO `resource` VALUES ('44', '出库退货报表', null, '出库退货报表', 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-15 11:41:46');
INSERT INTO `resource` VALUES ('45', '修改密码', null, '修改密码', 'menu_icon_datadeal', '8', '0', '0', '0', '2016-12-15 11:42:09');
INSERT INTO `resource` VALUES ('46', '修改资料', null, '修改资料', 'menu_icon_datadeal', '8', '0', '0', '0', '2016-12-15 11:42:28');
INSERT INTO `resource` VALUES ('47', '公告栏', null, '公告栏', 'menu_icon_datadeal', '8', '0', '0', '0', '2016-12-15 11:42:58');
INSERT INTO `resource` VALUES ('48', '资源管理', '/resource/manager', '资源管理', 'menu_icon_datadeal', '1', '0', '0', '0', '2016-12-15 11:47:21');
INSERT INTO `resource` VALUES ('49', '角色管理', '/role/manager', '角色管理', 'menu_icon_datadeal', '1', '0', '0', '0', '2016-12-15 11:47:40');
INSERT INTO `resource` VALUES ('50', '用户管理', '/user/manager', '用户管理', 'menu_icon_datadeal', '1', '0', '0', '0', '2016-12-15 11:48:12');
INSERT INTO `resource` VALUES ('51', '列表', '/resource/treeGrid', '资源列表', 'icon-list', '48', '0', '0', '0', '2016-12-15 15:44:36');
INSERT INTO `resource` VALUES ('52', '添加', '/resource/add', '资源添加', 'icon-add', '48', '0', '0', '1', '2016-12-15 15:44:47');
INSERT INTO `resource` VALUES ('53', '编辑', '/resource/edit', '资源编辑', 'icon-edit', '48', '0', '0', '1', '2016-12-15 15:44:58');
INSERT INTO `resource` VALUES ('54', '删除', '/resource/delete', '资源删除', 'icon-del', '48', '0', '0', '1', '2016-12-15 15:45:05');
INSERT INTO `resource` VALUES ('55', '列表', '/role/dataGrid', '角色列表', 'icon-list', '49', '0', '0', '0', '2016-12-15 15:53:27');
INSERT INTO `resource` VALUES ('56', '添加', '/role/add', '角色添加', 'icon-add', '49', '0', '0', '1', '2016-12-15 15:44:47');
INSERT INTO `resource` VALUES ('57', '编辑', '/role/edit', '角色编辑', 'icon-edit', '49', '0', '0', '1', '2016-12-15 15:44:58');
INSERT INTO `resource` VALUES ('58', '删除', '/role/delete', '角色删除', 'icon-del', '49', '0', '0', '1', '2016-12-15 15:45:05');
INSERT INTO `resource` VALUES ('59', '授权', '/role/grant', '角色授权', 'icon-ok', '49', '0', '0', '1', '2016-12-15 15:54:30');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0', '超级管理员', '0');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1', '1');
INSERT INTO `role_resource` VALUES ('2', '1', '48');
INSERT INTO `role_resource` VALUES ('3', '1', '49');
INSERT INTO `role_resource` VALUES ('4', '1', '50');
INSERT INTO `role_resource` VALUES ('5', '1', '51');
INSERT INTO `role_resource` VALUES ('6', '1', '52');
INSERT INTO `role_resource` VALUES ('7', '1', '53');
INSERT INTO `role_resource` VALUES ('8', '1', '54');
INSERT INTO `role_resource` VALUES ('9', '1', '55');
INSERT INTO `role_resource` VALUES ('10', '1', '56');
INSERT INTO `role_resource` VALUES ('11', '1', '57');
INSERT INTO `role_resource` VALUES ('12', '1', '58');
INSERT INTO `role_resource` VALUES ('13', '1', '59');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `opt_content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `client_ip` varchar(255) DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'test', 'test', '[类名]:com.wangzhixuan.controller.LoginController,[方法]:logout,[参数]:', null, '2016-12-15 10:59:15');
INSERT INTO `sys_log` VALUES ('2', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.LoginController,[方法]:logout,[参数]:', null, '2016-12-15 14:23:18');
INSERT INTO `sys_log` VALUES ('3', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.LoginController,[方法]:logout,[参数]:', null, '2016-12-15 14:33:28');
INSERT INTO `sys_log` VALUES ('4', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.LoginController,[方法]:logout,[参数]:', null, '2016-12-15 14:36:41');
INSERT INTO `sys_log` VALUES ('5', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.LoginController,[方法]:logout,[参数]:', null, '2016-12-15 15:26:50');
INSERT INTO `sys_log` VALUES ('6', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.LoginController,[方法]:logout,[参数]:', null, '2016-12-15 15:40:51');
INSERT INTO `sys_log` VALUES ('7', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:grantPage,[参数]:id=1&_=1481789189816&', '0:0:0:0:0:0:0:1', '2016-12-15 16:06:46');
INSERT INTO `sys_log` VALUES ('8', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:editPage,[参数]:id=1&_=1481789189817&', '0:0:0:0:0:0:0:1', '2016-12-15 16:07:02');
INSERT INTO `sys_log` VALUES ('9', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.ResourceController,[方法]:editPage,[参数]:id=53&_=1481789362458&', '0:0:0:0:0:0:0:1', '2016-12-15 16:10:50');
INSERT INTO `sys_log` VALUES ('10', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:grantPage,[参数]:id=1&_=1481789362459&', '0:0:0:0:0:0:0:1', '2016-12-15 16:11:48');
INSERT INTO `sys_log` VALUES ('11', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:addPage,[参数]:', null, '2016-12-15 19:19:53');
INSERT INTO `sys_log` VALUES ('12', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:add,[参数]:name=仓库管理员&seq=0&status=0&description=仓库管理员&', '0:0:0:0:0:0:0:1', '2016-12-15 19:20:56');
INSERT INTO `sys_log` VALUES ('13', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:editPage,[参数]:id=2&_=1481800780165&', '0:0:0:0:0:0:0:1', '2016-12-15 19:21:09');
INSERT INTO `sys_log` VALUES ('14', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:edit,[参数]:id=2&name=仓库管理&seq=0&status=0&description=仓库管理员&', '0:0:0:0:0:0:0:1', '2016-12-15 19:21:13');
INSERT INTO `sys_log` VALUES ('15', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:editPage,[参数]:id=2&_=1481800780166&', '0:0:0:0:0:0:0:1', '2016-12-15 19:21:17');
INSERT INTO `sys_log` VALUES ('16', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:edit,[参数]:id=2&name=仓库管理员&seq=0&status=0&description=仓库管理员&', '0:0:0:0:0:0:0:1', '2016-12-15 19:21:21');
INSERT INTO `sys_log` VALUES ('17', 'admin', 'admin', '[类名]:com.wangzhixuan.controller.RoleController,[方法]:delete,[参数]:id=2&', '0:0:0:0:0:0:0:1', '2016-12-15 19:21:38');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(64) NOT NULL COMMENT '登陆名',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `sex` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` tinyint(2) DEFAULT '0' COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户类别',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '098f6bcd4621d373cade4e832627b4f6', '0', '0', null, '0', '0', '2016-12-15 10:55:43');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(19) NOT NULL COMMENT '用户id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
