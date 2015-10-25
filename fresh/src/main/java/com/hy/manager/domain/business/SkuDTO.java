package com.hy.manager.domain.business;

import java.io.Serializable;

/**
 * 订单下面的各个SKU信息
 * 
 * @author Administrator
 *
 */
public class SkuDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String orderId;
	private String skuId;
	private int quantity;// 购买数量
	private double unitPrice;// 单价

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
