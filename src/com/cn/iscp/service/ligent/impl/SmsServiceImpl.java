package com.cn.iscp.service.ligent.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.auth.UserDao;
import com.cn.iscp.dao.ligent.SmsDao;
import com.cn.iscp.entity.auth.User;
import com.cn.iscp.entity.ligent.Sms;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.ligent.ince.SmsService;
import com.cn.paas.jiguang.jsms.ConstJsms;
import com.cn.paas.jiguang.jsms.SendMessage;
import com.cn.unit.utils.DateUtil;

@Service("smsService")
public class SmsServiceImpl implements SmsService {
	
	@Resource
	private SmsDao smsDao;
	@Resource
	private UserDao userDao;

	@Override
	public Sms findByMobile(String mobile) {
		return smsDao.findByMobile(mobile);
	}

	@Override
	public Sms insertSms(Sms model) {
		return smsDao.insertSms(model);
	}

	@Override
	public StateModel sendCodeTempSMS(Long loginUserId, String mobile) {
		// 获取验证码
		Boolean isExist = false;
		String sendCode = "" + (int)((Math.random()*9+1)*100000);
		Sms sms = this.findByMobile(mobile);
		if(sms != null && sms.getIsUse().intValue() == 0 
				&& DateUtil.getTimeDifferent(sms.getSendTime(), null, "second") < ConstJsms.JSMS_TEMP_ACTIVETIME){
			sendCode = sms.getSendCode();
			isExist = true;
		}
		
		// 获取用户类型
		User user = userDao.getByMobile(mobile);
		Integer userType = user != null ? user.getUserType() : 1;
		
    	SendMessage message = new SendMessage(userType, mobile);
    	try {
    		sms = message.sendCodeTempSMS(sendCode);
		} catch (Exception e) {
			return new StateModel(false);
		}
    	if(!isExist && sms != null){
        	sms.setCreateUserId(loginUserId);
        	this.insertSms(sms);
    	}
		return new StateModel("发送成功！", sms);
	}

}
