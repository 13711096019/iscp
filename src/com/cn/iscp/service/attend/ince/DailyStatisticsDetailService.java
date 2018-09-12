package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.DailyStatisticsDetail;

public interface DailyStatisticsDetailService {
	
	/**
	 * 获取考勤报表明细
	 */
	List<Map<String, Object>> findByDate(DailyStatisticsDetail model);
	
}
