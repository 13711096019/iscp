package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.ResearchDiscuss;
import com.cn.iscp.model.StateModel;

public interface ResearchDiscussService {

	/**
	 * 分页获取评论列表
	 */
	List<ResearchDiscuss> findByPage(ResearchDiscuss model);

	/**
	 * 分组获取评论列表
	 */
	List<ResearchDiscuss> findByGroup(ResearchDiscuss model);
	
	/**
	 * 根据边教边研编号获取评论列表
	 */
	List<ResearchDiscuss> findByResearch(ResearchDiscuss model);
	
	/**
	 * 新增(边教边研)评论
	 */
	StateModel insertDiscuss(ResearchDiscuss model);
	
	/**
	 * 删除(边教边研)评论
	 */
	StateModel deleteDiscuss(ResearchDiscuss model);
	
}
