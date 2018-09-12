package com.cn.iscp.entity.card.honors;

import com.cn.iscp.model.BasisModel;

/**
 * 集体荣誉对象
 * @author 10011037@qq.com
 * 2018-03-29
 */
public class HonorsCollective extends BasisModel{

	// 自增编号
    private Long collectiveId;
	// 荣誉标题
    private String honorsName;
	// 描述内容
    private String honorContent;
	// 荣誉图片
    private String honorsUrl;
	// 颁奖日期
    private String studyDate;
	// 创建时间
    private String createTime;
	// 创建人
    private Long createUserId;
    
    
    
	public Long getCollectiveId() {
		return collectiveId;
	}
	public void setCollectiveId(Long collectiveId) {
		this.collectiveId = collectiveId;
	}
	public String getHonorsName() {
		return honorsName;
	}
	public void setHonorsName(String honorsName) {
		this.honorsName = honorsName;
	}
	public String getHonorContent() {
		return honorContent;
	}
	public void setHonorContent(String honorContent) {
		this.honorContent = honorContent;
	}
	public String getHonorsUrl() {
		return honorsUrl;
	}
	public void setHonorsUrl(String honorsUrl) {
		this.honorsUrl = honorsUrl;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
    
}
