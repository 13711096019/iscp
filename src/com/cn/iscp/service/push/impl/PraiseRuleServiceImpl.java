package com.cn.iscp.service.push.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.push.PraiseRuleDao;
import com.cn.iscp.entity.push.PraiseRule;
import com.cn.iscp.service.push.ince.PraiseRuleService;

@Service("praiseRuleService")
public class PraiseRuleServiceImpl implements PraiseRuleService {
	
	@Resource
	private PraiseRuleDao praiseRuleDao;

	@Override
	public PraiseRule getPraiseRule() {
		return praiseRuleDao.getPraiseRule();
	}

	@Override
	public boolean updCarouselTime(PraiseRule model) {
		return praiseRuleDao.updCarouselTime(model);
	}

	@Override
	public boolean update(PraiseRule model) {
		return praiseRuleDao.update(model);
	}

}
