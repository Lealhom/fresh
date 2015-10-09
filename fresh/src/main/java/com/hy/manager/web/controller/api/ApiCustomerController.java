package com.hy.manager.web.controller.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Customer;
import com.hy.manager.service.business.CustomerService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/customer")
public class ApiCustomerController {
	@Autowired
	private CustomerService customerService;
	/**
	 * app端登录
	 * @return
	 */
	@RequestMapping(value = "app_login", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage login(String username, String password) {
		ResponseMessage message = new ResponseMessage();
		Customer customer = customerService.login(username, password);
		if(customer!=null){
			message.setMessage("登录成功");
			message.setData(true);
			
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("customerId", customer.getId());
			
		}else{
			message.setMessage("用户名密码错误");
			message.setData(false);
		}
		
		return message;
	}
	
	/**
	 * 获取用户个人信息
	 * @return
	 */
	@RequestMapping(value = "info", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseMessage userInfo() {
		ResponseMessage message = new ResponseMessage();
		int customerId = 1;
		Customer c = customerService.selectById(customerId);
		message.setData(c);
		return message;
	}
}
