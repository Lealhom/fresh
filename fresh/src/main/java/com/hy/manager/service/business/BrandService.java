package com.hy.manager.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Brand;
import com.hy.manager.domain.business.BrandMapper;
import com.hy.manager.service.AbstractService;

@Service
public class BrandService extends AbstractService<Brand> {

	@Autowired
	private BrandMapper brandMapper;

	public BrandService() {
		super(Brand.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return brandMapper;
	}

}
