package com.hy.manager.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Activity;
import com.hy.manager.domain.business.ActivityMapper;
import com.hy.manager.service.AbstractService;

@Service
public class ActivityService extends AbstractService<Activity> {

	@Autowired
	private ActivityMapper activityMapper;

	public ActivityService() {
		super(Activity.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return activityMapper;
	}

	public void addProductId(int activityId, String productId) {
		activityMapper.addProductId(Integer.toString(activityId), productId);
	}

	public void addProductIds(int activityId, String[] productIds) {
		for (String s : productIds) {
			this.addProductId(activityId, s);
		}
	}

	public List<Map<String, Object>> listBanner() {
		return this.activityMapper.listBanner();
	}

	public List<Map<String, Object>> listActivity() {
		return this.activityMapper.listActivity();
	}

	public void delProductIds(int activityId) {
		activityMapper.delProductIds(activityId);
	}

	public List<Map<String, Object>> listPresell() {
		return this.activityMapper.listPresell();
	}

}
