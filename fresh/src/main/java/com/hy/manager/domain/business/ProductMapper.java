package com.hy.manager.domain.business;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface ProductMapper extends AbstractMapper {
	public void addCategoryId(@Param("productId") String productId,@Param("categoryId") String categoryId);
}
