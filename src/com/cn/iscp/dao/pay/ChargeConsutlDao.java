package com.cn.iscp.dao.pay;

import java.util.Map;

import com.cn.iscp.entity.pay.ChargeConsutl;

public interface ChargeConsutlDao {
	
	/**
	 * 获取收费征询信息
	 */
	ChargeConsutl findByStudent(ChargeConsutl model);
	
	/**
	 * 提交收费征询信息
	 */
	ChargeConsutl updateConsutl(Map<String, Object> map);
	
}
