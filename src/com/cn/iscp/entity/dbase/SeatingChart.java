package com.cn.iscp.entity.dbase;

import com.cn.common._Tool;

/**
 * 座位表
 * @author 10011037@qq.com
 * 2017-07-25
 */
public class SeatingChart {
	
	// 自增编号
	private Long seatingId;
	// 动态班级编号
	private Long classNum;
	// 学生编号
	private Long studentId;
	// 行号
	private Integer rowNo;
	// 列号
	private Integer colNo;
	// 状态
	private Integer status;
	// 备注
	private String note;
	// 大组编号
	private Integer bigGroupId;
	// 小组编号
	private Integer smallGroupId;

	// 学生编号
	private String studentNum;
	// 学生姓名
	private String studentName;
	// 学生性别
    private Integer sexId;
	// 学生姓名列表
	private String studentNames;

	public SeatingChart(){};
	
	public SeatingChart(Long classNum, String studentNames){
		this.classNum = classNum;
		this.studentNames = studentNames;
	}
	
	public SeatingChart(Long classNum, Integer smallGroupId){
		this.classNum = classNum;
		this.smallGroupId = smallGroupId;
	}
	
	
	public Long getSeatingId() {
		return seatingId;
	}
	public void setSeatingId(Long seatingId) {
		this.seatingId = seatingId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Integer getRowNo() {
		return rowNo;
	}
	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}
	public Integer getColNo() {
		return colNo;
	}
	public void setColNo(Integer colNo) {
		this.colNo = colNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Integer getBigGroupId() {
		return bigGroupId;
	}
	public void setBigGroupId(Integer bigGroupId) {
		this.bigGroupId = bigGroupId;
	}
	public Integer getSmallGroupId() {
		return smallGroupId;
	}
	public void setSmallGroupId(Integer smallGroupId) {
		this.smallGroupId = smallGroupId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getStudentNames() {
		return studentNames;
	}
	public void setStudentNames(String studentNames) {
		this.studentNames = _Tool.toStr(studentNames);
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = _Tool.toStr(studentNum);
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	
}
