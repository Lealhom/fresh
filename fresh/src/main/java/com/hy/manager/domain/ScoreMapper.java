package com.hy.manager.domain;

import org.apache.ibatis.annotations.Param;

public interface ScoreMapper extends AbstractMapper {

	void updateScoreRate(@Param("rate") int rate);

	void updateCustomerScore(@Param("customerId")int customerId, @Param("score")double score);

}
