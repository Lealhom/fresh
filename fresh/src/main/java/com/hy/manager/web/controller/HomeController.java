package com.hy.manager.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.Menu;
import com.hy.manager.service.MenuService;

@Controller
public class HomeController extends BasicController {

	@Autowired
	private MenuService menuService;

	@RequiresAuthentication
	@RequestMapping(value = "/")
	public ModelAndView index() {
		List<Menu> menus = menuService.findPermissionMenu(0);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("menus", menus);
		return mav;
	}

	@RequestMapping(value = "login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "unauthorized", method = RequestMethod.GET)
	public ModelAndView unauthorized() {
		ModelAndView mav = new ModelAndView("unauthorized");
		return mav;
	}

}
