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
import com.hy.manager.domain.business.Activity;
import com.hy.manager.service.FileService;
import com.hy.manager.service.business.ActivityService;
import com.hy.manager.util.FileUploadUtil;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

@Controller
@RequestMapping(value = "activity")
public class ActivityController extends BasicController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private FileService fileService;
	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("activity/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return activityService.listPaged(parameter);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("activity/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(Activity activity, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(file, request);
		if(f==null){
			message.setMessage("上传文件大小不能超过"+FileUploadUtil.MAX_SIZE+"M");
			return message;
		}
		fileService.insert(f);
		activity.setImgUuid(f.getUuid());
		activityService.insert(activity);
		//添加产品与活动的关联关系
		activityService.addProductIds(activity.getId(),activity.getProductIds());
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("activity/update");
		Activity activity = activityService.selectById(id);
		mav.addObject("activity", activity);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(Activity activity) {
		ResponseMessage message = new ResponseMessage();
		activityService.update(activity);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		activityService.deleteByIds(ids);
		return message;
	}
}
