package com.cn.iscp.dao.ligent;

import com.cn.iscp.entity.ligent.Position;

public interface PositionDao {
	
	Position findUserPosition(Long userId);
	
}
