package com.hy.manager.domain;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ScoreMapper extends AbstractMapper {

	void updateScoreRate(@Param("rate") int rate,@Param("type") String type);

	void updateCustomerScore(@Param("customerId")int customerId, @Param("score")double score);

	Map<String,Object> findRateByType(@Param("type") String type);

}
