package com.hy.manager.web.controller.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.File;
import com.hy.manager.domain.business.Sku;
import com.hy.manager.service.FileService;
import com.hy.manager.service.business.SkuService;
import com.hy.manager.util.FileUploadUtil;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

@Controller
@RequestMapping(value = "sku")
public class SkuController extends BasicController {

	@Autowired
	private SkuService skuService;
	@Autowired
	private FileService fileService;
	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("sku/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return skuService.listPaged(parameter);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("sku/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(Sku sku,HttpServletRequest request,
			@RequestParam("mainImg") CommonsMultipartFile mainImg,
			@RequestParam("viceImgs") CommonsMultipartFile[] viceImgs) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(mainImg, request);
		if (f == null) {
			message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
			return message;
		}
		List<String> viceImgUuids = new ArrayList<String>();
		List<File> viceImgFle = new ArrayList<File>();
		for (CommonsMultipartFile file : viceImgs) {
			File viceImg = FileUploadUtil.upload(file, request);
			if (viceImg == null) {
				message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
				return message;
			}
			viceImgUuids.add(viceImg.getUuid());
			viceImgFle.add(viceImg);
		}
		fileService.insert(f);
		for (File file : viceImgFle) {
			fileService.insert(file);
		}
		sku.setMainImgUuid(f.getUuid());
		skuService.insert(sku);
		// 添加SKU跟副图的关联关系
		skuService.addViceImgUuids(sku.getId(), viceImgUuids);
		return message;
	}
	/**
	 * 弹出更换图片窗口
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "updateMainImg", method = RequestMethod.GET)
	public ModelAndView updateMainImgPage(int id) {
		ModelAndView mav = new ModelAndView("sku/updateMainImg");
		Sku sku = skuService.selectById(id);
		mav.addObject("sku", sku);
		return mav;
	}

	@RequestMapping(value = "updateViceImg", method = RequestMethod.GET)
	public ModelAndView updateViceImgPage(int id) {
		ModelAndView mav = new ModelAndView("sku/updateViceImg");
		Sku sku = skuService.selectById(id);
		mav.addObject("sku", sku);
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
	@RequestMapping(value = "updateMainImg", method = RequestMethod.POST)
	public ResponseMessage updateMainImg(Sku sku,
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(file, request);
		if (f == null) {
			message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
			return message;
		}
		fileService.insert(f);
		sku.setMainImgUuid(f.getUuid());
		skuService.update(sku);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "updateViceImg", method = RequestMethod.POST)
	public ResponseMessage updateViceImg(Sku sku,
			@RequestParam("file") CommonsMultipartFile viceImgs[],
			HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		List<String> viceImgUuids = new ArrayList<String>();
		List<File> viceImgFle = new ArrayList<File>();
		for (CommonsMultipartFile file : viceImgs) {
			File viceImg = FileUploadUtil.upload(file, request);
			if (viceImg == null) {
				message.setMessage("上传文件大小不能超过" + FileUploadUtil.MAX_SIZE + "M");
				return message;
			}
			viceImgUuids.add(viceImg.getUuid());
			viceImgFle.add(viceImg);
		}
		for (File file : viceImgFle) {
			fileService.insert(file);
		}
		// 删除产品跟副图的关联关系
		skuService.delViceImgUuids(sku.getId());
		// 添加产品跟副图的关联关系
		skuService.addViceImgUuids(sku.getId(), viceImgUuids);
		return message;
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("sku/update");
		Sku sku = skuService.selectById(id);
		mav.addObject("sku", sku);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(Sku sku) {
		ResponseMessage message = new ResponseMessage();
		skuService.update(sku);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		skuService.deleteByIds(ids);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "selectByorderId/{orderId}", method = RequestMethod.POST)
	public GridData selectByOrderId(@PathVariable int orderId) {
		GridData data = new GridData();
		List<Sku> skus = skuService.selectByOrderId(orderId);
		data.setRows(skus);
		data.setTotal(skus.size());
		return data;
	}
}
