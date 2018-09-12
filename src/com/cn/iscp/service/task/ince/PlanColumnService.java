package com.cn.iscp.service.task.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.task.PlanColumn;
import com.cn.iscp.model.StateModel;

public interface PlanColumnService {
	
	/**
	 * 工作-获取所有栏目列表
	 */
	List<PlanColumn> findAll();
	
	/**
	 * 工作-获取所有栏目内容列表
	 */
	List<PlanColumn> findAllColumnContent(Long planId);
	
	/**
	 * 工作-重新分配发布老师
	 */
	StateModel updateAllotTeacher(Map<String, Object> map);
	
	/**
	 * 工作-获取工作要点各部门老师列表
	 */
	List<PlanColumn> findTeacher();
	
	/**
	 * PC-重新分配模板执行人
	 */
	boolean updateTeacher(PlanColumn model);
	
	/**
	 * PC-根据老师编号获取老师姓名
	 */
	String findTeacherByIds(String ids);
	
	/**
	 * PC-根据编号获取对象
	 */
	PlanColumn findById(Long columnId);
	
	/**
	 * PC-根据登录老师编号获取对象
	 */
	PlanColumn findByColumnId(Long teacherId);
}
