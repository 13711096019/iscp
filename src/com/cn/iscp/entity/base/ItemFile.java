package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 分项目录对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class ItemFile extends BasisModel{
	
	/**
	 * 状态：0删除，1正常，2下拉列表不显示
	 */
	
	// 自增编号
    private Long itemFileId;
	// 父级分类
    private Long itemDirId;
	// 分项名称
    private String itemFileName;
	// 分项别名
    private String itemFileNick;
	// 分项描述
    private String itemFileDesc;
	// 排序
    private Integer sort;

	// 分类名称
    private String itemDirName;

    
    /**
     * 无参构造函数
     */
	public ItemFile(){};
	
	/**
     * 删除
     */
	public ItemFile(Long itemFileId){
		super(_Const.STATE_ERROR);
    	this.itemFileId = itemFileId;
	}
	
	/**
	 * 更新时间戳
	 */
	public ItemFile(Long itemFileId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.itemFileId = itemFileId;
	}
	
	/**
     * 
     */
	public ItemFile(Integer itemFileId, Long itemDirId){
    	this.itemFileId = Long.valueOf(itemFileId);
    	this.itemDirId = itemDirId;
	}
    
	public Long getItemFileId() {
		return itemFileId;
	}
	public void setItemFileId(Long itemFileId) {
		this.itemFileId = itemFileId;
	}
	public Long getItemDirId() {
		return itemDirId;
	}
	public void setItemDirId(Long itemDirId) {
		this.itemDirId = itemDirId;
	}
	public String getItemFileName() {
		return itemFileName;
	}
	public void setItemFileName(String itemFileName) {
		this.itemFileName = _Tool.toStr(itemFileName);
	}
	public String getItemFileDesc() {
		return itemFileDesc;
	}
	public void setItemFileDesc(String itemFileDesc) {
		this.itemFileDesc = _Tool.toStr(itemFileDesc);
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getItemDirName() {
		return itemDirName;
	}
	public void setItemDirName(String itemDirName) {
		this.itemDirName = _Tool.toStr(itemDirName);
	}
	public String getItemFileNick() {
		return itemFileNick;
	}
	public void setItemFileNick(String itemFileNick) {
		this.itemFileNick = _Tool.toStr(itemFileNick);
	}

    
}