package com.hy.manager.domain.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface SkuMapper extends AbstractMapper {
	public List<Sku> selectByOrderId(@Param("orderId") int orderId);

	public void updateSkuScore();

	public void updateSkuComment(@Param("skuId") int skuId,@Param("score") int score);
	
	public void addViceImgUuid(@Param("skuId") String skuId,@Param("viceImgUuid") String viceImgUuid,@Param("orderNum") int orderNum);
	
	public void delViceImgUuids(@Param("skuId") int skuId);
	
	public List<String> findViceImgs(@Param("skuId") int skuId);
}
