package com.cn.iscp.service.card.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.ClockOndayClassDao;
import com.cn.iscp.entity.card.ClockOndayClass;
import com.cn.iscp.service.card.ince.ClockOndayClassService;

@Service("clockOndayClassService")
public class ClockOndayClassServiceImpl implements ClockOndayClassService {
	
	@Resource
	private ClockOndayClassDao clockOndayClassDao;

	@Override
	public ClockOndayClass findByDate(ClockOndayClass model) {
		return clockOndayClassDao.findByDate(model);
	}

	@Override
	public List<ClockOndayClass> findByLastMonth(Long classNum) {
		return clockOndayClassDao.findByLastMonth(classNum);
	}

	@Override
	public ClockOndayClass censusClassAttendance(ClockOndayClass model) {
		return clockOndayClassDao.censusClassAttendance(model);
	}

	@Override
	public Integer handleClassClockonday() {
		return clockOndayClassDao.handleClassClockonday();
	}

}
