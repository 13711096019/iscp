package com.cn.iscp.service.card.impl.exam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.exam.ExamInfoDao;
import com.cn.iscp.entity.card.exam.ExamInfo;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.card.ince.exam.ExamInfoService;

@Service("examInfoService")
public class ExamInfoServiceImpl implements ExamInfoService {
	
	@Resource
	private ExamInfoDao examInfoDao;

	@Override
	public List<ExamInfo> findAll(Long userId) {
		return examInfoDao.findAll(userId);
	}

	@Override
	public ExamInfo findById(Long examInfoId) {
		return examInfoDao.findById(examInfoId);
	}

	@Override
	public Integer judgeRepeat(ExamInfo model) {
		return examInfoDao.judgeRepeat(model).intValue();
	}

	@Override
	public ExamInfo insertExamInfo(ExamInfo model) {
		return examInfoDao.insertExamInfo(model);
	}

	@Override
	public StateModel deleteExamInfo(Long examInfoId) {
		return examInfoDao.deleteExamInfo(examInfoId);
	}

}
