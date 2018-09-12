package com.cn.iscp.service.card.impl.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.exam.ExamPaperDao;
import com.cn.iscp.dao.card.exam.ExamScoreDao;
import com.cn.iscp.dao.dbase.ClassEntityDao;
import com.cn.iscp.dao.ligent.PushDao;
import com.cn.iscp.entity.card.exam.ExamPaper;
import com.cn.iscp.entity.card.exam.ExamScoreInput;
import com.cn.iscp.entity.dbase.ClassEntity;
import com.cn.iscp.entity.dbase.ClassEntityUpgrade;
import com.cn.iscp.model.ExamScore;
import com.cn.iscp.service.card.ince.exam.ExamScoreService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("examScoreService")
public class ExamScoreServiceImpl implements ExamScoreService {
	
	@Resource
	private ExamScoreDao examScoreDao;
	@Resource
	private ExamPaperDao examPaperDao;
	@Resource
	private ClassEntityDao classEntityDao;
	@Resource
	private PushDao pushDao;

	@Override
	public List<ExamScoreInput> findExamScore(Long examPaperId, Long classNum) {
		ClassEntityUpgrade model = new ClassEntityUpgrade(classNum, null);
		ClassEntity classes = classEntityDao.getClassEntityByKeyId(model);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("examPaperId", examPaperId);
		map.put("classEntityId", classes.getClassEntityId());
		return examScoreDao.findExamScore(map);
	}

	@Override
	public void handleExamScore(ExamScoreInput model) {
		// 处理学生成绩
		examScoreDao.handleExamScore(model);
		// 获取该试卷的年级编号
		ExamPaper exam = examPaperDao.findById(model.getExamPaperId());
		// 根据年级推送所有班牌机器码
		BasePushTimed.PushMachine(PushCode.EXAM_RESULT, false, exam.getGradeId(), null);
	}

	@Override
	public List<ExamScore> findRankingStudent(Long classNum) {
		return examScoreDao.findRankingStudent(classNum);
	}

}
