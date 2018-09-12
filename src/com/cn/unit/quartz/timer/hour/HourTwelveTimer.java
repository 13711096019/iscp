package com.cn.unit.quartz.timer.hour;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.iscp.service.attend.impl.DailyStatisticsServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 上班前定时器(每天5点,12点执行一次)
 * @author 10011037@qq.com
 * 2018-08-17
 */
public class HourTwelveTimer implements Job {
	
	
	private static Logger log = Logger.getLogger(HourTwelveTimer.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		log.info("----------------------------------------------------------");
		log.info("开始 上班前定时器(每天5点,12点执行一次)");
		log.info("----------------------------------------------------------");
		
		log.info("---------开始 每日考勤人数自动统计记录----------");
		DailyStatisticsServiceImpl dailyStatisticsService = (DailyStatisticsServiceImpl) SpringBeanFactoryUtil.getBean("dailyStatisticsService");
		dailyStatisticsService.censusDailyStatistics();
		log.info("---------结束 每日考勤人数自动统计记录----------");
		
		log.info("----------------------------------------------------------");
		log.info("结束 上班前定时器(每天5点,12点执行一次)");
		log.info("----------------------------------------------------------");
	}
	
}
