CREATE TABLE `t_coupon` (
  `id` int(11) NOT NULL auto_increment,
  `customerId` varchar(11) default NULL,
  `orderId` varchar(11) default NULL,
  `batchNo` varchar(20) default NULL,
  `money` double default NULL,
  `exceedMoney` double default NULL,
  `startTime` varchar(20) default NULL,
  `endTime` varchar(20) default NULL,
  `useTime` varchar(20) default NULL,
  `status` tinyint(4) default NULL,
  `name` varchar(45) default NULL,
  `description` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='现金券';