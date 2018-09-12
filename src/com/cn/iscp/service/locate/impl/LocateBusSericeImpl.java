package com.cn.iscp.service.locate.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.locate.LocateBusDao;
import com.cn.iscp.dao.locate.LocateBusSiteDao;
import com.cn.iscp.entity.locate.LocateBus;
import com.cn.iscp.service.locate.ince.LocateBusSerice;

@Service("locateBusSericel")
public class LocateBusSericeImpl implements LocateBusSerice {

	@Resource
	private LocateBusDao locateBusDao;
	@Resource
	private LocateBusSiteDao locateBusSiteDao;

	@Override
	public LocateBus findById(Long busId) {
		return locateBusDao.findById(busId);
	}

	@Override
	public List<LocateBus> findAll() {
		return locateBusDao.findAll();
	}

	@Override
	public List<LocateBus> findPage(Map<String, Object> map) {
		return locateBusDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return locateBusDao.getPageCount(map);
	}

	@Override
	public boolean update(LocateBus model) {
		return locateBusDao.update(model);
	}

	@Override
	public boolean insert(LocateBus model) {
		return locateBusDao.insert(model);
	}

	@Override
	public LocateBus findFinal() {
		return locateBusDao.findFinal();
	}

}
