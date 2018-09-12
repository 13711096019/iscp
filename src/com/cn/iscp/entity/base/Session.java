package com.cn.iscp.entity.base;

import java.util.Map;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 每日上课节次对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Session extends BasisModel{
	
	// 自增编号
    private Long sessionId;
	// 节次名称
    private String sessionName;
	// 开始时间
    private String startTime;
	// 结算时间
    private String endTime;
	// 是否排课(1是,0否)
    private Integer isTeacherSession;
	// 节次排序
    private Integer sort;
	// 备注
    private String note;
    
    // 课程表对象
    private Map<String, Object> courseMap;
    
    /**
     * 无参构造函数
     */
	public Session(){};
	
	/**
     * 删除
     */
	public Session(Long sessionId){
		super(_Const.STATE_ERROR);
    	this.sessionId = sessionId;
	}
	
	/**
	 * 更新时间戳
	 */
	public Session(Long sessionId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.sessionId = sessionId;
	}
    
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = _Tool.toStr(sessionName);
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getIsTeacherSession() {
		return isTeacherSession;
	}
	public void setIsTeacherSession(Integer isTeacherSession) {
		this.isTeacherSession = isTeacherSession;
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
	public Map<String, Object> getCourseMap() {
		return courseMap;
	}
	public void setCourseMap(Map<String, Object> courseMap) {
		this.courseMap = courseMap;
	}
	
}