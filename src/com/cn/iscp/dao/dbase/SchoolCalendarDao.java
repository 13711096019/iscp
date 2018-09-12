package com.cn.iscp.dao.dbase;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.dbase.SchoolCalendar;
import com.cn.iscp.entity.dbase.SchoolYear;

public interface SchoolCalendarDao {
    
	List<SchoolYear> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	SchoolYear findById(Long syId);
	
	void addCalendar(Map<String, Object> map);
	
	void editCalendar(Map<String, Object> map);
	
	List<SchoolCalendar> findCalendarByTerm(SchoolCalendar model);
	
	Long getCurrentSchoolYearId(Map<String, Object> map);
	
	Long getCurrentTermId(Map<String, Object> map);
	
	Integer getCurrentWeek(Map<String, Object> map);
	
	List<SchoolYear> findAll();
	
}