package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.School;

public interface SchoolService {
	
	List<School> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	School findById(Long userId);
	
	boolean insert(School model);
	
	boolean update(School model);
	
}