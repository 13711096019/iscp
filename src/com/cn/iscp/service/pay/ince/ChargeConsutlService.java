package com.cn.iscp.service.pay.ince;

import java.util.Map;

import com.cn.iscp.entity.pay.ChargeConsutl;

public interface ChargeConsutlService {
	
	/**
	 * 获取收费征询信息
	 */
	ChargeConsutl findConsult(ChargeConsutl model);
	
	/**
	 * 提交收费征询信息
	 */
	ChargeConsutl updateConsutl(Map<String, Object> map);
	
}
