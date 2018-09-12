package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.TeacherLeaveRecord;
import com.cn.iscp.model.StateModel;

public interface TeacherLeaveRecordService {
	
	/**
	 * 根据老师编号获取最近请假记录
	 */
	List<TeacherLeaveRecord> findByTeacher(TeacherLeaveRecord model);
	
	/**
	 * 获取待审批的请假记录
	 */
	List<TeacherLeaveRecord> findByCheck(Long teacherId);
	
	/**
	 * 获取有效的请假记录
	 */
	List<TeacherLeaveRecord> findByDate(TeacherLeaveRecord model);
	
	/**
	 * 老师请假申请
	 */
	TeacherLeaveRecord insertLeave(TeacherLeaveRecord model);

	/**
	 * 修改请假记录
	 */
	StateModel updateLeave(TeacherLeaveRecord model);
	
	/**
	 * 删除请假记录
	 */
	StateModel deleteLeave(TeacherLeaveRecord model);
	
	/**
	 * 请假申请审核
	 */
	StateModel checkLeave(TeacherLeaveRecord model);
	
	/**
	 * PC-分页获取类型列表
	 */
	List<TeacherLeaveRecord> findPage(Map<String, Object> map);
	
	/**
	 * PC-分页获取列表总数
	 */
	Long getPageCount(Map<String, Object> map);
	
	/**
	 * PC-新增
	 */
	boolean insert(TeacherLeaveRecord model);
	
	/**
	 * PC-编辑
	 */
	boolean update(TeacherLeaveRecord model);
	
	/**
	 * 根据编号获取请假信息
	 */
	TeacherLeaveRecord findById(Long leaveId);
}
