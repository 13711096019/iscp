package com.cn.iscp.service.ligent.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.ligent.UpgradeDao;
import com.cn.iscp.service.ligent.ince.UpgradeService;

@Service("upgradeService")
public class UpgradeServiceImpl implements UpgradeService {
	
	@Resource
	private UpgradeDao upgradeDao;
	
	@Override
	public void bindingBasicInfo() {
		upgradeDao.bindingBasicInfo();
	}
	
	@Override
	public void handleStudentInfo(Map<String, Object> map) {
		upgradeDao.handleStudentInfo(map);
	}
	
	@Override
	public void censusHavingInfo() {
		upgradeDao.censusHavingInfo();
	}
	
}
