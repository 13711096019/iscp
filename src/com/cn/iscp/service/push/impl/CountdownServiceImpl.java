package com.cn.iscp.service.push.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.push.CountdownDao;
import com.cn.iscp.entity.push.Countdown;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.iscp.service.push.ince.CountdownService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("countdownService")
public class CountdownServiceImpl extends BaseSericel implements CountdownService {
	
	@Resource
	private CountdownDao countdownDao;

	@Override
	public PageModel findPage(Map<String, Object> map) {
		map.put("itemCodeRangeLevel", _Const.ITEMCORD_RANGE_LEVEL);
		List<List<?>> list = countdownDao.findPage(map);
		return getMapByPage(list);
	}

	@Override
	public Countdown findById(Long keyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("downId", keyId);
		map.put("itemCodeRangeLevel", _Const.ITEMCORD_RANGE_LEVEL);
		return countdownDao.findById(map);
	}

	@Override
	public Countdown addCountdown(Countdown model) {
		model = countdownDao.addCountdown(model);
		if(model != null){
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			BasePushTimed.PushMachine(PushCode.COUNTDOWNS, true, gradeId, null);
		}
		return model;
	}

	@Override
	public Countdown editCountdown(Countdown model) {
		model = countdownDao.editCountdown(model);
		if(model != null){
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			BasePushTimed.PushMachine(PushCode.COUNTDOWNS, true, gradeId, null);
		}
		return model;
	}

	@Override
	public Integer delCountdown(Countdown model) {
		Integer count = countdownDao.delCountdown(model);
		if(count > 0){
			model = this.findById(model.getDownId());
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			BasePushTimed.PushMachine(PushCode.COUNTDOWNS, true, gradeId, null);
		}
		return count;
	}

	@Override
	public Countdown getByClassNum(Long classNum) {
		return countdownDao.getByClassNum(classNum);
	}
	
}
