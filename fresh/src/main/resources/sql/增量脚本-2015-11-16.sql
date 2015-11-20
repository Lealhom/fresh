CREATE TABLE `t_coupon` (
  `id` int(11) NOT NULL auto_increment,
  `money` double default NULL,
  `exceedMoney` double default NULL,
  `startTime` varchar(20) default NULL,
  `endTime` varchar(20) default NULL,
  `useTime` varchar(20) default NULL,
  `status` tinyint(4) default NULL,
  `type` tinyint(4) default NULL COMMENT '现金券类型，唯一键，不能有重复',
  `name` varchar(45) default NULL,
  `description` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='现金券';


CREATE TABLE `t_coupon_customer` (
  `id` int(11) NOT NULL auto_increment,
  `batchNo` varchar(20) default NULL,
  `couponId` varchar(11) default NULL,
  `customerId` varchar(11) default NULL,
  `orderId` varchar(11) default NULL,
  `useTime` varchar(20) default NULL COMMENT '使用时间',
  `status` tinyint(4) default NULL COMMENT '是否使用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE DATABASE  IF NOT EXISTS `fresh` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fresh`;

DROP TABLE IF EXISTS `t_score_configration`;
CREATE TABLE `t_score_configration` (
  `id` int(11) NOT NULL auto_increment,
  `rate` int(1) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `t_score_configration` WRITE;
INSERT INTO `t_score_configration` VALUES (1,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `showname` varchar(45) default '',
  `phone` varchar(15) default '',
  `email` varchar(45) default '',
  `imgUuid` varchar(40) default NULL,
  `score` double default NULL COMMENT '用户的积分',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='顾客';

LOCK TABLES `t_customer` WRITE;
INSERT INTO `t_customer` VALUES (2,'admin','admin','叶良辰','110','88888@qq.com','19bedfa3-4178-4532-8d63-a8003fea068a',NULL);
UNLOCK TABLES;

DROP TABLE IF EXISTS `t_sku`;
CREATE TABLE `t_sku` (
  `id` int(11) NOT NULL auto_increment,
  `status` tinyint(4) default NULL,
  `productId` varchar(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `originalPrice` double default NULL COMMENT '价格',
  `discountPrice` double default NULL,
  `scoreConvertRate` double default NULL,
  `standard` varchar(45) default NULL COMMENT '规格',
  `quantity` int(11) default NULL COMMENT '库存',
  `salesCount` int(11) default '0',
  `avgScore` double default '0',
  `haopingQuantity` int(11) default '0',
  `zhongpingQuantity` int(11) default '0',
  `chapingQuantity` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='SKU';

LOCK TABLES `t_sku` WRITE;
INSERT INTO `t_sku` VALUES (6,1,'11','新疆葡萄大份',151,80,0.2,'3斤',80,NULL,NULL,6,2,2),(7,1,'11','新疆葡萄小份',50,45,0.3,'1斤',100,NULL,NULL,NULL,NULL,NULL),(8,1,'10','新西兰红苹果大份',100,90,NULL,'3斤',500,NULL,NULL,NULL,NULL,NULL),(9,1,'10','新西兰红苹果小份',50,40,NULL,'1斤',400,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
