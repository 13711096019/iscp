package com.cn.unit.executor.push.phone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * 边教边研线程池
 */
public class ExecutorResearch {
	
	private static Logger log = Logger.getLogger(ExecutorNotify.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 边教边研编号
	private Long researchId;
	// 评论人
	private Long discussUserId;
	// 是否以通知形式推送
	private Boolean isCircular;

	
	public ExecutorResearch(Long researchId, Long discussUserId, boolean isCircular){
		this.researchId = researchId;
		this.discussUserId = discussUserId;
		this.isCircular = isCircular;
	}
	
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 边教边研推送线程");
            	// PhonePushTimed.PushResearchTeacher(getResearchId(), getDiscussUserId(), getIsCircular());
            	PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("researchId", getResearchId());
        		map.put("createUserId", getDiscussUserId());
        		List<PushModel> codeList = pushSericel.findTeacherByResearch(map);
        		
        		Push push = BasePushTimed.handleInvalidRecords(PushCode.REMIND_RESEARCH, false);
        		if(push != null){
        			Integer pushCount = 0;
        			for (PushModel pushModel : codeList) {
        				push.setKeyId(_Tool.toStr(getResearchId()));
        				log.info("[边教边研"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
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
            	log.info("结束 边教边研推送线程");
            }
        });
    }

	public Long getResearchId() {
		return researchId;
	}
	public void setResearchId(Long researchId) {
		this.researchId = researchId;
	}
	public Long getDiscussUserId() {
		return discussUserId;
	}
	public void setDiscussUserId(Long discussUserId) {
		this.discussUserId = discussUserId;
	}
	public Boolean getIsCircular() {
		return isCircular;
	}
	public void setIsCircular(Boolean isCircular) {
		this.isCircular = isCircular;
	}
	
}
