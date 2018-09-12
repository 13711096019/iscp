package com.cn.unit.quartz.timer.month;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.unit.executor.attend.ExecutorCreateScheduling;
import com.cn.unit.quartz.timer.hour.HourTwelveTimer;

/**
 * 每月20号凌晨1点定时器
 * @author 10011037@qq.com
 * 2018-08-21
 */
public class MonthTwentyTimer implements Job {
	
	private static Logger log = Logger.getLogger(HourTwelveTimer.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		log.info("----------------------------------------------------------");
		log.info("开始 每月20号定时器");
		log.info("----------------------------------------------------------");
		
		// 生成考勤排班信息线程池(生成下一个月的考勤排班信息)
		ExecutorCreateScheduling createScheduling = new ExecutorCreateScheduling();
		try {
			createScheduling.asynTask();
		} catch (InterruptedException e) {
			System.out.println("生成考勤排班信息线程池发生异常");
		}
		
		log.info("----------------------------------------------------------");
		log.info("结束 每月20号定时器");
		log.info("----------------------------------------------------------");
	}
	
}
