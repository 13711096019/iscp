package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.Plan;
import com.cn.iscp.entity.task.PlanContent;

public interface PlanContentService {
	
	/**
	 * PC-根据工作要点编号获取对象
	 */
     PlanContent findByplanId(Long planId);
     
     /**
      * PC-根据工作要点编号获取栏目内容
      */
    PlanContent findBycolumn(PlanContent model);
     
     
	/**
	 * 工作-根据工作要点编号获取工作要点内容
	 */
	List<PlanContent> findByPlan(PlanContent model);
	
	/**
	 * 工作-处理工作要点内容
	 */
	List<PlanContent> handleContent(Plan model);
}
