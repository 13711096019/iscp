package com.cn.iscp.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.ItemDirDao;
import com.cn.iscp.entity.base.ItemDir;
import com.cn.iscp.service.base.ince.ItemDirService;

@Service("itemDirService")
public class ItemDirServiceImpl implements ItemDirService {
	
	@Resource
	private ItemDirDao itemDirDao;

	@Override
	public ItemDir findById(Long itemDirId) {
		return itemDirDao.findById(itemDirId);
	}
	
	@Override
	public List<ItemDir> findByName(String itemDirName){
		return itemDirDao.findByName(itemDirName);
	}

	@Override
	public ItemDir findFinal() {
		return itemDirDao.findFinal();
	}
	
	@Override
	public List<ItemDir> findAll(){
		return itemDirDao.findAll();
	}

	@Override
	public boolean insert(ItemDir model) {
		return itemDirDao.insert(model);
	}

	@Override
	public boolean update(ItemDir model) {
		return itemDirDao.update(model);
	}

}
