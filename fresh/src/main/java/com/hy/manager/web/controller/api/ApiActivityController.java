package com.hy.manager.web.controller.api;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Activity;
import com.hy.manager.service.business.ActivityService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/activity")
public class ApiActivityController {
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 获取banner活动
	 * @return
	 */
	@RequestMapping(value = "list_banner")
	@ResponseBody
	public ResponseMessage listBanner() {
		List<Map<String,Object>> list = activityService.listBanner();
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	/**
	 * 获取普通活动
	 * @return
	 */
	@RequestMapping(value = "list_activity")
	@ResponseBody
	public ResponseMessage listActivity() {
		List<Map<String,Object>> list = activityService.listActivity();
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
}
