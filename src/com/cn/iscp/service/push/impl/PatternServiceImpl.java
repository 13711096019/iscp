package com.cn.iscp.service.push.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.push.PatternDao;
import com.cn.iscp.entity.push.Pattern;
import com.cn.iscp.service.push.ince.PatternService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("patternService")
public class PatternServiceImpl implements PatternService {
	
	@Resource
	private PatternDao patternDao;

	@Override
	public Pattern getMostUrgentPattern(Long classNum) {
		return patternDao.getMostUrgentPattern(classNum);
	}

	@Override
	public Pattern getOnlyPattern(Integer screenMode) {
		return patternDao.getOnlyPattern(screenMode);
	}

	@Override
	public Pattern findById(Long patternId) {
		return patternDao.findById(patternId);
	}

	@Override
	public Pattern editFlagPattern(Pattern model) {
		return patternDao.editFlagPattern(model);
	}

	@Override
	public List<Pattern> findValidPattern(Integer screenMode) {
		return patternDao.findValidPattern(screenMode);
	}

	@Override
	public List<Pattern> findInvalidPattern(Integer screenMode) {
		return patternDao.findInvalidPattern(screenMode);
	}

	@Override
	public Pattern addPattern(Pattern model) {
		Pattern pattern = patternDao.addPattern(model);
		if(pattern != null){
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			BasePushTimed.PushMachine(PushCode.PATTERN_URGENT, false, gradeId, null);
		}
		return pattern;
	}

	@Override
	public Pattern editPattern(Pattern model) {
		Pattern pattern = patternDao.editPattern(model);
		if(pattern != null){
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			BasePushTimed.PushMachine(PushCode.PATTERN_URGENT, false, gradeId, null);
		}
		return pattern;
	}

	@Override
	public boolean delPattern(Pattern model) {
		boolean revert = patternDao.delPattern(model);
		if(revert){
			model = this.findById(model.getPatternId());
			Long gradeId = null;
			if(_Tool.isInt(model.getScopeType()) && model.getScopeType().intValue()==_Const.SCOPE_CLASS){
				gradeId = _Tool.toLong(model.getGradeIds());
			}
			BasePushTimed.PushMachine(PushCode.PATTERN_URGENT, false, gradeId, null);
		}
		return revert;
	}

}
