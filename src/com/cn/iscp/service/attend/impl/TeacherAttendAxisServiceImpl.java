package com.cn.iscp.service.attend.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.TeacherAttendAxisDao;
import com.cn.iscp.entity.attend.TeacherAttendAxis;
import com.cn.iscp.service.attend.ince.TeacherAttendAxisService;

@Service("teacherAttendAxisService")
public class TeacherAttendAxisServiceImpl implements TeacherAttendAxisService {
	
	@Resource
	private TeacherAttendAxisDao teacherAttendAxisDao;
	
	@Override
	public List<TeacherAttendAxis> findByShift(Long shiftId) {
		return teacherAttendAxisDao.findByShift(shiftId);
	}
	
}
