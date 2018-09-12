package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Session;

public interface SessionService {
    
	List<Session> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Session findById(Long sessionId);
	
	Session findFinal();
	
	List<Session> findAll();
	
	boolean insert(Session model);
	
	boolean update(Session model);
	
}