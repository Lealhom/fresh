package com.hy.manager.web.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.business.Order;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

@Controller
@RequestMapping(value = "order")
public class OrderController extends BasicController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("order/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return orderService.listPaged(parameter);
	}
	/**
	 * 卖家发货
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "send", method = RequestMethod.POST)
	public ResponseMessage sendGoods(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		orderService.updateStatus(ids,Order.STATUS_SEND);//已发货
		return message;
	}
	/**
	 * 卖家退款
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "refunded", method = RequestMethod.POST)
	public ResponseMessage refund(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		orderService.updateStatus(ids,Order.STATUS_REFUNDED);
		return message;
	}
}
