package com.hy.manager.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hy.manager.domain.File;
import com.hy.manager.domain.Filetype;
import com.hy.manager.service.FileService;
import com.hy.manager.service.FiletypeService;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "file")
public class FileController extends BasicController {

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView upload(
			@RequestParam("fileUpload") CommonsMultipartFile file) {
		if (!file.isEmpty()) {
			String path = "D:/" + file.getOriginalFilename();
			java.io.File localFile = new java.io.File(path);
			try {
				file.transferTo(localFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Autowired
	private FileService fileService;
	@Autowired
	private FiletypeService filetypeService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("file/page");
		return mav;
	}

	@RequestMapping(value = "paged")
	@ResponseBody
	public GridData listPaged(Parameter parameter) {
		return fileService.listPaged(parameter);
	}
	
	@RequestMapping(value = "tree_filetype")
	@ResponseBody
	public List<Filetype> treeFiletype(String id) {
		if (null == id || "".equals(id)) {
			return this.filetypeService.selectByParentId(0);
		}
		return this.filetypeService.selectByParentId(Integer.valueOf(id));
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mav = new ModelAndView("file/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseMessage add(@RequestParam("fileUpload") CommonsMultipartFile file) {
		ResponseMessage message = new ResponseMessage();
		if (!file.isEmpty()) {
			String path = "D:/" + file.getOriginalFilename();
			java.io.File localFile = new java.io.File(path);
			try {
				file.transferTo(localFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(int id) {
		ModelAndView mav = new ModelAndView("file/update");
		File file = fileService.selectById(id);
		mav.addObject("file", file);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseMessage update(File file) {
		ResponseMessage message = new ResponseMessage();
		fileService.update(file);
		return message;
	}

	@ResponseBody
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ResponseMessage del(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		fileService.deleteByIds(ids);
		return message;
	}
}
