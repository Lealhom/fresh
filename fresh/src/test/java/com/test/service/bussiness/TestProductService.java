package com.test.service.bussiness;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.service.business.ProductService;
import com.hy.manager.web.Parameter;
import com.test.service.abs.AbstractTest;

public class TestProductService extends AbstractTest {
	ProductService productService;

	@Before
	public void init() {
		productService = (ProductService) applicationContext
				.getBean("productService");
	}

	@Test
	public void testAddCollection() {
		productService.addCollection(1, 3);
		productService.addCollection(1, 4);
		productService.addCollection(1, 5);
	}

	@Test
	public void testDelCollection() {
		productService.delCollection(1, 1);
	}

	@Test
	public void testListCollection() {
		Parameter p = new Parameter();
		p.setPage(1);
		p.setRows(10);
		List<Map<String, Object>> list = productService.listCollection(1,p);
		System.out.println(list);
	}
	@Test
	public void testSearch() {
		List<Map<String, Object>> list = productService.search("苹果");
		for(Map<String,Object> m:list){
			System.out.println(m.get("skuName"));
		}
	}
	@Test
	public void testListHotProduct() {
		List<Map<String, Object>> list = productService.listHotProduct(new Parameter());
		System.out.println(list.size());
	}
}
