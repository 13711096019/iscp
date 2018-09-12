package com.cn.iscp.service.task.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.PlanColumnDao;
import com.cn.iscp.dao.task.PlanContentDao;
import com.cn.iscp.entity.task.PlanColumn;
import com.cn.iscp.entity.task.PlanContent;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.task.ince.PlanColumnService;

@Service("planColumnService")
public class PlanColumnServiceImpl implements PlanColumnService{
	
    @Resource
    PlanColumnDao planColumnDao;
    @Resource
    PlanContentDao planContentDao;
    
	@Override
	public List<PlanColumn> findAll() {
		return planColumnDao.findAll();
	}

	@Override
	public List<PlanColumn> findAllColumnContent(Long planId) {
		//获取所有大栏目
		List<PlanColumn> planColumnList = this.findAll();
		PlanContent planContent = null;
		
		for (PlanColumn planColumn : planColumnList) {
			// 获取相对于栏目的备课内容proposer
			planContent = new PlanContent(planId, planColumn.getColumnId(),planColumn.getProposer());
			planContent = planContentDao.findBycolumn(planContent);
			
			planColumn.setPlanContent(planContent);
		}
		return planColumnList;
	}

	@Override
	public StateModel updateAllotTeacher(Map<String, Object> map) {
		return planColumnDao.updateAllotTeacher(map);
	}

	@Override
	public List<PlanColumn> findTeacher() {
		return planColumnDao.findTeacher();
	}

	@Override
	public boolean updateTeacher(PlanColumn model) {
		return planColumnDao.updateTeacher(model);
	}

	@Override
	public String findTeacherByIds(String ids) {
		return planColumnDao.findTeacherByIds(ids);
	}

	@Override
	public PlanColumn findById(Long columnId) {
		return planColumnDao.findById(columnId);
	}

	@Override
	public PlanColumn findByColumnId(Long teacherId) {
		return planColumnDao.findByColumnId(teacherId);
	}

	
	
}
