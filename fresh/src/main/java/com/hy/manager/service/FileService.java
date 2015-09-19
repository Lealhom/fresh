package com.hy.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.File;
import com.hy.manager.domain.FileMapper;

@Service
public class FileService extends AbstractService<File> {

	@Autowired
	private FileMapper fileMapper;

	public FileService() {
		super(File.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return fileMapper;
	}

}
