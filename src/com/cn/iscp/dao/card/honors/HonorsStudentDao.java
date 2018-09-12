package com.cn.iscp.dao.card.honors;

import java.util.List;

import com.cn.iscp.entity.card.honors.HonorsStudent;

public interface HonorsStudentDao {
	
	/**
	 * 终端-获取最近一月学生荣誉列表
	 */
	List<HonorsStudent> findByMonty(Long classNum);
	
	/**
	 * PC-获取本学年度学生荣誉列表
	 */
	List<HonorsStudent> findByTerm(Long classNum);
	
	/**
	 * PC-根据荣誉类型获取学生荣誉列表
	 */
	List<HonorsStudent> findByType(HonorsStudent model);
	
	/**
	 * PC-颁发学生荣誉
	 */
	void handleStudentHonors(HonorsStudent model);
	
	/**
	 * PC首页-获取最新4个学生标兵
	 */
	List<HonorsStudent> findByFresh();
	
	/**
	 * 编辑对象
	 */
	boolean update(HonorsStudent model);
}
