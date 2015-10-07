package com.hy.manager.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.service.business.OrderService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/order")
public class ApiOrderController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * 添加订单
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public ResponseMessage add(){
		this.orderService.insert(null);
		return null;
	}
	
	/**
	 * 付款
	 * @return
	 */
	@RequestMapping(value = "pay/{orderId}")
	@ResponseBody
	public ResponseMessage pay(){
		return null;
	}
	
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "del/{orderId}")
	@ResponseBody
	public ResponseMessage del(){
		return null;
	}
	
	/**
	 * 买家申请退货
	 * @return
	 */
	@RequestMapping(value = "refunding/{orderId}")
	@ResponseBody
	public ResponseMessage refunding(){
		return null;
	}
	/**
	 * 卖家退货
	 * @return
	 */
	@RequestMapping(value = "refunded/{orderId}")
	@ResponseBody
	public ResponseMessage refunded(){
		return null;
	}
	/**
	 * 取消订单
	 * @return
	 */
	@RequestMapping(value = "cancel/{orderId}")
	@ResponseBody
	public ResponseMessage cancel(){
		return null;
	}
	
	/**
	 * 发货
	 * @return
	 */
	@RequestMapping(value = "send/{orderId}")
	@ResponseBody
	public ResponseMessage send(){
		return null;
	}
	/**
	 * 收货
	 * @return
	 */
	@RequestMapping(value = "receive/{orderId}")
	@ResponseBody
	public ResponseMessage receive(){
		return null;
	}
	
}
