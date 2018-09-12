package com.cn.iscp.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.ClassDao;
import com.cn.iscp.entity.base.Class;
import com.cn.iscp.service.base.ince.ClassService;

@Service("classService")
public class ClassServiceImpl implements ClassService {
	
	@Resource
	private ClassDao classDao;

	@Override
	public Class findById(Long classId) {
		return classDao.findById(classId);
	}
	
	@Override
	public Class findByEntity(Long classEntityId){
		return classDao.findByEntity(classEntityId);
	}

	@Override
	public Class findByNum(Integer classNum) {
		return classDao.findByNum(classNum);
	}

	@Override
	public Class findFinal(Long gradeId){
		return classDao.findFinal(gradeId);
	}

	@Override
	public List<Class> findByGrade(Long gradeId) {
		return classDao.findByGrade(gradeId);
	}

	@Override
	public boolean insert(Class model) {
		return classDao.insert(model);
	}

	@Override
	public boolean update(Class model) {
		return classDao.update(model);
	}

}
