package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface AddressMapper extends AbstractMapper {

	public List<Address> addressList(@Param("customerId") int customerId,@Param("param")Parameter parameter);

	public void cancelDefaultFlag(@Param("customerId") int customerId);
}
