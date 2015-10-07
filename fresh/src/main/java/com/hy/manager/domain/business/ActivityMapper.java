package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface ActivityMapper extends AbstractMapper {

	public void addProductId(@Param("activityId") String activityId, @Param("productId") String productId);

	public List<Map<String,Object>> listBanner();

	public List<Map<String,Object>> listActivity();

}
