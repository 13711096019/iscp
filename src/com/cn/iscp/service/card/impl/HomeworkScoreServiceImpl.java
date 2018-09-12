package com.cn.iscp.service.card.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.HomeworkScoreDao;
import com.cn.iscp.entity.card.HomeworkScore;
import com.cn.iscp.service.card.ince.HomeworkScoreService;

@Service("homeworkScoreService")
public class HomeworkScoreServiceImpl implements HomeworkScoreService {
	
	@Resource
	private HomeworkScoreDao homeworkScoreDao;

	@Override
	public boolean handleHomeworkScore(HomeworkScore model) {
		return false;
	}

}
