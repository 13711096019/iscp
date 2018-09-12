package com.cn.iscp.service.attend.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.DailyStatisticsDao;
import com.cn.iscp.entity.attend.DailyStatistics;
import com.cn.iscp.service.attend.ince.DailyStatisticsService;
import com.cn.unit.quartz.task.PhonePushTimed;

@Service("dailyStatisticsService")
public class DailyStatisticsServiceImpl implements DailyStatisticsService {

	@Resource
	private DailyStatisticsDao dailyStatisticsDao;
	
	@Override
	public DailyStatistics censusDailyStatistics() {
		DailyStatistics daily = dailyStatisticsDao.censusDailyStatistics();
		if(daily != null){
			// 出勤报表推送
			PhonePushTimed.PushDailyStatistics();
		}
		return daily;
	}
	
	@Override
	public List<DailyStatistics> findByPage(Integer pageCount) {
		return dailyStatisticsDao.findByPage(pageCount);
	}

}
