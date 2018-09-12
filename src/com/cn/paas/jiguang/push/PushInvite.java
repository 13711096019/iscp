package com.cn.paas.jiguang.push;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.cn.common._Tool;
import com.cn.iscp.entity.dbase.ClassMgr;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.service.dbase.impl.ClassMgrServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 极光推送工具类
 * @author 10011037@qq.com
 * 2016-02-12
 */
public class PushInvite extends PushKey{
	
	public static void main(String[] args) {
		PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, "15113696535", PushCode.REMIND_TEACHERCLASS);
		jdpust.buildPushHasAlert(0);
	}
	
	private static Logger log = Logger.getLogger(PushInvite.class);
	
	// 大标题
	public static final String TITLE = "智慧校园";
	// 描述
	public static final String ALERT = "信息推送";
	
	public static final Integer MAXRETRYTIMES = 5;
	
	public static JPushClient jpushClient = null;
	
	// 推送标题
	private String pushTitle;
	// 推送内容描述
	private String pushDesc;
	// 接收人标识
	private String pushUser;
	// 推送内容
	private Map<String, Object> content;
	
	/**
	 * 根据接收人推送
	 * @param pushUser 接收人
	 * @param push 推送对象
	 * @param keyName 附带内容中的keyName
	 */
	public PushInvite(String pushUser, Push push, String keyName){
		super(push.getPushKey());
		this.pushUser = pushUser;
		this.content = new HashMap<String, Object>();
		content.put("keyNum", push.getPushCode());
		content.put("nozzle", push.getPushPath());
		content.put("describe", push.getPushDesc());
		
		if(_Tool.isLong(push.getKeyId())){
			// 内容中额外附带的编号
			content.put("keyId", push.getKeyId().toString());
		}
		if(!_Tool.isEmpty(keyName)){
			// 内容中额外附带的名称
			content.put("keyName", keyName);
		}
		
		this.pushTitle = push.getPushNick();
		if(_Tool.isEmpty(pushTitle)){
			this.pushTitle = TITLE;
		}
		this.pushDesc = push.getPushDesc();
		if(_Tool.isEmpty(pushDesc)){
			this.pushDesc = ALERT;
		}
	}
	
	/**
	 * 根据动态班级编号推送
	 * @param classNum 动态班级编号
	 * @param keyNum 推送码
	 */
	public PushInvite(int code, Long classNum, Integer keyNum){
		super(code);
		// 通知规则业务逻辑
		ClassMgrServiceImpl classMgrService = (ClassMgrServiceImpl) SpringBeanFactoryUtil.getBean("classMgrService");
		ClassMgr model = classMgrService.getByClassNum(classNum);
		if(model != null){
			this.pushUser = model.getMachineCode();
		}
		this.content = new HashMap<String, Object>();
		content.put("keyNum", keyNum);
	}
	
	/**
	 * 根据接收人推送
	 * @param pushUser 接收人
	 * @param keyNum 推送码
	 */
	public PushInvite(int code, String pushUser, Integer keyNum){
		super(code);
		this.pushUser = pushUser;
		this.content = new HashMap<String, Object>();
		content.put("keyNum", keyNum);
		/*if(keyNum > 5000){
			content.put("describe", PushCode.INTERFACE_PATH.get(keyNum));
		}else{
			content.put("nozzle", PushCode.INTERFACE_PATH.get(keyNum));
		}*/
	}
	
	/**
	 * 自定义内容推送
	 * @param pushUser 接收人
	 * @param content 推送内容
	 */
	public PushInvite(int code, String pushUser, Map<String, Object> content){
		super(code);
		this.pushUser = pushUser;
		this.content = content;
	}
	
	/**
	 * 没通知栏推送
	 */
	public boolean buildPushNotAlert() {
		// 判断接收人是否为空
		if(_Tool.isEmpty(getPushUser())){
			return false;
		}
		
		jpushClient = new JPushClient(getMasterSecret(), getAppKey(), MAXRETRYTIMES);
		
		PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag(getPushUser()))
                .setMessage(Message.newBuilder()
                        .setMsgContent(_Tool.toJson(getContent()))
                        .build())
                .build();
		
		try {
			jpushClient.sendPush(payload);
			log.info("推送成功:推送码["+getContent().get("keyNum")+"],目标["+getPushUser()+"],内容["+_Tool.toJson(getContent())+"]");
			return true;
		} catch (APIConnectionException e) {
			log.error("连接错误,请稍后再试!", e);
			return false;
		} catch (APIRequestException e) {
			log.error("极光服务器错误响应!", e);
			log.error("HTTP Status: "+e.getStatus()+"\tError Code: "+e.getErrorCode()+"\tError Message: "+e.getErrorMessage());
			return false;
		}
	}
	
	/**
	 * 推送全部(-1)
	 */
	public boolean buildPushAll() {
		// 判断接收人是否为空
		if(_Tool.isEmpty(getPushUser())){
			return false;
		}
		
		jpushClient = new JPushClient(getMasterSecret(), getAppKey(), MAXRETRYTIMES);
		PushPayload payload = PushPayload.alertAll(getPushDesc());
		try {
			jpushClient.sendPush(payload);
			log.info("推送成功:推送码["+getContent().get("keyNum")+"],目标["+getPushUser()+"],内容["+_Tool.toJson(getContent())+"]");
			return true;
		} catch (APIConnectionException e) {
			log.error("连接错误,请稍后再试!", e);
		} catch (APIRequestException e) {
			log.error("极光服务器错误响应!", e);
			log.error("HTTP Status: "+e.getStatus()+"\tError Code: "+e.getErrorCode()+"\tError Message: "+e.getErrorMessage());
		}
		return false;
	}
	
	
	 /**
	  * 有通知栏没附加内容
	  * @param timeToLive 推送存活时间
	  */
	public boolean buildPushHasAlert(Integer timeToLive) {
		// 判断接收人是否为空
		if(_Tool.isEmpty(getPushUser())){
			return false;
		}
		System.out.println("推送内容："+_Tool.toJson(getContent()));
		jpushClient = new JPushClient(getMasterSecret(), getAppKey(), MAXRETRYTIMES);
		PushPayload payload = null;
		if(_Tool.isInt(timeToLive)){
			payload = PushPayload
					.newBuilder()
					.setPlatform(Platform.android_ios())
					.setAudience(Audience.tag(getPushUser()))
					.setNotification(
							Notification
									.newBuilder()
									.setAlert(getPushDesc())
									.addPlatformNotification(
											AndroidNotification.newBuilder()
													.setTitle(getPushTitle()).build())
									.build())
					.setMessage(Message.content(_Tool.toJson(getContent())))
					.setOptions(Options.newBuilder()
							.setTimeToLive(timeToLive)
	                        .build())
					.build();
		}else{
			payload = PushPayload
					.newBuilder()
					.setPlatform(Platform.android_ios())
					.setAudience(Audience.tag(getPushUser()))
					.setNotification(
							Notification
									.newBuilder()
									.setAlert(getPushDesc())
									.addPlatformNotification(
											AndroidNotification.newBuilder()
													.setTitle(getPushTitle()).build())
									/*.addPlatformNotification(
											AndroidNotification.newBuilder()
													.addExtra("keyNum", getKeyNum())
													.build())*/
									/*.addPlatformNotification(
											IosNotification
													.newBuilder()
													.setBadge(1)
													.addExtra("extra_key",
															"extra_value").build())*/
									.build())
					.setMessage(Message.content(_Tool.toJson(getContent())))
					.build();
		}
		try {
			jpushClient.sendPush(payload);
			log.info("推送成功:推送码["+getContent().get("keyNum")+"],目标["+getPushUser()+"],内容["+_Tool.toJson(getContent())+"]");
			return true;
		} catch (APIConnectionException e) {
			log.error("连接错误,请稍后再试!", e);
		} catch (APIRequestException e) {
			log.error("极光服务器错误响应!", e);
			log.error("HTTP Status: "+e.getStatus()+"\tError Code: "+e.getErrorCode()+"\tError Message: "+e.getErrorMessage());
			System.out.println("HTTP Status: "+e.getStatus()+"\tError Code: "+e.getErrorCode()+"\tError Message: "+e.getErrorMessage());
		}
		return false;
	}
	
	
	/**
	 * 有通知栏有附加内容
	 */
	public boolean buildPushHasExtra() {
		// 判断接收人是否为空
		if(_Tool.isEmpty(getPushUser())){
			return false;
		}
		System.out.println("推送内容："+_Tool.toJson(getContent()));
		jpushClient = new JPushClient(getMasterSecret(), getAppKey(), MAXRETRYTIMES);
		PushPayload payload = PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag(getPushUser()))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert(getPushDesc())
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle(getPushTitle()).build())
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.addExtra("extraContent", _Tool.toJson(getContent()))
												.build())
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setBadge(1)
												.addExtra("extraContent",_Tool.toJson(getContent()))
												.build())
								.build())
				// .setMessage(Message.content(Tool.toJson(getContent())))
				.build();
		try {
			jpushClient.sendPush(payload);
			log.info("推送成功:推送码["+getContent().get("keyNum")+"],目标["+getPushUser()+"],内容["+_Tool.toJson(getContent())+"]");
			return true;
		} catch (APIConnectionException e) {
			log.error("连接错误,请稍后再试!");
		} catch (APIRequestException e) {
			// log.error("极光服务器错误响应!", e);
			log.error("极光服务器错误响应: HTTP Status: "+e.getStatus()+"\tError Code: "+e.getErrorCode()+"\tError Message: "+e.getErrorMessage());
		}
		return false;
	}
	
	
	
	public String getPushUser() {
		return pushUser;
	}
	public void setPushUser(String pushUser) {
		this.pushUser = pushUser;
	}
	public Map<String, Object> getContent() {
		return content;
	}
	public void setContent(Map<String, Object> content) {
		this.content = content;
	}
	public String getPushTitle() {
		return pushTitle;
	}
	public void setPushTitle(String pushTitle) {
		this.pushTitle = _Tool.toStr(pushTitle);
	}
	public String getPushDesc() {
		return pushDesc;
	}
	public void setPushDesc(String pushDesc) {
		this.pushDesc = _Tool.toStr(pushDesc);
	}
	
}
