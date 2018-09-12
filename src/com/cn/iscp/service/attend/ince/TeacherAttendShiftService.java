package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendShift;
import com.cn.iscp.model.StateModel;

public interface TeacherAttendShiftService {
	
	/**
	 * 根据考勤组获取考勤地点
	 */
	List<TeacherAttendShift> findByGroup(Long groupId, boolean hasAxis);
	
	/**
	 * 新增考勤班次
	 */
	TeacherAttendShift insertShift(TeacherAttendShift model);
	
	/**
	 * 编辑考勤班次
	 */
	TeacherAttendShift updateShift(TeacherAttendShift model);
	
	/**
	 * 删除考勤班次
	 */
	StateModel deleteShift(Long shiftId);
	
	/**
	 * 根据编号获取考勤班次
	 */
	TeacherAttendShift findById(Long shiftId);

}
