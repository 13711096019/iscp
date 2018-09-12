package com.cn.iscp.service.card.impl.exam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.exam.ExamSeatingTempDao;
import com.cn.iscp.entity.card.exam.ExamSeatingTemp;
import com.cn.iscp.service.card.ince.exam.ExamSeatingTempService;

@Service("examSeatingTempService")
public class ExamSeatingTempServiceImpl implements ExamSeatingTempService {
	
	@Resource ExamSeatingTempDao examSeatingTempDao;
	
	@Override
	public List<ExamSeatingTemp> findAll(Long userId) {
		return examSeatingTempDao.findAll(userId);
	}

	@Override
	public ExamSeatingTemp findById(Long tempId) {
		return examSeatingTempDao.findById(tempId);
	}

	@Override
	public List<ExamSeatingTemp> findByGrade(Long gradeId) {
		return examSeatingTempDao.findByGrade(gradeId);
	}

	@Override
	public ExamSeatingTemp insertExamSeatingTemp(ExamSeatingTemp model) {
		return examSeatingTempDao.insertExamSeatingTemp(model);
	}

	@Override
	public ExamSeatingTemp updateExamSeatingTemp(ExamSeatingTemp model) {
		return examSeatingTempDao.updateExamSeatingTemp(model);
	}

}
