package com.cn.iscp.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.ResearchDao;
import com.cn.iscp.entity.task.Research;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.task.ince.ResearchService;
import com.cn.unit.executor.push.phone.ExecutorResearch;

@Service("researchService")
public class ResearchServiceImpl implements ResearchService {
	
	@Resource
	private ResearchDao researchDao;

	@Override
	public List<Research> findByPage(Research model) {
		return researchDao.findByPage(model);
	}

	@Override
	public List<Research> findByTeacher(Research model) {
		return researchDao.findByTeacher(model);
	}

	@Override
	public Research findById(Long researchId) {
		return researchDao.findById(researchId);
	}
	
	@Override
	public Research insertResearch(Research model) {
		model = researchDao.insertResearch(model);
		// 推送
		// PhonePushTimed.PushResearchTeacher(model.getResearchId(), model.getCreateUserId(), true);
		ExecutorResearch executor = new ExecutorResearch(model.getResearchId(), model.getCreateUserId(), true);
		try {
			executor.asynTask();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public Research updateResearchPic(Research model) {
		return researchDao.updateResearchPic(model);
	}

	@Override
	public StateModel handleResearch(Research model) {
		StateModel stateModel = researchDao.handleResearch(model);
		if(stateModel.getStatusCode().intValue()==1){
			// 推送
			//PhonePushTimed.PushResearchTeacher(model.getResearchId(), model.getCreateUserId(), true);
			ExecutorResearch executor = new ExecutorResearch(model.getResearchId(), model.getCreateUserId(), true);
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return stateModel;
	}

	@Override
	public StateModel deleteResearch(Research model) {
		StateModel stateModel = researchDao.deleteResearch(model);
		if(stateModel.getStatusCode().intValue()==1){
			// 推送
			// PhonePushTimed.PushResearchTeacher(model.getResearchId(), null, false);
			ExecutorResearch executor = new ExecutorResearch(model.getResearchId(), null, false);
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return stateModel;
	}

}
