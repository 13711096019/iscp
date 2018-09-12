package com.cn.iscp.dao.card.exam;

import java.util.List;

import com.cn.iscp.entity.card.exam.ExamDescSeating;

public interface ExamDescSeatingDao {

	/**
	 * PC-根据班级动态编号获取数据
	 */
	List<ExamDescSeating> findByClass(ExamDescSeating model);
	
	/**
	 * PC-处理班级座位表
	 */
	void handleSeatingChart(ExamDescSeating model);
	
	/**
	 * 终端-获取考试临时座位表
	 */
	List<ExamDescSeating> findSeatingChart(ExamDescSeating model);
	
}
