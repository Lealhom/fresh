package com.hy.manager.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.service.business.AddressService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/address")
public class ApiAddressController {
	@Autowired
	private AddressService addressService;
	
	
	/**
	 * 地址列表
	 * @return
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public ResponseMessage list() {
		ResponseMessage message = new ResponseMessage();
		return message;
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public ResponseMessage add() {
		ResponseMessage message = new ResponseMessage();
		return message;
	}
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public ResponseMessage update() {
		ResponseMessage message = new ResponseMessage();
		return message;
	}
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "del")
	@ResponseBody
	public ResponseMessage del() {
		ResponseMessage message = new ResponseMessage();
		return message;
	}
}
