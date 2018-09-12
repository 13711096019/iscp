package com.cn.unit.quartz.timer.min;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.unit.executor.push.classcard.ExecutorClassroom;
import com.cn.unit.executor.push.classcard.ExecutorPattern;
import com.cn.unit.executor.push.phone.ExecutorAttendClass;
import com.cn.unit.executor.push.phone.ExecutorCalendar;

/**
 * 一分钟定时器
 * @author 10011037@qq.com
 * 2017-07-14
 */
public class MinOneTimer implements Job {
	
	
	private static Logger log = Logger.getLogger(MinOneTimer.class);
	
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		//log.info("---------开始 提醒上传打卡记录----------");
		// ClassCardPushTimed.PushUploadPunchTheClock();
		//log.info("---------结束 提醒上传打卡记录----------");
		try {
			//log.info("---------开始 推送课堂信息-------------");
			new ExecutorClassroom().asynTask();
			//log.info("---------结束 推送课堂信息-------------");
			
			//log.info("---------开始 模式推送-------------");
			new ExecutorPattern().asynTask();
			//log.info("---------结束 模式推送-------------");
			
			//log.info("---------开始 提醒老师上课-------------");
			new ExecutorAttendClass().asynTask();
			//log.info("---------结束 提醒老师上课-------------");
			
			//log.info("---------开始 日程提醒-------------");
			new ExecutorCalendar().asynTask();
			//log.info("---------结束 日程提醒-------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
