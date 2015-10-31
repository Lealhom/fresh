package com.test.service.bussiness;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.service.business.SkuService;
import com.test.service.abs.AbstractTest;

public class TestSkuService extends AbstractTest {
	SkuService skuService;

	@Before
	public void init() {
		skuService = (SkuService) applicationContext.getBean("skuService");
	}

	@Test
	public void testUpdate() {
		skuService.updateSkuComment(6, 5);
		skuService.updateSkuComment(6, 4);
		skuService.updateSkuComment(6, 3);
		skuService.updateSkuComment(6, 2);
		skuService.updateSkuComment(6, 1);
	}
}
