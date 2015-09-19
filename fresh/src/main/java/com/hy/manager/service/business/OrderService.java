package com.hy.manager.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Order;
import com.hy.manager.domain.business.OrderMapper;
import com.hy.manager.service.AbstractService;

@Service
public class OrderService extends AbstractService<Order> {

	@Autowired
	private OrderMapper orderMapper;

	public OrderService() {
		super(Order.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return orderMapper;
	}
	
	public List<Order> orderList(int userId) {
		return this.orderMapper.orderList(userId);
	}

}
