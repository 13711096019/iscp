package com.cn.iscp.service.locate.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.locate.LocateTeacherBusDao;
import com.cn.iscp.entity.locate.LocateTeacherBus;
import com.cn.iscp.service.locate.ince.LocateTeacherBusSerice;

@Service("locateTeacherBusSerice")
public class LocateTeacherBusSericeImpl implements LocateTeacherBusSerice {
	
	@Resource
	private LocateTeacherBusDao locateTeacherBusDao;
	
	@Override
	public LocateTeacherBus findByBus(Long busId) {
		return locateTeacherBusDao.findByBus(busId);
	}

}
