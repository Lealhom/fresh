package com.hy.manager.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.service.business.CommentService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/comment")
public class ApiCommentController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 添加评论
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public ResponseMessage add(){
		this.commentService.insert(null);
		return null;
	}
	/**
	 * 根据产品ID获取评论
	 * @return
	 */
	@RequestMapping(value = "list/{productId}")
	@ResponseBody
	public ResponseMessage listByProductId(){
		this.commentService.insert(null);
		return null;
	}
}
