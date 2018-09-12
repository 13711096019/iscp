package com.cn.iscp.entity.card.exam;

/**
 * 考试座位表
 * @author 10011037@qq.com
 * 2017-12-27
 */
public class ExamDescSeating {
	
	// 自增编号
	private Long seatingId;
	// 动态班级编号
	private Long classNum;
	// 考试编号
	private Long examInfoId;
	// 试卷编号
	private Long examId;
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
	
	// 学生编号
	private String studentNum;
	// 学生姓名
	private String studentName;
	// 学生性别
    private Integer sexId;
	// 学生姓名列表
	private String studentNames;
	
	public ExamDescSeating(){};
	
	public ExamDescSeating(Long examInfoId, Long classNum){
		this.examInfoId = examInfoId;
		this.classNum = classNum;
	}
	
	public ExamDescSeating(Long examInfoId, Long classNum, String studentNames){
		this.examInfoId = examInfoId;
		this.classNum = classNum;
		this.studentNames = studentNames;
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
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
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
		this.note = note;
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
	public Long getExamInfoId() {
		return examInfoId;
	}
	public void setExamInfoId(Long examInfoId) {
		this.examInfoId = examInfoId;
	}
	
}
