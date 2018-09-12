package com.cn.iscp.service.card.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.ClassRegularDao;
import com.cn.iscp.entity.card.ClassRegular;
import com.cn.iscp.service.card.ince.ClassRegularService;

@Service("classRegularService")
public class ClassRegularServiceImpl implements ClassRegularService {
	
	@Resource
	private ClassRegularDao classRegularDao;

	@Override
	public ClassRegular findByClass(Long classNum) {
		return classRegularDao.findByClass(classNum);
	}

	@Override
	public ClassRegular handleClassRegular(ClassRegular model) {
		return classRegularDao.handleClassRegular(model);
	}

}
