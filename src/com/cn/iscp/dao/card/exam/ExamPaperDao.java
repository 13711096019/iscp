package com.cn.iscp.dao.card.exam;

import java.util.List;

import com.cn.iscp.entity.card.exam.ExamPaper;

public interface ExamPaperDao {
	
	/**
	 * 根据编号获取对象
	 */
	ExamPaper findById(Long examPaperId);
	
	/**
	 * 根据考试信息编号获取试卷列表
	 */
	List<ExamPaper> findByInfo(Long examInfoId);

	/**
	 * 编辑试卷信息
	 */
	ExamPaper updateExamPaper(ExamPaper model);
	
}
