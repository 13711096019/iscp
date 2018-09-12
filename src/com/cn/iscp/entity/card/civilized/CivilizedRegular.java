package com.cn.iscp.entity.card.civilized;

import com.cn.common._Tool;

/**
 * 创文评分规则表
 * @author 10011037@qq.com
 * 2017-09-08
 */
public class CivilizedRegular {
	
	// 自增编号
    private Long smallItemId;
	// 创文评分大项编号
    private Long bigItemId;
	// 规则类型(1减分,2加分,3一票否决)
    private Integer smallItemType;
	// 是否固定分值(1是,0否)
    private Integer isFixedScore;
	// 创文评分细项排序
    private Integer smallItemSort;
	// 创文评分细项名称
    private String smallItem;
	// 各项排序
    private Integer allItemSort;
	// 分值
    private Double scoreStandard;
	// 创文评分细项描述
    private String smallItemDesc;
	// 是否允许一票否决（1=允许，0=不允许）
    private Integer allowOneNoteVeto;
	// 备注
    private String note;

	// 创文评分大项名称
    private String bigItemName;
	// 当前评分分数（没评分为空）
    private Double score;
    
	
	public Long getSmallItemId() {
		return smallItemId;
	}
	public void setSmallItemId(Long smallItemId) {
		this.smallItemId = smallItemId;
	}
	public Long getBigItemId() {
		return bigItemId;
	}
	public void setBigItemId(Long bigItemId) {
		this.bigItemId = bigItemId;
	}
	public Integer getSmallItemSort() {
		return smallItemSort;
	}
	public void setSmallItemSort(Integer smallItemSort) {
		this.smallItemSort = smallItemSort;
	}
	public String getSmallItem() {
		return smallItem;
	}
	public void setSmallItem(String smallItem) {
		this.smallItem = _Tool.toStr(smallItem);
	}
	public Integer getAllItemSort() {
		return allItemSort;
	}
	public void setAllItemSort(Integer allItemSort) {
		this.allItemSort = allItemSort;
	}
	public Double getScoreStandard() {
		return scoreStandard;
	}
	public void setScoreStandard(Double scoreStandard) {
		this.scoreStandard = scoreStandard;
	}
	public String getSmallItemDesc() {
		return smallItemDesc;
	}
	public void setSmallItemDesc(String smallItemDesc) {
		this.smallItemDesc = _Tool.toStr(smallItemDesc);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public String getBigItemName() {
		return bigItemName;
	}
	public void setBigItemName(String bigItemName) {
		this.bigItemName = _Tool.toStr(bigItemName);
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getAllowOneNoteVeto() {
		return allowOneNoteVeto;
	}
	public void setAllowOneNoteVeto(Integer allowOneNoteVeto) {
		this.allowOneNoteVeto = allowOneNoteVeto;
	}
	public Integer getSmallItemType() {
		return smallItemType;
	}
	public void setSmallItemType(Integer smallItemType) {
		this.smallItemType = smallItemType;
	}
	public Integer getIsFixedScore() {
		return isFixedScore;
	}
	public void setIsFixedScore(Integer isFixedScore) {
		this.isFixedScore = isFixedScore;
	}
    
	
}
