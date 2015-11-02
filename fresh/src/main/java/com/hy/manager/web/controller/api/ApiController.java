package com.hy.manager.web.controller.api;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hy.manager.domain.business.Order;
import com.hy.manager.service.business.OrderService;

@Controller
@RequestMapping(value = "api")
public class ApiController {
	
	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping("notify")
	public String notifyUrl(HttpServletRequest request) {
		String orderNo = request.getParameter("out_trade_no");
		String trade_no = request.getParameter("trade_no");
		//WAIT_BUYER_PAY 交易创建，等待买家付款。
		//TRADE_CLOSED在指定时间段内未支付时关闭的交易；在交易完成全额退款成功时关闭的交易。
		//TRADE_SUCCESS 交易成功，且可对该交易做操作，如：多级分润、退款等。
		//TRADE_FINISHED 交易成功且结束，即不可再做任何操作。
		String trade_status = request.getParameter("trade_status");
		String buyer_id = request.getParameter("buyer_id");
		String buyer_email = request.getParameter("buyer_email");
		Map<String, String[]> result = request.getParameterMap();
		System.out.println(JSON.toJSONString(result));
		int status = 0;
		if (trade_status.equals("WAIT_BUYER_PAY")) {
			status = Order.STATUS_NON_PAYMENT;
		} else if (trade_status.equals("TRADE_CLOSED")) {
			status = Order.STATUS_CANCEL;
		} else if (trade_status.equals("TRADE_SUCCESS")) {
			status = Order.STATUS_PAYMENT;
		} else if (trade_status.equals("TRADE_FINISHED")) {
			status = Order.STATUS_PAYMENT;
		}
		this.orderService.pay(orderNo, status, new Date(), buyer_id, buyer_email, trade_no);
		return "success";
	}
}
