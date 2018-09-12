package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Terms;

public interface TermsService {
    
	List<Terms> findPage(Map<String, Object> map);

	Long getPageCount(Map<String, Object> map);
	
	Terms findById(Long termId);
	
	Terms findFinal();
	
	List<Terms> findAll();
	
	boolean insert(Terms model);
	
	boolean update(Terms model);
	
}