package com.cn.iscp.entity.card;

import com.cn.common._Tool;


/**
 * 菜谱对象
 * @author 10011037@qq.com
 * 2017-09-04
 */
public class CookBook {

	// 自增编号
    private Long cookId;
	// 星期
    private Integer weekDay;
	// 早餐
    private String breakfastCook;
	// 午餐
    private String lunchCook;

	// 星期名称
    private String weekName;
    
    
	public Long getCookId() {
		return cookId;
	}
	public void setCookId(Long cookId) {
		this.cookId = cookId;
	}
	public Integer getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}
	public String getBreakfastCook() {
		return breakfastCook;
	}
	public void setBreakfastCook(String breakfastCook) {
		this.breakfastCook = _Tool.toStr(breakfastCook);
	}
	public String getLunchCook() {
		return lunchCook;
	}
	public void setLunchCook(String lunchCook) {
		this.lunchCook = _Tool.toStr(lunchCook);
	}
	public String getWeekName() {
		return weekName;
	}
	public void setWeekName(String weekName) {
		this.weekName = _Tool.toStr(weekName);
	}
	
}
