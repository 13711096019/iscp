package com.cn.iscp.dao.card.civilized;

import java.util.List;

import com.cn.iscp.entity.card.civilized.CivilizedClassScore;
import com.cn.iscp.entity.card.civilized.CivilizedGiveScore;

public interface CivilizedGiveScoreDao {
	
	/**
	 * 老师端-添加评分信息
	 */
	CivilizedGiveScore insertGiveScore(CivilizedGiveScore model);
	
	/**
	 * PC-查看创文明细
	 */
	List<CivilizedGiveScore> findDetail(CivilizedClassScore model);

	/**
	 * PC-删除评分信息
	 */
	void deleteGiveScore(Long scoreId);
	
}
