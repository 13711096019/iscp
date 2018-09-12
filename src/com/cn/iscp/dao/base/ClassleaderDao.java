package com.cn.iscp.dao.base;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Classleader;

public interface ClassleaderDao {
	
    List<Classleader> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Classleader findById(Long classleaderId);
	
	Classleader findFinal();
	
	boolean insert(Classleader model);
	
	boolean update(Classleader model);
}