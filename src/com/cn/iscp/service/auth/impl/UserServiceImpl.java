package com.cn.iscp.service.auth.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.auth.UserDao;
import com.cn.iscp.entity.auth.User;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.auth.ince.UserService;
import com.cn.paas.easemob.IMService;
import com.cn.paas.easemob.model.base.IMUser;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User findById(Long userId) {
		return userDao.findById(userId);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User getByMobile(String mobile) {
		return userDao.getByMobile(mobile);
	}

	@Override
	public StateModel updatePwd(User model) {
		User user = userDao.updatePwd(model);
		if(user != null){
			try {
				// 修改环信密码
				IMUser imUser = new IMUser(user.getUserKey(), user.getPassword());
				IMService.updateUserPwd(imUser);
			} catch (Exception e) {
				return new StateModel(true);
			}
			return new StateModel(true);
		}
		return new StateModel(false);
	}

	@Override
	public User handleBindPhone(User model) {
		return userDao.handleBindPhone(model);
	}

}
