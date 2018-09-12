package com.cn.iscp.service.ligent.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.ligent.LoginLogDao;
import com.cn.iscp.entity.ligent.LoginLog;
import com.cn.iscp.model.Artascope;
import com.cn.iscp.service.ligent.ince.LoginLogService;

@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
	
	@Resource
	private LoginLogDao loginLogDao;

	@Override
	public void handleLoginLog(Long userId, Integer logType) {
		LoginLog log = new LoginLog(userId, logType);
		loginLogDao.handleLoginLog(log);
	}

	@Override
	public Artascope findOnlineCount() {
		return loginLogDao.findOnlineCount();
	}

}
