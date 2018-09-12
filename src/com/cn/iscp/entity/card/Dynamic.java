package com.cn.iscp.entity.card;

import com.cn.common._Tool;

/**
 * 班级动态对象
 * @author 10011037@qq.com
 * 2017-07-13
 */
public class Dynamic {

	// 自增编号
    private Long dynamicId;
	// 班主体动态年级编号
    private Long classNum;
	// 图片路径
    private String title;
	// 备注
    private String content;
	// 图片路径
    private String pictureUrl;
	// 上传时间
    private String uploadTime;
	// 上传人
    private Long uploadUserId;
    
    
    
    
	public Long getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(Long dynamicId) {
		this.dynamicId = dynamicId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = _Tool.toStr(title);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = _Tool.toStr(content);
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = _Tool.toStr(uploadTime);
	}
	public Long getUploadUserId() {
		return uploadUserId;
	}
	public void setUploadUserId(Long uploadUserId) {
		this.uploadUserId = uploadUserId;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = _Tool.toStr(pictureUrl);
	}
	
}
