package com.cn.iscp.service.auth.ince;

import java.util.List;

import com.cn.iscp.entity.auth.Role;

public interface RoleService {
	
	/**
	 * 获取所有角色列表
	 */
	List<Role> findRole();
	
	/**
	 * 获取需要考勤角色列表
	 */
	List<Role> findByAttend();
	
	/**
	 * 获取所有角色列表+老师列表
	 */
	List<Role> findAllRole();
	
	/**
	 * 根据角色等级获取角色列表
	 */
	List<Role> findRoleByRank(Long userId);
	
	/**
	 * 获取下级老师角色列表
	 */
	List<Role> findFramework(List<Role> roleList, Long parentId);

}
