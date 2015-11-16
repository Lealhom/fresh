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