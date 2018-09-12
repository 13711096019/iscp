package com.cn.unit.executor.push.phone;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.base.Session;
import com.cn.iscp.entity.ligent.Push;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.base.impl.SessionServiceImpl;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 线程池-提醒老师上课
 */
public class ExecutorAttendClass {
	
	private static Logger log = Logger.getLogger(ExecutorAttendClass.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	
	public ExecutorAttendClass(){}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 提醒老师上课推送线程");
            	// PhonePushTimed.PushAttendClassTeacher();
            	// 获取5分钟后的时间(09:00)
        	 	String schoolTime = DateUtil.getDifferentTime(null, 5, DateUtil.H_M, "minute");
        		String newDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
        	 	String sessionTime = null;
        		// 班次业务逻辑
        		SessionServiceImpl sessionService = (SessionServiceImpl) SpringBeanFactoryUtil.getBean("sessionService");
        		List<Session> sessionList = sessionService.findAll();
        		if(sessionList != null && sessionList.size() > 0){
            		for (Session session : sessionList) {
            			Long sessionId = session.getSessionId();
            			sessionTime = DateUtil.getStrByStr(newDate+" "+session.getStartTime(), DateUtil.H_M);
            			Integer pushCode = null;
            			if(schoolTime.equals(sessionTime)){
            				pushCode = PushCode.REMIND_TEACHERCLASS;
            			}
            			
            			if(_Tool.isValid(pushCode)){
            				// 获取下节课老师列表
            				PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
            				List<PushModel> codeList = pushSericel.findTeacherByNextClass(sessionId);
            				
            				if(codeList == null || codeList.size() < 1)
            					break;
            				
            				// 获取推送对象
            				Push push = pushSericel.getPushByCode(pushCode);
            				
            				Integer pushCount = 0;
            				for (PushModel pushModel : codeList) {
            					log.info("[提醒老师上课"+pushCode+"]极光推送：用户账号" + pushModel.getUserKey());
            					PushInvite jdpust = new PushInvite(pushModel.getUserKey(), push, null);
            					try {
            						pushCount = jdpust.buildPushHasAlert(0) ? (pushCount+1) : pushCount;
            					} catch (Exception e) {
            						continue;
            					}
            				}
            				log.info("[提醒老师上课]共推送:"+pushCount+"条");
            				break;
            			}
            		}
        		}else{
            		log.info("[提醒老师上课]没到推送时间");
        		}
            	log.info("结束 提醒老师上课推送线程");
            }
        });
    }
	
}
