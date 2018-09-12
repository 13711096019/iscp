package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 年级科目关系对象
 * @author 10011037@qq.com
 * 2017-07-10
 */
public class GradeSubject {
	
	// 自增编号
    private Long gsId;
	// 自增编号
    private Long schoolYearId;
	// 年级编号
    private Long gradeId;
	// 科目编号
    private Long subjectId;
	// 备注
    private String note;
    
	// 年级名称
    private String gradeName;
	// 科目编号列表
    private String subjectIds;
	// 科目名称
    private String subjectName;
	// 科目名称列表
    private String subjectNames;
	// 科目数量
    private Integer subjectCount;
	// 学年名称
    private String schoolYearTitle;
    
    public GradeSubject(){};
    
    public GradeSubject(Long gradeId){
    	this.gradeId = gradeId;
    }
    
    public GradeSubject(Long gradeId, String subjectIds){
    	this.gradeId = gradeId;
    	this.subjectIds = subjectIds;
    }
    
    
	public Long getGsId() {
		return gsId;
	}
	public void setGsId(Long gsId) {
		this.gsId = gsId;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = _Tool.toStr(gradeName);
	}
	public String getSubjectNames() {
		return subjectNames;
	}
	public void setSubjectNames(String subjectNames) {
		this.subjectNames = _Tool.toStr(subjectNames);
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = _Tool.toStr(subjectName);
	}
	public Integer getSubjectCount() {
		return subjectCount;
	}
	public void setSubjectCount(Integer subjectCount) {
		this.subjectCount = subjectCount;
	}
	public String getSubjectIds() {
		return subjectIds;
	}
	public void setSubjectIds(String subjectIds) {
		this.subjectIds = _Tool.toStr(subjectIds);
	}
	public String getSchoolYearTitle() {
		return schoolYearTitle;
	}
	public void setSchoolYearTitle(String schoolYearTitle) {
		this.schoolYearTitle = schoolYearTitle;
	}
	
	
}