package com.cn.iscp.service.auth.ince;

import java.util.List;

import com.cn.iscp.entity.auth.User;
import com.cn.iscp.model.StateModel;

public interface UserService {

	/**
	 * PC-根据编号获取对象
	 */
	User findById(Long userId);
	
	/**
	 * PC-获取所有用户信息
	 */
	List<User> findAll();

	/**
	 * 根据手机号获取对象
	 */
	User getByMobile(String mobile);
	
	/**
	 * PC-修改密码
	 */
	StateModel updatePwd(User model);
	
	/**
	 * 绑定家长手机号
	 */
	User handleBindPhone(User model);
	
}
