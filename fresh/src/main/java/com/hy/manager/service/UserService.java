package com.hy.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.User;
import com.hy.manager.domain.UserMapper;

@Service
public class UserService extends AbstractService<User> {

	@Autowired
	private UserMapper userMapper;

	public UserService() {
		super(User.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return userMapper;
	}
	
	public User findByUsername(String username) {
		return this.userMapper.findByUsername(username);
	}

}
