package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 教室位置对象
 * @author 10011037@qq.com
 * 2017-08-30
 */
public class ClassRoom extends BasisModel{

	// 自增编号
    private Long roomId;
	// 教室编码
    private String roomCode;
	// 班主体编号
    private Long classEntityId;
	// 教室名称
    private String roomName;
	// 教室位置(楼号和楼层)
    private String roomLocation;
	// 教室用途
    private String roomUsage;
	// 描述
    private String note;

    
    /**
     * 无参构造函数
     */
	public ClassRoom(){};
	
	/**
     * 删除
     */
	public ClassRoom(Long roomId){
		super(_Const.STATE_ERROR);
    	this.roomId = roomId;
	}
	
	/**
	 * 更新时间戳
	 */
	public ClassRoom(Long roomId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.roomId = roomId;
	}
    
    
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = _Tool.toStr(roomCode);
	}
	public Long getClassEntityId() {
		return classEntityId;
	}
	public void setClassEntityId(Long classEntityId) {
		this.classEntityId = classEntityId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = _Tool.toStr(roomName);
	}
	public String getRoomLocation() {
		return roomLocation;
	}
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = _Tool.toStr(roomLocation);
	}
	public String getRoomUsage() {
		return roomUsage;
	}
	public void setRoomUsage(String roomUsage) {
		this.roomUsage = _Tool.toStr(roomUsage);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	
}
