package com.cn.iscp.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.FileInfoDao;
import com.cn.iscp.entity.task.FileInfo;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.task.ince.FileInfoService;

@Service("fileInfoServiceImpl")
public class FileInfoServiceImpl implements FileInfoService {
	
	@Resource
	private FileInfoDao fileInfoDao;

	@Override
	public List<FileInfo> findByPater(FileInfo model) {
		return fileInfoDao.findByPater(model);
	}

	@Override
	public List<FileInfo> findByName(FileInfo model) {
		return fileInfoDao.findByName(model);
	}

	@Override
	public StateModel insertFileInfo(FileInfo model) {
		return fileInfoDao.insertFileInfo(model);
	}

	@Override
	public StateModel updateFileName(FileInfo model) {
		return fileInfoDao.updateFileName(model);
	}

	@Override
	public StateModel deleteFileInfo(FileInfo model) {
		return fileInfoDao.deleteFileInfo(model);
	}

	@Override
	public StateModel updatePater(FileInfo model) {
		return fileInfoDao.updatePater(model);
	}

	@Override
	public FileInfo findById(Long fileId) {
		return fileInfoDao.findById(fileId);
	}
	
}
