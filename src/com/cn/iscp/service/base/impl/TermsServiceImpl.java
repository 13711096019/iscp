package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.TermsDao;
import com.cn.iscp.entity.base.Terms;
import com.cn.iscp.service.base.ince.TermsService;

@Service("termsService")
public class TermsServiceImpl implements TermsService {
	
	@Resource
	private TermsDao termsDao;
	
	@Override
	public List<Terms> findPage(Map<String, Object> map) {
		return termsDao.findPage(map);
	}
	
	@Override
	public Long getPageCount(Map<String, Object> map) {
		return termsDao.getPageCount(map);
	}
	
	@Override
	public Terms findById(Long termId) {
		return termsDao.findById(termId);
	}
	
	@Override
	public Terms findFinal() {
		return termsDao.findFinal();
	}
	
	@Override
	public boolean insert(Terms model) {
		return termsDao.insert(model);
	}
	
	@Override
	public boolean update(Terms model) {
		return termsDao.update(model);
	}

	@Override
	public List<Terms> findAll() {
		return termsDao.findAll();
	}
	
}
