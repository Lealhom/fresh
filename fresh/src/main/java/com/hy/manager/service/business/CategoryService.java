package com.hy.manager.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Category;
import com.hy.manager.domain.business.CategoryMapper;
import com.hy.manager.service.AbstractService;

@Service
public class CategoryService extends AbstractService<Category> {

	@Autowired
	private CategoryMapper categoryMapper;

	public CategoryService() {
		super(Category.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return categoryMapper;
	}

	public List<Map<String, Object>> categoryList() {
		return categoryMapper.categoryList();
	}

	public List<Category> selectByParentId(int parentId) {
		return categoryMapper.selectByParentId(parentId);
	}

	public List<Map<String, Object>> listCategoryMap() {
		return categoryMapper.listCategoryMap();
	}

}
