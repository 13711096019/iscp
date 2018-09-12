package com.cn.iscp.service.attend.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.attend.StudentLeaveRecordDao;
import com.cn.iscp.entity.attend.StudentLeaveRecord;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.StudentLeaveRecordService;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.unit.quartz.task.PhonePushTimed;

@Service("studentLeaveRecordService")
public class StudentLeaveRecordServiceImpl extends BaseSericel implements StudentLeaveRecordService{
	
	@Resource
	private StudentLeaveRecordDao studentLeaveRecordDao;
	
	@Override
	public List<StudentLeaveRecord> findByStudent(StudentLeaveRecord model) {
		return studentLeaveRecordDao.findByStudent(model);
	}

	@Override
	public List<StudentLeaveRecord> findByTeacher(Map<String, Object> map) {
		return studentLeaveRecordDao.findByTeacher(map);
	}
	
	@Override
	public List<StudentLeaveRecord> findByClass(StudentLeaveRecord model) {
		return studentLeaveRecordDao.findByClass(model);
	}
	
	@Override
	public StudentLeaveRecord insertLeave(StudentLeaveRecord model) {
		StudentLeaveRecord leave = studentLeaveRecordDao.insertLeave(model);
		if(leave != null && StudentLeaveRecord.STATE_SOLICIT_CONSULT==leave.getLeaveState().intValue()){
			// 极光推送
			PhonePushTimed.PushLeaveTeacher(leave.getUserKey(), leave.getLeaveId());
		}
		return leave;
	}

	@Override
	public StateModel updateState(StudentLeaveRecord model) {
		StateModel state = studentLeaveRecordDao.updateState(model);
		if(state.getStatusCode().intValue()==_Const.STATECODE_SUCCESS){
			// 极光推送
			PhonePushTimed.PushLeavePatriarch(state.getUserKey(), state.getKeyId());
		}
		return state;
	}

	@Override
	public PageModel findByPage(Map<String, Object> map) {
		List<List<?>> list = studentLeaveRecordDao.findByPage(map);
		return getMapByPage(list);
	}


}
