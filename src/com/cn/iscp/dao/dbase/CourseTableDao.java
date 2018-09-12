package com.cn.iscp.dao.dbase;

import java.util.List;

import com.cn.iscp.entity.dbase.CourseTable;
import com.cn.iscp.model.Classroom;

public interface CourseTableDao {
	
	/**
	 * 终端-获取最近两天课程信息
	 
	List<CourseTable> findCourseTable(Map<String, Object> map);*/
	
	/**
	 * PC-根据动态班级编号获取课程信息
	 */
	List<CourseTable> findByClassNum(Long classNum);
	
	/**
	 * 工作-根据老师编号获取个人课程表
	 */
	List<CourseTable> findByTeacher(Long teacherId);
	
	/**
	 * PC-更新班级课程表
	 */
	void handleCourseTable(CourseTable model);
	
	/**
	 * 终端-根据班级编号获取课堂信息
	 */
	List<List<?>> getCurrentLesson(Long classNum);
	
	/**
	 * 老师端-获取老师今天的所有课程
	 */
	List<Classroom> findByToday(Long teacherId);
}
