package com.cn.iscp.dao.attend;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherAttendGroup;

public interface TeacherAttendGroupDao {
	
	/**
	 * 根据考勤组和用户获取对象
	 */
	TeacherAttendGroup findByPower(TeacherAttendGroup model);
	
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
	TeacherAttendGroup deleteGroup(Long groupId);
	
	/**
	 * 获取考勤老师列表
	 */
	List<Map<String, Object>> findTeacher(Map<String, Object> map);
	
}
