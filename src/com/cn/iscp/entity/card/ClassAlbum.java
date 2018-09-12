package com.cn.iscp.entity.card;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;
import com.cn.unit.utils.DateUtil;

/**
 * 班级相册对象
 * @author 10011037@qq.com
 * 2017-07-13
 */
public class ClassAlbum extends BasisModel{

	// 自增编号
    private Long albumId;
	// 班主体动态年级编号
    private Long classNum;
	// 图片路径
    private String pictureUrl;
	// 备注
    private String note;
	// 上传时间
    private String uploadTime;
	// 上传人
    private Long uploadUserId;
    
    // 是否班貌(1是,0否)
    private Integer isAppearance;
    
    public ClassAlbum(){};
    
    /**
     * 新增
     */
    public ClassAlbum(Long classNum, String pictureUrl, String note, Long uploadUserId){
    	super.setInsert();
    	this.classNum = classNum;
    	this.pictureUrl = pictureUrl;
    	this.note = note;
    	this.uploadTime = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
    	this.uploadUserId = uploadUserId;
    }
    
	/**
     * 删除
     */
	public ClassAlbum(Long albumId){
		super(_Const.STATE_ERROR);
    	this.albumId = albumId;
	}
    
	public Long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = _Tool.toStr(pictureUrl);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
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
	public Integer getIsAppearance() {
		return isAppearance;
	}
	public void setIsAppearance(Integer isAppearance) {
		this.isAppearance = isAppearance;
	}
    
}
