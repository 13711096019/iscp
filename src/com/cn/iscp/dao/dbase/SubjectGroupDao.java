package com.cn.iscp.dao.dbase;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.dbase.SubjectGroup;

public interface SubjectGroupDao {
	
	/**
	 * 工作-根据年级科目老师编号获取科组关系列表
	 */
	List<SubjectGroup> findByTeacher(Long teacherId);
	
	/**
	 * 工作-获取科组老师列表
	 */
	List<SubjectGroup> findBySubject(SubjectGroup model);
	
	/**
	 * PC-根据老师编号获取所在科组的年级列表
	 */
	List<SubjectGroup> findGradeByTeacher(Long teacherId);
	
	/**
	 * PC-根据老师编号获取所在科组年级的科目列表
	 */
	List<SubjectGroup> findSubjectByTeacher(SubjectGroup model);
	
	/**
	 * PC-分页获取科组信息
	 */
	List<List<?>> findByPage(Map<String, Object> map);
	
	/**
	 * PC-重新分配科组长
	 */
	SubjectGroup updateLeader(Long groupId);

	/**
	 * PC-移除科组某一老师
	 */
	boolean delete(Long groupId);
	
	/**
	 * PC-添加科组老师
	 */
	SubjectGroup insert(SubjectGroup model);
	
	/**
	 * PC-根据科目编号获取老师列表
	 */
	List<SubjectGroup> findTeacherBySubject(SubjectGroup model);

	/**
	 * PC-处理科组老师
	 */
	void handleGroup(SubjectGroup model);
	
}
