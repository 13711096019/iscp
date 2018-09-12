package com.cn.iscp.service.ligent.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.ligent.PositionDao;
import com.cn.iscp.entity.ligent.Position;
import com.cn.iscp.service.ligent.ince.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	
	@Resource
	private PositionDao positionDao;

	@Override
	public Position findUserPosition(Long userId) {
		return positionDao.findUserPosition(userId);
	}

}
