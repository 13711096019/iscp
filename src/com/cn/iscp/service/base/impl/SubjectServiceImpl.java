package com.cn.iscp.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.SubjectDao;
import com.cn.iscp.entity.base.Subject;
import com.cn.iscp.service.base.ince.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	
	@Resource 
	private SubjectDao subjectDao;
	
	@Override
	public List<Subject> findPage(Map<String, Object> map) {
		return subjectDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return subjectDao.getPageCount(map);
	}

	@Override
	public Subject findById(Long subjectId) {
		return subjectDao.findById(subjectId);
	}

	@Override
	public Subject findFinal(){
		return subjectDao.findFinal();
	}

	@Override
	public List<Subject> findAll() {
		return subjectDao.findAll();
	}

	@Override
	public List<Subject> findByExem() {
		return subjectDao.findByExem();
	}
	
	@Override
	public List<Subject> findByGrade(Long gradeId){
		return subjectDao.findByGrade(gradeId);
	}

	@Override
	public boolean insert(Subject model) {
		return subjectDao.insert(model);
	}

	@Override
	public boolean update(Subject model) {
		return subjectDao.update(model);
	}

	@Override
	public List<Subject> findSubjectByTeacher(Long gradeId, Long teacherId, Integer isTotal) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gradeId", gradeId);
		map.put("teacherId", teacherId);
		map.put("isTotal", isTotal);
		return subjectDao.findSubjectByTeacher(map);
	}

}
