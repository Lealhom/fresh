package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface ProductMapper extends AbstractMapper {
	public void addCategoryId(@Param("productId") String productId,@Param("categoryId") String categoryId);

	public void setHot(@Param("ids") Object ids);

	public void cancelHot(@Param("ids") Object ids);

	public void addCollection(@Param("customerId") int customerId, @Param("productId") int productId);
	
	public void delCollection(@Param("customerId") int customerId, @Param("productId") int productId);

	public List<Product> listCollection(@Param("customerId") int customerId);
}
