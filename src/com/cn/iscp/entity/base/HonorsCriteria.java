package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 荣誉评选标准
 * @author 10011037@qq.com
 * 2017-08-08
 */
public class HonorsCriteria extends BasisModel{
	
	// 自增编号
    private Long criteriaId;
	// 荣誉编号
    private Long honorsId;
	// 条件内容
    private String content;
	// 荣誉名次
    private Integer sort;
    
    
    //荣誉名称
    private String honorsName;

    
    public String getHonorsName() {
		return honorsName;
	}

	public void setHonorsName(String honorsName) {
		this.honorsName = honorsName;
	}

	/**
     * 无参构造函数
     */
	public HonorsCriteria(){};
	
	/**
     * 删除
     */
	public HonorsCriteria(Long criteriaId){
		super(_Const.STATE_ERROR);
    	this.criteriaId = criteriaId;
	}
	
	/**
	 * 更新时间戳
	 */
	public HonorsCriteria(Long criteriaId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.criteriaId = criteriaId;
	}

	
	
	public Long getCriteriaId() {
		return criteriaId;
	}
	public void setCriteriaId(Long criteriaId) {
		this.criteriaId = criteriaId;
	}
	public Long getHonorsId() {
		return honorsId;
	}
	public void setHonorsId(Long honorsId) {
		this.honorsId = honorsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = _Tool.toStr(content);
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
}
