package com.hy.manager.service;

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

	public void updateScoreRate(int rate) {
		scoreMapper.updateScoreRate(rate);
	}

}
