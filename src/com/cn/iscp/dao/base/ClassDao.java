package com.cn.iscp.dao.base;

import java.util.List;

import com.cn.iscp.entity.base.Class;

public interface ClassDao {
	
	Class findById(Long classId);
	
	Class findByEntity(Long classEntityId);
	
	Class findByNum(Integer classNum);
	
	Class findByClassNum(Long classNum);
	
	Class findFinal(Long gradeId);
	
	List<Class> findByGrade(Long gradeId);
	
	boolean insert(Class model);
	
	boolean update(Class model);
	
}