package com.cn.iscp.service.base.ince;

import java.util.List;

import com.cn.iscp.entity.base.Grade;

public interface GradeService {
	
	Grade findById(Long gradeId);
	
	Grade findFinal();
	
	List<Grade> findAll();
	
	List<Grade> findBySection(String gradeSection);
	
	/*List<Grade> findBySchool(Long schoolId);*/
	
	void handleGradeSubject(Long gradeId, String[] idArray);
	
	boolean insert(Grade model);
	
	boolean update(Grade model);
	
	List<Grade> findAllClass();
	
	/**
	 * 工作-根据老师获取任课年级列表
	 * @isTotal 主任级以上角色是否查看全部（1是，0否）
	 */
	List<Grade> findGradeByTeacher(Long teacherId, Integer isTotal);
	
}