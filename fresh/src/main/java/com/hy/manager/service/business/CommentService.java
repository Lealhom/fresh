package com.hy.manager.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Comment;
import com.hy.manager.domain.business.CommentMapper;
import com.hy.manager.service.AbstractService;
import com.hy.manager.web.Parameter;

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

	public List<Map<String, Object>> listByOrderId(int orderId, Parameter parameter) {
		return this.commentMapper.listByOrderId(orderId,parameter);
	}

	public List<Map<String, Object>> listBySkuId(int skuId, Parameter parameter) {
		return this.commentMapper.listBySkuId(skuId,parameter);
	}

}
