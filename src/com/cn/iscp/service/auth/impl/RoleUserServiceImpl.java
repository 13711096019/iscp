package com.cn.iscp.service.auth.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.auth.RoleUserDao;
import com.cn.iscp.entity.auth.RoleUser;
import com.cn.iscp.service.auth.ince.RoleUserService;

@Service("roleUserService")
public class RoleUserServiceImpl implements RoleUserService {

	@Resource
	private RoleUserDao roleUserDao;

	@Override
	public List<RoleUser> findByUser(Long userId) {
		return roleUserDao.findByUser(userId);
	}

}
