package com.cn.iscp.service.attend.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.attend.TeacherAttendGroupDao;
import com.cn.iscp.entity.attend.TeacherAttendGroup;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendGroupService;

@Service("teacherAttendGroupService")
public class TeacherAttendGroupServiceImpl implements TeacherAttendGroupService {
	
	@Resource
	private TeacherAttendGroupDao teacherAttendGroupDao;

	@Override
	public boolean hasGroupPower(Long loginUserId, Long groupId) {
		TeacherAttendGroup group = new TeacherAttendGroup(groupId, null, null, loginUserId);
		group = teacherAttendGroupDao.findByPower(group);
		if(group != null){
			return true;
		}
		return false;
	}

	@Override
	public TeacherAttendGroup findById(Long groupId) {
		return teacherAttendGroupDao.findById(groupId);
	}

	@Override
	public TeacherAttendGroup findByLast() {
		return teacherAttendGroupDao.findByLast();
	}
	
	@Override
	public TeacherAttendGroup insertGroup(TeacherAttendGroup model) {
		return teacherAttendGroupDao.insertGroup(model);
	}
	
	@Override
	public TeacherAttendGroup updateGroup(TeacherAttendGroup model) {
		return teacherAttendGroupDao.updateGroup(model);
	}
	
	@Override
	public StateModel deleteGroup(Long groupId) {
		TeacherAttendGroup group = teacherAttendGroupDao.deleteGroup(groupId);
		return new StateModel(group.getStatus().intValue()==_Const.STATE_ERROR);
	}

	@Override
	public List<Map<String, Object>> findTeacher(Long groupId, Long roleId, String teacherName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		map.put("teacherName", _Tool.toQuery(teacherName));
		List<Map<String, Object>> revertMap = teacherAttendGroupDao.findTeacher(map);
		return revertMap;
	}
	
}
