package com.cn.iscp.dao.base;

import java.util.List;

import com.cn.iscp.entity.base.ItemFile;

public interface ItemFileDao {
	
	ItemFile findById(Long itemFileId);
	
	List<ItemFile> findByDirId(Integer itemDirId);
	
	ItemFile findByFileId(ItemFile model);
	
	ItemFile findFinal(Long itemDirId);
	
	boolean insert(ItemFile model);
	
	boolean update(ItemFile model);
	
}