package com.cn.iscp.service.push.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.push.PraiseDao;
import com.cn.iscp.dao.push.PraiseRuleDao;
import com.cn.iscp.entity.push.Praise;
import com.cn.iscp.entity.push.PraiseRule;
import com.cn.iscp.service.push.ince.PraiseService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("praiseService")
public class PraiseServiceImpl implements PraiseService {
	
	@Resource
	private PraiseDao praiseDao;
	@Resource
	private PraiseRuleDao praiseRuleDao;

	@Override
	public List<Praise> findByValid() {
		return praiseDao.findByValid(_Const.ITEMCORD_RANGE_LEVEL);
	}

	@Override
	public List<Praise> findByInvalid(Map<String, Object> map) {
    	map.put("itemCodeRangeLevel", _Const.ITEMCORD_RANGE_LEVEL);
		return praiseDao.findByInvalid(map);
	}

	@Override
	public Praise findById(Long praiseId) {
		return praiseDao.findById(praiseId);
	}

	@Override
	public boolean updInvalidPraise() {
		return praiseDao.updInvalidPraise();
	}

	@Override
	public PraiseRule findByClass(Long classNum) {
		PraiseRule rule = praiseRuleDao.getPraiseRule();
		if(rule == null){
			return null;
		}
		rule.setPraiseList(praiseDao.findByClass(classNum));
		return rule;
	}

	@Override
	public Praise insertPraise(Praise model) {
		model.setSchoolId(_Const.SCHOOL_ID);
		Praise praise = praiseDao.insertPraise(model);
		if(praise != null){
			// 极光推送
			BasePushTimed.PushMachine(PushCode.CLASS_PRAISE, false, null, null);
		}
		return praise;
	}

	@Override
	public boolean updatePraise(Praise model) {
		boolean revert = praiseDao.updatePraise(model);
		if(revert){
			// 极光推送
			BasePushTimed.PushMachine(PushCode.CLASS_PRAISE, false, null, null);
		}
		return revert;
	}

}
