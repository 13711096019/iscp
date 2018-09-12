package com.cn.iscp.service.attend.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.StudentLeaveRecord;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;

public interface StudentLeaveRecordService {
	
	/**
	 * 根据学生编号获取最近请假记录
	 */
	List<StudentLeaveRecord> findByStudent(StudentLeaveRecord model);
	
	/**
	 * 根据老师编号获取最近请假记录
	 */
	List<StudentLeaveRecord> findByTeacher(Map<String, Object> map);
	
	/**
	 * 根据动态班级编号获取最近学生请假记录
	 */
	List<StudentLeaveRecord> findByClass(StudentLeaveRecord model);
	
	/**
	 * 用户请假
	 */
	StudentLeaveRecord insertLeave(StudentLeaveRecord model);

	/**
	 * 修改请假记录状态为已查阅
	 */
	StateModel updateState(StudentLeaveRecord model);
	
	/**
	 * PC-分页获取类型列表
	 */
	//List<StudentLeaveRecord> findPage(Map<String, Object> map);
	
	/**
	 * PC-分页获取列表总数
	 */
	//Long getPageCount(Map<String, Object> map);
	
	/**
	 * PC-分页获取请假列表
	 */
	PageModel findByPage(Map<String, Object> map);
}
