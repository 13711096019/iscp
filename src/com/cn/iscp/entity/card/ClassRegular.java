package com.cn.iscp.entity.card;


/**
 * 班级公约对象
 * @author 10011037@qq.com
 * 2017-08-17
 */
public class ClassRegular {
	
	// 自增编号
    private Long regularId;
	// 班主体动态年级编号
    private Long classNum;
	// 创建时间
    private String createTime;
	// 班级公约内容
    private String regular;
	// 备注
    private String note;
	// 状态
    private Integer status;
    
    
    public ClassRegular(){};

    public ClassRegular(Long classNum, String regular){
    	this.classNum = classNum;
    	this.regular = regular;
    }
    
    
	public Long getRegularId() {
		return regularId;
	}
	public void setRegularId(Long regularId) {
		this.regularId = regularId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRegular() {
		return regular;
	}
	public void setRegular(String regular) {
		this.regular = regular;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
