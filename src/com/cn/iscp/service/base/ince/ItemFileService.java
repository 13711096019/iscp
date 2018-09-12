package com.cn.iscp.service.base.ince;

import java.util.List;

import com.cn.iscp.entity.base.ItemFile;

public interface ItemFileService {
	
	ItemFile findById(Long itemFileId);
	
	List<ItemFile> findByDirId(Integer itemDirId);
	
	ItemFile findByFileId(ItemFile model);
	
	ItemFile findFinal(Long itemDirId);
	
	boolean insert(ItemFile model);
	
	boolean update(ItemFile model);
	
}