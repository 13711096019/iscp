package com.cn.iscp.service.pay.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.pay.ChargeSeatingDao;
import com.cn.iscp.entity.pay.ChargeSeating;
import com.cn.iscp.service.pay.ince.ChargeSeatingService;

@Service("chargeSeatingService")
public class ChargeSeatingServiceImpl implements ChargeSeatingService {

	@Resource
	private ChargeSeatingDao chargeSeatingDao;

	@Override
	public List<ChargeSeating> findByStudent(ChargeSeating model) {
		return chargeSeatingDao.findByStudent(model);
	}

	@Override
	public List<ChargeSeating> findPage(Map<String, Object> map) {
		return chargeSeatingDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return chargeSeatingDao.getPageCount(map);
	}

	@Override
	public ChargeSeating findById(Long seatingId) {
		return chargeSeatingDao.findById(seatingId);
	}

	@Override
	public ChargeSeating findparticularsById(Long studentId, Long orderId) {
		return chargeSeatingDao.findparticularsById(studentId, orderId);
	}

	@Override
	public ChargeSeating findstudentById(Long studentId) {
		return chargeSeatingDao.findstudentById(studentId);
	}

}
