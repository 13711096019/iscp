package com.cn.iscp.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.FileTypeDao;
import com.cn.iscp.entity.task.FileType;
import com.cn.iscp.service.task.ince.FileTypeService;

@Service("fileTypeService")
public class FileTypeServiceImpl implements FileTypeService {
	
	@Resource
	private FileTypeDao fileTypeDao;

	@Override
	public List<FileType> findAll() {
		return fileTypeDao.findAll();
	}

	@Override
	public List<FileType> findByKey(String typeKey) {
		return fileTypeDao.findByKey(typeKey);
	}
	
}
