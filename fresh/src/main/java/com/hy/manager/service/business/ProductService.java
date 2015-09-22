package com.hy.manager.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Product;
import com.hy.manager.domain.business.ProductMapper;
import com.hy.manager.service.AbstractService;

@Service
public class ProductService extends AbstractService<Product> {

	@Autowired
	private ProductMapper productMapper;

	public ProductService() {
		super(Product.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return productMapper;
	}
	public void addCategoryId(int productId,String categoryId){
		this.productMapper.addCategoryId(Integer.toString(productId),categoryId);
	}
	public void addCategoryIds(int productId,String categoryIds[]){
		for(String s:categoryIds){
			this.addCategoryId(productId,s);
		}
	}
}
