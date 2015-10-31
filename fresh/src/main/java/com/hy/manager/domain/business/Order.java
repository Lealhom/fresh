package com.hy.manager.domain.business;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 0待付款 **/
	public static final int STATUS_NON_PAYMENT = 0;
	/** 1订单取消 **/
	public static final int STATUS_CANCEL = 1;
	/** 2已付款 待发货**/
	public static final int STATUS_PAYMENT = 2;
	/** 3已发货 **/
	public static final int STATUS_SEND = 3;
	/** 4收货 **/
	public static final int STATUS_RECEIVE = 4;
	/** 5申请退款、待退款 **/
	public static final int STATUS_REFUNDING = 5;
	/** 6申请退款、已退款 **/
	public static final int STATUS_REFUNDED = 6;
	/** 7已评价 **/
	public static final int STATUS_FINISH = 7;
	/** 8订单过期 **/
	public static final int STATUS_EXPIRE = 8;
	/** 9删除订单（逻辑删除） **/
	public static final int STATUS_DEL = 9;

	private int id;
	@JSONField(format = "yyyy/HH/dd hh:mm")
	private Date createTime;// 订单创建时间
	@JSONField(format = "yyyy/HH/dd hh:mm")
	private Date payTime;// 付款时间
	private int status;// 订单状态
	private String no;// 订单编号（根据一定的业务规则进行生成）
	private int customerId;// 购买人ID
	private String username;// 购买者的用户名
	private String showname;// 显示名，昵称
	private int addressId;// 收货地址Id
	private String address;// 收货地址
	private String consignee;// 收货人
	private String phone;// 手机
	private double price;// 订单价格
	private double discountPrice;// 订单折后价
	private double freight;// 运费
	private String message;// 给卖家留言
	private int payType;// 付款方式
	private String logisticsNo;// 物流编号（在卖家发货后，输入物流编号，方便消费者在相应的物流官网上进行查询）
	private String skuIds[];// 关联的SKU

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getStatusInfo() {
		if (status == Order.STATUS_CANCEL) {
			return "已取消";
		}
		if (status == Order.STATUS_DEL) {
			return "已删除";
		}
		if (status == Order.STATUS_FINISH) {
			return "已评价";
		}
		if (status == Order.STATUS_NON_PAYMENT) {
			return "待付款";
		}
		if (status == Order.STATUS_PAYMENT) {
			return "已付款";
		}
		if (status == Order.STATUS_RECEIVE) {
			return "已收货";
		}
		if (status == Order.STATUS_REFUNDED) {
			return "已退款";
		}
		if (status == Order.STATUS_REFUNDING) {
			return "待退款";
		}
		if (status == Order.STATUS_SEND) {
			return "已发货";
		}
		return String.valueOf(status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShowname() {
		return showname;
	}

	public void setShowname(String showname) {
		this.showname = showname;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String[] getSkuIds() {
		return skuIds;
	}

	public void setSkuIds(String[] skuIds) {
		this.skuIds = skuIds;
	}

}
