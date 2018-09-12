package com.cn.iscp.service.attend.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.TeacherAttendReviseDao;
import com.cn.iscp.entity.attend.TeacherAttendRevise;
import com.cn.iscp.service.attend.ince.TeacherAttendReviseService;

@Service("teacherAttendReviseService")
public class TeacherAttendReviseServiceImpl implements TeacherAttendReviseService {
	
	@Resource
	private TeacherAttendReviseDao teacherAttendReviseDao;

	@Override
	public List<TeacherAttendRevise> findByPage(TeacherAttendRevise model) {
		return teacherAttendReviseDao.findByPage(model);
	}

	@Override
	public List<TeacherAttendRevise> findByRecord(Long recordId) {
		return teacherAttendReviseDao.findByRecord(recordId);
	}

	@Override
	public TeacherAttendRevise insertRevise(TeacherAttendRevise model) {
		return teacherAttendReviseDao.insertRevise(model);
	}

	@Override
	public TeacherAttendRevise checkRevise(TeacherAttendRevise model) {
		return teacherAttendReviseDao.checkRevise(model);
	}

}
