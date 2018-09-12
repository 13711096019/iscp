package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.CalendarRemind;

public interface CalendarRemindService {
	
	/**
	 * 工作-根据老师编号获取所有提醒日期
	 */
	List<CalendarRemind> findByUser(Long userId);
	
	/**
	 * 工作-根据老师编号获取所有提醒日期
	 */
	List<CalendarRemind> findCalendarRemind(Long teacherId);
	
}
