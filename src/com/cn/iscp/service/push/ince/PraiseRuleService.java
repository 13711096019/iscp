package com.cn.iscp.service.push.ince;

import com.cn.iscp.entity.push.PraiseRule;

public interface PraiseRuleService {
	
	/**
	 * PC-获取规则
	 */
	PraiseRule getPraiseRule();
	
	/**
	 * 修改轮播时间
	 */
	boolean updCarouselTime(PraiseRule model);
	
	/**
	 * 修改对象
	 */
	boolean update(PraiseRule model);
	
}
