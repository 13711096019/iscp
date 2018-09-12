package com.cn.iscp.dao.base;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Subject;

public interface SubjectDao {
	
	/**
	 * 分页获取信息列表
	 */
	List<Subject> findPage(Map<String, Object> map);

	/**
	 * 获取分页信息列表总数
	 */
	Long getPageCount(Map<String, Object> map);
	
	/**
	 * 根据编号获取对象
	 */
	Subject findById(Long subjectId);
	
	/**
	 * 获取最后一个对象
	 */
	Subject findFinal();
	
	/**
	 * 获取所有科目
	 */
	List<Subject> findAll();
	
	/**
	 * 获取正科科目
	 */
	List<Subject> findByExem();
	
	/**
	 * 根据年级获取科目
	 */
	List<Subject> findByGrade(Long gradeId);
	
	/**
	 * 保存对象 
	 */
	boolean insert(Subject model);
	
	/**
	 * 修改对象
	 */
	boolean update(Subject model);

	/**
	 * 工作-根据老师与年级编号获取任课科目列表
	 */
	List<Subject> findSubjectByTeacher(Map<String, Object> map);
    
}