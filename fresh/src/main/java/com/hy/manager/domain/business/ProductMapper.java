package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.Parameter;

public interface ProductMapper extends AbstractMapper {
	public void addCategoryId(@Param("productId") String productId,@Param("categoryId") String categoryId);

	public void delCategoryIds(@Param("productId") int productId);

	public void addViceImgUuid(@Param("productId") String productId,@Param("viceImgUuid") String viceImgUuid,@Param("orderNum") int orderNum);

	public void delViceImgUuids(@Param("productId") int productId);

	public void setHot(@Param("ids") Object ids);

	public void cancelHot(@Param("ids") Object ids);

	public void addCollection(@Param("customerId") int customerId,@Param("skuId") int skuId);

	public void delCollection(@Param("customerId") int customerId,@Param("skuId") int skuId);

	public List<Map<String, Object>> listCollection(@Param("customerId") int customerId,@Param("param") Parameter parameter);

	public List<Map<String, Object>> listHotProduct(@Param("param") Parameter parameter);

	public List<Map<String, Object>> listByActivityId(@Param("activityId") int activityId,@Param("param") Parameter parameter);

	public List<Map<String, Object>> listByCategoryId(@Param("categoryId") int categoryId,@Param("param") Parameter parameter);

	public List<Map<String, Object>> search(@Param("name") String name,@Param("param") Parameter parameter);

	public Map<String, Object> detail(@Param("productId") int productId,@Param("skuId") int skuId,@Param("param") Parameter parameter);

	public List<String> findViceImgs(@Param("productId") int productId);

}
