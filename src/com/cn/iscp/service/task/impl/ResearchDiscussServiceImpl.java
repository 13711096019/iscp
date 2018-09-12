package com.cn.iscp.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.task.ResearchDiscussDao;
import com.cn.iscp.entity.task.ResearchDiscuss;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.task.ince.ResearchDiscussService;
import com.cn.unit.executor.push.phone.ExecutorResearch;

@Service("researchDiscussService")
public class ResearchDiscussServiceImpl implements ResearchDiscussService {
	
	@Resource
	private ResearchDiscussDao researchDiscussDao;

	@Override
	public List<ResearchDiscuss> findByPage(ResearchDiscuss model) {
		return researchDiscussDao.findByPage(model);
	}

	@Override
	public List<ResearchDiscuss> findByGroup(ResearchDiscuss model) {
		List<ResearchDiscuss> paterList = researchDiscussDao.findByGroup(model);
		for (ResearchDiscuss item : paterList) {
			model.setDiscussId(item.getDiscussId());
			item.setChildList(researchDiscussDao.findByGroup(model));
		}
		return paterList;
	}
	
	@Override
	public List<ResearchDiscuss> findByResearch(ResearchDiscuss model) {
		return researchDiscussDao.findByResearch(model);
	}
	
	@Override
	public StateModel insertDiscuss(ResearchDiscuss model) {
		model = researchDiscussDao.insertDiscuss(model);
		StateModel stateModel = null;
		if(model != null){
			stateModel = new StateModel(model);
			// 推送
			// PhonePushTimed.PushResearchTeacher(model.getResearchId(), model.getDiscussUserId(), true);
			ExecutorResearch executor = new ExecutorResearch(model.getResearchId(), model.getDiscussUserId(), true);
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			stateModel = new StateModel("该讨论已经被删除！");
		}
		return stateModel;
	}

	@Override
	public StateModel deleteDiscuss(ResearchDiscuss model) {
		StateModel stateModel = researchDiscussDao.deleteDiscuss(model);
		if(stateModel.getStatusCode().intValue()==1){
			// 推送
			// PhonePushTimed.PushResearchTeacher(model.getResearchId(), null, true);
			ExecutorResearch executor = new ExecutorResearch(model.getResearchId(), null, true);
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return stateModel;
	}

}
