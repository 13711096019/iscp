package com.cn.iscp.service.card.impl.honors;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.card.honors.HonorsClassDao;
import com.cn.iscp.entity.card.honors.HonorsClass;
import com.cn.iscp.service.card.ince.honors.HonorsClassService;

@Service("honorsClassService")
public class HonorsClassServiceImpl implements HonorsClassService {
	
	@Resource
	private HonorsClassDao honorsClassDao;

	@Override
	public List<HonorsClass> findCivilizationClass() {
		return honorsClassDao.findCivilizationClass();
	}

	@Override
	public List<Map<String, Object>> findCivilizedClassCensus() {
		return honorsClassDao.findCivilizedClassCensus();
	}
}
