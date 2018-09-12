package com.cn.iscp.service.card.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.HomeworkDao;
import com.cn.iscp.dao.dbase.ClassMgrDao;
import com.cn.iscp.entity.card.Homework;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.card.ince.HomeworkService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;

@Service("homeworkService")
public class HomeworkServiceImpl implements HomeworkService {
	
	@Resource
	private HomeworkDao homeworkDao;
	@Resource
	private ClassMgrDao classMgrDao;

	@Override
	public Homework findById(Long homeworkId) {
		return homeworkDao.findById(homeworkId);
	}

	@Override
	public List<Map<String, Object>> findHomeworkWeek(Long classNum) {
		List<Homework> gsList = homeworkDao.findHomeworkWeek(classNum);
		if(gsList == null || gsList.size() < 1){
			return null;
		}
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapList = new HashMap<String, Object>();
		List<Homework> homeList = new ArrayList<Homework>();
		
		String dateOld = gsList.get(0).getStudyDate();
		String dateNew = null;
		for (Homework homework : gsList) {
			dateNew = homework.getStudyDate();
			if(dateNew.equals(dateOld)){
				homeList.add(homework);
			}else{
				mapList.put("studyDate", dateOld);
				mapList.put("homeList", homeList);
				list.add(mapList);
				
				// 下一轮
				mapList = new HashMap<String, Object>();
				homeList = new ArrayList<Homework>();
				homeList.add(homework);
				dateOld = dateNew;
			}
		}
		mapList.put("studyDate", dateNew);
		mapList.put("homeList", homeList);
		list.add(mapList);
		return list;
	}

	@Override
	public List<Homework> getHomeworkToday(Long classNum) {
		return homeworkDao.getHomeworkToday(classNum);
	}

	@Override
	public List<Homework> findHomeworkByNewly(Long classNum) {
		return homeworkDao.findHomeworkByNewly(classNum);
	}

	@Override
	public List<Homework> findHormworkByDate(Homework model) {
		return homeworkDao.findHormworkByDate(model);
	}

	@Override
	public boolean handleHomework(Homework model) {
		boolean revert = homeworkDao.handleHomework(model).intValue() > 0;
		if(revert){
			// 推送到终端
			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, model.getClassNum(), PushCode.CLASS_HOMEWORK);
			jdpust.buildPushNotAlert();
		}
		return revert;
	}

	@Override
	public StateModel updateCheckCount(Homework model) {
		return homeworkDao.updateCheckCount(model);
	}

	@Override
	public List<Homework> findByTeacher(Homework model) {
		return homeworkDao.findByTeacher(model);
	}

	@Override
	public List<Map<String, Object>> findCheckPatriarch(Long homeworkId, Integer mark) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("homeworkId", homeworkId);
		map.put("mark", mark);
		return homeworkDao.findCheckPatriarch(map);
	}

}
