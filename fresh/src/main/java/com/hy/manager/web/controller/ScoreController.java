package com.hy.manager.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.service.ScoreService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "score")
public class ScoreController extends BasicController {
	@Autowired
	private ScoreService scoreService;
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "page")
	public ModelAndView index() {
		Map<String,Object> map = (Map<String, Object>) scoreService.selectById(1);
		int rate = Integer.valueOf(map.get("rate").toString());
		ModelAndView mav = new ModelAndView("score/page");
		mav.addObject("rate", rate);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(int rate) {
		ResponseMessage message = new ResponseMessage();
		scoreService.updateScoreRate(rate);
		return message;
	}
}
