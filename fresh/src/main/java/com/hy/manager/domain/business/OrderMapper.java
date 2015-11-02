package com.hy.manager.domain.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface OrderMapper extends AbstractMapper {

	public List<Map<String, Object>> orderList(
			@Param("customerId") int customerId,
			@Param("param") Parameter parameter);

	public Map<String, Object> orderDetail(@Param("orderId") int orderId);

	public void updateExpireOrder();

	public void updateSkuQuantity();

	public void updateStatus(@Param("ids") int[] ids,
			@Param("status") int status);

	public void pay(@Param("no") String no, @Param("status") int status,
			@Param("payTime") Date payTime, @Param("buyeId") String buyeId,
			@Param("buyerEmail") String buyerEmail,
			@Param("tradeNo") String tradeNo);

	public void addSku(SkuDTO skuDTO);

	public void decreaseSkuQuantity(@Param("skuId") String skuId,
			@Param("quantity") int quantity);

}
