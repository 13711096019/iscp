package com.cn.iscp.service.attend.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.attend.TeacherAttendCycleDao;
import com.cn.iscp.entity.attend.TeacherAttendCycle;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendCycleService;
import com.cn.unit.executor.attend.ExecutorIsFirstCycle;

@Service("teacherAttendCycleService")
public class TeacherAttendCycleServiceImpl implements TeacherAttendCycleService {
	
	@Resource
	private TeacherAttendCycleDao teacherAttendCycleDao;

	@Override
	public List<TeacherAttendCycle> findByGroup(Long groupId) {
		return teacherAttendCycleDao.findByGroup(groupId);
	}

	@Override
	public void isFirstCycle(Long groupId) {
		teacherAttendCycleDao.isFirstCycle(groupId);
	}

	@Override
	public TeacherAttendCycle insertCycle(TeacherAttendCycle model) {
		model = teacherAttendCycleDao.insertCycle(model);
		if(model != null){
			ExecutorIsFirstCycle executor = new ExecutorIsFirstCycle(model.getGroupId());
			try {
				executor.asynTask();
			} catch (InterruptedException e) {
				return model;
			}
		}
		return model;
	}

	@Override
	public TeacherAttendCycle updateCycle(TeacherAttendCycle model) {
		return teacherAttendCycleDao.updateCycle(model);
	}

	@Override
	public StateModel deleteCycle(Long cycleId) {
		TeacherAttendCycle group = teacherAttendCycleDao.deleteCycle(cycleId);
		return new StateModel(group.getStatus().intValue()==_Const.STATE_ERROR);
	}

	@Override
	public TeacherAttendCycle findById(Long cycleId) {
		return teacherAttendCycleDao.findById(cycleId);
	}

}
