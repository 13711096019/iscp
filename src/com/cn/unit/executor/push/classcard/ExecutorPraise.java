package com.cn.unit.executor.push.classcard;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 线程池-表扬信息(-1)
 */
public class ExecutorPraise {
	
	private static Logger log = Logger.getLogger(ExecutorPraise.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public ExecutorPraise(){}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 表扬信息推送线程");
        		// 获取需要推送的机器码
        		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		// List<PushModel> codeList = pushSericel.findByPraise();
        		List<PushModel> codeList = pushSericel.findAllMachineCode();
        		// 推送数量
        		Integer pushCount = 0;
        		Integer pushCode = PushCode.CLASS_PRAISE;
        		for (PushModel pushModel : codeList) {
        			// 极光推送
        			log.info("[表扬"+pushCode+"]极光推送：动态班级编号" + pushModel.getClassNum() + ",机器码" + pushModel.getMachineCode());
        			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
        			pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
        		}
        		log.info("[表扬]共推送:"+pushCount+"条");
            	log.info("结束 表扬信息推送线程");
            }
        });
    }
	
}
