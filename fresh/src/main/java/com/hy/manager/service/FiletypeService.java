package com.hy.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.Filetype;
import com.hy.manager.domain.FiletypeMapper;

@Service
public class FiletypeService extends AbstractService<Filetype> {

	@Autowired
	private FiletypeMapper filetypeMapper;

	public FiletypeService() {
		super(Filetype.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return filetypeMapper;
	}
	
	public List<Filetype> selectByParentId(int parentId) {
		return	this.filetypeMapper.selectByParentId(parentId);
	}

}
