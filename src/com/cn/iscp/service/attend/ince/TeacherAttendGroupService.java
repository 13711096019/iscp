package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendGroup;
import com.cn.iscp.model.StateModel;

public interface TeacherAttendGroupService {
	
	/**
	 * 判断用户是否有权限
	 */
	boolean hasGroupPower(Long loginUserId, Long groupId);

	/**
	 * 根据编号获取考勤组信息
	 */
	TeacherAttendGroup findById(Long groupId);

	/**
	 * 获取最新考勤组信息
	 */
	TeacherAttendGroup findByLast();
	
	/**
	 * 新增考勤组
	 */
	TeacherAttendGroup insertGroup(TeacherAttendGroup model);
	
	/**
	 * 编辑考勤组
	 */
	TeacherAttendGroup updateGroup(TeacherAttendGroup model);
	
	/**
	 * 删除考勤组
	 */
	StateModel deleteGroup(Long groupId);
	
	/**
	 * 根据角色编号获取考勤班次模板
	 */
	List<Map<String, Object>> findTeacher(Long groupId, Long roleId, String teacherName);
	
}
