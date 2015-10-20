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
  `startTime` varchar(30) NOT NULL,
  `endTime` varchar(30) NOT NULL,
  `status` tinyint(4) default NULL,
  `banner` tinyint(4) default NULL,
  `imgUuid` varchar(40) default NULL,
  `orderNum` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='活动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
INSERT INTO `t_activity` VALUES (8,'国庆活动','国庆活动国庆活动国庆活动国庆活动国庆活动','2015-10-11 21:40:36','2015-10-28 21:40:40',1,1,'754d5c2c-a6a9-4171-9fff-4d474d1224d5',1);
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_activity_product`
--

DROP TABLE IF EXISTS `t_activity_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity_product` (
  `id` int(11) NOT NULL auto_increment,
  `activityId` varchar(11) NOT NULL,
  `productId` varchar(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity_product`
--

LOCK TABLES `t_activity_product` WRITE;
/*!40000 ALTER TABLE `t_activity_product` DISABLE KEYS */;
INSERT INTO `t_activity_product` VALUES (1,'3','4'),(2,'3','5'),(3,'4','3'),(4,'4','6'),(5,'5','3'),(6,'6','3'),(7,'7','6'),(8,'8','10'),(9,'8','11');
/*!40000 ALTER TABLE `t_activity_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL auto_increment,
  `customerId` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL default '',
  `address` varchar(45) NOT NULL default '',
  `sex` int(11) default '1' COMMENT '1男2女',
  `consignee` varchar(45) NOT NULL default '' COMMENT '收货人',
  `longitude` float default '0',
  `latitude` float default '0',
  `defaultFlag` tinyint(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (2,1,'15828059647','考虑考虑',0,'肖繁花',0,0,NULL),(3,1,'15196636547','华新下街',1,'李良洪',88.08,77.07,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
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
  `imgUuid` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='品类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (6,'进口鲜果',1,'',''),(7,'苹果',2,'6','2.jpg'),(8,'西瓜',2,'6','19bedfa3-4178-4532-8d63-a8003fea068a'),(9,'葡萄',2,'6','putao.jpg'),(10,'肉禽蛋类',1,'',''),(11,'牛肉',2,'10','niurou.jpg'),(12,'羊肉',2,'10','yangrou.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='品类跟产品的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category_product`
--

LOCK TABLES `t_category_product` WRITE;
/*!40000 ALTER TABLE `t_category_product` DISABLE KEYS */;
INSERT INTO `t_category_product` VALUES (1,'6','6'),(2,'6','7'),(3,'7','7'),(4,'8','6'),(5,'9','6'),(18,'10','6'),(19,'10','7'),(22,'11','9');
/*!40000 ALTER TABLE `t_category_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_collection`
--

DROP TABLE IF EXISTS `t_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_collection` (
  `id` int(11) NOT NULL auto_increment,
  `customerId` int(11) default NULL,
  `productId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='“我的收藏”表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collection`
--

LOCK TABLES `t_collection` WRITE;
/*!40000 ALTER TABLE `t_collection` DISABLE KEYS */;
INSERT INTO `t_collection` VALUES (2,1,3),(3,1,4),(4,1,5),(5,1,3),(6,1,4),(7,1,5);
/*!40000 ALTER TABLE `t_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL auto_increment,
  `customerId` int(11) NOT NULL COMMENT '评论人ID',
  `orderId` int(11) NOT NULL COMMENT '订单ID',
  `skuId` int(11) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '评论时间',
  `content` varchar(200) NOT NULL default '' COMMENT '评论内容',
  `score` int(11) NOT NULL default '5' COMMENT '评分（等级）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (1,1,1,1,'2015-10-08 13:47:42','好！！！！！！！',5),(2,1,2,1,'2015-10-08 13:47:42','好！！！！！！！',4),(3,1,3,1,'2015-10-08 13:47:42','好！！！！！！！',5),(4,1,4,2,'2015-10-08 13:47:42','好！！！！！！！',5),(5,1,5,2,'2015-10-08 13:47:42','好！！！！！！！',4);
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
  `showname` varchar(45) default '',
  `phone` varchar(15) default '',
  `email` varchar(45) default '',
  `imgUuid` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='顾客';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
INSERT INTO `t_customer` VALUES (2,'admin','admin','叶良辰','110','88888@qq.com','19bedfa3-4178-4532-8d63-a8003fea068a');
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
  `typeId` int(11) default '0' COMMENT '文件分类的Id',
  `type` varchar(20) default NULL COMMENT '文件类型， jpg,mpg,png等等',
  `uuid` varchar(40) default NULL COMMENT '文件类型， jpg,mpg,png等等',
  `uploadTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_file`
--

LOCK TABLES `t_file` WRITE;
/*!40000 ALTER TABLE `t_file` DISABLE KEYS */;
INSERT INTO `t_file` VALUES (6,'奇异果.jpg',0,NULL,'','2015-09-20 15:36:57'),(7,'QQ截图20150915231903.png',0,NULL,'','2015-09-22 14:10:59'),(8,'QQ截图20150915231613.png',0,NULL,'','2015-09-22 14:26:30'),(9,'2.jpg',0,NULL,'','2015-09-22 15:14:11'),(10,'2.jpg',0,NULL,'119f2139-c00e-4ce5-a1cd-df2449233fb8','2015-10-06 14:56:04'),(11,'yangrou',0,'image/jpeg',NULL,'2015-10-11 08:32:47'),(12,'putao',0,'image/jpeg','09717566-482a-46d0-8475-4326ed01b452','2015-10-11 08:34:35'),(13,'img_2',0,'image/png','1f2a3ca0-3710-4777-bf8f-6a87a7fbc72a','2015-10-11 08:36:24'),(14,'img_4',0,'image/png','2aaf3570-ac00-489c-90be-c4e5cec84b79','2015-10-11 08:42:56'),(15,'2',0,'image/jpeg','7aeb349c-1be5-4b99-ba74-aa8e3b649c01','2015-10-11 09:35:29'),(16,'2',0,'image/jpeg','cb1aa928-89fd-43ec-a7a8-815b5f2d8272','2015-10-11 09:40:05'),(17,'2',0,'image/jpeg','d50b9604-6688-4bfc-a848-d5e110c9cc23','2015-10-11 09:40:35'),(18,'2',0,'image/jpeg','977f3cb4-3fba-4c6e-8ab6-5c62ba881f52','2015-10-11 09:41:06'),(19,'2',0,'image/jpeg','92150748-bc26-475a-bd86-4d8d9fd7ee8f','2015-10-11 11:04:04'),(20,'2',0,'image/jpeg','6f92b41d-ecb5-4340-92e7-2acd48935192','2015-10-11 11:29:16'),(21,'2',0,'image/jpeg','64cfc4c7-2a8c-4ba9-b366-cc9f989afabe','2015-10-11 11:35:46'),(22,'img_3',0,'image/png','e2ece2c8-3fe3-4859-8e43-607510e068a7','2015-10-11 11:38:37'),(23,'2',0,'image/jpeg','fa8fb5a1-0258-4bf3-b5fb-1f3eac8b247b','2015-10-11 11:39:59'),(24,'xigua',0,'image/jpeg','19bedfa3-4178-4532-8d63-a8003fea068a','2015-10-11 11:41:51'),(25,'putao',0,'image/jpeg','0e5adb27-9725-40c1-97d9-7bfe8aed315f','2015-10-11 12:45:58'),(26,'img_5',0,'image/png','754d5c2c-a6a9-4171-9fff-4d474d1224d5','2015-10-11 13:41:26');
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
  `customerId` int(11) NOT NULL,
  `createTime` timestamp NULL default NULL,
  `payTime` timestamp NULL default NULL COMMENT '付款时间',
  `price` double NOT NULL default '0' COMMENT '订单价格',
  `discountPrice` double default NULL,
  `freight` double default NULL,
  `status` tinyint(4) NOT NULL default '0' COMMENT '订单状态：0待付款 1已付款 2订单取消 3订单退款 4待评价 5订单完成',
  `addressId` int(11) default NULL,
  `payType` tinyint(4) default NULL,
  `no` varchar(45) default NULL,
  `logisticsNo` varchar(45) default NULL,
  `message` varchar(45) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_ORDER_USERID_idx` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,1,'2015-09-26 12:57:14','2015-05-06 15:25:30',12.5,NULL,NULL,3,NULL,NULL,NULL,'123564789',NULL),(2,1,'2015-09-26 14:19:03','2015-05-06 15:25:30',12.5,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL),(3,2,'2015-09-26 12:44:33','2015-09-27 12:44:33',100.5,80,12,3,3,0,'14433578734440','sfkd111111','老板，尽快发货，我等不及了');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_sku`
--

DROP TABLE IF EXISTS `t_order_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_sku` (
  `id` int(11) NOT NULL auto_increment,
  `orderId` int(11) NOT NULL COMMENT '所属订单的ID',
  `skuId` int(11) NOT NULL COMMENT 'sku的id',
  `quantity` int(11) default NULL COMMENT '购买了多少个此SKU，即这个SKU购买数量',
  `unitPrice` double default NULL COMMENT '这个SKU的单价',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='订单与SKU的中间表，订单与sku是一对多关系，';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_sku`
--

LOCK TABLES `t_order_sku` WRITE;
/*!40000 ALTER TABLE `t_order_sku` DISABLE KEYS */;
INSERT INTO `t_order_sku` VALUES (1,2,6,10,NULL),(2,2,7,20,NULL),(3,1,6,30,NULL),(4,3,7,10,NULL);
/*!40000 ALTER TABLE `t_order_sku` ENABLE KEYS */;
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
  `mainImgUuid` varchar(40) default NULL,
  `brandId` int(11) default NULL,
  `bornPlace` varchar(100) default NULL,
  `hot` tinyint(4) default '0',
  `salesCount` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='产品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (10,'新西兰红苹果1',1,'新西兰红苹果111','2015-10-11 13:35:58',NULL,'92150748-bc26-475a-bd86-4d8d9fd7ee8f',4,'新西兰1',0,NULL),(11,'新疆葡萄',1,'新疆葡萄新疆葡萄新疆葡萄新疆葡萄','2015-10-11 12:48:22','2015-10-11 12:49:12','0e5adb27-9725-40c1-97d9-7bfe8aed315f',4,'新疆',0,NULL);
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_file`
--

DROP TABLE IF EXISTS `t_product_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_file` (
  `id` int(11) NOT NULL auto_increment,
  `productId` int(11) default NULL,
  `imgUuid` varchar(50) default NULL,
  `type` tinyint(4) default NULL COMMENT '图片类型、区分是展示图还是商品详情介绍中的图。',
  `orderNum` tinyint(4) default NULL COMMENT '图片展示顺序，比如在展示图中，如果orderNum排在最前面的即是我们的主图',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='产品与图片间的中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_file`
--

LOCK TABLES `t_product_file` WRITE;
/*!40000 ALTER TABLE `t_product_file` DISABLE KEYS */;
INSERT INTO `t_product_file` VALUES (4,10,'ba4f4278-ea3a-426c-a436-f49bdf8b6f4e',1,1),(5,10,'84e64b48-5a2c-40c5-b6a9-0a8d2b2d2145',1,2),(6,11,'510ea171-ff13-4bb4-9ea4-5d20a4cbdd41',1,1),(7,11,'225b2020-8cc9-4b83-8a0d-b022e1e02fdd',1,2);
/*!40000 ALTER TABLE `t_product_file` ENABLE KEYS */;
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
  `productId` varchar(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `originalPrice` double default NULL COMMENT '价格',
  `discountPrice` double default NULL,
  `standard` varchar(45) default NULL COMMENT '规格',
  `quantity` int(11) default NULL COMMENT '库存',
  `salesCount` int(11) default NULL,
  `avgScore` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='SKU';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sku`
--

LOCK TABLES `t_sku` WRITE;
/*!40000 ALTER TABLE `t_sku` DISABLE KEYS */;
INSERT INTO `t_sku` VALUES (6,1,'11','新疆葡萄大份',100,80,'3斤',100,NULL,NULL),(7,1,'11','新疆葡萄小份',50,45,'1斤',100,NULL,NULL),(8,1,'10','新西兰红苹果大份',100,90,'3斤',500,NULL,NULL),(9,1,'10','新西兰红苹果小份',50,40,'1斤',400,NULL,NULL);
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

-- Dump completed on 2015-10-11 21:55:57
"Administrator" Sid: S-1-5-21-2173044074-3471317958-1174632630-500
