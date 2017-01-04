/*
Navicat MySQL Data Transfer

Source Server         : 111
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-01-04 08:15:55
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
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

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
INSERT INTO `resource` VALUES ('9', '收货入库确认', '/putstorage/receiving', '收货入库确认', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:14:47');
INSERT INTO `resource` VALUES ('10', '收货单管理', '/receiving/receivingPage', '收货单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:15:27');
INSERT INTO `resource` VALUES ('12', '调拨入库单管理', '/allotput/alloputPage', '调拨入库单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:18:36');
INSERT INTO `resource` VALUES ('13', '新增退货单管理', '/salesreturn/salesreturnAddPage', '新增退货单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:19:20');
INSERT INTO `resource` VALUES ('14', '退货入库单管理', '/salesreturn/salesreturnPage', '退货入库单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:20:10');
INSERT INTO `resource` VALUES ('17', '库存调整单查询', '/adjust/page', '库存调整单查询', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:23:12');
INSERT INTO `resource` VALUES ('18', '货品借还登记', '/borrow/borrowpage', '货品借出登记', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:23:58');
INSERT INTO `resource` VALUES ('21', '盘点单管理', '/make/selectpage', '盘点单管理', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:25:22');
INSERT INTO `resource` VALUES ('23', '新增调拨单', null, '新增调拨单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:26:28');
INSERT INTO `resource` VALUES ('25', '出货单管理', '/shipment/shipment.html', '出货单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:27:29');
INSERT INTO `resource` VALUES ('27', '调拨出库单管理', '/allotout/allotout.html', '调拨出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:28:50');
INSERT INTO `resource` VALUES ('29', '越库出货单管理', '/crossDatabase/crossDatabase.html', '越货出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:30:35');
INSERT INTO `resource` VALUES ('31', '直接出库单管理', '/invoice/invoice.html', '直接出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:31:47');
INSERT INTO `resource` VALUES ('32', '新增货品加工BOM方案', null, '新增货品加工BOM方案', 'menu_icon_datadeal', '5', '0', '0', '0', '2016-12-15 11:32:38');
INSERT INTO `resource` VALUES ('33', '加工方案管理', null, '加工方案管理', 'menu_icon_datadeal', '5', '0', '0', '0', '2016-12-15 11:33:55');
INSERT INTO `resource` VALUES ('34', '账户总览', null, '账户总览', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:34:55');
INSERT INTO `resource` VALUES ('35', '财务日结表', null, '财务日结表', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:35:23');
INSERT INTO `resource` VALUES ('39', '收入统计', '', '新增收入', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:38:29');
INSERT INTO `resource` VALUES ('40', '支出统计', '', '新增支出', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:38:46');
INSERT INTO `resource` VALUES ('41', '入库计划报表', null, '入库计划报表', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:39:27');
INSERT INTO `resource` VALUES ('42', '盘点差异报表', '/check/page', '实际收货报表', 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-15 11:40:07');
INSERT INTO `resource` VALUES ('43', '入库计划差异报表', null, '入库计划差异报表', 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-15 11:41:16');
INSERT INTO `resource` VALUES ('44', '出库退货报表', null, '出库退货报表', 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-15 11:41:46');
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
INSERT INTO `resource` VALUES ('60', '添加', '/user/add', '用户添加', 'icon-add', '50', '0', '0', '1', '2016-12-18 19:46:12');
INSERT INTO `resource` VALUES ('61', '仓库表', '/godown/page', null, 'menu_icon_datadeal', '7', '0', '0', '0', '2016-12-19 10:06:19');
INSERT INTO `resource` VALUES ('62', '货物报表', '/cargo/cargopage', null, 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-19 10:08:17');
INSERT INTO `resource` VALUES ('63', '编辑', '/user/edit', null, 'icon-edit', '50', '0', '0', '1', '2016-12-19 16:59:50');
INSERT INTO `resource` VALUES ('64', '删除', '/user/delete', null, 'icon-del', '50', '0', '0', '1', '2016-12-20 09:32:21');
INSERT INTO `resource` VALUES ('65', '修改密码', '/user/editPwdPage', null, 'icon-edit', '0', '0', '0', '0', '2016-12-20 19:49:40');
INSERT INTO `resource` VALUES ('66', '出货单添加', '/shipment/insert', '出货单添加', 'icon-add', '25', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('67', '出货单修改', '/shipment/update', '出货单修改', 'icon-edit', '25', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('68', '出货单删除', '/shipment/delete', '出货单删除', 'icon-del', '25', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('69', '调拨出库单添加', '/allotout/insert', '调拨出库单添加', 'icon-add', '27', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('70', '调拨出库单修改', '/allotout/update', '调拨出库单修改', 'icon-edit', '27', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('71', '调拨出库单删除', '/shipment/delete', '调拨出库单删除', 'icon-del', '27', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('72', '越库出货单添加', '/crossDatabase/insert', '越库出货单添加', 'icon-add', '29', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('73', '越库出货单修改', '/crossDatabase/update', '越库出货单修改', 'icon-edit', '29', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('74', '越库出货单删除', '/crossDatabase/delete', '越库出货单删除', 'icon-del', '29', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('75', '直接出库单添加', '/invoice/insert', '直接出库单添加', 'icon-add', '31', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('76', '直接出库单修改', '/invoice/update', '直接出库单修改', 'icon-edit', '31', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('77', '直接出库单删除', '/invoice/delete', '直接出库单删除', 'icon-del', '31', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('78', '仓库添加', '/godown/add', null, 'icon-add', '61', '0', '0', '1', '2016-12-27 14:27:29');
INSERT INTO `resource` VALUES ('79', '仓库扩建', '/godown/edit', null, 'icon-edit', '61', '0', '0', '1', '2016-12-27 14:30:13');
INSERT INTO `resource` VALUES ('80', '仓库停用', '/godown/delete', null, 'icon-del', '61', '0', '0', '1', '2016-12-27 14:30:54');
INSERT INTO `resource` VALUES ('81', '仓库启用', '/godown/delete', null, 'icon-ok', '61', '0', '0', '1', '2016-12-29 15:32:53');
INSERT INTO `resource` VALUES ('95', '调拨出库单导入', '/allotout/import', '调拨出库单导入', 'icon-del', '27', '0', '0', '1', '2016-12-26 00:00:00');
INSERT INTO `resource` VALUES ('97', '库存调整删除', '/adjust/delete', null, 'icon-del', '17', '0', '0', '1', '2016-12-22 20:11:17');
INSERT INTO `resource` VALUES ('98', '新增货品借出单', '/borrow/add', null, 'icon-add', '18', '0', '0', '1', '2016-12-22 20:12:30');
INSERT INTO `resource` VALUES ('99', '新增货物', '/cargo/insert', null, 'icon-add', '62', '0', '0', '1', '2016-12-26 20:24:52');
INSERT INTO `resource` VALUES ('100', '货品借还删除', '/borrow/delete', null, 'icon-del', '18', '0', '0', '1', '2016-12-27 16:10:38');
INSERT INTO `resource` VALUES ('101', '归还', '/borrow/edit', null, 'icon-edit', '18', '0', '0', '1', '2016-12-27 16:12:21');
INSERT INTO `resource` VALUES ('102', '删除', '/receiving/delete', null, 'icon-del', '10', '0', '0', '1', '2016-12-20 14:08:36');
INSERT INTO `resource` VALUES ('103', '编辑', '/receiving/update', null, 'icon-edit', '10', '0', '0', '1', '2016-12-20 14:28:57');
INSERT INTO `resource` VALUES ('104', '删除', '/allotput/delete', null, 'icon-del', '12', '0', '0', '1', '2016-12-20 19:10:26');
INSERT INTO `resource` VALUES ('105', '编辑', '/allotput/edit', null, 'icon-edit', '12', '0', '0', '1', '2016-12-20 19:11:40');
INSERT INTO `resource` VALUES ('106', '编辑', '/salesreturn/edit', null, 'icon-edit', '14', '0', '0', '1', '2016-12-20 19:56:47');
INSERT INTO `resource` VALUES ('107', '删除', '/salesreturn/delete', null, 'icon-del', '14', '0', '0', '1', '2016-12-20 19:57:26');
