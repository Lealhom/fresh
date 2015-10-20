package com.test.service.bussiness;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hy.manager.domain.business.Activity;
import com.hy.manager.service.business.ActivityService;
import com.test.service.abs.AbstractTest;

public class TestActivityService extends AbstractTest{
	ActivityService activityService;
	@Before
	public void init(){
		activityService	 = (ActivityService) applicationContext.getBean("activityService");
	}
	
	@Test
	public void testListAll(){
		List<Activity> list= activityService.listAll();
		System.out.println(list);
	}
}
