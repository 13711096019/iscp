package com.cn.iscp.entity.card;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.common._Url;

/**
 * 风采作品对象
 * @author 10011037@qq.com
 * 2017-08-09
 */
public class CampusWorks{
	
	// 自增编号
    private Long worksId;
	// 作品分类[CONST.ITEMCORD_WORKS_TYPE]
    private Long worksType;
	// 范围等级[CONST.ITEMDIRNAME_RANGE_LEVEL]
    private Integer scopeId;
	// 标题
    private String title;
	// 作品描述
    private String content;
	// 网络路径（http路径+文件名）
    private String httpPath;
	// 本地路径（文件目录+文件名）
    private String localPath;
	// 文件目录
    private String fileDir;
	// 文件名（带后缀）
    private String fileName;
	// 文件后缀
    private String fileExt;
	// 存在有效期
    private Integer hasValidDate;
	// 起始有效时间
    private String startTime;
	// 截止有效时间
    private String endTime;
	// 作品发布日期
    private String distributeDate;
	// 作品发布人编号
    private Long distributeUserId;
    // 发布人姓名
    private String distributeUserName;
	// 上传时间
    private String uploadTime;
	// 上传人
    private Long uploadUserId;
	// 允许发布(0已删除,1显示,2已经结束)
    private Integer status;
    
	// 作品发布人头像
    private String distributeUserHead;
    // 时间范围
    private String timeFrame;
    // 学校编号
    private Long schoolId;
    
    public Long getSchoolId() {
		return schoolId;
	}


	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}


	public String getTimeFrame() {
		return timeFrame;
	}


	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}


	/**
     * 无参构造函数
     */
	public CampusWorks(){};
	
    
    /**
     * 删除
     */
	public CampusWorks(Long worksId){
		this.status = _Const.STATE_ERROR;
    	this.worksId = worksId;
	}
	 /**
     * 新增 
     */
    public CampusWorks(Long worksType,Integer scopeId,Integer hasValidDate,String title,String uploadTime,String distributeDate,String distributeUserName,Long uploadUserId,String content,String startTime,String endTime, String localPath){  	
    	this.worksType = worksType;
    	this.scopeId = scopeId;
    	this.hasValidDate = hasValidDate;
    	this.title = title;
    	this.uploadTime = uploadTime;
    	this.content = content;
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.distributeDate=distributeDate;
    	this.uploadUserId = uploadUserId;
    	this.distributeUserName = distributeUserName;
    	this.localPath = _Tool.isEmpty(localPath) ? _Url.HONORS_HEAD_PORTRAIT : localPath;
    	this.status = _Const.STATE_SUCCESS;
    }
    /**
     * 更新
     */
    public CampusWorks(Long worksId,Long worksType,String title,String distributeUserName,Long uploadUserId,String content,String startTime,String endTime, String localPath){
    	this.worksId=worksId;
    	this.worksType = worksType;
    	this.title = title;
    	this.content = content;
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.uploadUserId = uploadUserId;
    	this.distributeUserName = distributeUserName;
    	this.localPath = _Tool.isEmpty(localPath) ? _Url.HONORS_HEAD_PORTRAIT : localPath;
    	this.status = _Const.STATE_SUCCESS;
    }
    
	public Long getWorksId() {
		return worksId;
	}
	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}
	public Long getWorksType() {
		return worksType;
	}
	public void setWorksType(Long worksType) {
		this.worksType = worksType;
	}
	public Integer getScopeId() {
		return scopeId;
	}
	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
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
		this.content = _Tool.toStr(content);
	}
	public Long getDistributeUserId() {
		return distributeUserId;
	}
	public void setDistributeUserId(Long distributeUserId) {
		this.distributeUserId = distributeUserId;
	}
	public String getHttpPath() {
		return httpPath;
	}
	public void setHttpPath(String httpPath) {
		this.httpPath = httpPath;
	}
	public String getLocalPath() {
		return localPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
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
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDistributeDate() {
		return distributeDate;
	}
	public void setDistributeDate(String distributeDate) {
		this.distributeDate = distributeDate;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Long getUploadUserId() {
		return uploadUserId;
	}
	public void setUploadUserId(Long uploadUserId) {
		this.uploadUserId = uploadUserId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDistributeUserName() {
		return distributeUserName;
	}
	public void setDistributeUserName(String distributeUserName) {
		this.distributeUserName = _Tool.toStr(distributeUserName);
	}
	public String getDistributeUserHead() {
		return distributeUserHead;
	}
	public void setDistributeUserHead(String distributeUserHead) {
		this.distributeUserHead = _Tool.toStr(distributeUserHead);
	}
	
}
