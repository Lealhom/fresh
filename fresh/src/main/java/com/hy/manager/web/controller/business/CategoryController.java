package com.hy.manager.web.controller.business;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.File;
import com.hy.manager.domain.business.Category;
import com.hy.manager.service.FileService;
import com.hy.manager.service.business.CategoryService;
import com.hy.manager.util.FileUploadUtil;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

@Controller
@RequestMapping(value = "category")
public class CategoryController extends BasicController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FileService fileService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("category/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return categoryService.listPaged(parameter);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("category/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(Category category,
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(file, request);
		if (f == null) {
			message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
			return message;
		}
		fileService.insert(f);
		category.setImgUuid(f.getUuid());
		if ("".equals(category.getParentId())) {
			category.setLevel(1);
		} else {
			Category parentCategory = categoryService.selectById(category
					.getParentId());
			category.setLevel(parentCategory.getLevel() + 1);
		}
		categoryService.insert(category);
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("category/update");
		Category category = categoryService.selectById(id);
		mav.addObject("category", category);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(Category category) {
		ResponseMessage message = new ResponseMessage();
		if ("".equals(category.getParentId())) {
			category.setLevel(1);
		} else {
			Category parentCategory = categoryService.selectById(category
					.getParentId());
			category.setLevel(parentCategory.getLevel() + 1);
		}
		categoryService.update(category);
		return message;
	}
	/**
	 * 弹出更换图片窗口
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "updateImg", method = RequestMethod.GET)
	public ModelAndView updateImgPage(int id) {
		ModelAndView mav = new ModelAndView("category/updateImg");
		Category category = categoryService.selectById(id);
		mav.addObject("category", category);
		return mav;
	}

	/**
	 * 更换图片
	 * 
	 * @param category
	 * @param file
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateImg", method = RequestMethod.POST)
	public ResponseMessage updateImgPage(Category category,
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(file, request);
		if (f == null) {
			message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
			return message;
		}
		fileService.insert(f);
		category.setImgUuid(f.getUuid());
		categoryService.update(category);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		categoryService.deleteByIds(ids);
		return message;
	}
}
