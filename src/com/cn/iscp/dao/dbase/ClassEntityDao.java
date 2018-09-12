package com.cn.iscp.dao.dbase;

import java.util.List;

import com.cn.iscp.entity.dbase.ClassEntity;
import com.cn.iscp.entity.dbase.ClassEntityUpgrade;

public interface ClassEntityDao {
	
	/**
	 * 根据用户获取班级信息列表
	 */
	List<ClassEntity> findClass(Long loginUserId);
	
	/**
	 * 根据编号(动态班级编号/实体班级编号)获取实体班级信息
	 */
	ClassEntity getClassEntityByKeyId(ClassEntityUpgrade model);
	
	/**
	 * 根据编号(动态班级编号/实体班级编号)获取动态班级信息
	 */
	ClassEntityUpgrade getClassEntityUpgradeByKeyId(ClassEntityUpgrade model);
	
	/**
	 * 根据年级获取班级列表
	 */
	List<ClassEntity> findByGrade(Long gradeId);

	/**
	 * PC-修改班级小组数
	 */
	Integer updSmallGroupCount(ClassEntity model);

	/**
	 * 处理教室位置
	 */
	void handleClassRoom(ClassEntity model);

	/**
	 * 根据动态班级编号获取该班级阶段的所有班级
	 */
	List<ClassEntity> findClassList(Long classNum);

	/**
	 * 判断老师是否为班主任
	 */
	List<ClassEntity> findByTeacher(Long teacherId);

	/**
	 * 修改班级默认视频
	 */
	boolean updDefaultVideo(ClassEntity model);
	
}
