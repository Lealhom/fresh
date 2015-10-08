package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface ProductMapper extends AbstractMapper {
	public void addCategoryId(@Param("productId") String productId,@Param("categoryId") String categoryId);

	public void setHot(@Param("ids") Object ids);

	public void cancelHot(@Param("ids") Object ids);

	public void addCollection(@Param("customerId") int customerId, @Param("productId") int productId);
	
	public void delCollection(@Param("customerId") int customerId, @Param("productId") int productId);

	public List<Product> listCollection(@Param("customerId") int customerId);

	public List<Map<String,Object>> listHotProduct();

	public List<Map<String,Object>> listByActivityId(@Param("activityId")int activityId);

	public List<Map<String, Object>> listByCategoryId(@Param("categoryId")int categoryId);

	public List<Map<String, Object>> search(@Param("name")String name);

	public List<Map<String, Object>> detail(@Param("productId")int productId,@Param("skuId")int skuId);
}
