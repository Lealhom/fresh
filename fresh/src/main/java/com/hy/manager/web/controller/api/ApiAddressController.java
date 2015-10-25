package com.hy.manager.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Address;
import com.hy.manager.service.business.AddressService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/address")
public class ApiAddressController {
	@Autowired
	private AddressService addressService;

	/**
	 * 地址列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public ResponseMessage list() {
		int customerId = 1;
		List<Address> list = this.addressService.addressList(customerId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public ResponseMessage add(Address address) {
		this.addressService.insert(address);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("添加成功!");
		return message;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public ResponseMessage update(Address address) {
		this.addressService.update(address);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("修改成功!");
		return message;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "del")
	@ResponseBody
	public ResponseMessage del(Address address) {
		int addressId = address.getId();
		this.addressService.deleteById(addressId);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("删除成功!");
		return message;
	}
}
