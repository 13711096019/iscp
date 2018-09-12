package com.cn.iscp.dao.chat;

import java.util.List;

import com.cn.iscp.entity.auth.User;
import com.cn.iscp.entity.chat.Label;
import com.cn.iscp.entity.chat.UserLabel;
import com.cn.iscp.model.StateModel;

public interface UserLabelDao {
	
	/**
	 * 分配好友标签
	 */
	void allotLabel(UserLabel model);
	
	/**
	 * 删除好友
	 */
	StateModel deleteFriend(UserLabel model);
	
	/**
	 * 根据标签获取通讯录好友列表
	 */
	List<User> findFriendByLabel(UserLabel model);
	
	/**
	 * 根据账号获取通讯录好友列表
	 */
	List<User> findFriendByUserKeys(Label model);
	
	/**
	 * 根据手机号或姓名获取用户列表
	 */
	List<User> findFriendByKeywords(Label model);
	
	/**
	 * 群聊 -根据老师编号集合获取老师姓名和头像
	 */
	
	List<User> findTeacherByMessage(String userName);
	
}
