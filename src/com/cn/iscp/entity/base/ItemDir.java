package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 分类目录对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class ItemDir extends BasisModel{
	
	// 自增编号
    private Long itemDirId;
    // 分类名称
    private String itemDirName;
    // 分类描述
    private String itemDirDesc;
    
    
    /**
     * 无参构造函数
     */
	public ItemDir(){};
	
	/**
     * 删除
     */
	public ItemDir(Long itemDirId){
		super(_Const.STATE_ERROR);
    	this.itemDirId = itemDirId;
	}
	
	/**
	 * 更新时间戳
	 */
	public ItemDir(Long itemDirId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.itemDirId = itemDirId;
	}
    
    
	public Long getItemDirId() {
		return itemDirId;
	}
	public void setItemDirId(Long itemDirId) {
		this.itemDirId = itemDirId;
	}
	public String getItemDirName() {
		return itemDirName;
	}
	public void setItemDirName(String itemDirName) {
		this.itemDirName = _Tool.toStr(itemDirName);
	}
	public String getItemDirDesc() {
		return itemDirDesc;
	}
	public void setItemDirDesc(String itemDirDesc) {
		this.itemDirDesc = _Tool.toStr(itemDirDesc);
	}
	
}