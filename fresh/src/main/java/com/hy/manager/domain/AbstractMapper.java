package com.hy.manager.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hy.manager.web.Parameter;

public interface AbstractMapper {

	public int insert(Object entity);

	public int update(Object entity);

	public int deleteById(@Param("id") Object id);

	public int deleteByIds(@Param("ids") Object ids);

	public <T> T selectById(@Param("id") Object id);

	public <T> List<T> listAll();
	
	public <T> List<T> listPaged(Parameter parameter);

	public long count();


}
