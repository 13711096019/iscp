package com.cn.iscp.dao.card.exam;

import java.util.List;

import com.cn.iscp.entity.card.exam.ExamSeatingTemp;

public interface ExamSeatingTempDao {
	
	/**
	 * PC-获取考试座位表模板列表
	 */
	List<ExamSeatingTemp> findAll(Long userId);
	
	/**
	 * PC-根据编号获取考试座位表模板对象
	 */
	ExamSeatingTemp findById(Long tempId);
	
	/**
	 * PC-根据年级编号获取考试座位表模板列表
	 */
	List<ExamSeatingTemp> findByGrade(Long gradeId);
	
	/**
	 * PC-新增考试座位表模板
	 */
	ExamSeatingTemp insertExamSeatingTemp(ExamSeatingTemp model);
	
	/**
	 * PC-编辑考试座位表模板
	 */
	ExamSeatingTemp updateExamSeatingTemp(ExamSeatingTemp model);
	
}
