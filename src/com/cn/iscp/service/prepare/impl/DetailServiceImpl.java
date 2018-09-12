package com.cn.iscp.service.prepare.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.prepare.DetailDao;
import com.cn.iscp.entity.prepare.Detail;
import com.cn.iscp.service.prepare.ince.DetailService;

@Service("detailService")
public class DetailServiceImpl implements DetailService{
	
	@Resource
	private DetailDao detailDao;

	@Override
	public Detail insertDetail(Detail model) {
		return detailDao.insertDetail(model);
	}

	@Override
	public Detail updateDetail(Detail model) {
		return detailDao.updateDetail(model);
	}
	
	@Override
	public Detail findByTopic(Long topicId) {
		return detailDao.findByTopic(topicId);
	}

	@Override
	public Detail handlePrepareClassInfo(Detail model) {
		return detailDao.handlePrepareClassInfo(model);
	}

	@Override
	public boolean updateDetailStatus(Detail model) {
		return detailDao.updateDetailStatus(model);
	}
	
	

	@Override
	public List<Detail> findPage(Map<String, Object> map) {
		return detailDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return detailDao.getPageCount(map);
	}

	@Override
	public Detail findById(Long detailId) {
		return detailDao.findById(detailId);
	}

	@Override
	public boolean insert(Detail model) {
		return detailDao.insert(model);
	}

	@Override
	public boolean update(Detail model) {
		return detailDao.update(model);
	}

	@Override
	public void handleDetail(Detail model) {
		detailDao.handleDetail(model);
	}

}
