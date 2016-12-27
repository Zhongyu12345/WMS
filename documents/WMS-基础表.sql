/*
Navicat MySQL Data Transfer

Source Server         : 111
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-12-19 08:55:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adjust
-- ----------------------------
DROP TABLE IF EXISTS `adjust`;
CREATE TABLE `adjust` (
  `j_id` int(11) NOT NULL AUTO_INCREMENT,
  `j_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `j_SKUmodel` varchar(255) DEFAULT NULL COMMENT '货物编号',
  `j_num` double(255,0) DEFAULT NULL COMMENT '调整数量',
  `j_names` varchar(255) DEFAULT NULL COMMENT '调整人',
  `j_cause` varchar(255) DEFAULT NULL COMMENT '调整原因',
  `j_time` datetime DEFAULT NULL COMMENT '调整时间',
  `j_whid` varchar(11) DEFAULT NULL COMMENT '调入仓库',
  `j_volum` double(255,0) DEFAULT NULL COMMENT '调整货物体积',
  PRIMARY KEY (`j_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adjust
-- ----------------------------

-- ----------------------------
-- Table structure for allotout
-- ----------------------------
DROP TABLE IF EXISTS `allotout`;
CREATE TABLE `allotout` (
  `ao_id` int(11) NOT NULL AUTO_INCREMENT,
  `ao_name` varchar(255) NOT NULL,
  `ao_SKUmodel` varchar(255) NOT NULL,
  `ao_num` int(11) NOT NULL,
  `ao_whid` varchar(500) NOT NULL,
  `ao_sippingNO` varchar(500) NOT NULL,
  `ao_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ao_volume` double NOT NULL,
  PRIMARY KEY (`ao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调拨出库单';

-- ----------------------------
-- Records of allotout
-- ----------------------------

-- ----------------------------
-- Table structure for allotput
-- ----------------------------
DROP TABLE IF EXISTS `allotput`;
CREATE TABLE `allotput` (
  `ap_id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_name` varchar(255) DEFAULT NULL,
  `ap_SKUmodel` varchar(255) DEFAULT NULL,
  `ap_num` double DEFAULT NULL,
  `ap_whid` varchar(255) DEFAULT NULL,
  `ap_sipping` varchar(255) DEFAULT NULL,
  `ap_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ap_volume` double(255,0) DEFAULT NULL,
  `ap_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ap_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of allotput
-- ----------------------------

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) DEFAULT NULL,
  `c_storerid` varchar(255) DEFAULT NULL,
  `c_supplierid` varchar(255) DEFAULT NULL,
  `c_shippingNO` varchar(255) DEFAULT NULL,
  `c_whid` varchar(255) DEFAULT NULL,
  `c_num` int(11) DEFAULT NULL,
  `c_totalweight` double DEFAULT NULL,
  `c_totalvolume` double DEFAULT NULL,
  `c_receivedate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `c_SKUmodel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cargo
-- ----------------------------

-- ----------------------------
-- Table structure for cargo_borrow
-- ----------------------------
DROP TABLE IF EXISTS `cargo_borrow`;
CREATE TABLE `cargo_borrow` (
  `cb_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cb_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `cb_SKUmodel` varchar(255) DEFAULT NULL COMMENT '货物型号',
  `cb_num` double(255,0) DEFAULT NULL COMMENT '数量',
  `cb_cause` varchar(255) DEFAULT NULL COMMENT '原因',
  `cb_names` varchar(255) DEFAULT NULL COMMENT '借用人',
  `cb_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`cb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cargo_borrow
-- ----------------------------

-- ----------------------------
-- Table structure for compay_accounts
-- ----------------------------
DROP TABLE IF EXISTS `compay_accounts`;
CREATE TABLE `compay_accounts` (
  `ca_id` int(11) NOT NULL AUTO_INCREMENT,
  `ca_accounts` int(11) NOT NULL,
  `ca_name` varchar(500) NOT NULL,
  PRIMARY KEY (`ca_id`),
  KEY `ca_accounts` (`ca_accounts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司账户表';

-- ----------------------------
-- Records of compay_accounts
-- ----------------------------

-- ----------------------------
-- Table structure for cross_database
-- ----------------------------
DROP TABLE IF EXISTS `cross_database`;
CREATE TABLE `cross_database` (
  `cd_id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_name` varchar(255) NOT NULL,
  `cd_SKUmodel` varchar(255) NOT NULL,
  `cd_num` double NOT NULL,
  `cd_whid` varchar(500) NOT NULL,
  `cd_oddnumbers` varchar(500) NOT NULL,
  `cd_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `cd_volume` double NOT NULL,
  PRIMARY KEY (`cd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='越库出货单';

-- ----------------------------
-- Records of cross_database
-- ----------------------------

-- ----------------------------
-- Table structure for give_back
-- ----------------------------
DROP TABLE IF EXISTS `give_back`;
CREATE TABLE `give_back` (
  `gb_id` int(11) NOT NULL AUTO_INCREMENT,
  `gb_name` varchar(255) NOT NULL,
  `gb_SKUmodel` varchar(255) NOT NULL,
  `gb_num` double NOT NULL,
  `gb_cause` varchar(1000) NOT NULL,
  `gb_status` int(11) NOT NULL,
  `gb_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`gb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货品归还表';

-- ----------------------------
-- Records of give_back
-- ----------------------------

-- ----------------------------
-- Table structure for godown
-- ----------------------------
DROP TABLE IF EXISTS `godown`;
CREATE TABLE `godown` (
  `go_id` int(11) NOT NULL AUTO_INCREMENT,
  `go_whid` varchar(255) DEFAULT NULL,
  `go_p` varchar(255) DEFAULT NULL,
  `go_volume` double DEFAULT NULL,
  `go_usevolume` double(255,0) DEFAULT NULL,
  `go_rdvolume` double DEFAULT NULL,
  PRIMARY KEY (`go_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of godown
-- ----------------------------

-- ----------------------------
-- Table structure for godown_entry
-- ----------------------------
DROP TABLE IF EXISTS `godown_entry`;
CREATE TABLE `godown_entry` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(255) DEFAULT NULL,
  `g_storerid` varchar(255) DEFAULT NULL,
  `g_phone` varchar(255) DEFAULT NULL,
  `g_supplierid` varchar(255) DEFAULT NULL,
  `g_sippingNO` varchar(255) DEFAULT NULL,
  `g_whid` varchar(255) DEFAULT NULL,
  `g_num` double DEFAULT NULL,
  `g_crossflag` varchar(255) DEFAULT NULL,
  `g_directflag` varchar(255) DEFAULT NULL,
  `g_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `g_adminid` int(11) DEFAULT NULL,
  `g_SKUmodel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of godown_entry
-- ----------------------------

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `i_income` decimal(10,0) NOT NULL,
  `i_pay` decimal(10,0) NOT NULL,
  `i_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `i_caid` int(11) NOT NULL,
  PRIMARY KEY (`i_id`),
  KEY `income_compay` (`i_caid`),
  CONSTRAINT `income_compay` FOREIGN KEY (`i_caid`) REFERENCES `compay_accounts` (`ca_accounts`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收/入财务表';

-- ----------------------------
-- Records of income
-- ----------------------------

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `in_id` int(11) NOT NULL AUTO_INCREMENT,
  `in_name` varchar(255) NOT NULL,
  `in_SKUmodel` varchar(255) NOT NULL,
  `in_num` double NOT NULL,
  `in_whid` varchar(500) NOT NULL,
  `in_oddnumber` varchar(500) NOT NULL,
  `in_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `in_volume` double NOT NULL,
  PRIMARY KEY (`in_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='直接发货单';

-- ----------------------------
-- Records of invoice
-- ----------------------------

-- ----------------------------
-- Table structure for make_inventory
-- ----------------------------
DROP TABLE IF EXISTS `make_inventory`;
CREATE TABLE `make_inventory` (
  `mi_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mi_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `mi_SKUmodel` varchar(255) DEFAULT NULL COMMENT '货物型号',
  `mi_num` double(255,0) DEFAULT NULL COMMENT '盘点数量',
  `mi_names` varchar(255) DEFAULT NULL COMMENT '盘点人',
  `mi_whid` int(11) DEFAULT NULL COMMENT '仓库编号',
  `mi_time` datetime DEFAULT NULL COMMENT '盘点时间',
  PRIMARY KEY (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of make_inventory
-- ----------------------------

-- ----------------------------
-- Table structure for receiving
-- ----------------------------
DROP TABLE IF EXISTS `receiving`;
CREATE TABLE `receiving` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(255) DEFAULT NULL,
  `r_storerid` varchar(255) DEFAULT NULL,
  `r_phone` varchar(255) DEFAULT NULL,
  `r_supplierid` varchar(255) DEFAULT NULL,
  `r_sippingNO` varchar(255) DEFAULT NULL,
  `r_whid` varchar(255) DEFAULT NULL,
  `r_num` double DEFAULT NULL,
  `r_crossflag` varchar(255) DEFAULT NULL,
  `r_directflag` varchar(255) DEFAULT NULL,
  `r_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `r_adminid` int(11) DEFAULT NULL,
  `r_partflag` int(11) DEFAULT NULL,
  `r_SKUmodel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receiving
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

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
INSERT INTO `resource` VALUES ('12', '调拨入库单管理', null, '调拨入库单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:18:36');
INSERT INTO `resource` VALUES ('13', '新增退货单管理', null, '新增退货单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:19:20');
INSERT INTO `resource` VALUES ('14', '退货入库单管理', null, '退货入库单管理', 'menu_icon_datadeal', '2', '0', '0', '0', '2016-12-15 11:20:10');
INSERT INTO `resource` VALUES ('17', '库存调整单查询', null, '库存调整单查询', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:23:12');
INSERT INTO `resource` VALUES ('18', '货品借出登记', null, '货品借出登记', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:23:58');
INSERT INTO `resource` VALUES ('19', '货品归还登记', null, '货品归还登记', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:24:31');
INSERT INTO `resource` VALUES ('20', '借出货品查询', null, '借出货品查询', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:24:55');
INSERT INTO `resource` VALUES ('21', '盘点单管理', null, '盘点单管理', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:25:22');
INSERT INTO `resource` VALUES ('22', '打印空白盘点单', null, '打印空白盘点单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:26:02');
INSERT INTO `resource` VALUES ('23', '新增调拨单', null, '新增调拨单', 'menu_icon_datadeal', '3', '0', '0', '0', '2016-12-15 11:26:28');
INSERT INTO `resource` VALUES ('25', '出货单管理', null, '出货单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:27:29');
INSERT INTO `resource` VALUES ('27', '调拨出库单管理', null, '调拨出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:28:50');
INSERT INTO `resource` VALUES ('29', '越库出货单管理', null, '越库出货单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:30:35');
INSERT INTO `resource` VALUES ('31', '直接出库单管理', null, '直接出库单管理', 'menu_icon_datadeal', '4', '0', '0', '0', '2016-12-15 11:31:47');
INSERT INTO `resource` VALUES ('32', '新增货品加工BOM方案', null, '新增货品加工BOM方案', 'menu_icon_datadeal', '5', '0', '0', '0', '2016-12-15 11:32:38');
INSERT INTO `resource` VALUES ('33', '加工方案管理', null, '加工方案管理', 'menu_icon_datadeal', '5', '0', '0', '0', '2016-12-15 11:33:55');
INSERT INTO `resource` VALUES ('34', '账户总览', null, '账户总览', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:34:55');
INSERT INTO `resource` VALUES ('35', '财务日结表', null, '财务日结表', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:35:23');
INSERT INTO `resource` VALUES ('39', '收入统计', '', '新增收入', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:38:29');
INSERT INTO `resource` VALUES ('40', '支出统计', '', '新增支出', 'menu_icon_datadeal', '6', '0', '0', '0', '2016-12-15 11:38:46');
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
INSERT INTO `resource` VALUES ('60', '添加', '/user/add', '用户添加', 'icon-add', '50', '0', '0', '1', '2016-12-18 19:46:12');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0', '超级管理员', '0');
INSERT INTO `role` VALUES ('3', '文员', '0', '', '0');
INSERT INTO `role` VALUES ('4', '普通员工', '0', '', '0');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('15', '3', '1');
INSERT INTO `role_resource` VALUES ('16', '3', '48');
INSERT INTO `role_resource` VALUES ('17', '3', '52');
INSERT INTO `role_resource` VALUES ('18', '3', '53');
INSERT INTO `role_resource` VALUES ('19', '3', '54');
INSERT INTO `role_resource` VALUES ('20', '3', '49');
INSERT INTO `role_resource` VALUES ('21', '3', '56');
INSERT INTO `role_resource` VALUES ('22', '3', '57');
INSERT INTO `role_resource` VALUES ('23', '3', '58');
INSERT INTO `role_resource` VALUES ('24', '3', '59');
INSERT INTO `role_resource` VALUES ('25', '3', '50');
INSERT INTO `role_resource` VALUES ('26', '3', '60');
INSERT INTO `role_resource` VALUES ('27', '3', '2');
INSERT INTO `role_resource` VALUES ('28', '3', '9');
INSERT INTO `role_resource` VALUES ('29', '3', '10');
INSERT INTO `role_resource` VALUES ('30', '3', '11');
INSERT INTO `role_resource` VALUES ('31', '3', '12');
INSERT INTO `role_resource` VALUES ('32', '3', '13');
INSERT INTO `role_resource` VALUES ('33', '3', '14');
INSERT INTO `role_resource` VALUES ('34', '3', '3');
INSERT INTO `role_resource` VALUES ('35', '3', '15');
INSERT INTO `role_resource` VALUES ('36', '3', '16');
INSERT INTO `role_resource` VALUES ('37', '3', '17');
INSERT INTO `role_resource` VALUES ('38', '3', '18');
INSERT INTO `role_resource` VALUES ('39', '3', '19');
INSERT INTO `role_resource` VALUES ('40', '3', '20');
INSERT INTO `role_resource` VALUES ('41', '3', '21');
INSERT INTO `role_resource` VALUES ('42', '3', '22');
INSERT INTO `role_resource` VALUES ('43', '3', '23');
INSERT INTO `role_resource` VALUES ('44', '3', '4');
INSERT INTO `role_resource` VALUES ('45', '3', '24');
INSERT INTO `role_resource` VALUES ('46', '3', '25');
INSERT INTO `role_resource` VALUES ('47', '3', '26');
INSERT INTO `role_resource` VALUES ('48', '3', '27');
INSERT INTO `role_resource` VALUES ('49', '3', '28');
INSERT INTO `role_resource` VALUES ('50', '3', '29');
INSERT INTO `role_resource` VALUES ('51', '3', '30');
INSERT INTO `role_resource` VALUES ('52', '3', '31');
INSERT INTO `role_resource` VALUES ('53', '3', '5');
INSERT INTO `role_resource` VALUES ('54', '3', '32');
INSERT INTO `role_resource` VALUES ('55', '3', '33');
INSERT INTO `role_resource` VALUES ('56', '3', '6');
INSERT INTO `role_resource` VALUES ('57', '3', '34');
INSERT INTO `role_resource` VALUES ('58', '3', '35');
INSERT INTO `role_resource` VALUES ('59', '3', '36');
INSERT INTO `role_resource` VALUES ('60', '3', '37');
INSERT INTO `role_resource` VALUES ('61', '3', '38');
INSERT INTO `role_resource` VALUES ('62', '3', '39');
INSERT INTO `role_resource` VALUES ('63', '3', '40');
INSERT INTO `role_resource` VALUES ('64', '3', '41');
INSERT INTO `role_resource` VALUES ('65', '3', '7');
INSERT INTO `role_resource` VALUES ('66', '3', '42');
INSERT INTO `role_resource` VALUES ('67', '3', '43');
INSERT INTO `role_resource` VALUES ('68', '3', '44');
INSERT INTO `role_resource` VALUES ('69', '3', '8');
INSERT INTO `role_resource` VALUES ('70', '3', '45');
INSERT INTO `role_resource` VALUES ('71', '3', '46');
INSERT INTO `role_resource` VALUES ('72', '3', '47');
INSERT INTO `role_resource` VALUES ('73', '1', '1');
INSERT INTO `role_resource` VALUES ('74', '1', '48');
INSERT INTO `role_resource` VALUES ('75', '1', '52');
INSERT INTO `role_resource` VALUES ('76', '1', '53');
INSERT INTO `role_resource` VALUES ('77', '1', '54');
INSERT INTO `role_resource` VALUES ('78', '1', '49');
INSERT INTO `role_resource` VALUES ('79', '1', '56');
INSERT INTO `role_resource` VALUES ('80', '1', '57');
INSERT INTO `role_resource` VALUES ('81', '1', '58');
INSERT INTO `role_resource` VALUES ('82', '1', '59');
INSERT INTO `role_resource` VALUES ('83', '1', '50');
INSERT INTO `role_resource` VALUES ('84', '1', '60');
INSERT INTO `role_resource` VALUES ('85', '1', '2');
INSERT INTO `role_resource` VALUES ('86', '1', '9');
INSERT INTO `role_resource` VALUES ('87', '1', '10');
INSERT INTO `role_resource` VALUES ('88', '1', '11');
INSERT INTO `role_resource` VALUES ('89', '1', '12');
INSERT INTO `role_resource` VALUES ('90', '1', '13');
INSERT INTO `role_resource` VALUES ('91', '1', '14');
INSERT INTO `role_resource` VALUES ('92', '1', '3');
INSERT INTO `role_resource` VALUES ('93', '1', '15');
INSERT INTO `role_resource` VALUES ('94', '1', '16');
INSERT INTO `role_resource` VALUES ('95', '1', '17');
INSERT INTO `role_resource` VALUES ('96', '1', '18');
INSERT INTO `role_resource` VALUES ('97', '1', '19');
INSERT INTO `role_resource` VALUES ('98', '1', '20');
INSERT INTO `role_resource` VALUES ('99', '1', '21');
INSERT INTO `role_resource` VALUES ('100', '1', '22');
INSERT INTO `role_resource` VALUES ('101', '1', '23');
INSERT INTO `role_resource` VALUES ('102', '1', '4');
INSERT INTO `role_resource` VALUES ('103', '1', '24');
INSERT INTO `role_resource` VALUES ('104', '1', '25');
INSERT INTO `role_resource` VALUES ('105', '1', '26');
INSERT INTO `role_resource` VALUES ('106', '1', '27');
INSERT INTO `role_resource` VALUES ('107', '1', '28');
INSERT INTO `role_resource` VALUES ('108', '1', '29');
INSERT INTO `role_resource` VALUES ('109', '1', '30');
INSERT INTO `role_resource` VALUES ('110', '1', '31');
INSERT INTO `role_resource` VALUES ('111', '1', '5');
INSERT INTO `role_resource` VALUES ('112', '1', '32');
INSERT INTO `role_resource` VALUES ('113', '1', '33');
INSERT INTO `role_resource` VALUES ('114', '1', '6');
INSERT INTO `role_resource` VALUES ('115', '1', '34');
INSERT INTO `role_resource` VALUES ('116', '1', '35');
INSERT INTO `role_resource` VALUES ('117', '1', '36');
INSERT INTO `role_resource` VALUES ('118', '1', '37');
INSERT INTO `role_resource` VALUES ('119', '1', '38');
INSERT INTO `role_resource` VALUES ('120', '1', '39');
INSERT INTO `role_resource` VALUES ('121', '1', '40');
INSERT INTO `role_resource` VALUES ('122', '1', '41');
INSERT INTO `role_resource` VALUES ('123', '1', '7');
INSERT INTO `role_resource` VALUES ('124', '1', '42');
INSERT INTO `role_resource` VALUES ('125', '1', '43');
INSERT INTO `role_resource` VALUES ('126', '1', '44');
INSERT INTO `role_resource` VALUES ('127', '1', '8');
INSERT INTO `role_resource` VALUES ('128', '1', '45');
INSERT INTO `role_resource` VALUES ('129', '1', '46');
INSERT INTO `role_resource` VALUES ('130', '1', '47');
INSERT INTO `role_resource` VALUES ('131', '4', '2');
INSERT INTO `role_resource` VALUES ('132', '4', '3');
INSERT INTO `role_resource` VALUES ('133', '4', '4');
INSERT INTO `role_resource` VALUES ('134', '4', '5');

-- ----------------------------
-- Table structure for sales_return
-- ----------------------------
DROP TABLE IF EXISTS `sales_return`;
CREATE TABLE `sales_return` (
  `sr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sr_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `sr_sipping` varchar(255) DEFAULT NULL COMMENT '客户托单号',
  `sr_storerid` int(11) DEFAULT NULL COMMENT '客户',
  `sr_phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `sr_names` varchar(255) DEFAULT NULL COMMENT '货物',
  `sr_SKUmodel` varchar(255) DEFAULT NULL COMMENT '货物型号',
  `sr_num` double(255,0) DEFAULT NULL COMMENT '货物数量',
  `sr_cause` varchar(255) DEFAULT NULL COMMENT '退货原因',
  `sr_time` datetime DEFAULT NULL COMMENT '退货时间',
  `sr_whid` int(11) DEFAULT NULL COMMENT '仓库编号',
  `sr_volume` double(255,0) DEFAULT NULL COMMENT '退货体积',
  PRIMARY KEY (`sr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sales_return
-- ----------------------------

-- ----------------------------
-- Table structure for shipment
-- ----------------------------
DROP TABLE IF EXISTS `shipment`;
CREATE TABLE `shipment` (
  `sh_id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_storeid` varchar(255) DEFAULT NULL,
  `sh_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `sh_phone` varchar(255) DEFAULT NULL,
  `sh_sippingNO` varchar(255) DEFAULT NULL,
  `sh_whid` varchar(255) DEFAULT NULL,
  `sh_damage` int(11) DEFAULT NULL,
  `sh_cause` varchar(255) DEFAULT NULL,
  `sh_SKUmodel` varchar(255) DEFAULT NULL,
  `sh_shnum` double DEFAULT NULL,
  `sh_totalweigh` double DEFAULT NULL,
  `sh_totalvolume` double DEFAULT NULL,
  PRIMARY KEY (`sh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipment
-- ----------------------------

-- ----------------------------
-- Table structure for stock_removal
-- ----------------------------
DROP TABLE IF EXISTS `stock_removal`;
CREATE TABLE `stock_removal` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_storerid` varchar(255) DEFAULT NULL,
  `s_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `s_phone` varchar(255) DEFAULT NULL,
  `sh_sippingNO` varchar(255) DEFAULT NULL,
  `s_whid` varchar(255) DEFAULT NULL,
  `s_client` varchar(255) DEFAULT NULL,
  `s_SKUmodel` varchar(255) DEFAULT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `s_num` double DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock_removal
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '098f6bcd4621d373cade4e832627b4f6', '0', '0', null, '0', '0', '2016-12-15 10:55:43');
INSERT INTO `user` VALUES ('2', 'user', '张三', 'e10adc3949ba59abbe56e057f20f883e', '0', '26', '', '0', '0', '2016-12-18 19:51:17');
INSERT INTO `user` VALUES ('3', 'users', '李四', 'e10adc3949ba59abbe56e057f20f883e', '0', null, '', '1', '0', '2016-12-18 20:06:45');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(19) NOT NULL COMMENT '用户id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '3');
INSERT INTO `user_role` VALUES ('3', '3', '4');
