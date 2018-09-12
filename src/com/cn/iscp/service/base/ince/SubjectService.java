package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Subject;

public interface SubjectService {
	
	List<Subject> findPage(Map<String, Object> map);

	Long getPageCount(Map<String, Object> map);
	
	Subject findById(Long subjectId);
	
	Subject findFinal();
	
	List<Subject> findAll();
	
	/**
	 * 获取正科科目
	 */
	List<Subject> findByExem();
	
	List<Subject> findByGrade(Long gradeId);
	
	boolean insert(Subject model);
	
	boolean update(Subject model);

	/**
	 * 工作-根据老师与年级编号获取任课科目列表
	 * @isTotal 主任级以上角色是否查看全部（1是，0否）
	 */
	List<Subject> findSubjectByTeacher(Long gradeId, Long teacherId, Integer isTotal);
    
}