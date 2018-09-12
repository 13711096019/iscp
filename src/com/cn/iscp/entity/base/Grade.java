package com.cn.iscp.entity.base;

import java.util.List;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.entity.dbase.ClassEntity;
import com.cn.iscp.model.BasisModel;

/**
 * 年级信息对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Grade extends BasisModel{
	
	// 自增编号
    private Long gradeId;
	// 年级名称
    private String gradeName;
	// 年级段位编号(1小学,2初中)
    private String sectionId;
	// 年级段位(幼儿园,小学,初中,高中,大学)
    private String gradeSection;
	// 分布顺序
    private Integer sort;
	// 备注
    private String note;
    
    // 班级列表
    List<ClassEntity> classList;
    // 科目列表
    List<Subject> subjectList;
    
    
    /**
     * 无参构造函数
     */
	public Grade(){};
	
	/**
     * 删除
     */
	public Grade(Long gradeId){
		super(_Const.STATE_ERROR);
    	this.gradeId = gradeId;
	}
	
	/**
	 * 更新时间戳
	 */
	public Grade(Long gradeId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.gradeId = gradeId;
	}
	
	public Grade(Long gradeId, String gradeName, List<Subject> subjectList){
    	this.gradeId = gradeId;
    	this.gradeName = gradeName;
    	this.subjectList = subjectList;
	}
	

	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = _Tool.toStr(gradeName);
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getGradeSection() {
		return gradeSection;
	}
	public void setGradeSection(String gradeSection) {
		this.gradeSection = _Tool.toStr(gradeSection);
	}
	public List<ClassEntity> getClassList() {
		return classList;
	}
	public void setClassList(List<ClassEntity> classList) {
		this.classList = classList;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
    
}