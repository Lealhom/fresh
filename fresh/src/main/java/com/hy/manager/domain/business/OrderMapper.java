package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface OrderMapper extends AbstractMapper {

	public List<Map<String,Object>> orderList(@Param("customerId") int customerId, Parameter parameter);

	public List<Map<String, Object>> orderDetail(@Param("orderId") int orderId, Parameter parameter);

	public void updateExpireOrder();

	public void updateSkuQuantity();

	public void updateStatus(@Param("ids") int[] ids,
			@Param("status") int status);

	public void addSku(SkuDTO skuDTO);

	public void decreaseSkuQuantity(@Param("skuId") String skuId,
			@Param("quantity") int quantity);

}
