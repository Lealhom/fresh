package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface OrderMapper extends AbstractMapper {

	public List<Order> orderList(@Param("userId") int userId);
	
	public void updateExpireOrder();
	
	public void updateSkuQuantity();
}
