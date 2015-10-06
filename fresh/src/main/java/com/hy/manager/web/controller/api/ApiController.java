package com.hy.manager.web.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Activity;
import com.hy.manager.domain.business.Address;
import com.hy.manager.domain.business.Category;
import com.hy.manager.domain.business.Comment;
import com.hy.manager.domain.business.Customer;
import com.hy.manager.domain.business.Order;
import com.hy.manager.domain.business.Product;
import com.hy.manager.service.business.ActivityService;
import com.hy.manager.service.business.AddressService;
import com.hy.manager.service.business.CategoryService;
import com.hy.manager.service.business.CommentService;
import com.hy.manager.service.business.CustomerService;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.service.business.ProductService;
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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ActivityService activityService;
	
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
	 * 获取用户个人信息
	 * @return
	 */
	@RequestMapping(value = "user/info", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage userInfo() {
		ResponseMessage message = new ResponseMessage();
		int customerId = 1;
		Customer c = customerService.selectById(customerId);
		message.setData(c);
		return message;
	}
	/**
	 * 提交订单
	 * @return
	 */
	@RequestMapping(value = "order/add", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage addOrder(Order order) {
		order.setCreateTime(new Date());//设置订单创建时间
		//设置订单编号
		long l = System.currentTimeMillis();
		String no = l+""+order.getCustomerId();
		order.setNo(no);
		orderService.insert(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("下单成功!");
		return message;
	}
	/**
	 * 更新订单
	 * @return
	 */
	@RequestMapping(value = "order/update", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage updateOrder(Order order) {
		if(order.getStatus()==Order.STATUS_PAYMENT){
			order.setPayTime(new Date());//设置订单付款时间
		}
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("操作订单成功!");
		return message;
	}
	/**
	 * 获得订单列表
	 * @return
	 */
	@RequestMapping(value = "user/order", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage orderList() {
		int customerId = 1;
		List<Order> list = orderService.orderList(customerId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 获得评论列表
	 * @return
	 */
	@RequestMapping(value = "comment/{orderId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage listComment(@PathVariable int orderId) {
		ResponseMessage message = new ResponseMessage();
		List<Comment> list = this.commentService.selectByOrderId(orderId);
		message.setData(list);
		return message;
	}

	/**
	 * 评论
	 * @return
	 */
	@RequestMapping(value = "comment/{orderId}/{rank}/{content}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage addComment(@PathVariable int orderId, @PathVariable int rank, @PathVariable String content) {
		int customerId = 1;
		Comment comment = new Comment();
		comment.setCustomerId(customerId);
		comment.setOrderId(orderId);
		comment.setContent(content);
		comment.setCreateTime(new Date());
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
	@RequestMapping(value = "user/address", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage listAddress() {
		int customerId = 1;
		List<Address> list = this.addressService.addressList(customerId);
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
	/**
	 * 获取活动
	 * @return
	 */
	@RequestMapping(value = "activity/list")
	@ResponseBody
	public ResponseMessage listActivity() {
		List<Activity> list = activityService.listAll();
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	/**
	 * 获得品类列表
	 * @return
	 */
	@RequestMapping(value = "category/list")
	@ResponseBody
	public ResponseMessage listCategory() {
		List<Map<String,Object>> list = categoryService.categoryList();
		List<Map<String,Object>> listLevel1 = new ArrayList<Map<String,Object>>(); 
		List<Map<String,Object>> listLevel2 = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> c:list){
			if("1".equals(c.get("level").toString())){
				listLevel1.add(c);
			}else if("2".equals(c.get("level").toString())){
				listLevel2.add(c);
			}
		}
		for(Map<String,Object> c1:listLevel1){
			List<Map<String,Object>> children = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> c2:listLevel2){
				String id = c1.get("id").toString();
				String parentId = c2.get("parentId").toString();
				if(id.equals(parentId)){
					children.add(c2);
				}
			}
			if(children.size()!=0){
				c1.put("children", children);
			}
		}
		ResponseMessage message = new ResponseMessage();
		message.setData(listLevel1);
		return message;
	}
	/**
	 * 根据某个一级品类的ID，得到它的子品类
	 * @return
	 */
	@RequestMapping(value = "category/find/{parentId}")
	@ResponseBody
	public ResponseMessage findChildrenCategory(@PathVariable int parentId) {
		List<Category> list = categoryService.selectByParentId(parentId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	/**
	 * 添加收藏
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "collection/add/{productId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage addCollection(@PathVariable int productId) {
		int customerId = 1;
		productService.addCollection(customerId,productId);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("添加收藏成功!");
		return message;
	}
	/**
	 * 取消收藏
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "collection/del/{productId}", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage delCollection(@PathVariable int productId) {
		int customerId = 1;
		productService.delCollection(customerId,productId);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("取消收藏成功!");
		return message;
	}
	/**
	 * 展示我的收藏
	 * @return
	 */
	@RequestMapping(value = "collection/list", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage listCollection() {
		int customerId = 1;
		List<Product> list = productService.listCollection(customerId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
}
