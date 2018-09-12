package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.Calendar;

public interface CalendarService {
	
	/**
	 * 工作-根据用户获取所有日程
	 */
	List<Calendar> findByUser(Long teacherId);
	
	/**
	 * 工作-根据日期获取日程事件列表
	 */
	List<Calendar> findByDate(Calendar model);
	
	/**
	 * 工作-根据提醒编号获取日程提醒对象
	 */
	List<Calendar> findByRemind(Long remindId);
	
	/**
	 * 工作-添加日程
	 */
	Calendar insertCurrent(Calendar model);
	
	/**
	 * 工作-更新日程
	 */
	Calendar updateCurrent(Calendar model);

	/**
	 * 工作-删除日程
	 */
	boolean deleteCurrent(Long calendarId);

	/**
	 * 工作-获取日程所包含的日期
	 */
	public List<Calendar> findDateByCalendar(Long teacherId);
	
}
