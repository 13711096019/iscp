package com.cn.iscp.service.task.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.PlanContentDao;
import com.cn.iscp.entity.task.Plan;
import com.cn.iscp.entity.task.PlanContent;
import com.cn.iscp.service.task.ince.PlanContentService;

@Service("planContentService")
public class PlanContentServiceImpl implements PlanContentService {
	
	@Resource
	private PlanContentDao planContentDao;

	

	@Override
	public List<PlanContent> findByPlan(PlanContent model) {
		return planContentDao.findByPlan(model);
	}
	
	@Override
	public List<PlanContent> handleContent(Plan model) {
		return planContentDao.handleContent(model);
	}

	@Override
	public PlanContent findByplanId(Long planId) {
		return planContentDao.findByplanId(planId);
	}

	@Override
	public PlanContent findBycolumn(PlanContent model) {
		return planContentDao.findBycolumn(model);
	}




	

}
