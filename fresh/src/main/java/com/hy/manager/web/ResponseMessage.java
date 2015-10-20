package com.hy.manager.web;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int STATUS_OK = 200;// 成功
	public static final int STATUS_UNAUTHORIZED = 401;// 需要登录
	public static final int STATUS_FORBIDDEN = 403;// 权限不够
	public static final int STATUS_ERROR = 500;// 权限不够
	
	public static final int ACTION_TOAST = 1;//弹出toast
	public static final int ACTION_LOGIN = 2;//回到登录页
	
	
	private int action = ACTION_TOAST;
	private int status = STATUS_OK;
	private String message;
	private Object data;

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

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
