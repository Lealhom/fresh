package com.hy.manager.web.controller.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.hy.manager.domain.business.Product;
import com.hy.manager.service.FileService;
import com.hy.manager.service.business.ProductService;
import com.hy.manager.util.FileUploadUtil;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "product")
public class ProductController extends BasicController {

	@Autowired
	private ProductService productService;
	@Autowired
	private FileService fileService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("product/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return productService.listPaged(parameter);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("product/add");
		return mav;
	}
	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public ModelAndView upload() {
		ModelAndView mav = new ModelAndView("product/upload");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(Product product,@RequestParam("mainImg") CommonsMultipartFile mainImg, @RequestParam("viceImgs") CommonsMultipartFile[] viceImgs,HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(mainImg, request);
		if(f==null){
			message.setMessage("上传文件大小不能超过"+FileUploadUtil.MAX_SIZE+"M");
			return message;
		}
		List<String> viceImgUuids = new ArrayList<String>();
		List<File> viceImgFle =  new ArrayList<File>();
		for(CommonsMultipartFile file:viceImgs){
			File viceImg = FileUploadUtil.upload(file, request);
			if(viceImg==null){
				message.setMessage("上传文件大小不能超过"+FileUploadUtil.MAX_SIZE+"M");
				return message;
			}
			viceImgUuids.add(viceImg.getUuid());
			viceImgFle.add(viceImg);
		}
		fileService.insert(f);
		for(File file:viceImgFle){
			fileService.insert(file);
		}
		product.setMainImgUuid(f.getUuid());
		product.setCreateTime(new Date());
		productService.insert(product);
		//添加产品跟品类的关联关系
		productService.addCategoryIds(product.getId(),product.getCategoryIds());
		//添加产品跟副图的关联关系
		productService.addViceImgUuids(product.getId(),viceImgUuids);
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("product/update");
		Product product = productService.selectById(id);
		mav.addObject("product", product);
		return mav;
	}
	/**
	 * 弹出更换图片窗口
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "updateMainImg", method = RequestMethod.GET)
	public ModelAndView updateMainImgPage(int id) {
		ModelAndView mav = new ModelAndView("product/updateMainImg");
		Product product = productService.selectById(id);
		mav.addObject("product", product);
		return mav;
	}
	@RequestMapping(value = "updateViceImg", method = RequestMethod.GET)
	public ModelAndView updateViceImgPage(int id) {
		ModelAndView mav = new ModelAndView("product/updateViceImg");
		Product product = productService.selectById(id);
		mav.addObject("product", product);
		return mav;
	}
	/**
	 * 更换图片
	 * @param category
	 * @param file
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateMainImg", method = RequestMethod.POST)
	public ResponseMessage updateMainImg(Product product, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		File f = FileUploadUtil.upload(file, request);
		if(f==null){
			message.setMessage("上传文件大小不能超过"+FileUploadUtil.MAX_SIZE+"M");
			return message;
		}
		fileService.insert(f);
		product.setUpdateTime(new Date());
		product.setMainImgUuid(f.getUuid());
		productService.update(product);
		return message;
	}
	@ResponseBody
	@RequestMapping(value = "updateViceImg", method = RequestMethod.POST)
	public ResponseMessage updateViceImg(Product product, @RequestParam("file") CommonsMultipartFile viceImgs[], HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		List<String> viceImgUuids = new ArrayList<String>();
		List<File> viceImgFle =  new ArrayList<File>();
		for(CommonsMultipartFile file:viceImgs){
			File viceImg = FileUploadUtil.upload(file, request);
			if(viceImg==null){
				message.setMessage("上传文件大小不能超过"+FileUploadUtil.MAX_SIZE+"M");
				return message;
			}
			viceImgUuids.add(viceImg.getUuid());
			viceImgFle.add(viceImg);
		}
		for(File file:viceImgFle){
			fileService.insert(file);
		}
		//删除产品跟副图的关联关系
		productService.delViceImgUuids(product.getId());
		//添加产品跟副图的关联关系
		productService.addViceImgUuids(product.getId(),viceImgUuids);
		return message;
	}
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(Product product) {
		ResponseMessage message = new ResponseMessage();
		product.setUpdateTime(new Date());
		productService.update(product);
		//先删除掉跟品类的关联关系
		productService.delCategoryIds(product.getId());
		//然后再添加产品跟品类的关联关系
		productService.addCategoryIds(product.getId(),product.getCategoryIds());
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		productService.deleteByIds(ids);
		return message;
	}
	/**
	 * 设置为热销产品
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "setHot", method = RequestMethod.POST)
	public ResponseMessage setHot(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		productService.setHot(ids);
		return message;
	}
	/**
	 * 取消热销产品
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancelHot", method = RequestMethod.POST)
	public ResponseMessage cancelHot(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		productService.cancelHot(ids);
		return message;
	}
}
