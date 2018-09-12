package com.cn.iscp.dao.card;

import java.util.List;

import com.cn.iscp.entity.card.HomeworkFeedback;

public interface HomeworkFeedbackDao {
	
	/**
	 * 家长端-根据日期获取作业反馈
	 */
	HomeworkFeedback getByDate(HomeworkFeedback model);

	/**
	 * 老师端-根据日期获取作业反馈列表
	 */
	List<HomeworkFeedback> findByDate(HomeworkFeedback model);
	
	/**
	 * 家长端-家长反馈
	 */
	HomeworkFeedback insert(HomeworkFeedback model);

	/**
	 * PC-根据布置作业日期获取学生家长反馈信息
	 */
	List<HomeworkFeedback> findHormworkFeedback(HomeworkFeedback model);
	
	/**
	 * 老师端-作业反馈统计
	 */
	List<HomeworkFeedback> findConditionCount(HomeworkFeedback model);
	
}
