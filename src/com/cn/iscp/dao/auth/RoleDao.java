package com.cn.iscp.dao.auth;

import java.util.List;

import com.cn.iscp.entity.auth.Role;

public interface RoleDao {
	
	/**
	 * 根据角色等级获取角色列表
	 */
	List<Role> findRoleByRank(Long userId);
	
	/**
	 * PC-获取所有教员角色列表
	 */
	List<Role> findAll();
	
	/**
	 * 获取需要考勤角色列表
	 */
	List<Role> findByAttend();
	
}
