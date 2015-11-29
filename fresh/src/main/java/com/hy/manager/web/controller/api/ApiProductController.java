package com.hy.manager.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.service.business.CommentService;
import com.hy.manager.service.business.ProductService;
import com.hy.manager.service.business.SkuService;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/product")
public class ApiProductController  extends ApiBasicController {
	@Autowired
	private ProductService productService;
	@Autowired
	private SkuService skuService;
	@Autowired
	private CommentService commentService;

	/**
	 * 获取热销产品
	 * 
	 * @return
	 */
	@RequestMapping(value = "hot")
	@ResponseBody
	public ResponseMessage listHotProduct(Parameter parameter) {
		List<Map<String, Object>> list = this.productService.listHotProduct(parameter);
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
	public ResponseMessage listByActivityId(@PathVariable int activityId, Parameter parameter) {
		List<Map<String, Object>> list = this.productService
				.listByActivityId(activityId,parameter);
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
	public ResponseMessage listByCategoryId(@PathVariable int categoryId, Parameter parameter) {
		List<Map<String, Object>> list = this.productService
				.listByCategoryId(categoryId,parameter);
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
			@PathVariable int skuId, Parameter parameter) {
		Map<String, Object> map = this.productService.detail(productId, skuId,parameter);
		List<String> viceImgs = this.skuService.findViceImgs(skuId);// 得到SKU副图
		map.put("viceImgs", viceImgs);
		ResponseMessage message = new ResponseMessage();
		message.setData(map);
		return message;
	}
	
	/**
	 * 根据skuId获取评论
	 * 
	 * @return
	 */
	@RequestMapping(value = "list_by_skuId/{skuId}")
	@ResponseBody
	public ResponseMessage listBySkuId(@PathVariable int skuId, Parameter parameter) {
		List<Map<String, Object>> list = this.commentService.listBySkuId(skuId,parameter);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}

}
