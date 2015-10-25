package com.hy.manager.shiro;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hy.manager.util.TokenUtils;
import com.hy.manager.web.ResponseMessage;

public class AppTokenAuthenticationFilter extends
		AbstractAppAuthenticationFilter {

	@Override
	public boolean isAccess(HttpServletRequest request,
			HttpServletResponse response) {
		String token = "";
		String nextToken = "";
		String password = "";
		//
		// Cookie[] cookies = request.getCookies();
		//
		// if (null == cookies || cookies.length == 0) {
		// return false;
		// }
		//
		token = request.getHeader("token");
		nextToken = request.getHeader("next");
		password = request.getHeader("time");
		//
		// for (Cookie cookie : cookies) {
		// if (cookie.getName().equals("token")) {
		// token = cookie.getValue();
		// } else if (cookie.getName().equals("next")) {
		// nextToken = cookie.getValue();
		// } else if (cookie.getName().equals("password")) {
		// password = cookie.getValue();
		// } else if(cookie.getName().equals("userName")){
		// request.setAttribute("userName", cookie.getValue());
		// }
		// }
		// if (!TokenUtils.validToken(token, password) &&
		// !TokenUtils.validToken(nextToken, password)) {
		// return false;
		// }
		// Date now = new Date(System.currentTimeMillis());
		// token = TokenUtils.getToken(password, now);
		// nextToken = TokenUtils.getToken(password,
		// TokenUtils.getNextHour(now));

		// response.setHeader("token", token);
		// response.setHeader("next", nextToken);
		// Cookie tokenCookie = new Cookie("token", token);
		// tokenCookie.setPath("/");
		// Cookie nextTokenCookie = new Cookie("next", nextToken);
		// nextTokenCookie.setPath("/");
		// // 将两个新token发给客户端
		// response.addCookie(tokenCookie);
		// response.addCookie(nextTokenCookie);
		return true;
	}

	@Override
	public boolean onAccessSuccess(HttpServletRequest request,
			HttpServletResponse response) {
		return true;
	}

	@Override
	public boolean onAccessFail(HttpServletRequest request,
			HttpServletResponse response) {
		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseMessage.STATUS_UNAUTHORIZED);
		message.setMessage("请登录");
		try {
			JSON.writeJSONStringTo(message, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
