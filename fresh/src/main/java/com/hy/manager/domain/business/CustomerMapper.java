package com.hy.manager.domain.business;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface CustomerMapper extends AbstractMapper {

	public Customer login(@Param("username") String username,@Param("password") String password);

	public void updateHeadPhoto(@Param("customerId") int customerId, @Param("imgUuid") String imgUuid);

}
