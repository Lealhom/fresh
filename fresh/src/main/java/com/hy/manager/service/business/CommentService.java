package com.hy.manager.service.business;

import java.util.List;
import java.util.Map;

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

	public List<Map<String, Object>> listByOrderId(int orderId) {
		return this.commentMapper.listByOrderId(orderId);
	}

	public List<Map<String, Object>> listBySkuId(int skuId) {
		return this.commentMapper.listBySkuId(skuId);
	}

}
