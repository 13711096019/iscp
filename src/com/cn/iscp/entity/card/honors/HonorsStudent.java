package com.cn.iscp.entity.card.honors;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 学生荣誉对象
 * @author 10011037@qq.com
 * 2017-07-13
 */
public class HonorsStudent extends BasisModel{

	// 自增编号
    private Long shId;
	// 班主体动态年级编号
    private Long classNum;
	// 学生编号
    private Long studentId;
	// 荣誉编号
    private Long honorsId;
	// 该荣誉名次
    private Integer honorsSort;
	// 学年度编号
    private Long termId;
	// 年份
    private Integer year;
	// 月份
    private Integer month;
	// 获奖时间
    private String studyDate;
	// 备注
    private String note;

	// 班级名称
    private String className;
	// 荣誉名称
    private String honorsName;
	// 学生姓名
    private String studentName;
	// 学生头像
    private String headPortrait;
	// 学生编号列表
    private String studentIds;
    
    public HonorsStudent(){};
    
    /**
     * PC-颁发班级荣誉
     */
    public HonorsStudent(Long classNum, Long honorsId, String studentIds, 
    		String studyDate, String note){
    	super.setInsert();
    	this.classNum = classNum;
    	this.honorsId = honorsId;
    	this.studentIds = studentIds;
    	this.studyDate = studyDate;
    	this.note = note;
    }
    
	/**
     * 删除
     */
	public HonorsStudent(Long shId, Long classNum){
		super(_Const.STATE_ERROR);
    	this.shId = shId;
    	this.classNum = classNum;
	}
    
	public Long getHonorsId() {
		return honorsId;
	}
	public void setHonorsId(Long honorsId) {
		this.honorsId = honorsId;
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
	public Long getShId() {
		return shId;
	}
	public void setShId(Long shId) {
		this.shId = shId;
	}
	public Integer getHonorsSort() {
		return honorsSort;
	}
	public void setHonorsSort(Integer honorsSort) {
		this.honorsSort = honorsSort;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = _Tool.toStr(studyDate);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public String getHonorsName() {
		return honorsName;
	}
	public void setHonorsName(String honorsName) {
		this.honorsName = _Tool.toStr(honorsName);
	}
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(String studentIds) {
		this.studentIds = _Tool.toStr(studentIds);
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
