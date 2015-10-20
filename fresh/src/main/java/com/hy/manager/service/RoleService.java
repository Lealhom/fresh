package com.hy.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.Role;
import com.hy.manager.domain.RoleMapper;

@Service
public class RoleService extends AbstractService<Role> {

	@Autowired
	private RoleMapper roleMapper;

	public RoleService() {
		super(Role.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return roleMapper;
	}

}
