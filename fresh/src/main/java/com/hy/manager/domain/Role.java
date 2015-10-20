package com.hy.manager.domain;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int STATUS_NORMAL = 1;// 正常
	public static final int STATUS_FORBIDDEN = 2;// 禁用

	private int id;
	private String name;
	private int status;
	private String description;

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

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
