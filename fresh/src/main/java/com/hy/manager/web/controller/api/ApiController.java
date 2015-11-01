package com.hy.manager.web.controller.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "api")
public class ApiController {

	@ResponseBody
	@RequestMapping("notify")
	public String notifyUrl(HttpServletRequest request) {
		Map<String, String[]> result = request.getParameterMap();
		System.out.println(JSON.toJSONString(result));
		return "success";
	}
}
