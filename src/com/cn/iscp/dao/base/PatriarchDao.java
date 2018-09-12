package com.cn.iscp.dao.base;

import java.util.List;

import com.cn.iscp.entity.base.Patriarch;

public interface PatriarchDao {

	/**
	 * APP-家长登录
	 */
	List<Patriarch> login(Patriarch model);

	/**
	 * 根据动态班级编号获取学生家长信息
	 */
	List<Patriarch> findByClassNum(Long classNum);
	
	/**
	 * PC-老师为学生绑定登录家长
	 */
	// Patriarch handleByTeacher(Patriarch model);
	
	/**
	 * APP-家长绑定学生信息
	 */
	// StateModel handleByPatriarch(Patriarch model);

	/**
	 * APP-根据编号获取家长信息
	 */
	Patriarch findById(Long patriarchId);

	/**
	 * 根据手机号获取家长信息 
	 */
	Patriarch findByAccount(String logAccount);

	/**
	 * APP-修改头像
	 */
	boolean updateHeadPortrait(Patriarch model);
	
}
