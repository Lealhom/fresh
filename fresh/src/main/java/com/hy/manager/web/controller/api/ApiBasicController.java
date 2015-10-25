package com.hy.manager.web.controller.api;

import javax.servlet.http.HttpServletRequest;

public class ApiBasicController {

	protected int getUid(HttpServletRequest request) {
		String uidStr = request.getParameter("uid");
		return Integer.valueOf(uidStr);
	}
}
