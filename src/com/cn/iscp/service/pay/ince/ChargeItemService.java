package com.cn.iscp.service.pay.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.pay.ChargeItem;
import com.cn.iscp.entity.pay.ChargeSeating;

/**
 * 收费设置
 * @author xz
 * 2018-03-01
 */
public interface ChargeItemService {
	
	// 根据工单编号获取缴费项列表
	List<ChargeItem> findByOrder(ChargeSeating model);
	
	//分页获取列表数据
	List<ChargeItem> findPage(Map<String, Object> map);
		
	//获取分页总数
	Long getPageCount(Map<String, Object> map);
	    
	//根据编号获取列表
	ChargeItem findById(Long chargeitemId);
	
	//更新
	boolean update(ChargeItem model);
	
	//新增
	boolean insert(ChargeItem model);

}
