package com.cn.iscp.entity.card.civilized;

import java.util.List;

import com.cn.common._Tool;

/**
 * 创文规则大项
 * @author 10011037@qq.com
 * 2017-09-08
 */
public class CivilizedItem {

	// 自增编号
    private Long bigItemId;
	// 创文评分大项名称
    private String bigItemName;
	// 创文评分大项关键名
    private String saveFieldName;
	// 排序
    private Integer sort;
    
    // 规则列表
    private List<CivilizedRegular> regularList;
    
    
	public Long getBigItemId() {
		return bigItemId;
	}
	public void setBigItemId(Long bigItemId) {
		this.bigItemId = bigItemId;
	}
	public String getBigItemName() {
		return bigItemName;
	}
	public void setBigItemName(String bigItemName) {
		this.bigItemName = _Tool.toStr(bigItemName);
	}
	public String getSaveFieldName() {
		return saveFieldName;
	}
	public void setSaveFieldName(String saveFieldName) {
		this.saveFieldName = _Tool.toStr(saveFieldName);
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public List<CivilizedRegular> getRegularList() {
		return regularList;
	}
	public void setRegularList(List<CivilizedRegular> regularList) {
		this.regularList = regularList;
	}
    
}
