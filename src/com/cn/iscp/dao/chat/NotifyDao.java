package com.cn.iscp.dao.chat;

import java.util.List;

import com.cn.iscp.entity.chat.Notify;
import com.cn.iscp.model.StateModel;

public interface NotifyDao {
	
	/**
	 * 分页获取校信通知信息
	 */
	List<Notify> findByPage(Notify model);
	
	/**
	 * 新增校信通知
	 */
	StateModel insertNotify(Notify model);
	
	/**
	 * 编辑校信通知
	 */
	Notify updateNotify(Notify model);
	
	/**
	 * 删除校信通知
	 */
	StateModel deleteNotify(Notify model);
	
}
