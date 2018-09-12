package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Honors;

public interface HonorsService {
    
	List<Honors> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Honors findById(Long honorsId);
	
	Honors findFinal();
	
	List<Honors> findBySection(Integer section);
	
	boolean insert(Honors model);
	
	boolean update(Honors model);

}
