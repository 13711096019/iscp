package com.cn.iscp.dao.chat;

import com.cn.iscp.entity.chat.GroupChat;

public interface GroupChatDao {
	
	/**
	 * PC-根据群编号获取对象
	 */
	GroupChat findByGroupId(Long groupId);
	
	/**
	 * 根据群编号解散群聊
	 */
	boolean deleteGroupchat(Long groupId);
	
	/**
	 *新增对象
	 */
	boolean insert(GroupChat model);
	
	/**
	 * 更新对象
	 */
	boolean update(GroupChat model);
	
}
