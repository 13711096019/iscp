package com.cn.iscp.service.pay.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.pay.ChargeOrder;
import com.cn.iscp.model.StateModel;

/**
 * 收费设置
 * @author xz
 * 2018-03-01
 */
public interface ChargeOrderService {
	
	// 新增工单
	StateModel insertOrder(ChargeOrder model);
	
	// 编辑工单
	ChargeOrder updateOrder(ChargeOrder model);

	//分页获取列表数据
	List<ChargeOrder> findPage(Map<String, Object> map);
		
	//获取分页总数
	Long getPageCount(Map<String, Object> map);
	    
	//根据编号获取列表
	ChargeOrder findById(Long orderId);
    
	// 获取最新学期班级缴费工单编号
	ChargeOrder getByStudent(Long studentId);
	
	//更新状态
	boolean updateStatus(ChargeOrder model);
	
	//根据编号判断是否录入收费价格
	Integer findpriceById(Long orderId);

}
