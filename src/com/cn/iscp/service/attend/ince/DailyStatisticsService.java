package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.DailyStatistics;

public interface DailyStatisticsService {
	
	/**
	 * 生成每日考勤人数统计记录
	 */
	DailyStatistics censusDailyStatistics();
	
	/**
	 * 分页获取出勤报表
	 */
	List<DailyStatistics> findByPage(Integer pageCount);
	
}
