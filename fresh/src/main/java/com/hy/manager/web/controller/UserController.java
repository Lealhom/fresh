package com.hy.manager.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.User;
import com.hy.manager.service.UserService;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "user")
public class UserController extends BasicController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("user/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return userService.listPaged(parameter);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("user/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(User user) {
		ResponseMessage message = new ResponseMessage();
		user.setCreateTime(new Date());
		userService.insert(user);
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("user/update");
		User user = userService.selectById(id);
		mav.addObject("user", user);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(User user) {
		ResponseMessage message = new ResponseMessage();
		userService.update(user);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		userService.deleteByIds(ids);
		return message;
	}
}
