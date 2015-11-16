package com.test.service.bussiness;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.service.business.CouponService;
import com.hy.manager.web.Parameter;
import com.test.service.abs.AbstractTest;

public class TestCouponService extends AbstractTest {
	CouponService couponService;

	@Before
	public void init() {
		couponService = (CouponService) applicationContext.getBean("couponService");
	}

	@Test
	public void testMyCoupon() {
		Parameter parameter = new Parameter();
		parameter.setPage(1);
		parameter.setRows(10);
		List<Map<String,Object>> list = couponService.listByCustomerId(1, parameter);
		System.out.println(list.size());
	}
	
	//发放现金券
	@Test
	public void testAddCustomerCoupon() {
		String batchNo = String.valueOf(System.currentTimeMillis());
		int status = 1;
		couponService.addCustomerCoupon(1, 1, batchNo, status);
	}
	
	//使用现金券
	@Test
	public void testUseCoupon() {
		String useTime = "2015-11-07 15:30:53";
		String batchNo = "1447683252847";
		int orderId = 1;
		couponService.useCoupon(useTime, batchNo,orderId);
	}
}
