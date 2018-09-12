package com.cn.iscp.service.pay.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeTypeDao;
import com.cn.iscp.entity.pay.ChargeType;
import com.cn.iscp.service.pay.ince.ChargeTypeService;

@Service("chargeTypeService")
public class ChargeTypeServiceImpl implements ChargeTypeService{
	
	@Resource
	private ChargeTypeDao chargeTypeDao;

	@Override
	public List<ChargeType> findPage(Map<String, Object> map) {
		return chargeTypeDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return chargeTypeDao.getPageCount(map);
	}

	@Override
	public ChargeType findById(Long chargetypeId) {
		return chargeTypeDao.findById(chargetypeId);
	}

	@Override
	public boolean insert(ChargeType model) {
		return chargeTypeDao.insert(model);
	}

	@Override
	public boolean update(ChargeType model) {
		return chargeTypeDao.update(model);
	}

	@Override
	public List<ChargeType> findAll() {
		return chargeTypeDao.findAll();
	}

	@Override
	public List<ChargeType> findorderById(Long orderId) {
		return chargeTypeDao.findorderById(orderId);
	}

}
