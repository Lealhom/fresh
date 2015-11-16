package com.hy.manager.domain.business;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int status;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;// 创建时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;// 最后更新时间
	private String description;// 产品描述
	private String bornPlace;// 产地
	private String mainImgUuid;// 主图的uuid
	private int brandId;// 品牌id
	private String brandName;// 品牌名称
	private String categoryIds[];// 接收添加商品是，前端传回来的参数
	private String categoryNames;// 接收数据库返回回来的品类名称
	private int hot;// 是否为热销商品

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getHotInfo() {
		if (status == 1) {
			return "是";
		}
		if (status == 0) {
			return "否";
		}
		return String.valueOf(hot);
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainImgUuid() {
		return mainImgUuid;
	}

	public void setMainImgUuid(String mainImgUuid) {
		this.mainImgUuid = mainImgUuid;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String[] getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String[] categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(String categoryNames) {
		this.categoryNames = categoryNames;
	}

	public String getBornPlace() {
		return bornPlace;
	}

	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

}
