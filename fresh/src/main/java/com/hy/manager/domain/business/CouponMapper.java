package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface CouponMapper extends AbstractMapper {

	List<Map<String,Object>> listByCustomerId(@Param("customerId")int customerId, @Param("param")Parameter parameter);

}
