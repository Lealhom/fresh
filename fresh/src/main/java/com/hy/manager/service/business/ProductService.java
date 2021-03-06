package com.hy.manager.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Product;
import com.hy.manager.domain.business.ProductMapper;
import com.hy.manager.service.AbstractService;
import com.hy.manager.web.Parameter;

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

	public void addCategoryId(int productId, String categoryId) {
		this.productMapper.addCategoryId(Integer.toString(productId),
				categoryId);
	}

	public void addCategoryIds(int productId, String categoryIds[]) {
		for (String s : categoryIds) {
			this.addCategoryId(productId, s);
		}
	}

	public void delCategoryIds(int productId) {
		this.productMapper.delCategoryIds(productId);
	}

	public void addViceImgUuid(int productId, String viceImgUuid, int orderNum) {
		this.productMapper.addViceImgUuid(Integer.toString(productId),
				viceImgUuid, orderNum);
	}

	public void addViceImgUuids(int productId, List<String> viceImgUuids) {
		for (int i = 0; i < viceImgUuids.size(); i++) {
			this.addViceImgUuid(productId, viceImgUuids.get(i), (i + 1));
		}
	}

	public void setHot(int[] ids) {
		this.productMapper.setHot(ids);
	}

	public void cancelHot(int[] ids) {
		this.productMapper.cancelHot(ids);
	}

	public List<Map<String, Object>> listHotProduct(Parameter parameter) {
		return this.productMapper.listHotProduct(parameter);
	}

	public void addCollection(int customerId, int skuId) {
		this.productMapper.addCollection(customerId, skuId);
	}

	public void delCollection(int customerId, int skuId) {
		this.productMapper.delCollection(customerId, skuId);
	}

	public List<Map<String, Object>> listCollection(int customerId, Parameter parameter) {
		return this.productMapper.listCollection(customerId,parameter);
	}

	public List<Map<String, Object>> listByActivityId(int activityId, Parameter parameter) {
		return this.productMapper.listByActivityId(activityId,parameter);
	}
	
	public List<Map<String, Object>> listByJifen(Parameter parameter) {
		return this.productMapper.listByJifen(parameter);
	}

	public List<Map<String, Object>> listByCategoryId(int categoryId, Parameter parameter) {
		return this.productMapper.listByCategoryId(categoryId,parameter);
	}

	public List<Map<String, Object>> search(String name) {
		return this.productMapper.search(name);
	}

	public Map<String, Object> detail(int productId, int skuId, Parameter parameter) {
		return this.productMapper.detail(productId, skuId,parameter);
	}

	public List<String> findViceImgs(int productId) {
		return this.productMapper.findViceImgs(productId);
	}

	public void delViceImgUuids(int productId) {
		productMapper.delViceImgUuids(productId);
	}

}
