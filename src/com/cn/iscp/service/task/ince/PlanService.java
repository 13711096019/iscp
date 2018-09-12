package com.cn.iscp.service.task.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.task.Plan;
import com.cn.iscp.model.StateModel;

public interface PlanService {
	
	/**
	 * PC-分页获取对象
	 */
    List<Plan> findPage(Map<String, Object> map);
    /**
	 * PC-获取分页总数
	 */
	Long getPageCount(Map<String, Object> map);
	/**
	 * PC-根据编号获取对象
	 */
	Plan findById(Long planId);
	/**
	 * 工作-获取所有工作要点
	 */
	List<Plan> findAll(Long userId);
	
	/**
	 * 工作-根据周次获取工作要点
	 */
	Plan findByWeek(Integer weekNum);
	
	/**
	 * 工作-处理工作要点
	 */
	StateModel handlePlan(Plan model);
	
	/**
	 * 工作-删除工作要点
	 */
	StateModel deletePlan(Plan model);
	
	/**
	 * PC-修改状态
	 */
	boolean updateplanStatus(Plan model);
	
	/**
	 * PC-更新对象
	 */
	boolean update(Plan model);
}
