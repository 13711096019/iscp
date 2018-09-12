package com.cn.iscp.dao.dbase;

import java.util.List;

import com.cn.iscp.entity.dbase.GradeSubject;

public interface GradeSubjectDao {
	
	/**
	 * PC-查看所有年级科目列表
	 */
	List<GradeSubject> findGradeSubject();
	
	/**
	 * PC-获取所有科目(根据年级判断是否存在)
	 */
	List<GradeSubject> findAllByGrade(Long gradeId);
	
	/**
	 * PC-处理年级科目关系
	 */
	void handleGradeSubject(GradeSubject model);
	
	/**
	 * 根据年级获取科目
	 */
	List<GradeSubject> findByGrade(Long gradeId);
	
	/**
	 * 根据年级获取考试科目
	 */
	List<GradeSubject> findExamSubjectByGrade(Long gradeId);
	
	
	
	
    
	/**
	 * 新增年级科目
	 * @return 新增结果
	 *//*
	Integer insert(GradeSubject model);
	
	*//**
	 * 判断年度是否存在
	 * @return 大于0存在
	 *//*
	Long getCountBySchoolYearId(Long schoolYearId);
	
	*//**
	 * 查看年级科目列表
	 * @return
	 *//*
	List<GradeSubject> findPage();
	
	*/
	
}