package com.cn.iscp.entity.card.honors;

import java.util.List;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 班级荣誉对象
 * @author 10011037@qq.com
 * 2017-07-13
 */
public class HonorsClass extends BasisModel{

	// 自增编号
    private Long chId;
	// 班主体动态年级编号
    private Long classNum;
	// 学年
    private Long schoolYearId;
	// 学年度
    private Integer termId;
	// 月份
    private Integer month;
	// 周
    private Integer weekNum;
	// 荣誉编号
    private Long honorsId;
	// 获奖时间
    private String studyDate;
	// 荣誉排名
    private Integer honorsSort;
	// 备注
    private String note;

	// 班级名称
    private String className;
	// 荣誉名称
    private String honorsName;
	// 荣誉图片路径
    private String honorsUrl;
	// 班主体动态年级编号集合
    private String classNums;
	// 老师姓名
    private String teacherName;
	// 头像
    private String headPortrait;
	// 获取年级阶段
    private Integer stage;
    // 荣誉列表
    private List<HonorsClass> honorsList;
    
    public HonorsClass(){};
    
    /**
     * PC-颁发班级荣誉
     */
    public HonorsClass(String classNums, Long honorsId, String studyDate, String note){
    	super.setInsert();
    	this.classNums = classNums;
    	this.honorsId = honorsId;
    	this.studyDate = studyDate;
    	this.note = note;
    }
    
	/**
     * 删除
     */
	public HonorsClass(Long chId, Long classNum){
		super(_Const.STATE_ERROR);
    	this.chId = chId;
    	this.classNum = classNum;
	}
    
	public Long getChId() {
		return chId;
	}
	public void setChId(Long chId) {
		this.chId = chId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getHonorsId() {
		return honorsId;
	}
	public void setHonorsId(Long honorsId) {
		this.honorsId = honorsId;
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
		this.note = note;
	}
	public String getHonorsName() {
		return honorsName;
	}
	public void setHonorsName(String honorsName) {
		this.honorsName = _Tool.toStr(honorsName);
	}
	public String getHonorsUrl() {
		return honorsUrl;
	}
	public void setHonorsUrl(String honorsUrl) {
		this.honorsUrl = _Tool.toStr(honorsUrl);
	}
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public Integer getHonorsSort() {
		return honorsSort;
	}
	public void setHonorsSort(Integer honorsSort) {
		this.honorsSort = honorsSort;
	}
	public List<HonorsClass> getHonorsList() {
		return honorsList;
	}
	public void setHonorsList(List<HonorsClass> honorsList) {
		this.honorsList = honorsList;
	}
	public String getClassNums() {
		return classNums;
	}
	public void setClassNums(String classNums) {
		this.classNums = _Tool.toStr(classNums);
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public Integer getStage() {
		return stage;
	}
	public void setStage(Integer stage) {
		this.stage = stage;
	}
	public Integer getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
    
}
