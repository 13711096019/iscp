package com.cn.iscp.dao.auth;

import java.util.List;

import com.cn.iscp.entity.auth.RoleUser;

public interface RoleUserDao {
	
	/**
	 * 工作-根据用户获取角色列表
	 */
	List<RoleUser> findByUser(Long userId);

}
