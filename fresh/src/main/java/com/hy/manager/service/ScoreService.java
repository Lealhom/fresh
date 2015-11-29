package com.hy.manager.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.ScoreMapper;

@Service
public class ScoreService extends AbstractService<Object> {

	@Autowired
	private ScoreMapper scoreMapper;

	public ScoreService() {
		super(Object.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return scoreMapper;
	}

	public void updateScoreRate(int rate,String type) {
		scoreMapper.updateScoreRate(rate,type);
	}
	public void updateCustomerScore(int customerId,double score){
		scoreMapper.updateCustomerScore(customerId,score);
	}

	public Map<String,Object> findRateByType(String type) {
		return scoreMapper.findRateByType(type);
	}
}
