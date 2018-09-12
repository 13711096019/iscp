package com.cn.unit.executor.push.phone;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.quartz.task.BasePushTimed;

/**
 * 校信通知线程池
 */
public class ExecutorNotify {
	
	private static Logger log = Logger.getLogger(ExecutorNotify.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 通知编号
	private Long notifyId;
	// 是否以通知形式推送
	private Boolean isCircular;
	
	
	public ExecutorNotify(Long notifyId, boolean isCircular){
		this.notifyId = notifyId;
		this.isCircular = isCircular;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 校信通知用户推送线程");
            	// PhonePushTimed.PushNotifyUser(getNotifyId(), getIsCircular());
            	PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		List<PushModel> codeList = pushSericel.findUserByNotify(getNotifyId());
        		
        		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_NOTIFY, false);
        		if(push != null){
        			Integer pushCount = 0;
        			for (PushModel pushModel : codeList) {
        				int pushKey = pushModel.getUserType().intValue() == 1 ? PushKey.CODE_PATRIARCH : PushKey.CODE_TEACHER;
        				push.setPushKey(pushKey);
        				push.setKeyId(_Tool.toStr(getNotifyId()));
        				log.info("[校信通知"+push.getPushCode()+"]极光推送：用户类型："+pushModel.getUserType()+"\t"+pushKey+"用户账号" + pushModel.getUserKey());
        				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
        				try {
        					if(getIsCircular()){
        						pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
        					}else{
        						pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
        					}
        				} catch (Exception e) {
        					continue;
        				}
        			}
        		}
            	log.info("结束 校信通知用户推送线程");
            }
        });
    }
	
	public Long getNotifyId() {
		return notifyId;
	}
	public void setNotifyId(Long notifyId) {
		this.notifyId = notifyId;
	}
	public Boolean getIsCircular() {
		return isCircular;
	}
	public void setIsCircular(Boolean isCircular) {
		this.isCircular = isCircular;
	}
	
	
}
