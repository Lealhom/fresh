package com.hy.manager.domain;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends AbstractMapper {

	public User findByUsername(@Param("username") String username);
}
