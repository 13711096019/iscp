package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.HonorsDao;
import com.cn.iscp.entity.base.Honors;
import com.cn.iscp.service.base.ince.HonorsService;

@Service("honorsService")
public class HonorsServiceImpl implements HonorsService {
	
	@Resource
	private HonorsDao honorsDao;
	
	@Override
	public List<Honors> findPage(Map<String, Object> map) {
		return honorsDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return honorsDao.getPageCount(map);
	}

	@Override
	public Honors findById(Long honorsId) {
		return honorsDao.findById(honorsId);
	}

	@Override
	public List<Honors> findBySection(Integer section) {
		return honorsDao.findBySection(section);
	}

	@Override
	public boolean insert(Honors model) {
		return honorsDao.insert(model);
	}

	@Override
	public boolean update(Honors model) {
		return honorsDao.update(model);
	}

	@Override
	public Honors findFinal() {
		return honorsDao.findFinal();
	}

}
