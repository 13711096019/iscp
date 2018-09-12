package com.cn.iscp.dao.base;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Session;

public interface SessionDao {
    
	List<Session> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Session findById(Long sessionId);
	
	Session findFinal();
	
	List<Session> findAll();
	
	String findAllTime();
	
	boolean insert(Session model);
	
	boolean update(Session model);
	
}