package com.cn.iscp.dao.ligent;

import com.cn.iscp.entity.ligent.Sms;

public interface SmsDao {
	
	/**
	 * 根据手机号获取最近短信信息
	 */
	Sms findByMobile(String mobile);

	/**
	 * 新增短信信息
	 */
	Sms insertSms(Sms model);
	
}
