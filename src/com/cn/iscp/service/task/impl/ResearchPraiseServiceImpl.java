package com.cn.iscp.service.task.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.ResearchPraiseDao;
import com.cn.iscp.entity.task.ResearchPraise;
import com.cn.iscp.service.task.ince.ResearchPraiseService;

@Service("researchPraiseService")
public class ResearchPraiseServiceImpl implements ResearchPraiseService {
	
	@Resource
	private ResearchPraiseDao researchPraiseDao;

	@Override
	public ResearchPraise insertPraise(ResearchPraise model) {
		return researchPraiseDao.insertPraise(model);
	}

}
