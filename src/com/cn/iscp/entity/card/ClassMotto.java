package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 班风班训对象
 * @author 10011037@qq.com
 * 2017-08-07
 */
public class ClassMotto {
	
	// 自增编号
    private Long mottoId;
	// 班主体动态年级编号
    private Long classNum;
	// 班风
    private String atmosphere;
	// 班训
    private String motto;
	// 备注
    private String note;
	// 口号
    private String slogan;
	// 目标
    private String goal;
	// 公约
    private String regulations;
	// 班主任寄语
    private String leaveWord;
	// 班貌(班级图片)
    private String appearance;
    
    public ClassMotto(){};
    
    public ClassMotto(Long classNum, String atmosphere, String motto, String slogan, 
    		String goal, String leaveWord, String appearance){
    	this.classNum = classNum;
    	this.atmosphere = atmosphere;
    	this.motto = motto;
    	this.slogan = slogan;
    	this.goal = goal;
    	this.leaveWord = leaveWord;
    	this.appearance = appearance;
    }
    
    
	public Long getMottoId() {
		return mottoId;
	}
	public void setMottoId(Long mottoId) {
		this.mottoId = mottoId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getAtmosphere() {
		return atmosphere;
	}
	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = _Tool.toStr(slogan);
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = _Tool.toStr(goal);
	}
	public String getRegulations() {
		return regulations;
	}
	public void setRegulations(String regulations) {
		this.regulations = _Tool.toStr(regulations);
	}
	public String getLeaveWord() {
		return leaveWord;
	}
	public void setLeaveWord(String leaveWord) {
		this.leaveWord = _Tool.toStr(leaveWord);
	}
	public String getAppearance() {
		return appearance;
	}
	public void setAppearance(String appearance) {
		this.appearance = _Tool.toStr(appearance);
	}
	
}
