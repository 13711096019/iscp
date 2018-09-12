package com.cn.iscp.dao.attend;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.DailyStatisticsDetail;

public interface DailyStatisticsDetailDao {
	
	/**
	 * 获取考勤报表明细
	 */
	List<Map<String, Object>> findByDate(DailyStatisticsDetail model);
	
}
