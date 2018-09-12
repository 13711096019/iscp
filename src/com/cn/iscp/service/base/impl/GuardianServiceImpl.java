package com.cn.iscp.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.GuardianDao;
import com.cn.iscp.entity.base.Guardian;
import com.cn.iscp.service.base.ince.GuardianService;

@Service("GuardianService")
public class GuardianServiceImpl implements GuardianService {
	@Resource
	private GuardianDao guardianDao;

	@Override
	public List<Guardian> findByStudent(Long studentId) {
		return guardianDao.findByStudent(studentId);
	}

}
