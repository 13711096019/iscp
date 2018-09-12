package com.cn.iscp.dao.pay;

import java.util.List;

import com.cn.iscp.entity.pay.ChargeConsutlItem;

public interface ChargeConsutlItemDao {
	
	/**
	 * 获取征询意见项目列表
	 */
	List<ChargeConsutlItem> findByConsult(Long consutlId);
	
}
