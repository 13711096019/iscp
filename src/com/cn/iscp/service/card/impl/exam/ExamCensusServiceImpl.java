package com.cn.iscp.service.card.impl.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.exam.ExamCensusDao;
import com.cn.iscp.entity.card.exam.ExamCensusClass;
import com.cn.iscp.entity.card.exam.ExamCensusGrade;
import com.cn.iscp.service.card.ince.exam.ExamCensusService;

@Service("examCensusService")
public class ExamCensusServiceImpl implements ExamCensusService {
	
	@Resource
	private ExamCensusDao examCensusDao;

	@Override
	public ExamCensusClass getClassByExamPaperId(Long examPaperId, Long classNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("examPaperId", examPaperId);
		map.put("classNum", classNum);
		return examCensusDao.getClassByExamPaperId(map);
	}

	/*@Override
	public List<ExamCensusClass> examResultConsult(Map<String, Object> map) {
		return examCensusDao.examResultConsult(map);
	}*/

	@Override
	public List<ExamCensusClass> findRankingClass(Map<String, Object> map) {
		return examCensusDao.findRankingClass(map);
	}
	
	
	
	

	@Override
	public ExamCensusGrade getGradeByExamPaperId(Long examPaperId) {
		return examCensusDao.getGradeByExamPaperId(examPaperId);
	}

	@Override
	public void examResultStatistic(Long examPaperId) {
		examCensusDao.examResultStatistic(examPaperId);
	}

}
