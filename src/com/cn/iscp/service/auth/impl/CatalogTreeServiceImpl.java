package com.cn.iscp.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.auth.CatalogTreeDao;
import com.cn.iscp.entity.auth.CatalogTree;
import com.cn.iscp.service.auth.ince.CatalogTreeService;

@Service("catalogTreeService")
public class CatalogTreeServiceImpl implements CatalogTreeService {
	
	@Resource
	private CatalogTreeDao catalogTreeDao;

	@Override
	public List<CatalogTree> findLeftMenu(String userAccount) {
		CatalogTree model = new CatalogTree(userAccount, 1, null);
		List<CatalogTree> list = catalogTreeDao.getRoleCatalogTree(model);
		
		List<CatalogTree> revertList = new ArrayList<CatalogTree>();
		List<CatalogTree> childList = null;
		List<CatalogTree> sunList = null;
		Long catalogId = null, parentId = null;
		for (CatalogTree item : list) {
			parentId = item.getParentId();
			if(parentId.intValue() == 0){
				childList = new ArrayList<CatalogTree>();
				catalogId = item.getCatalogId();
				for (CatalogTree child : list) {
					parentId = child.getParentId();
					if(parentId.intValue()==catalogId.intValue()){
						sunList = new ArrayList<CatalogTree>();
						for (CatalogTree sun : list) {
							if(sun.getParentId().intValue()==child.getCatalogId().intValue()){
								sunList.add(sun);
							}
						}
						child.setChildList(sunList);
						childList.add(child);
					}
				}
				item.setChildList(childList);
				revertList.add(item);
			}
		}
		return revertList;
	}

	@Override
	public List<CatalogTree> findButton(String userAccount, String catalogCode) {
		CatalogTree model = new CatalogTree(userAccount, 2, catalogCode);
		return catalogTreeDao.getRoleCatalogTree(model);
	}

}
