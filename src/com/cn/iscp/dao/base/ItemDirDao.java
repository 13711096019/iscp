package com.cn.iscp.dao.base;

import java.util.List;

import com.cn.iscp.entity.base.ItemDir;

public interface ItemDirDao {
	
	ItemDir findById(Long itemDirId);
	
	List<ItemDir> findByName(String itemDirName);
	
	ItemDir findFinal();
	
	List<ItemDir> findAll();
	
	boolean insert(ItemDir model);
	
	boolean update(ItemDir model);
	
}