package com.hy.manager.domain.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.domain.AbstractMapper;

public interface CategoryMapper extends AbstractMapper {

	public List<Map<String, Object>> categoryList();

	public List<Category> selectByParentId(@Param("parentId") int parentId);

	public List<Map<String, Object>> listCategoryMap();

}
