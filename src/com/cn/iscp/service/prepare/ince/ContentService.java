package com.cn.iscp.service.prepare.ince;

import com.cn.iscp.entity.prepare.Content;

public interface ContentService {
	
	/**
	 * 工作-根据栏目编号获取备课内容
	 */
	Content findByDetail(Content model);
	
	/**
	 * 工作-根据栏目编号获取备课内容
	 */
	Content findById(Long contentId);
	
}
