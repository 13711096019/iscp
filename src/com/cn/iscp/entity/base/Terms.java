package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 学期对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Terms extends BasisModel{
	
	// 自增编号
    private Long termId;
	// 学期名称
    private String termName;
	// 排序
    private Integer sort;
	// 备注
    private String note;
    
    /**
     * 无参构造函数
     */
	public Terms(){};
	
	/**
     * 删除
     */
	public Terms(Long termId){
		super(_Const.STATE_ERROR);
    	this.termId = termId;
	}
	
	/**
	 * 更新时间戳
	 */
	public Terms(Long termId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.termId = termId;
	}
    
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = _Tool.toStr(termName);
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}

}