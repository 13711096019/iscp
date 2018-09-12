package com.cn.iscp.dao.card.civilized;

import java.util.List;

import com.cn.iscp.entity.card.civilized.CivilizedClassScore;

public interface CivilizedClassScoreDao {
	
	/**
	 * 终端-获取相应阶段的创文评分列表
	 */
	List<CivilizedClassScore> findClassScoreByStage(CivilizedClassScore model);
	
	/**
	 * PC-获取班级排名列表
	 */
	List<List<?>> findClasssSore(CivilizedClassScore model);
	
	/**
	 * 定时器-每天凌晨统计班级创文排名
	 */
	void censusClassScore();
	
	/**
	 * PC-按日统计班级创文排名
	 */
	void censusClassScoreByDay(String studyDate);
	
}
