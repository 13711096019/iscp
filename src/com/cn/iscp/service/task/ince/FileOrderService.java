package com.cn.iscp.service.task.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.task.FileOrder;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;

public interface FileOrderService {

	/**
	 * PC-分页获取工单列表
	 */
	PageModel findPage(Map<String, Object> map);
	
	/**
	 * 根据编号获取工单信息
	 */
	FileOrder findById(Long orderId);
	
	/**
	 * 根据状态获取打印工单列表(老师)
	 */
	List<FileOrder> findByState(FileOrder model);
	
	/**
	 * 根据状态获取打印工单列表(打印员)
	 */
	List<FileOrder> findByWaitPrint(FileOrder model);
	
	/**
	 * 新增打印工单
	 */
	FileOrder insertFileOrder(FileOrder model);
	
	/**
	 * 编辑打印工单
	 */
	StateModel updateFileOrder(FileOrder model);
	
	/**
	 * 编辑打印工单状态
	 */
	StateModel updateFileOrderState(FileOrder model);

	/**
	 * 删除打印工单
	 */
	StateModel deleteFileOrder(Long orderId);
	
}
