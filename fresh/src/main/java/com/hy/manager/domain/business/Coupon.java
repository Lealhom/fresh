package com.hy.manager.domain.business;

import java.io.Serializable;

/**
 * 现金券
 * @author lianghongl
 */
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private double money;//现金券金额
	private String startTime;//有效期起
	private String endTime;//有效期止
	private int status;//状态
	private int type;//现金券类型
	private double exceedMoney;//订单金额超过多少可以用
	private String name;//名称
	private String description;//描述
	public static final int TYPE_NORMAL  = 1;//普通现金券
	public static final int TYPE_REGISTER = 2;//注册时送的现金券
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusInfo() {
		if (status == 1) {
			return "正常";
		}
		if (status == 2) {
			return "禁用";
		}
		return String.valueOf(status);
	}
	public int getType() {
		return type;
	}
	public String getTypeInfo() {
		if (type == Coupon.TYPE_NORMAL) {
			return "普通现金券";
		}
		if (type == Coupon.TYPE_REGISTER) {
			return "注册型现金券";
		}
		return String.valueOf(type);
	}
	public void setType(int type) {
		this.type = type;
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
