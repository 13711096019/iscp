package com.cn.iscp.service.task.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.PlanDao;
import com.cn.iscp.entity.task.Plan;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.task.ince.PlanService;

@Service("planService")
public class PlanServiceImpl implements PlanService {
	
	@Resource
	private PlanDao planDao;
	
	@Override
	public List<Plan> findPage(Map<String, Object> map) {
		return planDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return planDao.getPageCount(map);
	}

	@Override
	public Plan findById(Long planId) {
		return planDao.findById(planId);
	}
	@Override
	public List<Plan> findAll(Long userId) {
		return planDao.findAll(userId);
	}

	@Override
	public Plan findByWeek(Integer weekNum) {
		return planDao.findByWeek(weekNum);
	}

	@Override
	public StateModel handlePlan(Plan model) {
		return planDao.handlePlan(model);
	}

	@Override
	public StateModel deletePlan(Plan model) {
		return planDao.deletePlan(model);
	}

	@Override
	public boolean update(Plan model) {
		return planDao.update(model);
	}

	@Override
	public boolean updateplanStatus(Plan model) {
		return planDao.updateplanStatus(model);
	}

}
