package com.hy.manager.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Comment;
import com.hy.manager.domain.business.CommentMapper;
import com.hy.manager.service.AbstractService;

@Service
public class CommentService extends AbstractService<Comment> {

	@Autowired
	private CommentMapper commentMapper;

	public CommentService() {
		super(Comment.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return commentMapper;
	}
	
	public List<Comment> selectByOrderId(int orderId) {
		return this.commentMapper.selectByOrderId(orderId);
	}

}
