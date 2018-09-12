package com.cn.iscp.dao.base;

import java.util.List;

import com.cn.iscp.entity.base.Guardian;

public interface GuardianDao {
	
	/**
	 * 根据学生编号获取监护人列表
	 */
	List<Guardian> findByStudent(Long studentId);
	
}