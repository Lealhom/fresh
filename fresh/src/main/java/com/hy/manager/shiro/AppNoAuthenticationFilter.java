package com.hy.manager.shiro;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hy.manager.web.ResponseMessage;

public class AppNoAuthenticationFilter extends AbstractAppAuthenticationFilter {

	@Override
	public boolean isAccess(HttpServletRequest request,
			HttpServletResponse response) {
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
