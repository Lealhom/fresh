package com.hy.manager.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.service.business.ProductService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/product")
public class ApiProductController {
	@Autowired
	private ProductService productService;

	/**
	 * 获取热销产品
	 * 
	 * @return
	 */
	@RequestMapping(value = "hot")
	@ResponseBody
	public ResponseMessage listHotProduct() {
		List<Map<String, Object>> list = this.productService.listHotProduct();
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 获取某活动下的产品
	 * 
	 * @return
	 */
	@RequestMapping(value = "list_by_activityId/{activityId}")
	@ResponseBody
	public ResponseMessage listByActivityId(@PathVariable int activityId) {
		List<Map<String, Object>> list = this.productService
				.listByActivityId(activityId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 获取某品类下的产品
	 * 
	 * @return
	 */
	@RequestMapping(value = "list_by_categoryId/{categoryId}")
	@ResponseBody
	public ResponseMessage listByCategoryId(@PathVariable int categoryId) {
		List<Map<String, Object>> list = this.productService
				.listByCategoryId(categoryId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 搜索
	 * 
	 * @return
	 */
	@RequestMapping(value = "search/{name}")
	@ResponseBody
	public ResponseMessage search(@PathVariable String name) {
		List<Map<String, Object>> list = this.productService.search(name);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

	/**
	 * 产品详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "detail/{productId}/{skuId}")
	@ResponseBody
	public ResponseMessage detail(@PathVariable int productId,
			@PathVariable int skuId) {
		Map<String, Object> map = this.productService.detail(productId, skuId);
		List<String> viceImgs = this.productService.findViceImgs(productId);// 得到副图
		map.put("viceImgs", viceImgs);
		ResponseMessage message = new ResponseMessage();
		message.setData(map);
		return message;
	}

	/**
	 * 添加收藏
	 * 
	 * @return
	 */
	@RequestMapping(value = "add_collection/{productId}")
	@ResponseBody
	public ResponseMessage addCollection(@PathVariable int productId) {
		int customerId = 1;
		productService.addCollection(customerId, productId);
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
	public ResponseMessage delCollection(@PathVariable int productId) {
		int customerId = 1;
		productService.delCollection(customerId, productId);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("取消收藏成功!");
		return message;
	}

}
