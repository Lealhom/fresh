package com.test.service.bussiness;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hy.manager.domain.business.Comment;
import com.hy.manager.service.business.CommentService;
import com.test.service.abs.AbstractTest;

public class TestCommentService extends AbstractTest{
	CommentService commentService;
	@Before
	public void init(){
		commentService	 = (CommentService) applicationContext.getBean("commentService");
	}
	
	@Test
	public void testAdd(){
		Comment comment = new Comment();
		comment.setCustomerId(1);
		comment.setOrderId(1);
		comment.setContent("苹果很吵吃，下次还来买");
		comment.setCreateTime(new Date());
		comment.setRank(1);
		int i = commentService.insert(comment);
		Assert.assertEquals(1, i);
	}
	@Test
	public void testList(){
		List<Comment> list = this.commentService.selectByOrderId(1);
		for(Comment c: list){
			System.out.println(c.getContent());
		}
	}
	@Test
	public void testDelete(){
		commentService.deleteById(1);
	}
}
