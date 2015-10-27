package com.hy.manager.web.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Order;
import com.hy.manager.domain.business.SkuDTO;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/order")
public class ApiOrderController extends ApiBasicController {
	@Autowired
	private OrderService orderService;

	/**
	 * 添加订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public ResponseMessage add(HttpServletRequest request, Order order, @RequestParam("skus[]") SkuDTO[] skus) {
		
		int uid = this.getUid(request);
		order.setCustomerId(uid);
		
		order.setCreateTime(new Date());// 设置订单创建时间
		// 设置订单编号
		long l = System.currentTimeMillis();
		String no = l + "" + order.getCustomerId();
		order.setNo(no);
		order.setStatus(Order.STATUS_NON_PAYMENT);// 待付款
		orderService.insert(order);
		// 添加订单中的sku相关信息，包括购买的数量，购买时的价格等等
		orderService.addSkus(order.getId(), skus);
		// 减少各个SKU的库存量
		orderService.decreaseSkusQuantity(skus);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("下单成功!");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("orderNo", order.getNo());
		result.put("orderId", order.getId());
		result.put("orderStatus", order.getStatus());
		result.put("orderStatusInfo", order.getStatusInfo());
		
		message.setData(result);
		return message;
	}

	/**
	 * 取消订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "cancel")
	@ResponseBody
	public ResponseMessage cancel(Order order) {
		order.setStatus(Order.STATUS_CANCEL);// 取消订单
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("取消订单成功!");
		return message;
	}

	/**
	 * 付款
	 * 
	 * @return
	 */
	@RequestMapping(value = "pay")
	@ResponseBody
	public ResponseMessage pay(Order order) {
		order.setPayTime(new Date());// 设置订单付款时间
		order.setStatus(Order.STATUS_PAYMENT);// 已付款
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("付款成功!");
		return message;
	}

	/**
	 * 收货
	 * 
	 * @return
	 */
	@RequestMapping(value = "receive")
	@ResponseBody
	public ResponseMessage receive(Order order) {
		order.setStatus(Order.STATUS_RECEIVE);// 已收货
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("收货成功!");
		return message;
	}

	/**
	 * 买家申请退货
	 * 
	 * @return
	 */
	@RequestMapping(value = "refunding")
	@ResponseBody
	public ResponseMessage refunding(Order order) {
		order.setStatus(Order.STATUS_REFUNDING);// 已收货
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("申请退货!");
		return message;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "del")
	@ResponseBody
	public ResponseMessage del(Order order) {
		order.setStatus(Order.STATUS_DEL);
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("删除成功!");
		return message;
	}

}
