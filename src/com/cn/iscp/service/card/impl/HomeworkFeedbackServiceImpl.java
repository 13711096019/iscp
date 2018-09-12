package com.cn.iscp.service.card.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.HomeworkFeedbackDao;
import com.cn.iscp.entity.card.HomeworkFeedback;
import com.cn.iscp.service.card.ince.HomeworkFeedbackService;

@Service("homeworkFeedbackService")
public class HomeworkFeedbackServiceImpl implements HomeworkFeedbackService {
	
	@Resource
	private HomeworkFeedbackDao homeworkFeedbackDao;

	@Override
	public HomeworkFeedback getByDate(HomeworkFeedback model) {
		return homeworkFeedbackDao.getByDate(model);
	}

	@Override
	public List<HomeworkFeedback> findByDate(HomeworkFeedback model) {
		return homeworkFeedbackDao.findByDate(model);
	}

	@Override
	public HomeworkFeedback insert(HomeworkFeedback model) {
		return homeworkFeedbackDao.insert(model);
	}

	@Override
	public List<HomeworkFeedback> findHormworkFeedback(HomeworkFeedback model) {
		return homeworkFeedbackDao.findHormworkFeedback(model);
	}

	@Override
	public List<HomeworkFeedback> findConditionCount(HomeworkFeedback model) {
		return homeworkFeedbackDao.findConditionCount(model);
	}

}
