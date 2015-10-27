package com.hy.manager.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Address;
import com.hy.manager.service.business.AddressService;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/address")
public class ApiAddressController extends ApiBasicController {
	@Autowired
	private AddressService addressService;

	/**
	 * 地址列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public ResponseMessage list(HttpServletRequest request,Parameter parameter) {
		int customerId = this.getUid(request);
		List<Address> list = this.addressService.addressList(customerId,parameter);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	/**
	 * 根据ID得到地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "find/{addressId}")
	@ResponseBody
	public ResponseMessage find(@PathVariable int addressId) {
		ResponseMessage message = new ResponseMessage();
		Address address = this.addressService.selectById(addressId);
		message.setData(address);
		return message;
	}
	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public ResponseMessage add(HttpServletRequest request, Address address) {
		int customerId = this.getUid(request);
		address.setCustomerId(customerId);
		if(address.isDefaultFlag()){//如果勾选了“设置为默认地址”，则先把改用户下的所有地址设为“非默认”
			this.addressService.cancelDefaultFlag(customerId);//取消默认地址
		}
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
	public ResponseMessage update(HttpServletRequest request, Address address) {
		int customerId = this.getUid(request);
		if(address.isDefaultFlag()){//如果勾选了“设置为默认地址”，则先把改用户下的所有地址设为“非默认”
			this.addressService.cancelDefaultFlag(customerId);//取消默认地址
		}
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
