package com.test.service.bussiness;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hy.manager.domain.business.Customer;
import com.hy.manager.service.business.CustomerService;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.test.service.abs.AbstractTest;

public class TestCustomerService extends AbstractTest{
	CustomerService customerService;
	@Before
	public void init(){
		customerService	 = (CustomerService) applicationContext.getBean("customerService");
	}
	
	@Test
	public void testAdd(){
		Customer customer = new Customer();
		customer.setUsername("username");
		customer.setPassword("password");
		customer.setPhone("15195566214");
		customer.setEmail("11112222@qq.com");
		customer.setShowname("叶良辰");
		int i = customerService.insert(customer);
		Assert.assertEquals(1, i);
	}
	@Test
	public void testList(){
		Parameter parameter = new Parameter();
		parameter.setPage(1);
		parameter.setRows(10);
		GridData data = customerService.listPaged(parameter);
		if(data.getRows()!=null && data.getRows().size()>0){
			for(int i=0;i<data.getRows().size();i++){
				Customer c = (Customer)data.getRows().get(i);
				System.out.println(c.getShowname());
			}
		}
	}
	@Test
	public void testDelete(){
		customerService.deleteById(1);
	}
	@Test
	public void testUpdate(){
		Customer entity = customerService.selectById(2);
		entity.setPhone("110");
		customerService.update(entity);
	}
	@Test
	public void testSelectOne(){
		Customer entity = customerService.selectById(2);
		System.out.println(entity);
	}
}
