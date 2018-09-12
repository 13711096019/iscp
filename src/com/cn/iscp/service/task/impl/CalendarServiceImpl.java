package com.cn.iscp.service.task.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.CalendarDao;
import com.cn.iscp.entity.task.Calendar;
import com.cn.iscp.service.task.ince.CalendarService;

@Service("calendarService")
public class CalendarServiceImpl implements CalendarService {
	
	@Resource
	private CalendarDao calendarDao;

	@Override
	public List<Calendar> findByUser(Long teacherId) {
		return calendarDao.findByUser(teacherId);
	}
	
	@Override
	public List<Calendar> findByDate(Calendar model) {
		return calendarDao.findByDate(model);
	}
	
	@Override
	public List<Calendar> findByRemind(Long remindId) {
		return calendarDao.findByRemind(remindId);
	}

	@Override
	public Calendar insertCurrent(Calendar model) {
		return calendarDao.insertCurrent(model);
	}

	@Override
	public Calendar updateCurrent(Calendar model) {
		return calendarDao.updateCurrent(model);
	}
	
	@Override
	public boolean deleteCurrent(Long calendarId) {
		calendarDao.deleteCurrent(calendarId);
		return true;
	}
	
	@Override
	public List<Calendar> findDateByCalendar(Long teacherId) {
		List<Calendar> revertList = new ArrayList<Calendar>();
		List<Calendar> list = calendarDao.findByUser(teacherId);
		for (Calendar item : list) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try{
	            Date startDate = dateFormat.parse(item.getStartDate());
	            Date endDate = dateFormat.parse(item.getEndDate());
	            java.util.Calendar calendar = java.util.Calendar.getInstance();
	            calendar.setTime(startDate);
	            while(calendar.getTime().before(endDate)){
					revertList.add(new Calendar(dateFormat.format(calendar.getTime())));
	                calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
	            }
				revertList.add(new Calendar(dateFormat.format(endDate)));
	        }
	        catch(Exception e){
	            e.printStackTrace();
	            continue;
	        }
		}
		
		// 过滤重复选项
		for (int i = 0; i < revertList.size() - 1; i++) {
            for (int j = revertList.size() - 1; j > i; j--) {
                if (revertList.get(j).getRemindDate().equals(revertList.get(i).getRemindDate())) {
                	revertList.remove(j);
                }
            }
        }
        
		return revertList;
	}
	
}
