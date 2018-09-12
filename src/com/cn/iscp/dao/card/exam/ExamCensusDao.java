package com.cn.iscp.dao.card.exam;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.exam.ExamCensusClass;
import com.cn.iscp.entity.card.exam.ExamCensusGrade;

public interface ExamCensusDao {
    
	/**
	 * PC-根据试卷编号获取班级统计信息
	 */
	ExamCensusClass getClassByExamPaperId(Map<String, Object> map);

	/**
	 * 终端-根据班级/科目获取月考成绩统计
	 
	List<ExamCensusClass> examResultConsult(Map<String, Object> map);*/

	/**
	 * 终端-获取月考班级排名
	 */
	List<ExamCensusClass> findRankingClass(Map<String, Object> map);
	
	
	
	
	
	
	
	/**
	 * PC-根据试卷编号获取年级统计信息
	 */
	ExamCensusGrade getGradeByExamPaperId(Long examPaperId);
	
	/**
	 * PC-根据试卷编号统计
	 */
	void examResultStatistic(Long examPaperId);
	
}
