package com.hy.manager.web.controller;

import java.util.List;
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
		List<Object> list =  scoreService.listAll();
//		int rate = Integer.valueOf(map.get("rate").toString());
//		mav.addObject("rate1", rate);
		ModelAndView mav = new ModelAndView("score/page");
		for(int i=0;i<list.size();i++){
			Map<String,Object> map = (Map<String, Object>) list.get(i);
			if("moneyToScore".equals((String)map.get("type"))){
				int rate = Integer.valueOf(map.get("rate").toString());
				mav.addObject("rate1", rate);
			}
			if("scoreToMoney".equals((String)map.get("type"))){
				int rate = Integer.valueOf(map.get("rate").toString());
				mav.addObject("rate2", rate);
			}
		}
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update1(int rate1,int rate2) {
		ResponseMessage message = new ResponseMessage();
		scoreService.updateScoreRate(rate1,"moneyToScore");
		scoreService.updateScoreRate(rate2,"scoreToMoney");
		return message;
	}
}
