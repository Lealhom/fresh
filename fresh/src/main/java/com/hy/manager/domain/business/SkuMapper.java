package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface SkuMapper extends AbstractMapper {
	public List<Sku> selectByOrderId(@Param("orderId") int orderId);
}
