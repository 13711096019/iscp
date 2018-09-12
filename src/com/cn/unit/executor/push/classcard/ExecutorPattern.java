package com.cn.unit.executor.push.classcard;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.push.Pattern;
import com.cn.iscp.model.PushModel;
import com.cn.iscp.service.ligent.impl.PushSericelImpl;
import com.cn.iscp.service.push.impl.PatternServiceImpl;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 线程池-班牌模式
 */
public class ExecutorPattern {
	
	private static Logger log = Logger.getLogger(ExecutorPattern.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	
	public ExecutorPattern(){}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 班牌模式推送线程");
            	// 当前时间
        		String newTime = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
        		String newDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
        		// 所有有效班牌机器码
        		PatternServiceImpl patternService = (PatternServiceImpl) SpringBeanFactoryUtil.getBean("patternService");
        		PushSericelImpl pushSericel = (PushSericelImpl) SpringBeanFactoryUtil.getBean("pushSericel");
        		List<PushModel> codeList = pushSericel.findAllMachineCode();
        		
        		// 推送标识码
        		Integer pushCount = 0;
        		for (PushModel pushModel : codeList) {
        			Long classNum = pushModel.getClassNum();
        			Pattern pattern = patternService.getMostUrgentPattern(classNum);
        			if(pattern == null){
        				// 当前没有需要操作的模式!
        				continue;
        			}
        			// 获取模式推送码
        			Integer pushCode = _Tool.toInt(pattern.getItemFileNick());
        			int startMin = DateUtil.getTimeDifferent(newDate + " " + pattern.getStartTime(), newTime, "minute");
        			int endMin = DateUtil.getTimeDifferent(newDate + " " + pattern.getEndTime(), newTime, "minute");
        			// 模式开关(1启动模式,0关闭模式)
        			if(startMin >= 0 && startMin < 3){
        				log.info("[模式]启动模式!");
        			}else if(endMin >= 0 && endMin < 3){
        				log.info("[模式]关闭模式!");
        				pushCode = pushCode * 10;
        			}else{
        				// 模式已经处理
        				continue;
        			}
        			
        			log.info("[模式"+pushCode+"]极光推送：动态班级编号" + classNum + ",机器码" + pushModel.getMachineCode());
        			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, pushModel.getMachineCode(), pushCode);
        			pushCount = jdpust.buildPushNotAlert() ? (pushCount+1) : pushCount;
        		}
        		log.info("[模式]共推送:"+pushCount+"条");
            	log.info("结束 班牌模式推送线程");
            }
        });
    }
	
}
