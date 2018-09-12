package com.cn.iscp.service.pay.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeItemDao;
import com.cn.iscp.entity.pay.ChargeItem;
import com.cn.iscp.entity.pay.ChargeSeating;
import com.cn.iscp.service.pay.ince.ChargeItemService;

@Service("chargeItemService")
public class ChargeItemServiceImpl implements ChargeItemService{
	
	@Resource
	private ChargeItemDao chargeItemDao;

	@Override
	public List<ChargeItem> findByOrder(ChargeSeating model) {
		return chargeItemDao.findByOrder(model);
	}

	@Override
	public List<ChargeItem> findPage(Map<String, Object> map) {
		return chargeItemDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return chargeItemDao.getPageCount(map);
	}

	@Override
	public ChargeItem findById(Long chargeitemId) {
		return chargeItemDao.findById(chargeitemId);
	}

	@Override
	public boolean update(ChargeItem model) {
		return chargeItemDao.update(model);
	}

	@Override
	public boolean insert(ChargeItem model) {
		return chargeItemDao.insert(model);
	}

	
}
