package com.hy.manager.web;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int STATUS_OK = 200;// 成功
	public static final int STATUS_UNAUTHORIZED = 401;// 需要登录
	public static final int STATUS_FORBIDDEN = 403;// 权限不够
	public static final int STATUS_ERROR = 500;// 权限不够

	private int status = STATUS_OK;
	private String message;
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
