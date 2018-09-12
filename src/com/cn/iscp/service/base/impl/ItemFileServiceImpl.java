package com.cn.iscp.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.ItemFileDao;
import com.cn.iscp.entity.base.ItemFile;
import com.cn.iscp.service.base.ince.ItemFileService;

@Service("itemFileService")
public class ItemFileServiceImpl implements ItemFileService {
	
	@Resource
	private ItemFileDao itemFileDao;

	@Override
	public ItemFile findById(Long itemFileId) {
		return itemFileDao.findById(itemFileId);
	}

	@Override
	public List<ItemFile> findByDirId(Integer itemDirId) {
		return itemFileDao.findByDirId(itemDirId);
	}

	@Override
	public ItemFile findByFileId(ItemFile model) {
		return itemFileDao.findByFileId(model);
	}

	@Override
	public ItemFile findFinal(Long itemDirId) {
		return itemFileDao.findFinal(itemDirId);
	}

	@Override
	public boolean insert(ItemFile model) {
		return itemFileDao.insert(model);
	}

	@Override
	public boolean update(ItemFile model) {
		return itemFileDao.update(model);
	}

}
