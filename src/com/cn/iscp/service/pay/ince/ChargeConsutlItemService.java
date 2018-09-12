package com.cn.iscp.service.pay.ince;

import java.util.List;

import com.cn.iscp.entity.pay.ChargeConsutlItem;

public interface ChargeConsutlItemService {
	
	/**
	 * 获取征询意见项目列表
	 */
	List<ChargeConsutlItem> findByConsult(Long consutlId);
	
}
