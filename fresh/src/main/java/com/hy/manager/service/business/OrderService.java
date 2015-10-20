package com.hy.manager.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Order;
import com.hy.manager.domain.business.OrderMapper;
import com.hy.manager.domain.business.SkuDTO;
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
	/**
	 * 把超过一定时间的未付款订单修改为过期订单
	 */
	public void updateExpireOrder(){
		this.orderMapper.updateExpireOrder();
	}
	/**
	 * 修改sku的库存量，把过期订单里面的sku的购买数量还原到相应sku的库存量中
	 */
	public void updateSkuQuantity(){
		this.orderMapper.updateSkuQuantity();
	}

	public void updateStatus(int[] ids,int status) {
		this.orderMapper.updateStatus(ids,status);
	}

	public void addSkus(int orderId, SkuDTO[] skuDTOS) {
		for(SkuDTO o:skuDTOS){
			this.addSku(orderId, o);
		}
	}
	public void addSku(int orderId, SkuDTO o) {
		o.setOrderId(Integer.toString(orderId));
		this.orderMapper.addSku(o);
	}

	public void decreaseSkusQuantity(SkuDTO[] skuDTOS) {
		for(SkuDTO o:skuDTOS){
			this.orderMapper.decreaseSkuQuantity(o.getSkuId(),o.getQuantity());
		}
	}
	
}
