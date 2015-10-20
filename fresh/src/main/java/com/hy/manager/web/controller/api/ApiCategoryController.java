package com.hy.manager.web.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Category;
import com.hy.manager.service.business.CategoryService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/category")
public class ApiCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value = "list_category_map")
	@ResponseBody
	public ResponseMessage listCategoryMap() {
		List<Map<String,Object>> list = categoryService.listCategoryMap();
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
	/**
	 * 获得品类列表
	 * @return
	 */
	@RequestMapping(value = "list")
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
	@RequestMapping(value = "list_children/{parentId}")
	@ResponseBody
	public ResponseMessage listChildrenCategory(@PathVariable int parentId) {
		List<Category> list = categoryService.selectByParentId(parentId);
		ResponseMessage message = new ResponseMessage();
		message.setData(list);
		return message;
	}
}
