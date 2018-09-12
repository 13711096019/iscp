package com.cn.iscp.service.task.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.FileOrderDao;
import com.cn.iscp.entity.task.FileOrder;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.iscp.service.task.ince.FileOrderService;

@Service("fileOrderService")
public class FileOrderServiceImpl extends BaseSericel implements FileOrderService {
	
	@Resource
	private FileOrderDao fileOrderDao;

	@Override
	public PageModel findPage(Map<String, Object> map) {
		List<List<?>> list = fileOrderDao.findPage(map);
		return getMapByPage(list);
	}

	@Override
	public FileOrder findById(Long orderId) {
		return fileOrderDao.findById(orderId);
	}

	@Override
	public List<FileOrder> findByState(FileOrder model) {
		return fileOrderDao.findByState(model);
	}

	@Override
	public List<FileOrder> findByWaitPrint(FileOrder model) {
		return fileOrderDao.findByWaitPrint(model);
	}
	
	@Override
	public FileOrder insertFileOrder(FileOrder model) {
		return fileOrderDao.insertFileOrder(model);
	}

	@Override
	public StateModel updateFileOrder(FileOrder model) {
		return fileOrderDao.updateFileOrder(model);
	}

	@Override
	public StateModel updateFileOrderState(FileOrder model) {
		return fileOrderDao.updateFileOrderState(model);
	}

	@Override
	public StateModel deleteFileOrder(Long orderId) {
		return fileOrderDao.deleteFileOrder(orderId);
	}

}
