package com.cn.iscp.service.attend.ince;

import java.util.List;

import com.cn.iscp.entity.attend.TeacherAttendRevise;

public interface TeacherAttendReviseService {
	
	/**
	 * 分页获取补卡列表
	 */
	List<TeacherAttendRevise> findByPage(TeacherAttendRevise model);
	
	/**
	 * 根据打卡记录编号获取补卡列表
	 */
	List<TeacherAttendRevise> findByRecord(Long recordId);
	
	/**
	 * 新增补卡记录
	 */
	TeacherAttendRevise insertRevise(TeacherAttendRevise model);
	
	/**
	 * 审批补卡记录
	 */
	TeacherAttendRevise checkRevise(TeacherAttendRevise model);
	
}
