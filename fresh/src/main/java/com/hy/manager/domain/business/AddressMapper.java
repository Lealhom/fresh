package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface AddressMapper extends AbstractMapper {

	public List<Address> addressList(@Param("customerId") int customerId);
}
