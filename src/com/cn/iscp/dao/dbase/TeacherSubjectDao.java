package com.cn.iscp.dao.dbase;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.dbase.TeacherSubject;

public interface TeacherSubjectDao {
	
	/**
	 * PC-根据动态班级编号获取任课教师列表
	 */
	List<TeacherSubject> findByClassNum(Long classNum);
	
	/**
	 * PC-处理教师科目
	 */
	TeacherSubject handleTeacherSubject(TeacherSubject model);
	
	/**
	 * 老师端-获取教师任教班级列表
	 */
	List<Map<String, Object>> findTeachClass(Long teacherId);

	/**
	 * 工作-根据老师编号获取任课班级和科目列表
	 */
	List<TeacherSubject> findClassByTeacher(Long teacherId);

	/**
	 * 工作-根据老师编号获取任课班级和科目
	 */
	List<TeacherSubject> findSubjectByTeacher(Long teacherId);

	/**
	 * PC-根据科目编号获取老师列表
	 */
	List<TeacherSubject> findTeacherBySubject(Long subjectId);

	/**
	 * PC-根据科目编号获取老师列表
	 */
	Long judgeSubjectTeacher(TeacherSubject model);
	
	/**
	 * PC-根据动态班级编号和科目编号获取班级名称,科任老师姓名
	 */
	Map<String, Object> getSubjectTeacher(Map<String, Object> map);
		
}
