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
 * 线程池-日程提醒
 */
public class ExecutorCalendar {
	
	private static Logger log = Logger.getLogger(ExecutorCalendar.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	
	public ExecutorCalendar(){}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 日程提醒推送线程");
            	// PhonePushTimed.PushCalendar();
            	// 日程逻辑层
        		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		List<PushModel> codeList = pushSericel.findUserByCurrent();
        		
        		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_CALENDAR, false);
        		Integer pushCount = 0;
        		for (PushModel pushModel : codeList) {
        			int pushKey = pushModel.getUserType().intValue() == 1 ? PushKey.CODE_PATRIARCH : PushKey.CODE_TEACHER;
        			push.setPushKey(pushKey);
        			push.setKeyId(_Tool.toStr(pushModel.getKeyId()));
        			log.info("[日程提醒"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
        			PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
        			try {
        				pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
        			} catch (Exception e) {
        				continue;
        			}
        		}
            	log.info("结束日程提醒推送线程");
            }
        });
    }
	
}
