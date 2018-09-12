package com.cn.iscp.entity.card.exam;

import com.cn.common._Const;

/**
 * 试卷座位模板表
 * @author 10011037@qq.com
 * 2017-12-20
 */
public class ExamSeatingTemp {
	
	// 自增编号
	private Long tempId;
	// 学年编号
    private Long schoolYearId;
	// 年级编号
	private Long gradeId;
	// 模板标题
    private String title;
	// 描述内容
    private String content;
	// 模板状态
	private Integer status;

	// 班主体动态年级编号
    private Long classNum;
	// 年级名称
    private String gradeName;
	// 学生座位数量
    private Integer seatingCount;
    
    public ExamSeatingTemp(){};
    
    public ExamSeatingTemp(Long tempId){
    	this.tempId = tempId;
    	this.status = _Const.STATE_ERROR;
    }
    
	
	public Long getTempId() {
		return tempId;
	}
	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getSeatingCount() {
		return seatingCount;
	}
	public void setSeatingCount(Integer seatingCount) {
		this.seatingCount = seatingCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
