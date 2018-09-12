package com.cn.iscp.service.locate.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.locate.LocateBusDao;
import com.cn.iscp.dao.locate.LocateBusSiteDao;
import com.cn.iscp.entity.locate.LocateBus;
import com.cn.iscp.entity.locate.LocateBusSite;
import com.cn.iscp.service.locate.ince.LocateBusSiteSerice;

@Service("locateBusSiteSerice")
public class LocateBusSiteSericeImpl implements LocateBusSiteSerice {

	@Resource
	private LocateBusSiteDao locateBusSiteDao;
	@Resource
	private LocateBusDao locateBusDao;

	@Override
	public LocateBusSite findById(Long siteId) {
		return locateBusSiteDao.findById(siteId);
	}

	@Override
	public List<LocateBus> findAll() {
		List<LocateBus> busList = locateBusDao.findAll();
		for (LocateBus bus : busList) {
			bus.setSiteList(locateBusSiteDao.findByBus(bus.getBusId()));
		}
		return busList;
	}

	@Override
	public List<LocateBusSite> findPage(Map<String, Object> map) {
		return locateBusSiteDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return locateBusSiteDao.getPageCount(map);
	}

	@Override
	public boolean update(LocateBusSite model) {
		return locateBusSiteDao.update(model);
	}

	@Override
	public boolean insert(LocateBusSite model) {
		return locateBusSiteDao.insert(model);
	}

	@Override
	public LocateBusSite findFinal() {
		return locateBusSiteDao.findFinal();
	}

}
