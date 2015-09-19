package com.hy.manager.web;

import java.io.Serializable;

public class Parameter implements Serializable {

	private static final long serialVersionUID = 1L;

	private int page;
	private int rows;

	public int getStart() {
		return (page - 1) * rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
