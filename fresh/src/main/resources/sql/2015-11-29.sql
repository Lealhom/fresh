DROP TABLE IF EXISTS `t_score_configration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_score_configration` (
  `id` int(11) NOT NULL auto_increment,
  `rate` int(1) default '0',
  `type` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_score_configration`
--

LOCK TABLES `t_score_configration` WRITE;
/*!40000 ALTER TABLE `t_score_configration` DISABLE KEYS */;
INSERT INTO `t_score_configration` VALUES (1,6,'moneyToScore'),(2,2,'scoreToMoney');