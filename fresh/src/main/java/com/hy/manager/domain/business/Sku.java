package com.hy.manager.domain.business;

import java.io.Serializable;

public class Sku implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String productId;
	private String productName;
	private String name;
	private int status;// 上架、下架状态
	private double originalPrice;// 原价
	private double discountPrice;// 折扣价
	private double scoreConvertRate;// 允许兑换的积分比例
	private String standard;// 规格
	private int quantity;// 库存数量
	private double avgScore;// 该sku的平均评分
	private int haopingQuantity;//好评数量
	private int zhongpingQuantity;//好评数量
	private int chapingQuantity;//好评数量
	private String mainImgUuid;// 主图的uuid
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public int getStatus() {
		return status;
	}
	public String getStatusInfo() {
		if (status == 1) {
			return "上架";
		}
		if (status == 2) {
			return "下架";
		}
		return String.valueOf(status);
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getScoreConvertRate() {
		return scoreConvertRate;
	}

	public void setScoreConvertRate(double scoreConvertRate) {
		this.scoreConvertRate = scoreConvertRate;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public int getHaopingQuantity() {
		return haopingQuantity;
	}

	public void setHaopingQuantity(int haopingQuantity) {
		this.haopingQuantity = haopingQuantity;
	}

	public int getZhongpingQuantity() {
		return zhongpingQuantity;
	}

	public void setZhongpingQuantity(int zhongpingQuantity) {
		this.zhongpingQuantity = zhongpingQuantity;
	}

	public int getChapingQuantity() {
		return chapingQuantity;
	}

	public void setChapingQuantity(int chapingQuantity) {
		this.chapingQuantity = chapingQuantity;
	}

	public String getMainImgUuid() {
		return mainImgUuid;
	}

	public void setMainImgUuid(String mainImgUuid) {
		this.mainImgUuid = mainImgUuid;
	}
}
