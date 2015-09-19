package com.hy.manager.domain.business;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**0待付款**/
	public static final int STATUS_NON_PAYMENT = 0;
	/**1已付款**/
	public static final int STATUS_PAYMENT = 1;
	/**2订单取消**/
	public static final int STATUS_CANCEL = 2;
	/**3订单退款**/
	public static final int STATUS_REFUND = 3;
	/**4待评价**/
	public static final int STATUS_FINISH = 4;
	/**5订单完成**/
	public static final int STATUS_COMMENT = 5;
	
	private int id;
	@JSONField(format = "yyyy/HH/dd hh:mm")
	private Date createtime;// 订单创建时间
	@JSONField(format = "yyyy/HH/dd hh:mm")
	private Date paytime;// 付款时间
	private double price;// 订单价格
	private int status;// 订单状态：0待付款 1已付款 2订单取消 3订单退款 4待评价 5订单完成
	private int customId;//购买人ID
	
	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getPaytime() {
		return paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return customId;
	}

	public void setUserId(int userId) {
		this.customId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
