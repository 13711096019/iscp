package com.cn.iscp.service.card.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.base.ItemFileDao;
import com.cn.iscp.dao.card.ClassesLeaderDao;
import com.cn.iscp.entity.base.ItemFile;
import com.cn.iscp.entity.card.ClassesLeader;
import com.cn.iscp.service.card.ince.ClassesLeaderService;

@Service("classesLeaderService")
public class ClassesLeaderServiceImpl implements ClassesLeaderService {
	
	@Resource
	private ClassesLeaderDao classesLeaderDao;
	@Resource
	private ItemFileDao itemFileDao;
	
	@Override
	public List<Map<String, Object>> findByClass(Long classNum) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		
		// 参数
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("classNum", classNum);
		
		List<ItemFile> typeList = itemFileDao.findByDirId(_Const.ITEMCORD_CLASS_LEADER);
		for (ItemFile itemFile : typeList) {
			map = new HashMap<String, Object>();
			map.put("leaderTypeId", itemFile.getItemFileId());
			map.put("leaderTypeName", itemFile.getItemFileName());
			
			data.put("classLeaderType", itemFile.getItemFileId());
			map.put("leaderList", classesLeaderDao.findByClass(data));
			mapList.add(map);
		}
		return mapList;
	}

	@Override
	public List<List<ClassesLeader>> findClassLeader(Long classNum) {
		return classesLeaderDao.findClassLeader(classNum);
	}

	@Override
	public ClassesLeader handleClassLeader(ClassesLeader model) {
		return classesLeaderDao.handleClassLeader(model);
	}

}
