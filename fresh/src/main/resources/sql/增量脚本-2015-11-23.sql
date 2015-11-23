ALTER TABLE `fresh`.`t_customer` 
CHANGE COLUMN `score` `score` DOUBLE NULL DEFAULT 0 COMMENT '用户的积分' ;


DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL default '',
  `url` varchar(45) NOT NULL default '',
  `icon` varchar(45) NOT NULL default '',
  `type` tinyint(4) NOT NULL default '1',
  `status` tinyint(4) NOT NULL default '1',
  `ordernum` int(11) NOT NULL default '0',
  `parentId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

LOCK TABLES `t_menu` WRITE;

INSERT INTO `t_menu` VALUES (1,'系统管理','system','\'\'','icon-info',1,1,0,NULL),(2,'用户管理','user','user/page','icon-user',1,1,0,1),(3,'角色管理','role','role/page','icon-role',1,1,0,1),(4,'菜单管理','menu','menu/page','icon-menu',1,1,0,1),(6,'外卖业务','takeout','','',1,1,0,NULL),(7,'外卖管理','carte','carte/page','icon-info',1,1,0,6),(8,'订单管理','order','order/page','icon-info',1,1,0,6),(9,'评论管理','comment','comment/page','icon-info',1,1,10,6),(10,'活动管理','activity','activity/page','icon-info',1,1,40,12),(12,'生鲜超市','fresh','1','icon-info',1,1,30,NULL),(13,'顾客维护','customer','customer/page','icon-info',1,1,10,12),(14,'品牌管理','brand','brand/page','icon-info',1,1,20,12),(15,'品类管理','category','category/page','icon-info',1,1,30,12),(16,'商品管理','product','product/page','icon-info',1,1,40,12),(17,'SKU管理','sku','sku/page','icon-info',1,1,60,12),(18,'文件管理','file','file/page','icon-info',1,1,40,1),(19,'现金券管理','coupon','coupon/page','icon-info',1,1,0,12),(20,'积分配置','score','score/page','icon-info',1,1,0,12);
UNLOCK TABLES;


