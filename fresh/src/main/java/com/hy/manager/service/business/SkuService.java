package com.hy.manager.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Sku;
import com.hy.manager.domain.business.SkuMapper;
import com.hy.manager.service.AbstractService;
import com.hy.manager.web.GridData;

@Service
public class SkuService extends AbstractService<Sku> {

	@Autowired
	private SkuMapper skuMapper;

	public SkuService() {
		super(Sku.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return skuMapper;
	}

	public GridData selectByOrderId(int orderId) {
		GridData data = new GridData();
		List<Sku> skus = this.skuMapper.selectByOrderId(orderId);
		data.setRows(skus);
		data.setTotal(skus.size());
		return data;
	}
	/**
	 * 更新sku的评分
	 */
	public void updateSkuScore() {
		this.skuMapper.updateSkuScore();
	}

}
