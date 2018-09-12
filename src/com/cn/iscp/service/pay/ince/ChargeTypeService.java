package com.cn.iscp.service.pay.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.pay.ChargeType;

public interface ChargeTypeService {

	//分页获取类型列表
    List<ChargeType> findPage(Map<String, Object> map);
    
    //分页获取列表总数
	Long getPageCount(Map<String, Object> map);
	
	//根据编号获取信息
	ChargeType findById(Long chargetypeId);
	
	//获取所有数据
	List<ChargeType> findAll();
	
	//根据工单编号获取列表
    List<ChargeType> findorderById(Long orderId);
	
	//新增
    boolean insert(ChargeType model);
    
	//更新
	boolean update(ChargeType model);
	
}
