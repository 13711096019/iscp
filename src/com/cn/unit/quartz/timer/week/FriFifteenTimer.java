package com.cn.unit.quartz.timer.week;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 周五15点定时器
 * @author 10011037@qq.com
 * 2018-05-25
 */
public class FriFifteenTimer implements Job {
	
	private static Logger log = Logger.getLogger(FriFifteenTimer.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		
	}
	
}
