package com.hy.manager.domain.business;

import java.io.Serializable;

/**
 * 活动
 * 
 * @author huoyao
 *
 */
public class Activity implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int status;
	private String name;
	private String description;
	private String startTime;
	private String endTime;
	private int banner;// 是否为banner
	private int presell;// 是否为预售
	private int pre_rate;//预售时需要预付几成的定金
	public int getPresell() {
		return presell;
	}

	public void setPresell(int presell) {
		this.presell = presell;
	}

	public int getPre_rate() {
		return pre_rate;
	}

	public void setPre_rate(int pre_rate) {
		this.pre_rate = pre_rate;
	}

	private String productIds[];
	private String productNames;
	private int orderNum;// 序号
	private String imgUuid;// 活动图片uuid
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
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
	public String getPresellInfo() {
		if (presell == 1) {
			return "是";
		}
		if (presell == 2) {
			return "否";
		}
		return String.valueOf(presell);
	}
	public String getBannerInfo() {
		if (banner == 1) {
			return "是";
		}
		if (banner == 2) {
			return "否";
		}
		return String.valueOf(banner);
	}
	public void setStatus(int status) {
		this.status = status;
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

	public int getBanner() {
		return banner;
	}

	public void setBanner(int banner) {
		this.banner = banner;
	}

	public String[] getProductIds() {
		return productIds;
	}

	public void setProductIds(String[] productIds) {
		this.productIds = productIds;
	}

	public String getProductNames() {
		return productNames;
	}

	public void setProductNames(String productNames) {
		this.productNames = productNames;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getImgUuid() {
		return imgUuid;
	}

	public void setImgUuid(String imgUuid) {
		this.imgUuid = imgUuid;
	}
}
