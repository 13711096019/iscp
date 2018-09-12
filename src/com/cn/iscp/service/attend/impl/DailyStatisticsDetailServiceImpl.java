package com.cn.iscp.service.attend.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.DailyStatisticsDetailDao;
import com.cn.iscp.entity.attend.DailyStatisticsDetail;
import com.cn.iscp.service.attend.ince.DailyStatisticsDetailService;

@Service("dailyStatisticsDetailService")
public class DailyStatisticsDetailServiceImpl implements DailyStatisticsDetailService {
	
	@Resource
	private DailyStatisticsDetailDao dailyStatisticsDetailDao;
	
	@Override
	public List<Map<String, Object>> findByDate(DailyStatisticsDetail model) {
		return dailyStatisticsDetailDao.findByDate(model);
	}
	
}