package com.cn.iscp.service.prepare.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.GradeDao;
import com.cn.iscp.dao.base.SubjectDao;
import com.cn.iscp.dao.prepare.TopicDao;
import com.cn.iscp.entity.base.Grade;
import com.cn.iscp.entity.base.Subject;
import com.cn.iscp.entity.prepare.Topic;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.iscp.service.prepare.ince.TopicService;

@Service("topicService")
public class TopicServiceImpl extends BaseSericel implements TopicService {
	
	@Resource
	private TopicDao topicDao;
	@Resource
	private GradeDao gradeDao;
	@Resource
	private SubjectDao subjectDao;
	
	@Override
	public List<Topic> findByGrade(Topic model) {
		return topicDao.findByGrade(model);
	}

	@Override
	public List<Topic> findMyTopicByGrade(Topic model) {
		return topicDao.findMyTopicByGrade(model);
	}
	
	@Override
	public List<Grade> findTopicByTeacher(Long teacherId, boolean isMyDraft, boolean isMyPlan, Integer isTotal) {
		List<Grade> gradeList = new ArrayList<Grade>();
		Topic topic = null;
		Long gradeId = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teacherId", teacherId);
		map.put("isTotal", isTotal);
		List<Grade> list = gradeDao.findGradeByTeacher(map);
		
		List<Subject> subjectList = null;
		for (Grade item : list) {
			gradeId = item.getGradeId();
			map.put("gradeId", gradeId);
			subjectList = subjectDao.findSubjectByTeacher(map);
			for (Subject subject : subjectList) {
				topic = new Topic(gradeId, subject.getSubjectId());
				if(isMyDraft){
					// 我备课的课题列表
					topic.setDraftTeacherId(teacherId);
					subject.setTopicList(this.findMyTopicByGrade(topic));
				} else if (isMyPlan){
					// 我个人的课题列表
					topic.setDraftTeacherId(teacherId);
					subject.setTopicList(topicDao.findByTeacher(topic));
				} else {
					// 所有课题列表
					subject.setTopicList(this.findByGrade(topic));
				}
			}
			gradeList.add(new Grade(gradeId, item.getGradeName(), subjectList));
		}
		return gradeList;
	}

	@Override
	public PageModel findTopiByPage(Map<String, Object> map) {
		List<List<?>> list = topicDao.findTopiByPage(map);
		return getMapByPage(list);
	}
	
	@Override
	public Topic findById(Long topicId) {
		return topicDao.findById(topicId);
	}
	
	@Override
	public boolean insert(Topic model) {
		return topicDao.insert(model);
	}
	
	@Override
	public boolean update(Topic model) {
		return topicDao.update(model);
	}

	@Override
	public boolean updateFlagtime(Topic model) {
		return topicDao.updateFlagtime(model);
	}

	@Override
	public boolean deleteByContent(Long topicId) {
		return topicDao.deleteByContent(topicId);
	}
	
}
