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
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.quartz.task.BasePushTimed;

/**
 * 线程池-提醒家长查看作业
 */
public class ExecutorCheckHomework {
	
	private static Logger log = Logger.getLogger(ExecutorCheckHomework.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 作业编号
	private Long homeworkId;
	
	
	public ExecutorCheckHomework(Long homeworkId){
		this.homeworkId = homeworkId;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 提醒家长查看作业线程");
            	// PhonePushTimed.PushNotCheckHomeworkPatriarch(getHomeworkId());
            	PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		List<PushModel> codeList = pushSericel.findPatriarchByNotCheckHomework(homeworkId);
        		
        		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_NOTCHECKHOMEWORK, false);
        		if(push != null){
        			Integer pushCount = 0;
        			for (PushModel pushModel : codeList) {
        				push.setKeyId(_Tool.toStr(homeworkId));
        				log.info("[提醒家长查看作业"+push.getPushCode()+"]极光推送：用户类型："+pushModel.getUserType()+"\t用户账号" + pushModel.getUserKey());
        				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
        				try {
        					pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
        				} catch (Exception e) {
        					continue;
        				}
        			}
        		}
            	log.info("结束 提醒家长查看作业线程");
            }
        });
    }

	public Long getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	
}
