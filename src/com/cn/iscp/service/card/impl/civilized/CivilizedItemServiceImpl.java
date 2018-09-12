package com.cn.iscp.service.card.impl.civilized;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.civilized.CivilizedItemDao;
import com.cn.iscp.dao.card.civilized.CivilizedRegularDao;
import com.cn.iscp.entity.card.civilized.CivilizedItem;
import com.cn.iscp.service.card.ince.civilized.CivilizedItemService;

@Service("civilizedItemService")
public class CivilizedItemServiceImpl implements CivilizedItemService {
	
	@Resource
	private CivilizedItemDao civilizedItemDao;
	@Resource
	private CivilizedRegularDao civilizedRegularDao;

	@Override
	public List<CivilizedItem> findAll() {
		return civilizedItemDao.findAll();
	}

	@Override
	public List<CivilizedItem> findItemRegular() {
		List<CivilizedItem> itemList = this.findAll();
		for (CivilizedItem item : itemList) {
			item.setRegularList(civilizedRegularDao.findByItem(item.getBigItemId()));
		}
		return itemList;
	}

	@Override
	public CivilizedItem findById(Long bigItemId) {
		return civilizedItemDao.findById(bigItemId);
	}

	@Override
	public boolean insert(CivilizedItem model) {
		return civilizedItemDao.insert(model);
	}

	@Override
	public boolean update(CivilizedItem model) {
		return civilizedItemDao.update(model);
	}

}
