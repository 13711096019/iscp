package com.cn.iscp.service.prepare.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.prepare.TeachingPlanDao;
import com.cn.iscp.entity.prepare.TeachingPlan;
import com.cn.iscp.service.prepare.ince.TeachingPlanService;

@Service("teachingPlanService")
public class TeachingPlanServiceImpl implements TeachingPlanService {

	@Resource
	private TeachingPlanDao teachingPlanDao;
	
	@Override
	public TeachingPlan findByTopic(TeachingPlan model) {
		return teachingPlanDao.findByTopic(model);
	}

	@Override
	public TeachingPlan handleTeachingPlan(TeachingPlan model) {
		return teachingPlanDao.handleTeachingPlan(model);
	}

	@Override
	public List<TeachingPlan> findPage(Map<String, Object> map) {
		return teachingPlanDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return teachingPlanDao.getPageCount(map);
	}

	@Override
	public TeachingPlan findById(Long teachingId) {
		return teachingPlanDao.findById(teachingId);
	}

	@Override
	public boolean update(TeachingPlan model) {
		return teachingPlanDao.update(model);
	}

}
