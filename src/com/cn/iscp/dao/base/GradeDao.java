package com.cn.iscp.dao.base;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Grade;

public interface GradeDao {
	
	Grade findById(Long gradeId);
	
	Grade findFinal();
	
	List<Grade> findAll();
	
	List<Grade> findBySection(String gradeSection);
	
	/*List<Grade> findBySchool(Long schoolId);*/
	
	void handleGradeSubject(Map<String, Object> map);
	
	boolean insert(Grade model);
	
	boolean update(Grade model);
	
	/**
	 * 工作-根据老师获取任课年级列表
	 */
	List<Grade> findGradeByTeacher(Map<String, Object> map);
	
}