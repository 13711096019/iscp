package com.cn.iscp.entity.base;

import java.util.List;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.common._Url;
import com.cn.iscp.entity.card.honors.HonorsStudent;
import com.cn.iscp.model.BasisModel;

/**
 * 荣誉对象
 * @author 10011037@qq.com
 * 2017-07-22
 */
public class Honors extends BasisModel{
	
	// 自增编号
    private Long honorsId;
	// 荣誉名称
    private String honorsName;
	// 荣誉路径
    private String honorsUrl;
	// 荣誉类型(1学生荣誉,2班级荣誉)
    private Integer section;
	// 荣誉名次
    private Integer sort;
	// 备注
    private String note;
    
    // 荣誉评选标准列表
    private List<HonorsCriteria> criteriaList;
    // 学生列表
    private List<HonorsStudent> studentHonorsList;
    
    /**
     * 无参构造函数
     */
	public Honors(){};
	
	/**
     * 删除
     */
	public Honors(Long honorsId){
		super(_Const.STATE_ERROR);
    	this.honorsId = honorsId;
	}

    /**
     * 新增
     */
    public Honors(String honorsName,Integer section, String note,Integer sort, String honorsUrl){
    	this.honorsName = honorsName;
    	this.section = section;
    	this.note = note;
    	this.sort = sort;
    	this.honorsUrl = _Tool.isEmpty(honorsUrl) ? _Url.HONORS_HEAD_PORTRAIT : honorsUrl;
    	this.status = _Const.STATE_SUCCESS;
    	this.flagtime = System.currentTimeMillis();
    }
    /**
     * 更新
     */
    public Honors(Long honorsId,String honorsName,String note,Integer sort, String honorsUrl){
    	this.honorsId = honorsId;
    	this.honorsName = honorsName;
    	this.note = note;
    	this.sort = sort;
    	this.honorsUrl =honorsUrl ;
    	this.status = _Const.STATE_SUCCESS;
    	this.flagtime = System.currentTimeMillis();
    }
	/**
	 * 更新时间戳
	 */
	public Honors(Long honorsId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.honorsId = honorsId;
	}
	
	public Long getHonorsId() {
		return honorsId;
	}
	public void setHonorsId(Long honorsId) {
		this.honorsId = honorsId;
	}
	public String getHonorsName() {
		return honorsName;
	}
	public void setHonorsName(String honorsName) {
		this.honorsName = _Tool.toStr(honorsName);
	}
	public String getHonorsUrl() {
		return honorsUrl;
	}
	public void setHonorsUrl(String honorsUrl) {
		this.honorsUrl = _Tool.toStr(honorsUrl);
	}
	public Integer getSection() {
		return section;
	}
	public void setSection(Integer section) {
		this.section = section;
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
	public List<HonorsCriteria> getCriteriaList() {
		return criteriaList;
	}
	public void setCriteriaList(List<HonorsCriteria> criteriaList) {
		this.criteriaList = criteriaList;
	}
	public List<HonorsStudent> getStudentHonorsList() {
		return studentHonorsList;
	}
	public void setStudentHonorsList(List<HonorsStudent> studentHonorsList) {
		this.studentHonorsList = studentHonorsList;
	}
    
	
}