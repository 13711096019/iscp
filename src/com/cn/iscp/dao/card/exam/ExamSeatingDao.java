package com.cn.iscp.dao.card.exam;

import java.util.List;

import com.cn.iscp.entity.card.exam.ExamSeating;

public interface ExamSeatingDao {

	/**
	 * PC-根据班级动态编号获取数据
	 */
	List<ExamSeating> findByClass(ExamSeating model);
	
	/**
	 * PC-处理考试模板班级座位表
	 */
	void handleSeatingChart(ExamSeating model);
	
}
