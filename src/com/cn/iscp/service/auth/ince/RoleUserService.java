package com.cn.iscp.service.auth.ince;

import java.util.List;

import com.cn.iscp.entity.auth.RoleUser;

public interface RoleUserService {
	
	/**
	 * 工作-根据用户获取角色列表
	 */
	List<RoleUser> findByUser(Long userId);

}
