package com.cn.iscp.service.ligent.ince;

import com.cn.iscp.entity.ligent.Sms;
import com.cn.iscp.model.StateModel;

public interface SmsService {
	
	/**
	 * 根据手机号获取最近短信信息
	 */
	Sms findByMobile(String mobile);

	/**
	 * 新增短信信息
	 */
	Sms insertSms(Sms model);

	/**
	 * 发送验证码短信请求
	 */
	StateModel sendCodeTempSMS(Long loginUserId, String mobile);
	
}
