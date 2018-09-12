package com.cn.iscp.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.base.QualificationDao;
import com.cn.iscp.entity.base.Qualification;
import com.cn.iscp.service.base.ince.QualificationService;

@Service("qualificationService")
public class QualificationServiceImpl implements QualificationService {
	
	@Resource
	private QualificationDao qualificationDao;

	@Override
	public Qualification getQualification(Long teacherId) {
		return qualificationDao.getQualification(teacherId);
	}

	@Override
	public boolean handleQualification(Qualification model) {
		model.setStatus(_Const.STATE_ERROR);
		qualificationDao.update(model);
		model.setStatus(_Const.STATE_SUCCESS);
		return qualificationDao.insert(model);
	}

}
