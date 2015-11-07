package com.hy.manager.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Coupon;
import com.hy.manager.domain.business.CouponMapper;
import com.hy.manager.service.AbstractService;
import com.hy.manager.web.Parameter;

@Service
public class CouponService extends AbstractService<Coupon> {

	@Autowired
	private CouponMapper couponMapper;

	public CouponService() {
		super(Coupon.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return couponMapper;
	}

	public List<Map<String,Object>> listByCustomerId(int customerId, Parameter parameter) {
		return couponMapper.listByCustomerId(customerId,parameter);
	}

}
