package com.cn.iscp.service.card.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.CensusStudentDao;
import com.cn.iscp.entity.card.CensusStudent;
import com.cn.iscp.service.card.ince.CensusStudentService;

@Service("censusStudentService")
public class CensusStudentServiceImpl implements CensusStudentService {
	
	@Resource
	private CensusStudentDao censusStudentDao;

	@Override
	public CensusStudent getStudentCensus(Long studentId) {
		return censusStudentDao.getStudentCensus(studentId);
	}

	@Override
	public boolean update(CensusStudent model) {
		return censusStudentDao.update(model);
	}

	@Override
	public boolean insert(CensusStudent model) {
		return censusStudentDao.insert(model);
	}

}
