package com.cn.iscp.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.CalendarDao;
import com.cn.iscp.dao.task.CalendarRemindDao;
import com.cn.iscp.entity.task.Calendar;
import com.cn.iscp.entity.task.CalendarRemind;
import com.cn.iscp.service.task.ince.CalendarRemindService;

@Service("calendarRemindService")
public class CalendarRemindServiceImpl implements CalendarRemindService {
	
	@Resource
	private CalendarRemindDao calendarRemindDao;
	@Resource
	private CalendarDao calendarDao;
	
	@Override
	public List<CalendarRemind> findByUser(Long userId) {
		return calendarRemindDao.findByUser(userId);
	}
	
	@Override
	public List<CalendarRemind> findCalendarRemind(Long userId) {
		List<CalendarRemind> revertList = calendarRemindDao.findByUser(userId);
		Calendar calendar = new Calendar(userId, null);
		for (CalendarRemind item : revertList) {
			calendar.setRemindDate(item.getRemindDate());
			item.setCalendarList(calendarDao.findByDate(calendar));
		}
		return null;
	}

}
