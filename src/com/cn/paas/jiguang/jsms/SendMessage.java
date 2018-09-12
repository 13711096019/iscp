package com.cn.paas.jiguang.jsms;

import org.apache.log4j.Logger;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jsms.api.SendSMSResult;
import cn.jsms.api.common.SMSClient;
import cn.jsms.api.common.model.SMSPayload;

import com.cn.iscp.entity.ligent.Sms;

/**
 * 极光短信接口
 * @author 10011037@qq.com
 * 2018-05-22
 */
public class SendMessage {
	
	private static Logger log = Logger.getLogger(SendMessage.class);
	
	private String appKey;
	private String masterSecret;
	// 发送的手机号
	private String sendPhone;
	// 用户类型(1学生,2老师)
	private Integer userType;
	
	/**
	 * 极光短信接口
	 * @param userType 用户类型(1学生,2老师)
	 */
	public SendMessage(Integer userType, String sendPhone){
		this.userType = userType;
		this.sendPhone = sendPhone;
		switch (userType) {
		case 1:	// 学生(家长端)
			this.appKey = ConstJsms.JSMS_APPLY_APPKEY_PATRIARCH;
			this.masterSecret = ConstJsms.JSMS_APPLY_SECRET_PATRIARCH;
			break;
		case 2:	// 老师(教师端)
			this.appKey = ConstJsms.JSMS_APPLY_APPKEY_TEACHER;
			this.masterSecret = ConstJsms.JSMS_APPLY_SECRET_TEACHER;
			break;
		default:
			break;
		}
	}
	
	/**
	 * 单号码验证码模板短信
	 * @param sendCode 验证码
	 * 您的验证码：{{code}}，10分钟内有效，请勿泄露。如非本人操作，请忽略此短信。
	 */
	public Sms sendCodeTempSMS(String sendCode) {
		// 模板信息
		Integer tempId = getUserType().intValue() == 1 ? 
				ConstJsms.JSMS_TEMPID_PATRIARCH : ConstJsms.JSMS_TEMPID_TEACHER;
        String tempContent = "您的验证码："+sendCode+"，10分钟内有效，请勿泄露。如非本人操作，请忽略此短信";
        
	    SMSClient client = new SMSClient(getMasterSecret(), getAppKey());
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber(getSendPhone())
                .setTempId(tempId)
                .addTempPara("code", sendCode)
                .build();
        
        try {
            SendSMSResult res = client.sendTemplateSMS(payload);
            log.info(res.toString());
            System.out.println(res.toString());
            Sms sms = new Sms(getSendPhone(), getUserType(), 
            		res.getMessageId(), tempId, sendCode, tempContent);
            return sms;
        } catch (APIRequestException e) {
        	log.error("Error response from JPush server. Should review and fix it. ", e);
        	log.info("HTTP Status: " + e.getStatus());
        	log.info("Error Message: " + e.getMessage());
        } catch (APIConnectionException e) {
        	log.error("Connection error. Should retry later. ", e);
        }
        return null;
    }
	
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getMasterSecret() {
		return masterSecret;
	}
	public void setMasterSecret(String masterSecret) {
		this.masterSecret = masterSecret;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
}
