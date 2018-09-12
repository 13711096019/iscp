package com.cn.iscp.service.attend.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.attend.TeacherAttendAxisDao;
import com.cn.iscp.dao.attend.TeacherAttendShiftDao;
import com.cn.iscp.entity.attend.TeacherAttendShift;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendShiftService;

@Service("teacherAttendShiftService")
public class TeacherAttendShiftServiceImpl implements TeacherAttendShiftService {
	
	@Resource
	private TeacherAttendShiftDao teacherAttendShiftDao;
	@Resource
	private TeacherAttendAxisDao teacherAttendAxisDao;

	@Override
	public List<TeacherAttendShift> findByGroup(Long groupId, boolean hasAxis) {
		List<TeacherAttendShift> shiftList = teacherAttendShiftDao.findByGroup(groupId);
		if(hasAxis && shiftList != null && shiftList.size() > 0){
			for (TeacherAttendShift item : shiftList) {
				item.setAxisList(teacherAttendAxisDao.findByShift(item.getShiftId()));
			}
		}
		return shiftList;
	}

	@Override
	public TeacherAttendShift insertShift(TeacherAttendShift model) {
		return teacherAttendShiftDao.insertShift(model);
	}

	@Override
	public TeacherAttendShift updateShift(TeacherAttendShift model) {
		return teacherAttendShiftDao.updateShift(model);
	}

	@Override
	public StateModel deleteShift(Long shiftId) {
		return teacherAttendShiftDao.deleteShift(shiftId);
	}

	@Override
	public TeacherAttendShift findById(Long shiftId) {
		return teacherAttendShiftDao.findById(shiftId);
	}

}
