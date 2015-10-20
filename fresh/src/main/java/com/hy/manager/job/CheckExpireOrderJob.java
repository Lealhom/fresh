package com.hy.manager.job;

import org.springframework.context.ApplicationContextAware;

import com.hy.manager.service.business.OrderService;
/**
 * @author lianghongl
 * 定时检查过期的订单，下单24小时候仍未付款的，将视为过期订单，系统自动取消该订单，并把相应sku的库存量写回去
 * 这样的目的是防止恶意下单，把库存量减少了却又不付款，典型的占着茅坑不拉屎
 */
public class CheckExpireOrderJob extends AbstractJob implements ApplicationContextAware{
	/**
	 * 这里用autowired搞不到事，试了几种网上的方法也搞不到事，就用继承ApplicationContextAware，然后通过applicationContext.getBean()来获得吧
	 */
	private OrderService orderService;
	protected void execute() {
		orderService = (OrderService) applicationContext.getBean("orderService");
		System.out.println("执行订单定时任务");
		orderService.updateSkuQuantity();
		orderService.updateExpireOrder();
	}

}