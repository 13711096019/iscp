package com.cn.iscp.entity.card;


/**
 * 班级值日对象
 * @author 10011037@qq.com
 * 2017-07-11
 */
public class Onduty {
	
	// 自增编号
    private Long ondutyId;
	// 班主体动态年级编号
    private Long classNum;
	// 星期几
    private Integer weekNum;
	// 早读纪律
    private String read;
	// 课间纪律
    private String rest;
	// 早餐中餐
    private String meal;
	// 扫地擦窗
    private String cleaning;
	// 讲台黑板
    private String platform;
	// 电源班牌
    private String source;
	// 标兵
    private String example;
    
    // 栏目编号
    private Integer columnId;
    // 学生编号集合
    private String studentIds;
    
    public Onduty(){}
    
    public Onduty(Long classNum, Integer weekNum, Integer columnId, String studentIds){
    	this.classNum = classNum;
    	this.weekNum = weekNum;
    	this.columnId = columnId;
    	this.studentIds = studentIds;
    }

	public Long getOndutyId() {
		return ondutyId;
	}
	public void setOndutyId(Long ondutyId) {
		this.ondutyId = ondutyId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Integer getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getRest() {
		return rest;
	}
	public void setRest(String rest) {
		this.rest = rest;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getCleaning() {
		return cleaning;
	}
	public void setCleaning(String cleaning) {
		this.cleaning = cleaning;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public Integer getColumnId() {
		return columnId;
	}
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}
	public String getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(String studentIds) {
		this.studentIds = studentIds;
	}
	
	
}
