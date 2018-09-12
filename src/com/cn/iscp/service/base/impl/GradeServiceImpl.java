package com.cn.iscp.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.iscp.dao.base.GradeDao;
import com.cn.iscp.dao.dbase.ClassEntityDao;
import com.cn.iscp.entity.base.Grade;
import com.cn.iscp.service.base.ince.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {
	
	@Resource
	private GradeDao gradeDao;
	@Resource
	private ClassEntityDao classEntityDao;

	@Override
	public Grade findById(Long userId) {
		return gradeDao.findById(userId);
	}

	@Override
	public Grade findFinal(){
		return gradeDao.findFinal();
	}

	@Override
	public List<Grade> findAll() {
		return gradeDao.findAll();
	}
	
	@Override
	public List<Grade> findBySection(String gradeSection) {
		return gradeDao.findBySection(gradeSection);
	}

	/*@Override
	public List<Grade> findBySchool(Long schoolId) {
		return gradeDao.findBySchool(schoolId);
	}*/
	
	@Override
	public void handleGradeSubject(Long gradeId, String[] idArray){
		StringBuffer ids = new StringBuffer();
		if(idArray != null && idArray.length > 0){
			for (String subjectId : idArray) {
				if(_Tool.isInt(subjectId)){
					ids.append(subjectId);
					ids.append(",");
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gradeId", gradeId);
		map.put("subjectIds", ids.toString());
		map.put("flagtime", System.currentTimeMillis());
		gradeDao.handleGradeSubject(map);
	}

	@Override
	public boolean insert(Grade model) {
		return gradeDao.insert(model);
	}

	@Override
	public boolean update(Grade model) {
		return gradeDao.update(model);
	}

	@Override
	public List<Grade> findAllClass() {
		List<Grade> gradeList = gradeDao.findAll();
		for (Grade grade : gradeList) {
			grade.setClassList(classEntityDao.findByGrade(grade.getGradeId()));
		}
		return gradeList;
	}

	@Override
	public List<Grade> findGradeByTeacher(Long teacherId, Integer isTotal) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teacherId", teacherId);
		map.put("isTotal", isTotal);
		return gradeDao.findGradeByTeacher(map);
	}

}
