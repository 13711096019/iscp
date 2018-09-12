package com.cn.iscp.service.card.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.CensusClassDao;
import com.cn.iscp.entity.card.CensusClass;
import com.cn.iscp.service.card.ince.CensusClassService;

@Service("censusClassService")
public class CensusClassServiceImpl implements CensusClassService{
	
	@Resource
	private CensusClassDao censusClassDao;

	@Override
	public CensusClass getClassCensus(Long classNum) {
		return censusClassDao.getClassCensus(classNum);
	}

	@Override
	public void censusClassCensus() {
		censusClassDao.censusClassCensus();
	}
	
}
