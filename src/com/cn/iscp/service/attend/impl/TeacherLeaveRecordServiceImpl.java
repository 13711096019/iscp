package com.cn.iscp.service.attend.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.TeacherLeaveRecordDao;
import com.cn.iscp.entity.attend.TeacherLeaveRecord;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherLeaveRecordService;
import com.cn.unit.executor.push.phone.ExecutorTeacherLeave;

@Service("teacherLeaveRecordService")
public class TeacherLeaveRecordServiceImpl implements TeacherLeaveRecordService {

	@Resource
	private TeacherLeaveRecordDao teacherLeaveRecordDao;
	
	@Override
	public List<TeacherLeaveRecord> findByTeacher(TeacherLeaveRecord model) {
		return teacherLeaveRecordDao.findByTeacher(model);
	}

	@Override
	public List<TeacherLeaveRecord> findByCheck(Long teacherId) {
		return teacherLeaveRecordDao.findByCheck(teacherId);
	}

	@Override
	public List<TeacherLeaveRecord> findByDate(TeacherLeaveRecord model) {
		return teacherLeaveRecordDao.findByDate(model);
	}

	@Override
	public TeacherLeaveRecord insertLeave(TeacherLeaveRecord model) {
		TeacherLeaveRecord leave = teacherLeaveRecordDao.insertLeave(model);
		if(leave != null){
			ExecutorTeacherLeave executor = new ExecutorTeacherLeave(leave.getLeaveId(), model.getTeacherId(), 1);
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return leave;
	}

	@Override
	public StateModel updateLeave(TeacherLeaveRecord model) {
		return teacherLeaveRecordDao.updateLeave(model);
	}

	@Override
	public StateModel deleteLeave(TeacherLeaveRecord model) {
		return teacherLeaveRecordDao.deleteLeave(model);
	}
	
	@Override
	public StateModel checkLeave(TeacherLeaveRecord model) {
		StateModel state = teacherLeaveRecordDao.checkLeave(model);
		if(state != null && state.getStatusCode().intValue() == 1){
			ExecutorTeacherLeave executor = new ExecutorTeacherLeave(model.getLeaveId(), model.getTeacherId(), 3);
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return state;
	}
	
	@Override
	public List<TeacherLeaveRecord> findPage(Map<String, Object> map) {
		return teacherLeaveRecordDao.findPage(map);
	}
	
	@Override
	public Long getPageCount(Map<String, Object> map) {
		return teacherLeaveRecordDao.getPageCount(map);
	}
	
	@Override
	public boolean insert(TeacherLeaveRecord model) {
		return teacherLeaveRecordDao.insert(model);
	}
	
	@Override
	public boolean update(TeacherLeaveRecord model) {
		return teacherLeaveRecordDao.update(model);
	}

	@Override
	public TeacherLeaveRecord findById(Long leaveId) {
		return teacherLeaveRecordDao.findById(leaveId);
	}

}
