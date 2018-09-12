package com.cn.iscp.dao.dbase;

import java.util.List;

import com.cn.iscp.entity.dbase.SeatingChart;

public interface SeatingChartDao {
	
	/**
	 * PC-根据班级动态编号获取数据
	 */
	List<SeatingChart> findByClass(Long classNum);
	
	/**
	 * PC-处理班级座位表
	 */
	void handleSeatingChart(SeatingChart model);
	
	/**
	 * PC-处理班级小组
	 */
	void handleSeatingGroup(SeatingChart model);
	
	/**
	 * 终端-获取座位表
	 */
	List<SeatingChart> findSeatingChart(Long classNum);
	
	/**
	 * PC-根据小组编号获取学生列表
	 */
	List<SeatingChart> findStudentByGroup(SeatingChart model);
	
}
