package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.FileType;

public interface FileTypeService {
	
	/**
	 * 获取所有文件类型列表
	 */
	List<FileType> findAll();
	
	/**
	 * 根据关键字模糊查询类型
	 */
	List<FileType> findByKey(String typeKey);
	
}
