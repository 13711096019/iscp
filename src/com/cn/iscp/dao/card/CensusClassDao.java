package com.cn.iscp.dao.card;

import com.cn.iscp.entity.card.CensusClass;

public interface CensusClassDao {
	
	/**
	 * PC-获取班级统计对象
	 */
	CensusClass getClassCensus(Long classNum);
	
	/**
	 * PC-统计本学期学生的情况
	 */
	void censusClassCensus();
	
}
