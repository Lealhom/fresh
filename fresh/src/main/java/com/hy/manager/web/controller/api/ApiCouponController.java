package com.hy.manager.web.controller.api;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.service.business.CouponService;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/coupon")
public class ApiCouponController extends ApiBasicController {
	@Autowired
	private CouponService couponService;

	/**
	 * 地址列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "my_coupon")
	@ResponseBody
	public ResponseMessage list(HttpServletRequest request,Parameter parameter) {
		int customerId = this.getUid(request);
		List<Map<String,Object>> list = this.couponService.listByCustomerId(customerId,parameter);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	
	/**
	 * 可用的现金券列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "use_coupon")
	@ResponseBody
	public ResponseMessage uselist(HttpServletRequest request, Parameter parameter, double price) {
		int customerId = this.getUid(request);
		List<Map<String,Object>> list = this.couponService.listByCustomerId(customerId,parameter);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
}
