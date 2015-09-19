package com.hy.manager.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends AbstractMapper {

	public List<Menu> findPermissionMenu(@Param("userId") int userId);
}
