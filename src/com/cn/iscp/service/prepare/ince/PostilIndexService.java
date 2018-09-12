package com.cn.iscp.service.prepare.ince;

import java.util.List;

import com.cn.iscp.entity.prepare.PostilIndex;

public interface PostilIndexService {
	
	/**
	 * PC-根据备课内容编号获取批注列表
	 */
	List<PostilIndex> findByContent(Long contentId);
	
}
