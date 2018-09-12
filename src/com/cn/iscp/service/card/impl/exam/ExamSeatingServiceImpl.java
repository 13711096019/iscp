package com.cn.iscp.service.card.impl.exam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.exam.ExamSeatingDao;
import com.cn.iscp.entity.card.exam.ExamSeating;
import com.cn.iscp.service.card.ince.exam.ExamSeatingService;

@Service("examSeatingService")
public class ExamSeatingServiceImpl implements ExamSeatingService {
	
	@Resource
	private ExamSeatingDao examSeatingDao;
	
	@Override
	public List<ExamSeating> findByClass(ExamSeating model) {
		return examSeatingDao.findByClass(model);
	}

	@Override
	public void handleSeatingChart(ExamSeating model) {
		examSeatingDao.handleSeatingChart(model);
	}

}
