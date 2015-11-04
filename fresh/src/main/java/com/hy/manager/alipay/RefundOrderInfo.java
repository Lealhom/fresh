package com.hy.manager.alipay;

import java.util.List;

import com.hy.manager.domain.business.Order;

/**
 * 封装退款订单的信息,在后台的订单管理界面，选择多个订单，点击退款，输入退款理由，然后把退款的订单和订单理由封装到这个里面，每个订单需要的信息是订单的交易号tradeNo，订单总金额
 * @author Administrator
 *
 */
public class RefundOrderInfo {
	String reason;//退款理由
	List<Order> orders;//多个退款订单，因为需要支持批量退款
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
