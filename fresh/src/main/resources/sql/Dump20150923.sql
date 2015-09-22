CREATE DATABASE  IF NOT EXISTS `fresh` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fresh`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: fresh
-- ------------------------------------------------------
-- Server version	5.0.96-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `t_activity`
--

DROP TABLE IF EXISTS `t_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL default '',
  `description` varchar(255) NOT NULL default '',
  `startTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `endTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL default '',
  `address` varchar(45) NOT NULL default '',
  `sex` int(11) NOT NULL default '1' COMMENT '1男2女',
  `consignee` varchar(45) NOT NULL default '' COMMENT '收货人',
  `longitude` float NOT NULL default '0',
  `latitude` float NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (1,1,'15828059647','四川省成都市双流县中和街道朝阳小区dddddff',0,'霍耀',0,0),(2,1,'15828059647','考虑考虑',0,'肖繁花',0,0);
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brand`
--

DROP TABLE IF EXISTS `t_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brand`
--

LOCK TABLES `t_brand` WRITE;
/*!40000 ALTER TABLE `t_brand` DISABLE KEYS */;
INSERT INTO `t_brand` VALUES (4,'都乐111','Dole（都乐）食品公司于1851年在夏威夷岛成立，发展至今已成为世界上最大的、品质最好的新鲜水果、蔬菜的生产、销售跨国集团之一111'),(5,'佳沛','新西兰奇异果知名品牌');
/*!40000 ALTER TABLE `t_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `level` int(11) NOT NULL default '1',
  `parentId` varchar(8) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='品类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (6,'进口鲜果',1,''),(7,'苹果',2,'6');
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_category_product`
--

DROP TABLE IF EXISTS `t_category_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category_product` (
  `id` int(11) NOT NULL auto_increment,
  `productId` varchar(11) NOT NULL,
  `categoryId` varchar(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='品类跟产品的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category_product`
--

LOCK TABLES `t_category_product` WRITE;
/*!40000 ALTER TABLE `t_category_product` DISABLE KEYS */;
INSERT INTO `t_category_product` VALUES (1,'6','6'),(2,'6','7');
/*!40000 ALTER TABLE `t_category_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL auto_increment,
  `customId` int(11) NOT NULL COMMENT '评论人ID',
  `productId` int(11) NOT NULL COMMENT '菜单ID',
  `orderId` int(11) NOT NULL COMMENT '订单ID',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '评论时间',
  `content` varchar(200) NOT NULL default '' COMMENT '评论内容',
  `rank` int(11) NOT NULL default '5' COMMENT '评分（等级）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `showname` varchar(45) NOT NULL default '',
  `phone` varchar(15) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_file`
--

DROP TABLE IF EXISTS `t_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_file` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `typeId` int(11) default '0',
  `path` varchar(150) NOT NULL,
  `uploadTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_file`
--

LOCK TABLES `t_file` WRITE;
/*!40000 ALTER TABLE `t_file` DISABLE KEYS */;
INSERT INTO `t_file` VALUES (6,'奇异果.jpg',0,'static/upload/efa7bfcc-5c60-499a-8be3-98df0682d038-奇异果.jpg','2015-09-20 15:36:57'),(7,'QQ截图20150915231903.png',0,'static/upload/30b3c2c4-8cbd-4a2b-b487-fcbca31e8c32-QQ截图20150915231903.png','2015-09-22 14:10:59'),(8,'QQ截图20150915231613.png',0,'static/upload/96d8d120-cc90-44ed-94ac-475bc0cb439e-QQ截图20150915231613.png','2015-09-22 14:26:30'),(9,'2.jpg',0,'static/upload/8fdcfd2c-acc5-4f11-9f78-becaa7e1e023-2.jpg','2015-09-22 15:14:11');
/*!40000 ALTER TABLE `t_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_filetype`
--

DROP TABLE IF EXISTS `t_filetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_filetype` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `parentId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文件类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_filetype`
--

LOCK TABLES `t_filetype` WRITE;
/*!40000 ALTER TABLE `t_filetype` DISABLE KEYS */;
INSERT INTO `t_filetype` VALUES (1,'默认',NULL);
/*!40000 ALTER TABLE `t_filetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'系统管理','system','\'\'','icon-info',1,1,0,NULL),(2,'用户管理','user','user/page','icon-user',1,1,0,1),(3,'角色管理','role','role/page','icon-role',1,1,0,1),(4,'菜单管理','menu','menu/page','icon-menu',1,1,0,1),(6,'外卖业务','takeout','','',1,1,0,NULL),(7,'外卖管理','carte','carte/page','icon-info',1,1,0,6),(8,'订单管理','order','order/page','icon-info',1,1,0,6),(9,'评论管理','comment','comment/page','icon-info',1,1,10,6),(10,'活动管理','activity','activity/page','icon-info',1,1,40,12),(12,'生鲜超市','fresh','1','icon-info',1,1,30,NULL),(13,'顾客维护','customer','customer/page','icon-info',1,1,10,12),(14,'品牌管理','brand','brand/page','icon-info',1,1,20,12),(15,'品类管理','category','category/page','icon-info',1,1,30,12),(16,'商品管理','product','product/page','icon-info',1,1,40,12),(17,'SKU管理','sku','sku/page','icon-info',1,1,60,12),(18,'文件管理','file','file/page','icon-info',1,1,40,1);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL auto_increment,
  `customId` int(11) NOT NULL,
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `paytime` timestamp NULL default NULL COMMENT '付款时间',
  `price` double NOT NULL default '0' COMMENT '订单价格',
  `status` tinyint(4) NOT NULL default '0' COMMENT '订单状态：0待付款 1已付款 2订单取消 3订单退款 4待评价 5订单完成',
  PRIMARY KEY  (`id`),
  KEY `FK_ORDER_USERID_idx` (`customId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,1,'2015-05-06 15:25:30','2015-05-06 15:25:30',12.5,1),(2,1,'2015-05-06 15:25:30','2015-05-06 15:25:30',12.5,2);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission`
--

DROP TABLE IF EXISTS `t_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL auto_increment,
  `resource_id` int(11) NOT NULL,
  `principal_id` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL default '1',
  PRIMARY KEY  (`id`),
  KEY `FK_PERMISSION_RESOURCE_ID_idx` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `status` int(11) default '1' COMMENT '状态 0下架 1上架',
  `description` varchar(1024) default NULL,
  `createTime` timestamp NULL default NULL,
  `updateTime` timestamp NULL default NULL,
  `fileId` int(11) default NULL,
  `brandId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='产品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (3,'特大佳沛新西兰绿奇异果',1,'特大佳沛新西兰绿奇异果','2015-09-20 15:36:58',NULL,6,5),(4,'aaaaa',1,'','2015-09-22 14:11:00',NULL,7,4),(5,'bbbbbbbbb',1,'aaaaaaaaaaaaa','2015-09-22 14:26:30',NULL,8,4),(6,'新西兰皇后红玫瑰苹果',1,'源自新西兰的皇后红玫瑰苹果，外表色泽鲜亮，果形光滑圆润，口感甜脆，透出淡淡玫瑰香味。红玫瑰苹果因其果皮色亮如盛开的玫瑰花，故此而得名，西方又名浪漫之果。','2015-09-22 15:14:13',NULL,9,5);
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resource`
--

DROP TABLE IF EXISTS `t_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `status` tinyint(4) NOT NULL default '1',
  `url` varchar(45) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_RESOURCE_MENU_ID_idx` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource`
--

LOCK TABLES `t_resource` WRITE;
/*!40000 ALTER TABLE `t_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `status` tinyint(4) NOT NULL default '1',
  `description` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'管理员',1,'管理员');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sku`
--

DROP TABLE IF EXISTS `t_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sku` (
  `id` int(11) NOT NULL auto_increment,
  `status` tinyint(4) default NULL,
  `productId` varchar(11) NOT NULL COMMENT '所属产品',
  `name` varchar(45) NOT NULL,
  `originalPrice` double default NULL COMMENT '价格',
  `discountPrice` double default NULL,
  `standard` varchar(45) default NULL COMMENT '规格',
  `quantity` int(11) default NULL COMMENT '库存',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='SKU';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sku`
--

LOCK TABLES `t_sku` WRITE;
/*!40000 ALTER TABLE `t_sku` DISABLE KEYS */;
INSERT INTO `t_sku` VALUES (1,1,'6','啊啊啊',444,111,'1斤',1000);
/*!40000 ALTER TABLE `t_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` tinyint(4) NOT NULL default '1',
  `type` tinyint(4) NOT NULL default '1',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `sex` tinyint(4) NOT NULL default '1',
  `age` int(11) NOT NULL default '0',
  `phone` varchar(45) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'huoyao','huoyao','霍耀1',1,1,'2015-05-06 15:25:30',1,0,'15828059647','519034857@qq.com'),(2,'admin','admin','管理员',1,1,'2015-05-06 15:25:30',1,0,'15828059647','519034857@qq.com'),(3,'111','1111','111',1,1,'2015-09-22 15:43:52',1,5,'111111','1111111@qq.com');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_userrole`
--

DROP TABLE IF EXISTS `t_userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_userrole` (
  `id` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_USER_ID_idx` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_userrole`
--

LOCK TABLES `t_userrole` WRITE;
/*!40000 ALTER TABLE `t_userrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-23  0:49:56
"Administrator" Sid: S-1-5-21-2173044074-3471317958-1174632630-500
