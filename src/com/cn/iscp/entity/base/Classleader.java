package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.iscp.model.BasisModel;


/**
 * 学生班干部
 * @author xz
 * 2017-08-2
 */
public class Classleader extends BasisModel{
	
	// 自增编号
    private Long classleaderId;
	// 班干部类型
    private Integer classLeaderType;
	// 班干部名称
    private String classleaderName;
	// 分布顺序
    private Integer sort;
	// 职位描述
    private String dutyDesc;
    
    /**
     * 无参构造函数
     */
	public Classleader(){};
	
	/**
     * 删除
     */
	public Classleader(Long classleaderId){
		super(_Const.STATE_ERROR);
    	this.classleaderId = classleaderId;
	}
    
	/**
	 * 更新时间戳
	 */
	public Classleader(Long classleaderId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.classleaderId = classleaderId;
	}
	
	public Long getClassleaderId() {
		return classleaderId;
	}
	public void setClassleaderId(Long classleaderId) {
		this.classleaderId = classleaderId;
	}
	public Integer getClassLeaderType() {
		return classLeaderType;
	}
	public void setClassLeaderType(Integer classLeaderType) {
		this.classLeaderType = classLeaderType;
	}
	public String getClassleaderName() {
		return classleaderName;
	}
	public void setClassleaderName(String classleaderName) {
		this.classleaderName = classleaderName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getDutyDesc() {
		return dutyDesc;
	}
	public void setDutyDesc(String dutyDesc) {
		this.dutyDesc = dutyDesc;
	}
}