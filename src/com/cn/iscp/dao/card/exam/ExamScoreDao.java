package com.cn.iscp.dao.card.exam;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.exam.ExamScoreInput;
import com.cn.iscp.model.ExamScore;

public interface ExamScoreDao {
	
	/**
	 * PC-获取班级学生成绩信息
	 */
	List<ExamScoreInput> findExamScore(Map<String, Object> map);
	
	/**
	 * PC-处理学生成绩
	 */
	void handleExamScore(ExamScoreInput model);
	
	/**
	 * 终端-获取学生排名
	 */
	List<ExamScore> findRankingStudent(Long classNum);
	
}
