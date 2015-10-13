package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface OrderMapper extends AbstractMapper {

	public List<Order> orderList(@Param("customerId") int customerId);
	
	public void updateExpireOrder();
	
	public void updateSkuQuantity();

	public void updateStatus(@Param("ids")int[] ids,@Param("status")int status);

	public void addSku(SkuDTO skuDTO);

	public void decreaseSkuQuantity(@Param("skuId") String skuId, @Param("quantity") int quantity);
}
