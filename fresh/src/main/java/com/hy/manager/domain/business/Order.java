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
	/**6订单过期**/
	public static final int STATUS_EXPIRE = 6;
	
	private int id;
	@JSONField(format = "yyyy/HH/dd hh:mm")
	private Date createTime;// 订单创建时间
	@JSONField(format = "yyyy/HH/dd hh:mm")
	private Date payTime;// 付款时间
	private int status;// 订单状态：0待付款 1已付款 2订单取消 3订单退款 4待评价 5订单完成 6订单过期
	private String no;//订单编号（根据一定的业务规则进行生成）
	private int customerId;//购买人ID
	private int addressId;//收货地址
	private double price;// 订单价格
	private double discountPrice;//订单折后价
	private double freight;//运费
	private String message;//给卖家留言 
	private int payType;//付款方式
	private String logisticsNo;//物流编号（在卖家发货后，输入物流编号，方便消费者在相应的物流官网上进行查询）
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
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
}
