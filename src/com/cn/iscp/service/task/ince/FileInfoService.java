package com.cn.iscp.service.task.ince;

import java.util.List;

import com.cn.iscp.entity.task.FileInfo;
import com.cn.iscp.model.StateModel;

public interface FileInfoService {

	/**
	 * 根据父级编号获取文件列表
	 */
    List<FileInfo> findByPater(FileInfo model);
    
	/**
	 * 根据文件名称模糊查找文件
	 */
    List<FileInfo> findByName(FileInfo model);
    
    /**
	 * 添加文件夹/文档
	 */
    StateModel insertFileInfo(FileInfo model);
    
    /**
	 * 文件重命名
	 */
    StateModel updateFileName(FileInfo model);
    
    /**
	 * 删除文件
	 */
    StateModel deleteFileInfo(FileInfo model);
    
    /**
	 * 移动文件
	 */
    StateModel updatePater(FileInfo model);
    
    /**
	 * PC-根据编号获取对象
	 */
    FileInfo findById(Long fileId);
    
}
