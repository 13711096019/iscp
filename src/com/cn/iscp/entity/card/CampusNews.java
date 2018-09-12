package com.cn.iscp.entity.card;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;
import com.cn.unit.utils.DateUtil;

/**
 * 校园新闻对象
 * @author 10011037@qq.com
 * 2017-08-09
 */
public class CampusNews extends BasisModel{
	
	// 自增编号
    private Long newsId;
	// 标题
    private String title;
	// 内容
    private String content;
	// 链接
    private String link;
	// 数据类别(1校园新闻,2名人典故,3科普知识)
    private Integer newsMold;
	// 新闻分类[CONST.ITEMCORD_NEWS_TYPE]
    private Integer newsType;
	// 存在有效期
    private Integer hasValidDate;
	// 起始有效时间
    private String startTime;
	// 截止有效时间
    private String endTime;
	// 封面图
    private String coverPic;
	// 上传时间
    private String uploadTime;
	// 上传人
    private Long uploadUserId;
    
	// 新闻分类名称
    private String newsTypeName;
	// 时间范围
    private String timeFrame;
	// 上传人姓名
    private String uploadUserName;
	// 上传人头像
    private String uploadUserPic;

    /**
     * 新增
     */
	public void setInsert(Long loginUserId) {
		super.setInsert();
    	this.hasValidDate = 1;
    	this.uploadUserId = loginUserId;
    	this.uploadTime = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
	}
    
    /**
     * 无参构造函数
     */
	public CampusNews(){};
	
	/**
     * 删除
     */
	public CampusNews(Long newsId){
		super(_Const.STATE_ERROR);
    	this.newsId = newsId;
	}
	
	/**
	 * 更新时间戳
	 */
	public CampusNews(Long newsId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.newsId = newsId;
	}
    
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getNewsType() {
		return newsType;
	}
	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}
	public Integer getHasValidDate() {
		return hasValidDate;
	}
	public void setHasValidDate(Integer hasValidDate) {
		this.hasValidDate = hasValidDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = _Tool.toStr(startTime);
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = _Tool.toStr(endTime);
	}
	public String getNewsTypeName() {
		return newsTypeName;
	}
	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = _Tool.toStr(newsTypeName);
	}
	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = _Tool.toStr(timeFrame);
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
	public String getUploadUserName() {
		return uploadUserName;
	}
	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = _Tool.toStr(uploadUserName);
	}
	public String getUploadUserPic() {
		return uploadUserPic;
	}
	public void setUploadUserPic(String uploadUserPic) {
		this.uploadUserPic = _Tool.toStr(uploadUserPic);
	}
	public Integer getNewsMold() {
		return newsMold;
	}
	public void setNewsMold(Integer newsMold) {
		this.newsMold = newsMold;
	}
	public String getCoverPic() {
		return coverPic;
	}
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
	
	
}
