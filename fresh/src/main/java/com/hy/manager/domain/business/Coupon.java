package com.hy.manager.domain.business;

import java.io.Serializable;

/**
 * 现金券
 * @author lianghongl
 */
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String customerId;
	private String orderId;
	private String batchNo;//批次号
	private double money;//现金券金额
	private String startTime;//有效期起
	private String endTime;//有效期止
	private String useTime;//使用时间
	private int status;//是否使用
	private double exceedMoney;//订单金额超过多少可以用
	private String name;//名称
	private String description;//描述
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getExceedMoney() {
		return exceedMoney;
	}
	public void setExceedMoney(double exceedMoney) {
		this.exceedMoney = exceedMoney;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
