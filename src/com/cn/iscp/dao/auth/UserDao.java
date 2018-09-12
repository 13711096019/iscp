package com.cn.iscp.dao.auth;

import java.util.List;

import com.cn.iscp.entity.auth.User;

public interface UserDao {
	
	/**
	 * PC-获取所有用户信息
	 */
	List<User> findAll();

	/**
	 * PC-根据编号获取对象
	 */
	User findById(Long userId);
	
	/**
	 * PC-修改密码
	 */
	User updatePwd(User model);

	/**
	 * 根据手机号获取对象
	 */
	User getByMobile(String mobile);

	/**
	 * 绑定家长手机号
	 */
	User handleBindPhone(User model);
	
}
