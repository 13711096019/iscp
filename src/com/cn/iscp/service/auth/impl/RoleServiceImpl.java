package com.cn.iscp.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Tool;
import com.cn.iscp.dao.auth.RoleDao;
import com.cn.iscp.dao.base.TeacherDao;
import com.cn.iscp.entity.auth.Role;
import com.cn.iscp.service.auth.ince.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;
	@Resource
	private TeacherDao teacherDao;

	@Override
	public List<Role> findRole() {
		return roleDao.findAll();
	}

	@Override
	public List<Role> findByAttend() {
		return roleDao.findByAttend();
	}

	@Override
	public List<Role> findAllRole() {
		List<Role> roleList = this.findRole();
		for (Role role : roleList) {
			role.setTeacherList(teacherDao.findPhoneBook(role.getRoleId()));
		}
		return roleList;
	}

	@Override
	public List<Role> findRoleByRank(Long userId) {
		return roleDao.findRoleByRank(userId);
	}

	@Override
	public List<Role> findFramework(List<Role> roleList, Long parentId) {
		if(roleList == null || roleList.size() < 1)
			roleList = this.findRole();
		if(!_Tool.isLong(parentId))
			parentId = 0L;

		List<Role> revertList = new ArrayList<Role>();
		String parentsId = null;
		for (Role role : roleList) {
			parentsId = "," + role.getParentId() + ",";
			if(parentsId.indexOf("," + parentId + ",") >= 0){
				role.setRoleList(findFramework(roleList, role.getRoleId()));
				revertList.add(role);
			}
			if(revertList.size() < 1){
				continue;
			}
		}
		return revertList;
	}

}
