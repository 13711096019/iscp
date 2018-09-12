package com.cn.iscp.service.prepare.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.Grade;
import com.cn.iscp.entity.prepare.Topic;
import com.cn.iscp.model.PageModel;

public interface TopicService {
	
	/**
	 * 老师端-根据年级科目获取课题列表
	 */
	List<Topic> findByGrade(Topic model);
	
	/**
	 * 老师端-根据年级科目获取我的备课课题列表
	 */
	List<Topic> findMyTopicByGrade(Topic model);
	
	/**
	 * 工作-根据老师编号获取课题列表
	 */
	List<Grade> findTopicByTeacher(Long teacherId, boolean isMyDraft, boolean isMyPlan, Integer isTotal);
	
	/**
	 * PC-分页获取课题信息
	 */
	PageModel findTopiByPage(Map<String, Object> map);
	
	/**
	 * PC-根据编号获取对象
	 */
	Topic findById(Long topicId);
	
	/**
	 * PC-根据编号删除
	 */
	boolean deleteByContent(Long topicId);

	/**
	 * PC-新增
	 */
	boolean insert(Topic model);

	/**
	 * PC-编辑
	 */
	boolean update(Topic model);
	
	/**
	 * PC-更新时间戳
	 */
	boolean updateFlagtime(Topic model);
	
}
