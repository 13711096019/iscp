package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.SessionDao;
import com.cn.iscp.entity.base.Session;
import com.cn.iscp.service.base.ince.SessionService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {
	
	@Resource
	private SessionDao sessionDao;

	@Override
	public List<Session> findPage(Map<String, Object> map) {
		return sessionDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return sessionDao.getPageCount(map);
	}

	@Override
	public Session findById(Long sessionId) {
		return sessionDao.findById(sessionId);
	}

	@Override
	public Session findFinal() {
		return sessionDao.findFinal();
	}

	@Override
	public List<Session> findAll() {
		return sessionDao.findAll();
	}

	@Override
	public boolean insert(Session model) {
		return sessionDao.insert(model);
	}

	@Override
	public boolean update(Session model) {
		return sessionDao.update(model);
	}

}
