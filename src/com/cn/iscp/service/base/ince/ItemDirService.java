package com.cn.iscp.service.base.ince;

import java.util.List;

import com.cn.iscp.entity.base.ItemDir;

public interface ItemDirService {
	
	ItemDir findById(Long itemDirId);
	
	List<ItemDir> findByName(String itemDirName);
	
	ItemDir findFinal();
	
	List<ItemDir> findAll();
	
	boolean insert(ItemDir model);
	
	boolean update(ItemDir model);
	
}