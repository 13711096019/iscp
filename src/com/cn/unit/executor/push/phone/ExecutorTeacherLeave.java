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
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.quartz.task.BasePushTimed;

/**
 * 老师请假通知线程池
 */
public class ExecutorTeacherLeave {
	
	private static Logger log = Logger.getLogger(ExecutorTeacherLeave.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 请假记录编号
	private Long leaveId;
	// 登录老师编号
	private Long loginUserId;
	// 推送对象标识（1审批员，2请假者，3查看者+请假者）
	private Integer aimType;
	
	
	public ExecutorTeacherLeave(Long leaveId, Long loginUserId, Integer aimType){
		this.leaveId = leaveId;
		this.loginUserId = loginUserId;
		this.aimType = aimType;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 老师请假通知线程:leaveId=["+leaveId+"]");
        		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		
        		// 推送给审批员
        		if(getAimType().intValue() == 1 || getAimType().intValue() == 3){
        			List<PushModel> codeList = pushSericel.findTeacherByTeacherLeave(getLeaveId(), getLoginUserId(), 1);
        			Integer pushCode = getAimType().intValue() == 1 ? PushCode.REMIND_TEACHER_LEAVE : PushCode.REMIND_TEACHER_SEE;
            		Push push = BasePushTimed.handleInvalidRecords(pushCode, false);
            		if(push != null){
            			Integer pushCount = 0;
            			for (PushModel pushModel : codeList) {
            				log.info("[老师请假通知"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
            				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
            				try {
            					pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
            				} catch (Exception e) {
            					continue;
            				}
            			}
            		}
        		}
        		
        		// 推送给请假者
        		if(getAimType().intValue() == 2 || getAimType().intValue() == 3){
        			List<PushModel> codeList = pushSericel.findTeacherByTeacherLeave(getLeaveId(), getLoginUserId(), 0);
            		Integer pushCode = PushCode.REMIND_TEACHER_CHECK;
            		Push push = BasePushTimed.handleInvalidRecords(pushCode, false);
            		if(push != null){
            			Integer pushCount = 0;
            			for (PushModel pushModel : codeList) {
            				log.info("[老师请假通知"+push.getPushCode()+"]极光推送：用户账号" + pushModel.getUserKey());
            				PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
            				try {
            					pushCount = jdpust.buildPushHasExtra() ? (pushCount+1) : pushCount;
            				} catch (Exception e) {
            					continue;
            				}
            			}
            		}
        		}
        		
            	log.info("结束 老师请假通知线程");
            }
        });
    }

	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	public Integer getAimType() {
		return aimType;
	}
	public void setAimType(Integer aimType) {
		this.aimType = aimType;
	}
	public Long getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(Long loginUserId) {
		this.loginUserId = loginUserId;
	}
	
}
