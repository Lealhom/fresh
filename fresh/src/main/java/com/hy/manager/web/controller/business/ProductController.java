package com.hy.manager.web.controller.business;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

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

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(Product product,@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) {
		ResponseMessage message = new ResponseMessage();
		if(file.getSize() > 5*(1024*1024)){
			message.setMessage("上传文件大小不能超过5M");
			return message;
		}
		String uuidFileName = UUID.randomUUID()+"-"+file.getOriginalFilename();
		String realPath = request.getSession().getServletContext().getRealPath("/") + "/static/upload/" + uuidFileName;
		String reletivePath = "static/upload/" + uuidFileName;
		if (!file.isEmpty()) {
			java.io.File localFile = new java.io.File(realPath);
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), localFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File f = new File();
		f.setName(file.getOriginalFilename());
		f.setPath(reletivePath);
		f.setUploadTime(new Date());
		fileService.insert(f);
		
		product.setCreateTime(new Date());
		product.setFileId(f.getId());
		productService.insert(product);
		//添加品类跟品牌的关联关系
		productService.addCategoryIds(product.getId(),product.getCategoryIds());
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("product/update");
		Product product = productService.selectById(id);
		mav.addObject("product", product);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(Product product) {
		ResponseMessage message = new ResponseMessage();
		productService.update(product);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		productService.deleteByIds(ids);
		return message;
	}
}
