package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 班级动态学期班干部
 * @author 10011037@qq.com
 * 2017-08-02
 */
public class ClassesLeader {

	// 自增编号
    private Long classesLeaderId;
	// 动态编辑编号
    private Long classNum;
	// 班干部编号
    private Long classLeaderId;
	// 学生编号
    private Long studentId;
	// 备注
    private String note;

	// 班干部名称
    private String classLeaderName;
	// 学生姓名
    private String studentName;
	// 学生性别
    private Integer sexId;
	// 排序
    private Integer sort;
	// 学生头像
    private String headPortrait;
	// 班干部职责
    private String dutyDesc;
    
    public ClassesLeader(){};
    
    public ClassesLeader(Long classNum, Long classLeaderId, Long studentId){
    	this.classNum = classNum;
    	this.classLeaderId = classLeaderId;
    	this.studentId = studentId;
    }
    
    
	public Long getClassesLeaderId() {
		return classesLeaderId;
	}
	public void setClassesLeaderId(Long classesLeaderId) {
		this.classesLeaderId = classesLeaderId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getClassLeaderId() {
		return classLeaderId;
	}
	public void setClassLeaderId(Long classLeaderId) {
		this.classLeaderId = classLeaderId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getClassLeaderName() {
		return classLeaderName;
	}
	public void setClassLeaderName(String classLeaderName) {
		this.classLeaderName = _Tool.toStr(classLeaderName);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getDutyDesc() {
		return dutyDesc;
	}
	public void setDutyDesc(String dutyDesc) {
		this.dutyDesc = _Tool.toStr(dutyDesc);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
