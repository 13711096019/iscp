package com.cn.iscp.dao.card;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.card.Homework;
import com.cn.iscp.model.StateModel;

public interface HomeworkDao {
	
	/**
	 * PC-根据编号获取对象
	 */
	Homework findById(Long homeworkId);
	
	/**
	 * PC-获取最近一周班级作业
	 */
	List<Homework> findHomeworkWeek(Long classNum);
	
	/**
	 * 终端-获取当前班级值日对象
	 */
	List<Homework> getHomeworkToday(Long classNum);
	
	/**
	 * 家长端-获取最近一次作业列表
	 */
	List<Homework> findHomeworkByNewly(Long classNum);

	/**
	 * 老师端-根据日期获取班级作业
	 */
	List<Homework> findHormworkByDate(Homework model);
	
	/**
	 * PC-布置功课
	 */
	Long handleHomework(Homework model);
	
	/**
	 * 家长端-修改作业查看人数
	 */
	StateModel updateCheckCount(Homework model);
	
	/**
	 * 老师端-根据老师获取功课列表
	 */
	List<Homework> findByTeacher(Homework model);
	
	/**
	 * 获取没查看（已查看）作业的家长列表
	 */
	List<Map<String, Object>> findCheckPatriarch(Map<String, Object> map);
	
}
