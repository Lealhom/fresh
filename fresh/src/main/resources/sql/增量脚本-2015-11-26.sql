CREATE TABLE `t_sku_file` (
  `id` int(11) NOT NULL auto_increment,
  `skuId` int(11) default NULL,
  `imgUuid` varchar(50) default NULL,
  `type` tinyint(4) default NULL COMMENT '图片类型、区分是展示图还是详情介绍中的图。',
  `orderNum` tinyint(4) default NULL COMMENT '图片展示顺序，比如在展示图中，如果orderNum排在最前面的即是我们的主图',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='SKU与图片间的中间表';

ALTER TABLE `fresh`.`t_sku` 
ADD COLUMN `mainImgUuid` VARCHAR(40) NULL AFTER `productId`;
