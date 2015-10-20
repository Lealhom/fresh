package com.hy.manager.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;

public class CustomLogoutFilter extends LogoutFilter {

	@Override
	protected void issueRedirect(ServletRequest request,
			ServletResponse response, String redirectUrl) throws Exception {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		// AjaxObject ajaxObject = new AjaxObject();
		// httpServletResponse.getWriter().write(JsonUtil.fromObjectToString(ajaxObject));
	}
}
