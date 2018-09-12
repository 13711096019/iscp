package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.Research;
import com.cn.iscp.model.StateModel;

public interface ResearchService {
	
	/**
	 * 分页查看边教边研
	 */
	List<Research> findByPage(Research model);
	
	/**
	 * 根据老师获取边教边研
	 */
	List<Research> findByTeacher(Research model);
	
	/**
	 * 根据编号获取边教边研对象
	 */
	Research findById(Long researchId);
	
	/**
	 * 新增边教边研
	 */
	Research insertResearch(Research model);
	
	/**
	 * 追加边教边研图片
	 */
	Research updateResearchPic(Research model);

	/**
	 * 整合边教边研
	 */
	StateModel handleResearch(Research model);

	/**
	 * 删除边教边研
	 */
	StateModel deleteResearch(Research model);
	
}
