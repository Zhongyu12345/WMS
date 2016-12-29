-- 修改菜单链接

UPDATE resource SET url = '/shipment/shipment.html' WHERE id = '25';
UPDATE resource SET url = '/allotout/allotout.html' WHERE id = '27';
UPDATE resource SET url = '/crossDatabase/crossDatabase.html' WHERE id = '29';
UPDATE resource SET url = '/invoice/invoice.html' WHERE id = '31';

-- 添加操作按钮
INSERT INTO resource VALUES (null,'出货单添加','/shipment/insert','出货单添加','icon-add','25','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'出货单修改','/shipment/update','出货单修改','icon-edit','25','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'出货单删除','/shipment/delete','出货单删除','icon-del','25','0','0','1','2016-12-26 00:00:00');

INSERT INTO resource VALUES (null,'调拨出库单添加','/allotout/insert','调拨出库单添加','icon-add','27','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'调拨出库单修改','/allotout/update','调拨出库单修改','icon-edit','27','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'调拨出库单删除','/allotout/delete','调拨出库单删除','icon-del','27','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'调拨出库单导入','/allotout/import','调拨出库单导入','icon-del','27','0','0','1','2016-12-26 00:00:00');

INSERT INTO resource VALUES (null,'越库出货单添加','/crossDatabase/insert','越库出货单添加','icon-add','29','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'越库出货单修改','/crossDatabase/update','越库出货单修改','icon-edit','29','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'越库出货单删除','/crossDatabase/delete','越库出货单删除','icon-del','29','0','0','1','2016-12-26 00:00:00');

INSERT INTO resource VALUES (null,'直接出库单添加','/invoice/insert','直接出库单添加','icon-add','31','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'直接出库单修改','/invoice/update','直接出库单修改','icon-edit','31','0','0','1','2016-12-26 00:00:00');
INSERT INTO resource VALUES (null,'直接出库单删除','/invoice/delete','直接出库单删除','icon-del','31','0','0','1','2016-12-26 00:00:00');