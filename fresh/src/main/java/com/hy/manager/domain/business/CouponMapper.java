package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface CouponMapper extends AbstractMapper {

	List<Map<String,Object>> listByCustomerId(@Param("customerId")int customerId, @Param("param")Parameter parameter);
	List<Map<String,Object>> uselistByCustomerId(@Param("customerId")int customerId, @Param("param")Parameter parameter, @Param("exceedMoney") double exceedMoney);

	Coupon findByType(@Param("type")int type);

	void addCustomerCoupon(@Param("customerId")int customerId, @Param("couponId")int couponId, @Param("batchNo")String batchNo, @Param("status")int status);

	void useCoupon(@Param("useTime")String useTime,@Param("batchNo")String batchNo,@Param("orderId")int orderId);

}
