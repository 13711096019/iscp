package com.cn.iscp.dao.card;

import java.util.List;

import com.cn.iscp.entity.card.Leave;

public interface LeaveDao {
	
	/**
	 * PC-获取班级请假学生列表
	 */
	List<Leave> findLeaveByDate(Leave model);
	
	/**
	 * 老师端-根据动态班级编号获取最近请假记录
	 */
	List<Leave> findLeaveByClass(Leave model);
	
	/**
	 * 家长端-根据学生编号获取最近请假记录
	 */
	List<Leave> findLeaveByStudent(Leave model);
	
	/**
	 * PC-学生请假
	 */
	Leave addLeave(Leave model);
	
	/**
	 * PC-删除学生请假记录
	 */
	boolean delLeave(Long leaveId);
	
}
