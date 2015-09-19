package com.hy.manager.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Sku;
import com.hy.manager.domain.business.SkuMapper;
import com.hy.manager.service.AbstractService;

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

}
