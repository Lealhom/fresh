package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface ProductMapper extends AbstractMapper {
	public void addCategoryId(@Param("productId") String productId,
			@Param("categoryId") String categoryId);

	public void delCategoryIds(@Param("productId") int productId);

	public void addViceImgUuid(@Param("productId") String productId,
			@Param("viceImgUuid") String viceImgUuid,
			@Param("orderNum") int orderNum);

	public void delViceImgUuids(@Param("productId") int productId);

	public void setHot(@Param("ids") Object ids);

	public void cancelHot(@Param("ids") Object ids);

	public void addCollection(@Param("customerId") int customerId,
			@Param("skuId") int skuId);

	public void delCollection(@Param("customerId") int customerId,
			@Param("skuId") int skuId);

	public List<Map<String, Object>> listCollection(@Param("customerId") int customerId);

	public List<Map<String, Object>> listHotProduct();

	public List<Map<String, Object>> listByActivityId(
			@Param("activityId") int activityId);

	public List<Map<String, Object>> listByCategoryId(
			@Param("categoryId") int categoryId);

	public List<Map<String, Object>> search(@Param("name") String name);

	public Map<String, Object> detail(@Param("productId") int productId,
			@Param("skuId") int skuId);

	public List<String> findViceImgs(@Param("productId") int productId);

}
