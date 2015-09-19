package com.hy.manager.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FiletypeMapper extends AbstractMapper {

	public List<Filetype> selectByParentId(@Param("parentId") int parentId);
}
