package com.cn.iscp.dao.card;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.ClassesLeader;

public interface ClassesLeaderDao {
	
	/**
	 * 终端-根据班级获取班干部列表
	 */
	List<ClassesLeader> findByClass(Map<String, Object> map);

	/**
	 * PC-根据班级分类获取班干部列表
	 */
	List<List<ClassesLeader>> findClassLeader(Long classNum);
	
	/**
	 * PC-分配学生班干部
	 */
	ClassesLeader handleClassLeader(ClassesLeader model);
}
