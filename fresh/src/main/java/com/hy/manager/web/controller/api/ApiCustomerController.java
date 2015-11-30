package com.hy.manager.web.controller.api;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alipay.util.UtilDate;
import com.hy.manager.domain.File;
import com.hy.manager.domain.business.Coupon;
import com.hy.manager.domain.business.Customer;
import com.hy.manager.domain.business.Product;
import com.hy.manager.service.FileService;
import com.hy.manager.service.business.CouponService;
import com.hy.manager.service.business.CustomerService;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.service.business.ProductService;
import com.hy.manager.util.FileUploadUtil;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/customer")
public class ApiCustomerController extends ApiBasicController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private FileService fileService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CouponService couponService;
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value = "register", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage register(HttpServletRequest request,Customer customer) {
		ResponseMessage message = new ResponseMessage();
		customerService.insert(customer);//注册用户
		int customerId = customer.getId();
		//发放两张注册类型的现金券
		Coupon c = couponService.findByType(Coupon.TYPE_REGISTER);
		for(int i=0;i<2;i++){
			String batchNo = customerId+String.valueOf(System.currentTimeMillis());//用户id加上时间戳作为批次号
			int status = 1;//未使用
			couponService.addCustomerCoupon(customerId,c.getId(),batchNo,status);
		}
		message.setData(customer);
		return message;
	}
	/**
	 * 使用现金券
	 * @return
	 */
	@RequestMapping(value = "use_coupon", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage useCoupon(HttpServletRequest request,String batchNo,int orderId) {
		ResponseMessage message = new ResponseMessage();
		String useTime = UtilDate.getDateFormatter();
		couponService.useCoupon(useTime, batchNo, orderId);
		return message;
	}
	/**
	 * app端登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "app_login", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage login(String username, String password) {
		ResponseMessage message = new ResponseMessage();
		Customer customer = customerService.login(username, password);
		if (customer != null) {
			message.setMessage("登录成功");
			message.setData(customer);

			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("customerId", customer.getId());

		} else {
			message.setStatus(ResponseMessage.STATUS_ERROR);
			message.setMessage("用户名密码错误");
			message.setData(false);
		}

		return message;
	}

	/**
	 * 获取用户个人信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "info", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage userInfo(HttpServletRequest request) {
		
		int customerId = this.getUid(request);
		
		ResponseMessage message = new ResponseMessage();
		Customer customer = customerService.selectById(customerId);
		message.setData(customer);
		return message;
	}

	/**
	 * 更新头像
	 * 
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "head_pohto", method = RequestMethod.POST)
	public ResponseMessage updateHeadPhoto(Product product,
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(file, request);
		if (f == null) {
			message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
			return message;
		}
		fileService.insert(f);
		int customerId = this.getUid(request);;// 用户Id
		customerService.updateHeadPhoto(customerId, f.getUuid());
		return message;
	}
	/**
	 * 获得我的订单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "my_order", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage myorder(HttpServletRequest request,Parameter parameter) {
		int customerId = this.getUid(request);
		List<Map<String,Object>> list = orderService.orderList(customerId,parameter);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	
	/**
	 * 获得我的收藏
	 * 
	 * @return
	 */
	@RequestMapping(value = "my_collection", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage myCollection(HttpServletRequest request,Parameter parameter) {
		int customerId = this.getUid(request);
		List<Map<String, Object>> list = productService.listCollection(customerId,parameter);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 添加收藏
	 * 
	 * @return
	 */
	@RequestMapping(value = "add_collection/{skuId}")
	@ResponseBody
	public ResponseMessage addCollection(HttpServletRequest request,@PathVariable int skuId) {
		int customerId = this.getUid(request);
		productService.delCollection(customerId, skuId);//先删除，防止出现多次收藏，出现重复数据
		productService.addCollection(customerId, skuId);//然后再添加收藏
		ResponseMessage message = new ResponseMessage();
		message.setMessage("添加收藏成功!");
		return message;
	}
	
	/**
	 * 取消收藏
	 * 
	 * @return
	 */
	@RequestMapping(value = "del_collection/{productId}")
	@ResponseBody
	public ResponseMessage delCollection(HttpServletRequest request,@PathVariable int skuId) {
		int customerId = this.getUid(request);
		productService.delCollection(customerId, skuId);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("取消收藏成功!");
		return message;
	}
}
