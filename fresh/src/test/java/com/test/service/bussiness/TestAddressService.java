package com.test.service.bussiness;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hy.manager.domain.business.Address;
import com.hy.manager.service.business.AddressService;
import com.hy.manager.web.Parameter;
import com.test.service.abs.AbstractTest;

public class TestAddressService extends AbstractTest {
	AddressService addressService;

	@Before
	public void init() {
		addressService = (AddressService) applicationContext
				.getBean("addressService");
	}

	@Test
	public void testAdd() {
		Address entity = new Address();
		entity.setAddress("华新下街");
		entity.setConsignee("李良洪");
		entity.setCustomerId(1);
		entity.setDefaultFlag(true);
		entity.setLatitude(77.07);
		entity.setLongitude(88.08);
		entity.setPhone("15196636547");
		entity.setSex(1);
		int i = addressService.insert(entity);
		Assert.assertEquals(1, i);
	}

	@Test
	public void testList() {
		List<Address> list = addressService.addressList(1,new Parameter());
		for (Address a : list) {
			System.out.println(a.getAddress());
		}
	}

	@Test
	public void testDelete() {
		addressService.deleteById(1);
	}

	@Test
	public void testUpdate() {
		Address entity = addressService.selectById(1);
		entity.setAddress("华新下街111");
		entity.setConsignee("李良洪111");
		entity.setCustomerId(1111);
		entity.setDefaultFlag(true);
		entity.setLatitude(77.071);
		entity.setLongitude(88.081);
		entity.setPhone("15196636547111");
		entity.setSex(0);
		addressService.update(entity);
	}

}
