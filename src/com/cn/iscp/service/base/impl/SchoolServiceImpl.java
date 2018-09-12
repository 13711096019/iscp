package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.SchoolDao;
import com.cn.iscp.entity.base.School;
import com.cn.iscp.service.base.ince.SchoolService;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService{
	
	@Resource
	private SchoolDao schoolDao;
	
	@Override
	public List<School> findPage(Map<String, Object> map) {
		return schoolDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return schoolDao.getPageCount(map);
	}

	@Override
	public School findById(Long userId) {
		return schoolDao.findById(userId);
	}

	@Override
	public boolean insert(School model) {
		return schoolDao.insert(model);
	}

	@Override
	public boolean update(School model) {
		return schoolDao.update(model);
	}

}
