package com.hy.manager.web.controller.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Comment;
import com.hy.manager.domain.business.Order;
import com.hy.manager.service.ScoreService;
import com.hy.manager.service.business.CommentService;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.service.business.SkuService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/comment")
public class ApiCommentController  extends ApiBasicController{
	@Autowired
	private CommentService commentService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SkuService skuService;
	@Autowired
	private ScoreService scoreService;
	/**
	 * 添加评论
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "add/{orderId}/{skuId}")
	@ResponseBody
	public ResponseMessage add(Comment comment, @PathVariable int orderId,
			@PathVariable int skuId,HttpServletRequest request) {
		int customerId = this.getUid(request);
		comment.setCustomerId(customerId);
		comment.setOrderId(orderId);
		comment.setSkuId(skuId);
		comment.setCreateTime(new Date());
		this.commentService.insert(comment);

		Order order = orderService.selectById(orderId);
		order.setStatus(Order.STATUS_FINISH);// 已评价
		orderService.update(order);
		
		//根据评分，更新sku的好评数，中评数，差评数
		int skuCommentScore = comment.getScore();
		skuService.updateSkuComment(skuId,skuCommentScore);
		
		double a = order.getPrice();
		if(order.getDiscountPrice() > 0 ){
			a = order.getDiscountPrice();
		}
		Map<String,Object> map = (Map<String, Object>) scoreService.selectById(1);
		int rate = Integer.valueOf(map.get("rate").toString());
		double score = a*rate*0.1;//订单金额换算成积分
		scoreService.updateCustomerScore(customerId,score);//更新用户的积分
		
		ResponseMessage message = new ResponseMessage();
		message.setMessage("评论成功!");
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
