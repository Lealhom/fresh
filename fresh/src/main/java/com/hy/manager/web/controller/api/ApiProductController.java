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
	 * @return
	 */
	@RequestMapping(value = "hot")
	@ResponseBody
	public List<Map<String,Object>> listHotProduct(){
		return this.productService.listHotProduct();
	}
	
	/**
	 * 获取某活动下的产品
	 * @return
	 */
	@RequestMapping(value = "activity/{activityId}")
	@ResponseBody
	public List<Map<String,Object>> listByActivityId(@PathVariable int activityId){
		return this.productService.listByActivityId(activityId);
	}
	
	/**
	 * 获取某品类下的产品
	 * @return
	 */
	@RequestMapping(value = "category/{categoryId}")
	@ResponseBody
	public List<Map<String,Object>> listByCategoryId(@PathVariable int categoryId){
		return this.productService.listByCategoryId(categoryId);
	}
	
	/**
	 * 搜索
	 * @return
	 */
	@RequestMapping(value = "search/{name}")
	@ResponseBody
	public List<Map<String,Object>> search(@PathVariable String name){
		return this.productService.search(name);
	}
	
	/**
	 * 产品详情
	 * @return
	 */
	@RequestMapping(value = "detail/{productId}")
	@ResponseBody
	public List<Map<String,Object>> detail(@PathVariable int productId){
		return this.productService.detail(productId);
	}
	
	/**
	 * 添加收藏
	 * @return
	 */
	@RequestMapping(value = "add_collection")
	@ResponseBody
	public ResponseMessage addCollection() {
		ResponseMessage message = new ResponseMessage();
		return message;
	}
	/**
	 * 取消收藏
	 * @return
	 */
	@RequestMapping(value = "del_collection")
	@ResponseBody
	public ResponseMessage delCollection() {
		ResponseMessage message = new ResponseMessage();
		return message;
	}
	
}
