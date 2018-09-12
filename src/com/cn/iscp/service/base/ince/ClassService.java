package com.cn.iscp.service.base.ince;

import java.util.List;

import com.cn.iscp.entity.base.Class;

public interface ClassService {
	
	Class findById(Long classId);
	
	Class findByEntity(Long classEntityId);
	
	Class findByNum(Integer classNum);
	
	Class findFinal(Long gradeId);
	
	List<Class> findByGrade(Long gradeId);
	
	boolean insert(Class model);
	
	boolean update(Class model);
	
}