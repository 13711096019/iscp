package com.cn.iscp.dao.card.civilized;

import java.util.List;

import com.cn.iscp.entity.card.civilized.CivilizedItem;

public interface CivilizedItemDao {
	
	List<CivilizedItem> findAll();
	
	CivilizedItem findById(Long bigItemId);
	
	boolean insert(CivilizedItem model);
	
	boolean update(CivilizedItem model);
	
}
