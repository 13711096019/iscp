package com.cn.iscp.service.auth.ince;

import java.util.List;

import com.cn.iscp.entity.auth.CatalogTree;

public interface CatalogTreeService {
	
	/**
	 * 获取左菜单列表
	 */
	List<CatalogTree> findLeftMenu(String userAccount);
	
	/**
	 * 获取页面按钮列表
	 */
	List<CatalogTree> findButton(String userAccount, String catalogCode);
	
}
