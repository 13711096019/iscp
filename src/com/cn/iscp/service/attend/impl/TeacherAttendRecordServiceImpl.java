package com.cn.iscp.service.attend.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.TeacherAttendRecordDao;
import com.cn.iscp.dao.attend.TeacherAttendSchedulingDao;
import com.cn.iscp.entity.attend.TeacherAttendRecord;
import com.cn.iscp.service.attend.ince.TeacherAttendRecordService;

@Service("teacherAttendRecordService")
public class TeacherAttendRecordServiceImpl implements TeacherAttendRecordService {
	
	@Resource
	private TeacherAttendRecordDao teacherAttendRecordDao;
	@Resource
	private TeacherAttendSchedulingDao teacherAttendSchedulingDao;
	
	@Override
	public void handleRecord(Long groupId) {
		teacherAttendRecordDao.handleRecord(groupId);
	}

	@Override
	public void censusRecord(String attendDate) {
		teacherAttendRecordDao.censusRecord(attendDate);
	}

	@Override
	public List<Map<String, Object>> findByDate(TeacherAttendRecord model) {
		return teacherAttendRecordDao.findByDate(model);
	}
	
	@Override
	public List<Map<String, Object>> findByScheduling(Long schedulingId) {
		return teacherAttendRecordDao.findByScheduling(schedulingId);
	}
	
	@Override
	public TeacherAttendRecord insertRecord(TeacherAttendRecord model) {
		return teacherAttendRecordDao.insertRecord(model);
	}
	
}
