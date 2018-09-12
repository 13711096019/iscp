package com.cn.iscp.service.base.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.base.ClassRoom;

public interface ClassRoomService {
	
	List<ClassRoom> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	ClassRoom findById(Long roomId);
	
	List<ClassRoom> findAll();
	
	boolean insert(ClassRoom model);
	
	boolean update(ClassRoom model);
	
}
