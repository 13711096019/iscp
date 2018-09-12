package com.cn.iscp.service.prepare.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.prepare.TeachingPlan;

public interface TeachingPlanService {
	
	/**
	 * 工作-根据课题编号获取教案对象
	 */
	TeachingPlan findByTopic(TeachingPlan model);
	
	/**
	 * 工作-处理教案信息
	 */
	TeachingPlan handleTeachingPlan(TeachingPlan model);
	/**
	 * 分页获取对象
	 */
    List<TeachingPlan> findPage(Map<String, Object> map);
    /**
	 * 获取分页总数
	 */
	Long getPageCount(Map<String, Object> map);
	/**
	 * PC-根据编号获取对象
	 */
	TeachingPlan findById(Long teachingId);
	/**
	 * PC-编辑
	 */
	boolean update(TeachingPlan model);
}
