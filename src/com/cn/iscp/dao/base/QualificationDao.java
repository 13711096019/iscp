package com.cn.iscp.dao.base;

import com.cn.iscp.entity.base.Qualification;

public interface QualificationDao {
    
	Qualification getQualification(Long teacherId);
	
	boolean insert(Qualification model);
	
	boolean update(Qualification model);
	
}