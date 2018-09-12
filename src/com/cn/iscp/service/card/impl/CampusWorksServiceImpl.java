package com.cn.iscp.service.card.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.CampusWorksDao;
import com.cn.iscp.entity.card.CampusWorks;
import com.cn.iscp.service.card.ince.CampusWorksService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

@Service("campusWorksService")
public class CampusWorksServiceImpl implements CampusWorksService {
	
	@Resource
	private CampusWorksDao campusWorksDao;

	@Override
	public List<CampusWorks> findCampusWorks(Integer getCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("getCount", getCount);
		return campusWorksDao.findCampusWorks(map);
	}

	@Override
	public List<CampusWorks> findPage(Map<String, Object> map) {
		return campusWorksDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		
		return campusWorksDao.getPageCount(map);
	}

	@Override
	public CampusWorks findById(Long worksId) {
	
		return campusWorksDao.findById(worksId);
	}

	@Override
	public List<CampusWorks> findByValid(Map<String, Object> map) {
		return campusWorksDao.findByValid(map);
	}

	@Override
	public boolean update(CampusWorks model) {
		boolean revert = campusWorksDao.update(model);
		if(revert){
			BasePushTimed.PushMachine(PushCode.CAMPUS_WORKS, false, null, null);
		}
		return revert;
	}

	@Override
	public boolean insert(CampusWorks model) {
		boolean revert = campusWorksDao.insert(model);
		if(revert){
			BasePushTimed.PushMachine(PushCode.CAMPUS_WORKS, false, null, null);
		}
		return revert;
	}

}
