package com.hy.manager.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractAppAuthenticationFilter extends AuthenticationFilter {

	public static final String TOKEN = "token";
	public static final String NEXT_TOKEN = "nextToken";
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		logger.debug("App用户进入校验!" + getLoginUrl());
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println(req.getRequestURI());
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		if (isAccess(req, res)) {
			return onAccessSuccess(req, res);
		}
		return onAccessFail(req, res);
	}

	/**
	 * 判断合法性
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract boolean isAccess(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 认证成功进行的操作处理
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract boolean onAccessSuccess(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 认证失败时处理结果
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract boolean onAccessFail(HttpServletRequest request, HttpServletResponse response);

}
