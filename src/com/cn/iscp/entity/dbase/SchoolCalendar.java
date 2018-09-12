package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 校历(按周)
 * @author 10011037@qq.com
 * 2017-07-06
 */
public class SchoolCalendar {
	
	// 周校历编号
	private Long scId;
	// 学期校历编号
	private Long schoolYearId;
	// 学年度编号
	private Long termId;
	// 周别
	private Integer week;
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	// 备注
	private String note;
	
	public SchoolCalendar(){};
	
	public SchoolCalendar(Long schoolYearId, Long termId){
		this.schoolYearId = schoolYearId;
		this.termId = termId;
	}
	
	public Long getScId() {
		return scId;
	}
	public void setScId(Long scId) {
		this.scId = scId;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = _Tool.toStr(startDate);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = _Tool.toStr(endDate);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	
}
