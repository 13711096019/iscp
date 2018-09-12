package com.cn.iscp.service.prepare.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.prepare.Detail;

public interface DetailService {
	
	/**
	 * 工作-分配备课老师
	 */
	Detail insertDetail(Detail model);
	
	/**
	 * 工作-分配备课老师
	 */
	Detail updateDetail(Detail model);
	
	/**
	 * 工作-根据课题编号获取备课明细信息
	 */
	Detail findByTopic(Long topicId);

	/**
	 * 工作-处理备课信息
	 */
	Detail handlePrepareClassInfo(Detail model);

	/**
	 * 工作-修改明细状态 
	 */
	boolean updateDetailStatus(Detail model);
	/**
	 * 更新备课
	 */
	void handleDetail(Detail model);
	
    List<Detail> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Detail findById(Long detailId);
	
	boolean insert(Detail model);
	
	boolean update(Detail model);
}
