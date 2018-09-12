package com.cn.iscp.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.ClassRoomDao;
import com.cn.iscp.entity.base.ClassRoom;
import com.cn.iscp.service.base.ince.ClassRoomService;

@Service("classRoomService")
public class ClassRoomServiceImpl implements ClassRoomService {
	
	@Resource
	private ClassRoomDao classRoomDao;

	@Override
	public List<ClassRoom> findPage(Map<String, Object> map) {
		return classRoomDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return classRoomDao.getPageCount(map);
	}

	@Override
	public ClassRoom findById(Long roomId) {
		return classRoomDao.findById(roomId);
	}

	@Override
	public List<ClassRoom> findAll() {
		return classRoomDao.findAll();
	}

	@Override
	public boolean insert(ClassRoom model) {
		return classRoomDao.insert(model);
	}

	@Override
	public boolean update(ClassRoom model) {
		return classRoomDao.update(model);
	}

}
