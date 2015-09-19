package com.hy.manager.web.controller.api;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Address;
import com.hy.manager.domain.business.Comment;
import com.hy.manager.domain.business.Order;
import com.hy.manager.service.business.AddressService;
import com.hy.manager.service.business.CommentService;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.util.TokenUtils;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api")
public class ApiController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private AddressService addressService;
	
	@ModelAttribute
	public void setVaryResponseHeader(HttpServletResponse response) {
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
	}
	
	@RequestMapping(value = "app_login", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage login(String username, String password, String time) {
		ResponseMessage message = new ResponseMessage();
		message.setData(TokenUtils.getToken(time));
		return message;
	}
	
	/**
	 * 提交订单
	 * @return
	 */
	@RequestMapping(value = "order", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage order(Order order) {
		order.setCreatetime(new Date());
		orderService.insert(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("评论成功!");
		return message;
	}

	/**
	 * 获得订单列表
	 * @return
	 */
	@RequestMapping(value = "order/{userId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage order(@PathVariable int userId) {
		List<Order> list = orderService.orderList(userId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 获得评论列表
	 * @return
	 */
	@RequestMapping(value = "comment/{carteId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage comment(@PathVariable int carteId) {
		ResponseMessage message = new ResponseMessage();
		List<Comment> list = this.commentService.selectByCarteId(carteId);
		message.setData(list);
		return message;
	}

	/**
	 * 评论
	 * @return
	 */
	@RequestMapping(value = "{userId}/comment/{carteId}/{orderId}/{rank}/{content}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage comment(@PathVariable int userId, @PathVariable int carteId, @PathVariable int orderId, @PathVariable int rank, @PathVariable String content) {
		Comment comment = new Comment();
//		comment.setUserId(userId);
		comment.setCarteId(carteId);
		comment.setOrderId(orderId);
		comment.setContent(content);
		comment.setCreatetime(new Date());
		comment.setRank(rank);
		this.commentService.insert(comment);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("评论成功!");
		return message;
	}
	
	/**
	 * 通過用戶ID获得地址列表
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "address/{userId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage address(@PathVariable int userId) {
		List<Address> list = this.addressService.addressList(userId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 查询地址
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value = "find/address/{addressId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage findAddress(@PathVariable int addressId) {
		Address address = this.addressService.selectById(addressId);
		ResponseMessage message = new ResponseMessage();
		message.setData(address);
		return message;
	}
	
	/**
	 * 编辑地址
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "edit/address", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage editAddress(Address address) {
		if (address.getId() > 0) {
			this.addressService.update(address);
		} else {
			this.addressService.insert(address);
		}
		ResponseMessage message = new ResponseMessage();
		message.setMessage("编辑成功!");
		return message;
	}
	
	/**
	 * 删除地址
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "del/address/{addressId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage delAddress(@PathVariable int addressId) {
		this.addressService.deleteById(addressId);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("删除成功!");
		return message;
	}

}
