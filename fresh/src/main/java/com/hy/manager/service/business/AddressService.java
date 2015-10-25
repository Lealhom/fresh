package com.hy.manager.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Address;
import com.hy.manager.domain.business.AddressMapper;
import com.hy.manager.service.AbstractService;

@Service
public class AddressService extends AbstractService<Address> {

	@Autowired
	private AddressMapper addressMapper;

	public AddressService() {
		super(Address.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return addressMapper;
	}

	/**
	 * 获得地址列表
	 * 
	 * @return
	 */
	public List<Address> addressList(int userId) {
		return this.addressMapper.addressList(userId);
	}
	
	public void cancelDefaultFlag(int customerId) {
		this.addressMapper.cancelDefaultFlag(customerId);
	}

}
