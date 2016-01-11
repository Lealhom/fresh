ALTER TABLE `fresh`.`t_activity` 
ADD COLUMN `presell` TINYINT(4) NULL COMMENT '是否预售' AFTER `orderNum`,
ADD COLUMN `pre_rate` TINYINT(4) NULL COMMENT '预售需要付几成的定金' AFTER `presell`;
SET SQL_SAFE_UPDATES = 0;
update t_activity set presell = 2 ;
update t_activity set pre_rate = 1 ;