package com.cn.iscp.dao.auth;

import java.util.List;

import com.cn.iscp.entity.auth.CatalogTree;

public interface CatalogTreeDao {
	
	/**
	 * PC-读取权限列表
	 */
	List<CatalogTree> getRoleCatalogTree(CatalogTree model);
	
}
