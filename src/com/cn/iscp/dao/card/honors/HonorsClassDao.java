package com.cn.iscp.dao.card.honors;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.honors.HonorsClass;

public interface HonorsClassDao {
	
	/**
	 * PC-获取上个月文明班列表
	 */
	List<HonorsClass> findCivilizationClass();
	
	/**
	 * 终端-判断上一周是否为文明班
	 */
	HonorsClass judgeIsCivilizedClass(Long classNum);
	
	/**
	 * 统计-获取文明班获奖次数最多的10个班级
	 */
	List<Map<String, Object>> findCivilizedClassCensus();
	
}
