package com.hy.manager.web.controller.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Comment;
import com.hy.manager.domain.business.Order;
import com.hy.manager.service.business.CommentService;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/comment")
public class ApiCommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private OrderService orderService;

	/**
	 * 添加评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "add/{orderId}/{skuId}")
	@ResponseBody
	public ResponseMessage add(Comment comment, @PathVariable int orderId,
			@PathVariable int skuId) {
		int customerId = 1;
		comment.setCustomerId(customerId);
		comment.setOrderId(orderId);
		comment.setSkuId(skuId);
		comment.setCreateTime(new Date());
		this.commentService.insert(comment);

		Order order = orderService.selectById(orderId);
		order.setStatus(Order.STATUS_FINISH);// 已评价
		orderService.update(order);

		ResponseMessage message = new ResponseMessage();
		message.setMessage("评论成功!");
		return message;
	}

	/**
	 * 根据skuId获取评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "list_by_skuId/{skuId}")
	@ResponseBody
	public ResponseMessage listBySkuId(@PathVariable int skuId) {
		List<Map<String, Object>> list = this.commentService.listBySkuId(skuId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 根据订单ID获取评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "list_by_orderId/{orderId}")
	@ResponseBody
	public ResponseMessage listByOrderId(@PathVariable int orderId) {
		List<Map<String, Object>> list = this.commentService
				.listByOrderId(orderId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
}
