package com.cn.iscp.dao.card;

import java.util.List;

import com.cn.iscp.entity.card.ClockOndayClass;

public interface ClockOndayClassDao {
	
	/**
	 * 终端-根据日期获取班级考勤情况
	 */
	ClockOndayClass findByDate(ClockOndayClass model);
	
	/**
	 * PC-获取最近一个月班级情况
	 */
	List<ClockOndayClass> findByLastMonth(Long classNum);
	
	/**
	 * 终端-按日期统计班级考勤
	 */
	ClockOndayClass censusClassAttendance(ClockOndayClass model);
	
	/**
	 * 定时器-统计班级考勤情况
	 */
	Integer handleClassClockonday();
}
