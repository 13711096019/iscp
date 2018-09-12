package com.cn.iscp.dao.chat;

import java.util.List;

import com.cn.iscp.entity.chat.Label;

public interface LabelDao {

	/**
	 * 根据用户编号获取标签列
	 */
	List<Label> findByUser(Long userId);

	/**
	 * 新增标签信息
	 */
	Label insertLabel(Label model);
	
	/**
	 * 编辑标签信息
	 */
	Label updateLabel(Label model);

	/**
	 * 删除标签信息
	 */
	void deleteLabel(Long labelId);
	
}
