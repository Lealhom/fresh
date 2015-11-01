ALTER TABLE `fresh`.`t_order` 
ADD COLUMN `buyeId` VARCHAR(45) NULL COMMENT '买家支付宝用户号，买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。' AFTER `message`,
ADD COLUMN `buyerEmail` VARCHAR(45) NULL COMMENT '买家支付宝账号，买家支付宝账号，可以是Email或手机号码。' AFTER `buyeId`,
ADD COLUMN `tradeNo` VARCHAR(45) NULL COMMENT '支付宝交易号,该交易在支付宝系统中的交易流水号。最短16位，最长64位。' AFTER `buyerEmail`;
