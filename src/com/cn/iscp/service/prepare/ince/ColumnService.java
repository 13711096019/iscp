package com.cn.iscp.service.prepare.ince;

import java.util.List;

import com.cn.iscp.entity.prepare.Column;

public interface ColumnService {
	
	/**
	 * 工作-获取所有栏目列表
	 */
	List<Column> findAllColumn();
	
	/**
	 * 工作-获取所有栏目内容列表
	 */
	List<Column> findAllColumnContent(Long detailId);
	
}
