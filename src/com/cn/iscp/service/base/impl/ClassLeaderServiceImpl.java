package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.ClassleaderDao;
import com.cn.iscp.entity.base.Classleader;
import com.cn.iscp.service.base.ince.ClassLeaderService;

@Service("classleaderService")
public class ClassLeaderServiceImpl implements ClassLeaderService {
	
	@Resource
	private ClassleaderDao classleaderDao;

	@Override
	public List<Classleader> findPage(Map<String, Object> map) {
		return classleaderDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return classleaderDao.getPageCount(map);
	}

	@Override
	public Classleader findById(Long classleaderId) {
		return classleaderDao.findById(classleaderId);
	}

	@Override
	public Classleader findFinal() {
		return classleaderDao.findFinal();
	}

	@Override
	public boolean insert(Classleader model) {
		return classleaderDao.insert(model);
	}

	@Override
	public boolean update(Classleader model) {
		return classleaderDao.update(model);
	}
}
