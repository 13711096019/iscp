package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 校历(学期)
 * @author 10011037@qq.com
 * 2017-07-06
 */
public class SchoolYear {
	
	// 校历编号
	private Long syId;
	// 校历学年标题
	private String syTitle;
	// 第一学年度开始日期
	private String term1startDate;
	// 第一学年度结束日期
	private String term1endDate;
	// 第二学年度开始日期
	private String term2startDate;
	// 第二学年度结束日期
	private String term2endDate;
	// 备注
	private String note;
	
	// 学年度名称
	private String termName;
	// 第一学年度周期总数
	private Integer calendar1Count;
	// 第二学年度周期总数
	private Integer calendar2Count;
	
	
	public Long getSyId() {
		return syId;
	}
	public void setSyId(Long syId) {
		this.syId = syId;
	}
	public String getTerm1startDate() {
		return term1startDate;
	}
	public void setTerm1startDate(String term1startDate) {
		this.term1startDate = _Tool.toStr(term1startDate);
	}
	public String getTerm1endDate() {
		return term1endDate;
	}
	public void setTerm1endDate(String term1endDate) {
		this.term1endDate = _Tool.toStr(term1endDate);
	}
	public String getTerm2startDate() {
		return term2startDate;
	}
	public void setTerm2startDate(String term2startDate) {
		this.term2startDate = _Tool.toStr(term2startDate);
	}
	public String getTerm2endDate() {
		return term2endDate;
	}
	public void setTerm2endDate(String term2endDate) {
		this.term2endDate = _Tool.toStr(term2endDate);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = _Tool.toStr(termName);
	}
	public Integer getCalendar1Count() {
		return calendar1Count;
	}
	public void setCalendar1Count(Integer calendar1Count) {
		this.calendar1Count = calendar1Count;
	}
	public Integer getCalendar2Count() {
		return calendar2Count;
	}
	public void setCalendar2Count(Integer calendar2Count) {
		this.calendar2Count = calendar2Count;
	}
	public String getSyTitle() {
		return syTitle;
	}
	public void setSyTitle(String syTitle) {
		this.syTitle = syTitle;
	}
	
	
}
