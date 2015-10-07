package com.hy.manager.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Customer;
import com.hy.manager.domain.business.CustomerMapper;
import com.hy.manager.service.AbstractService;

@Service
public class CustomerService extends AbstractService<Customer> {

	@Autowired
	private CustomerMapper customerMapper;

	public CustomerService() {
		super(Customer.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return customerMapper;
	}
	
	public boolean login(String username, String password){
		Customer customer = this.customerMapper.login(username,password);
		if(customer!=null){
			return true;
		}
		return false;
	}
}
