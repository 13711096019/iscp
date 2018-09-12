package com.cn.iscp.entity.base;

import java.util.List;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.entity.prepare.Topic;
import com.cn.iscp.model.BasisModel;

/**
 * 科目对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Subject extends BasisModel{
	
	// 自增编号
    private Long subjectId;
	// 科目名称
    private String subjectName;
	// 排序
    private Integer sort;
	// 备注
    private String note;

	// 年级科目目录
    private Integer subjectCount;
    // 课题列表
    private List<Topic> topicList;
    
    /**
     * 无参构造函数
     */
	public Subject(){};
	
	/**
     * 删除
     */
	public Subject(Long subjectId){
		super(_Const.STATE_ERROR);
    	this.subjectId = subjectId;
	}
	
	/**
	 * 更新时间戳
	 */
	public Subject(Long subjectId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.subjectId = subjectId;
	}
    
    
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = _Tool.toStr(subjectName);
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
	public Integer getSubjectCount() {
		return subjectCount;
	}
	public void setSubjectCount(Integer subjectCount) {
		this.subjectCount = subjectCount;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		if(topicList == null || topicList.size() < 1){
			topicList = null;
		}
		this.topicList = topicList;
	}
	
}