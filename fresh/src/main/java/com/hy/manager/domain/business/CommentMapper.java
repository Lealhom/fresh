package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface CommentMapper extends AbstractMapper {

	public List<Map<String, Object>> listByOrderId(@Param("orderId") int orderId);

	public List<Map<String, Object>> listBySkuId(@Param("skuId") int skuId,@Param("param") Parameter parameter);
}
