package com.test.service.bussiness;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.service.business.CategoryService;
import com.test.service.abs.AbstractTest;

public class TestCategoryService extends AbstractTest {
	CategoryService categoryService;

	@Before
	public void init() {
		categoryService = (CategoryService) applicationContext
				.getBean("categoryService");
	}

	@Test
	public void testListCategoryMap() {
		List<Map<String, Object>> list = categoryService.listCategoryMap();
		System.out.println(list.size());
	}
}
