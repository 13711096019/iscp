package com.cn.iscp.service.card.impl.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.ClassDao;
import com.cn.iscp.dao.card.exam.ExamDescSeatingDao;
import com.cn.iscp.dao.card.exam.ExamPaperDao;
import com.cn.iscp.dao.push.PatternDao;
import com.cn.iscp.entity.base.Class;
import com.cn.iscp.entity.card.exam.ExamDescSeating;
import com.cn.iscp.entity.card.exam.ExamPaper;
import com.cn.iscp.entity.push.Pattern;
import com.cn.iscp.service.card.ince.exam.ExamPaperService;

@Service("examPaperService")
public class ExamPaperServiceImpl implements ExamPaperService {
	
	@Resource
	private ExamPaperDao examPaperDao;
	@Resource
	private PatternDao patternDao;
	@Resource
	private ClassDao classDao;
	@Resource
	private ExamDescSeatingDao examDescSeatingDao;

	@Override
	public ExamPaper findById(Long examPaperId) {
		return examPaperDao.findById(examPaperId);
	}
	
	@Override
	public List<ExamPaper> findByInfo(Long examInfoId) {
		return examPaperDao.findByInfo(examInfoId);
	}

	@Override
	public ExamPaper updateExamPaper(ExamPaper model) {
		return examPaperDao.updateExamPaper(model);
	}

	@Override
	public ExamPaper getExamPatternInfo(Long classNum) {
		Pattern pattern = patternDao.getMostUrgentPattern(classNum);
		if(pattern == null){
			return null;
		}
		Long examPaperId = pattern.getExamPaperId();
		ExamPaper exam = examPaperDao.findById(examPaperId);
		if(exam != null){
			Class classes = classDao.findByClassNum(classNum);
			exam.setClassNo(classes.getClassAlias());
			ExamDescSeating model = new ExamDescSeating(pattern.getExamInfoId(), classNum);
			List<ExamDescSeating> list = examDescSeatingDao.findSeatingChart(model);
			exam.setSeatingList(list);
		}
		return exam;
	}

	@Override
	public Map<String, Object> getExamPatternInfos(Long classNum) {
		Pattern pattern = patternDao.getMostUrgentPattern(classNum);
		if(pattern == null){
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		Long examPaperId = pattern.getExamPaperId();
		ExamPaper exam = examPaperDao.findById(examPaperId);
		if(exam != null){
			map.put("examName", exam.getTitle());
			map.put("subjectName", exam.getSubjectName());
			map.put("examTime", exam.getExamTime());
			map.put("startTime", exam.getStartTime());
			map.put("endTime", exam.getEndTime());
			map.put("teachIds", exam.getMoniterTeach());
			Class classes = classDao.findByClassNum(classNum);
			map.put("classNo", classes.getClassAlias());
			ExamDescSeating model = new ExamDescSeating(pattern.getExamInfoId(), classNum);
			List<ExamDescSeating> list = examDescSeatingDao.findSeatingChart(model);
			map.put("seatingList", list);
		}
		return map;
	}

}
