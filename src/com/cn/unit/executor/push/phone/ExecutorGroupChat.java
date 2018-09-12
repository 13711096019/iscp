package com.cn.unit.executor.push.phone;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.quartz.task.BasePushTimed;

/**
 * 线程池-修改群聊信息推送
 */
public class ExecutorGroupChat {
	
	private static Logger log = Logger.getLogger(ExecutorNotify.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 群编号
	private String groupId;
	// 群名称
	private String groupName;

	
	public ExecutorGroupChat(String groupId, String groupName){
		this.groupId = groupId;
		this.groupName = groupName;
	}
	
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 修改群聊信息推送线程");
            	// PhonePushTimed.PushGroupChatUser(getGroupId(), getGroupName());
            	PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		List<PushModel> codeList = pushSericel.findGroupChatUser(getGroupId());
        		
        		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_GROUPCHAT, false);
        		Integer pushCount = 0;
        		for (PushModel pushModel : codeList) {
        			int pushKey = pushModel.getUserType().intValue() == 1 ? PushKey.CODE_PATRIARCH : PushKey.CODE_TEACHER;
        			push.setPushKey(pushKey);
        			push.setKeyId(getGroupId());
        			log.info("[群聊信息更新"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
        			PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, getGroupName());
        			try {
        				pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
        			} catch (Exception e) {
        				continue;
        			}
        		}
            	log.info("结束 修改群聊信息推送线程");
            }
        });
    }


	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
}
