package com.hy.manager.service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;

public abstract class AbstractService<T> {

	protected Class<T> entity;

	public AbstractService(Class<T> entity) {
		this.entity = entity;
	}

	public abstract AbstractMapper getAbstractMapper();

	/**
	 * 创建实体
	 * 
	 * @param entity
	 */
	public int insert(T entity) {
		return getAbstractMapper().insert(entity);
	}

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		getAbstractMapper().update(entity);
	}

	/**
	 * 删除实体
	 * 
	 * @param ids
	 */
	public void deleteById(Object id) {
		getAbstractMapper().deleteById(id);
	}

	/**
	 * 批量删除实体
	 * 
	 * @param entity
	 * @return
	 */
	public void deleteByIds(Object ids) {
		getAbstractMapper().deleteByIds(ids);
	}

	public T selectById(Object id) {
		return getAbstractMapper().selectById(id);
	}

	/**
	 * 分页
	 * 
	 * @return
	 */
	public GridData listPaged(Parameter parameter) {
		GridData data = new GridData();
		data.setRows(this.getAbstractMapper().listPaged(parameter));
		data.setTotal(this.getAbstractMapper().count());
		return data;
	}

}
