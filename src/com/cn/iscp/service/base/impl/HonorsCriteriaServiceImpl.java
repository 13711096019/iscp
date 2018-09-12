package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.base.HonorsCriteriaDao;
import com.cn.iscp.dao.base.HonorsDao;
import com.cn.iscp.entity.base.Honors;
import com.cn.iscp.entity.base.HonorsCriteria;
import com.cn.iscp.service.base.ince.HonorsCriteriaService;

@Service("honorsCriteriaService")
public class HonorsCriteriaServiceImpl implements HonorsCriteriaService {
	
	@Resource
	private HonorsCriteriaDao honorsCriteriaDao;
	@Resource
	private HonorsDao honorsDao;

	@Override
	public List<HonorsCriteria> findByHonors(Long honorsId) {
		return honorsCriteriaDao.findByHonors(honorsId);
	}

	@Override
	public List<Honors> findHonorsCriteria() {
		List<Honors> list = honorsDao.findBySection(_Const.HONORS_STUDENT);
		for (Honors honors : list) {
			honors.setCriteriaList(this.findByHonors(honors.getHonorsId()));
		}
		return list;
	}

	@Override
	public List<HonorsCriteria> findPage(Map<String, Object> map) {
		return honorsCriteriaDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return honorsCriteriaDao.getPageCount(map);
	}

	@Override
	public HonorsCriteria findById(Long criteriaId) {
		// TODO Auto-generated method stub
		return honorsCriteriaDao.findById(criteriaId);
	}

	@Override
	public HonorsCriteria findFinal() {
		// TODO Auto-generated method stub
		return honorsCriteriaDao.findFinal();
	}

	@Override
	public boolean insert(HonorsCriteria model) {
		// TODO Auto-generated method stub
		return honorsCriteriaDao.insert(model);
	}

	@Override
	public boolean update(HonorsCriteria model) {
		// TODO Auto-generated method stub
		return honorsCriteriaDao.update(model);
	}

}
