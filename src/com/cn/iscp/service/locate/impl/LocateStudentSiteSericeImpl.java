package com.cn.iscp.service.locate.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.locate.LocateStudentSiteDao;
import com.cn.iscp.entity.locate.LocateStudentSite;
import com.cn.iscp.service.locate.ince.LocateStudentSiteSerice;

@Service("locateStudentSiteSerice")
public class LocateStudentSiteSericeImpl implements LocateStudentSiteSerice {
	
	@Resource
	private LocateStudentSiteDao locateStudentSiteDao;
	
	@Override
	public List<LocateStudentSite> findByBus(Long busId) {
		return locateStudentSiteDao.findByBus(busId);
	}

}
