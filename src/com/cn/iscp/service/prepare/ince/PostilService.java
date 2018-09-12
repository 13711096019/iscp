package com.cn.iscp.service.prepare.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.prepare.Postil;

public interface PostilService {

	/**
	 * 工作-插入标注
	 */
	Postil insertPostil(Postil model);

	/**
	 * 工作-删除标注
	 */
	boolean deletePostil(Long postilId);
	
	/**
	 * 工作-根据标注下标指数编号获取批注列表
	 */
	List<Postil> findByIndex(Long indexId);

    List<Postil> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Postil findById(Map<String, Object> map);
	
	boolean insert(Postil model);
	
	boolean update(Postil model);
}
