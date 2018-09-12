package com.cn.unit.executor.push.classcard;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.base.Session;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.base.impl.SessionServiceImpl;
import com.cn.iscp.service.dbase.impl.CourseTableServiceImpl;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 线程池-课堂信息
 */
public class ExecutorClassroom {
	
	private static Logger log = Logger.getLogger(ExecutorClassroom.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	
	public ExecutorClassroom(){}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 课堂信息推送线程");
            	// ClassCardPushTimed.PushCurrentLesson();
            	String nowTime = DateUtil.getStrByDate(null, DateUtil.H_M);
        		String nowDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
        		// 班次业务逻辑
        		SessionServiceImpl sessionService = (SessionServiceImpl) SpringBeanFactoryUtil.getBean("sessionService");
        		List<Session> sessionList = sessionService.findAll();
        		if(sessionList != null && sessionList.size() > 0){
	        		for (Session session : sessionList) {
	        			Integer pushCode = null;
	        			if(nowTime.equals(DateUtil.getStrByStr(nowDate+" "+session.getStartTime(), DateUtil.H_M))){
	        				pushCode = PushCode.CLASS_ROOM;
	        			}else if(nowTime.equals(DateUtil.getStrByStr(nowDate+" "+session.getEndTime(), DateUtil.H_M))){
	        				pushCode = PushCode.CLASS_ROOM * 10;
	        			}
	        			if(_Tool.isValid(pushCode)){
	        				// 所有有效班牌机器码
	        				PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
	        				List<PushModel> codeList = pushSericel.findAllMachineCode();
	        				
	        				// 没有课程直接推送关闭
	        				CourseTableServiceImpl courseTableService = (CourseTableServiceImpl) SpringBeanFactoryUtil.getBean("courseTableService");
	        				StateModel state = courseTableService.getCurrentLesson(codeList.get(0).getClassNum());
	        				if(state.getData()==null){
	        					pushCode = PushCode.CLASS_ROOM * 10;
	        				}
	        				
	        				Integer pushCount = 0;
	        				for (PushModel pushModel : codeList) {
	        					log.info("[课堂"+pushCode+"]极光推送：动态班级编号" + pushModel.getClassNum() + ",机器码" + pushModel.getMachineCode());
	        					PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
	        					pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
	        				}
	        				log.info("[课堂]共推送:"+pushCount+"条");
	        				break;
	        			}
	        		}
        		}else{
            		log.info("[课堂]没到推送时间");
        		}	
            	log.info("结束 课堂信息推送线程");
            }
        });
    }
	
}
