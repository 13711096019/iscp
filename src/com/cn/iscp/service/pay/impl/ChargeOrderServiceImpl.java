package com.cn.iscp.service.pay.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeOrderDao;
import com.cn.iscp.entity.pay.ChargeOrder;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.pay.ince.ChargeOrderService;

@Service("chargeOrderService")
public class ChargeOrderServiceImpl implements ChargeOrderService{
	
	@Resource
	private ChargeOrderDao chargeOrderDao;

	@Override
	public StateModel insertOrder(ChargeOrder model) {
		return chargeOrderDao.insertOrder(model);
	}

	@Override
	public ChargeOrder updateOrder(ChargeOrder model) {
		return chargeOrderDao.updateOrder(model);
	}

	@Override
	public List<ChargeOrder> findPage(Map<String, Object> map) {
		return chargeOrderDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return chargeOrderDao.getPageCount(map);
	}

	@Override
	public ChargeOrder findById(Long orderId) {
		return chargeOrderDao.findById(orderId);
	}

	@Override
	public ChargeOrder getByStudent(Long studentId) {
		return chargeOrderDao.getByStudent(studentId);
	}

	@Override
	public boolean updateStatus(ChargeOrder model) {
		return chargeOrderDao.updateStatus(model);
	}

	@Override
	public Integer findpriceById(Long orderId) {
		return chargeOrderDao.findpriceById(orderId);
	}

}
