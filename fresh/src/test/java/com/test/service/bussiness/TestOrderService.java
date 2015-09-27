package com.test.service.bussiness;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.domain.business.Order;
import com.hy.manager.service.business.OrderService;
import com.test.service.abs.AbstractTest;

public class TestOrderService  extends AbstractTest{
	OrderService orderService;
	@Before
	public void init(){
		orderService	 = (OrderService) applicationContext.getBean("orderService");
	}
	
	@Test
	public void testAdd(){
		Order order = new Order();
		order.setCreateTime(new Date());//设置订单创建时间
		//设置订单编号
		long l = System.currentTimeMillis();
		String no = l+""+order.getCustomerId();
		order.setNo(no);
		order.setAddressId(1);
		order.setCustomerId(2);
		order.setDiscountPrice(80.00);
		order.setFreight(12.00);
		order.setLogisticsNo("sfkd111111");
		order.setMessage("老板，尽快发货，我等不及了");
		order.setPayTime(new Date());
		order.setPrice(100.50);
		order.setStatus(0);
		orderService.insert(order);
	}
	@Test
	public void testUpdate(){
		Order order = orderService.selectById(1);
		order.setStatus(1);
		order.setCreateTime(new Date());
		order.setLogisticsNo("123564789");
		orderService.update(order);
	}
}
