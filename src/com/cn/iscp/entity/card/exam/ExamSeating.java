package com.cn.iscp.entity.card.exam;

/**
 * 试卷座位模板座位表
 * @author 10011037@qq.com
 * 2017-12-26
 */
public class ExamSeating {
	
	// 自增编号
	private Long seatingId;
	// 考试座位表模板编号
    private Long tempId;
	// 班主体动态年级编号
    private Long classNum;
	// 学生编号
    private Long studentId;
	// 行号
	private Integer rowNo;
	// 列号
	private Integer colNo;

	// 学生编号
	private String studentNum;
	// 学生姓名
	private String studentName;
	// 学生性别
    private Integer sexId;
	// 学生姓名列表
	private String studentNames;
	
	public ExamSeating(){};
	
	public ExamSeating(Long tempId, Long classNum){
		this.tempId = tempId;
		this.classNum = classNum;
	}
	
	public ExamSeating(Long tempId, Long classNum, String studentNames){
		this.tempId = tempId;
		this.classNum = classNum;
		this.studentNames = studentNames;
	}
	
	
	public Long getSeatingId() {
		return seatingId;
	}
	public void setSeatingId(Long seatingId) {
		this.seatingId = seatingId;
	}
	public Long getTempId() {
		return tempId;
	}
	public void setTempId(Long tempId) {
		this.tempId = tempId;
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
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public String getStudentNames() {
		return studentNames;
	}
	public void setStudentNames(String studentNames) {
		this.studentNames = studentNames;
	}
	
}
