package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 班别信息对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Class extends BasisModel{
	
	// 自增编号
    private Long classId;
	// 年级编号
    private Long gradeId;
	// 班级名称
    private String className;
	// 班牌名称
    private String classAlias;
	// 规则总分
    private Integer value;
	// 分布顺序
    private Integer sort;
	// 升级规则：分布顺序+10
    private Integer upgradeJump;
	// 备注
    private String note;

	// 年级名称
    private String gradeName;
	// 动态班级编号
    private Long classNum;

    
    /**
     * 无参构造函数
     */
	public Class(){};
	
	/**
     * 删除
     */
	public Class(Long classId){
		super(_Const.STATE_ERROR);
    	this.classId = classId;
	}
	
	/**
	 * 更新时间戳
	 */
	public Class(Long classId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.classId = classId;
	}
    
    
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getClassAlias() {
		return classAlias;
	}
	public void setClassAlias(String classAlias) {
		this.classAlias = _Tool.toStr(classAlias);
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getUpgradeJump() {
		return upgradeJump;
	}
	public void setUpgradeJump(Integer upgradeJump) {
		this.upgradeJump = upgradeJump;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = _Tool.toStr(gradeName);
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}

}