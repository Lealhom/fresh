package com.hy.manager.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class BaseFormAuthenticationFilter extends FormAuthenticationFilter {

	// /**
	// * 覆盖默认实现，用sendRedirect直接跳出框架，以免造成js框架重复加载js出错。
	// * @param token
	// * @param subject
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// * @see
	// org.apache.shiro.web.filter.authc.FormAuthenticationFilter#onLoginSuccess(org.apache.shiro.authc.AuthenticationToken,
	// org.apache.shiro.subject.Subject, javax.servlet.ServletRequest,
	// javax.servlet.ServletResponse)
	// */
	// @Override
	// protected boolean onLoginSuccess(AuthenticationToken token,
	// Subject subject, ServletRequest request, ServletResponse response)
	// throws Exception {
	// HttpServletRequest httpServletRequest = (HttpServletRequest)request;
	// HttpServletResponse httpServletResponse = (HttpServletResponse)response;
	//
	// if
	// (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))
	// || request.getParameter("ajax") == null) {//不是ajax请求
	// // httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
	// this.getSuccessUrl());//直接跳转到成功页面
	// httpServletResponse.setContentType("text/html;charset=UTF-8");
	// httpServletResponse.setHeader("Cache-Control","no-cache");
	// // AjaxObject ajaxObject = new AjaxObject();
	// //
	// httpServletResponse.getWriter().write(JsonUtil.fromObjectToString(ajaxObject));
	// } else {
	// httpServletRequest.getRequestDispatcher("/login/timeout/success").forward(httpServletRequest,
	// httpServletResponse);
	// }
	// return false;
	// }

}
