package com.cn.unit.quartz.timer.min;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.quartz.task.BasePushTimed;

/**
 * 五分钟定时器
 * @author 10011037@qq.com
 * 2017-07-14
 */
public class MinFiveTimer implements Job {
	
	
	/*private static Logger log = Logger.getLogger(MinFiveTimer.class);*/
	
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		/*log.info("----------------------------------------------------------");
		log.info("开始 五分钟定时器");
		log.info("----------------------------------------------------------");*/
		
		/**
		 * 过滤过期数据并推送
		 */
		Integer[] pushCodes = {
				// 通知公告,校园视频,三风简讯,风采作品
				PushCode.NOTICE, PushCode.VIDEO, PushCode.SPIRIT, PushCode.CAMPUS_WORKS,
				// 校园新闻,名人典故,科普知识,班级表扬
				PushCode.CAMPUS_NEWS, PushCode.CAMPUS_ALLUSION, PushCode.CAMPUS_KNOWLEDGE, PushCode.CLASS_PRAISE
			};
		for (Integer pushCode : pushCodes) {
			BasePushTimed.PushMachine(pushCode, true, null, null);
		}

		/**
		 * 过滤过期数据
		 */
		Integer[] filterCodes = {
				// 日程提醒
				PushCode.REMIND_CALENDAR
			};
		for (Integer filterCode : filterCodes) {
			BasePushTimed.handleInvalidRecords(filterCode, true);
		}
		
		/*log.info("----------------------------------------------------------");
		log.info("结束 五分钟定时器");
		log.info("----------------------------------------------------------");*/
	}
	
}
