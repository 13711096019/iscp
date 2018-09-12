package com.cn.iscp.service.ligent.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.ligent.RemindDao;
import com.cn.iscp.entity.ligent.Remind;
import com.cn.iscp.service.ligent.ince.RemindService;

@Service("remindService")
public class RemindServiceImpl implements RemindService {
	
	@Resource
	private RemindDao remindDao;

	@Override
	public Remind getByRandom() {
		return remindDao.getByRandom();
	}

	@Override
	public Remind getByKey(String remindKey) {
		return remindDao.getByKey(remindKey);
	}

}
