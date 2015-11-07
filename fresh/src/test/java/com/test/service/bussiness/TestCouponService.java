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
}
