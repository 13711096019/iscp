package com.cn.iscp.dao.card.civilized;

import java.util.List;

import com.cn.iscp.entity.card.civilized.CivilizedGiveScore;
import com.cn.iscp.entity.card.civilized.CivilizedRegular;

public interface CivilizedRegularDao {
	
	/**
	 * PC-根据大项获取信息列表
	 */
	List<CivilizedRegular> findByItem(Long bigItemId);
	
	/**
	 * PC-根据编号获取对象
	 */
	CivilizedRegular findById(Long smallItemId);

	/**
	 * 老师端-获取所有创文评分规则
	 */
	List<CivilizedRegular> findScoreRegular(CivilizedGiveScore model);
	
	/**
	 * PC-获取所有创文评分规则
	 */
	List<CivilizedRegular> findRegular();
	
}
