package com.cn.iscp.entity.card;

import com.cn.common._Const;

/**
 * 值日栏目对象
 * @author 10011037@qq.com
 * 2017-07-11
 */
public class OndutyColumn {
	
	// 自增编号
    private Long columnId;
	// 栏目名称
    private String columnName;
	// 栏目要求
    private String columnAsk;
	// 栏目排序
    private Integer sort;
	// 状态
    private Integer status;
    
    
    public OndutyColumn(){}
    
    /**
     * 更新
     */
	public void setUpdate() {
    	this.status = _Const.STATE_SUCCESS;
	}

	public Long getColumnId() {
		return columnId;
	}
	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnAsk() {
		return columnAsk;
	}
	public void setColumnAsk(String columnAsk) {
		this.columnAsk = columnAsk;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
