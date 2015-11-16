package com.hy.manager.web.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.business.Coupon;
import com.hy.manager.service.business.CouponService;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

@Controller
@RequestMapping(value = "coupon")
public class CouponController extends BasicController {

	@Autowired
	private CouponService couponService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("coupon/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return couponService.listPaged(parameter);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("coupon/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(Coupon coupon) {
		ResponseMessage message = new ResponseMessage();
		Coupon c = couponService.findByType(coupon.getType());
		if(null != c){
			message.setMessage("已经存在此类型的现金券");
		}else{
			couponService.insert(coupon);
		}
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("coupon/update");
		Coupon coupon = couponService.selectById(id);
		mav.addObject("coupon", coupon);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(Coupon coupon) {
		ResponseMessage message = new ResponseMessage();
		couponService.update(coupon);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		couponService.deleteByIds(ids);
		return message;
	}
}
