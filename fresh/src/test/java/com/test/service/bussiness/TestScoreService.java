package com.test.service.bussiness;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.service.ScoreService;
import com.test.service.abs.AbstractTest;

public class TestScoreService extends AbstractTest {
	ScoreService scoreService;

	@Before
	public void init() {
		scoreService = (ScoreService) applicationContext.getBean("scoreService");
	}

	@Test
	public void test() {
		Map<String,Object> map = scoreService.findRateByType("scoreToMoney");
		int rate = Integer.valueOf(map.get("rate").toString());
		System.out.println(rate);
	}
}
