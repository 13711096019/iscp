package com.cn.unit.quartz.timer.day;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.iscp.service.card.impl.ClockOndayClassServiceImpl;
import com.cn.iscp.service.card.impl.civilized.CivilizedClassScoreServiceImpl;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.unit.executor.attend.ExecutorCensusScheduling;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.quartz.task.BasePushTimed;
import com.cn.unit.utils.DateUtil;

/**
 * 每天两点定时器
 * @author 10011037@qq.com
 * 2017-07-21
 */
public class DayTwoTimer implements Job {
	
	private static Logger log = Logger.getLogger(DayTwoTimer.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		log.info("----------------------------------------------------------");
		log.info("开始 每天两点定时器");
		log.info("----------------------------------------------------------");
		
		// 统计人员排班表信息(必须先统计前一天打卡记录状态[ExecutorCensusRecord],已定位每天1点统计)
		ExecutorCensusScheduling censusScheduling = new ExecutorCensusScheduling();
		try {
			censusScheduling.asynTask();
		} catch (InterruptedException e) {
			System.out.println("统计人员排班表信息线程池发生异常");
		}
		
		log.info("---------开始 初始化创文数据----------");
		CivilizedClassScoreServiceImpl civilizedClassScoreService = (CivilizedClassScoreServiceImpl) SpringBeanFactoryUtil.getBean("civilizedClassScoreService");
		civilizedClassScoreService.censusClassScoreByDay(DateUtil.getStrByDate(DateUtil.getSystemDate(), DateUtil.YYYY_MM_DD));
		log.info("---------结束 初始化创文数据----------");
		
		log.info("---------开始 统计班级考勤情况----------");
		ClockOndayClassServiceImpl clockOndayClassService = (ClockOndayClassServiceImpl) SpringBeanFactoryUtil.getBean("clockOndayClassService");
		clockOndayClassService.handleClassClockonday();
		log.info("---------结束 统计班级考勤情况----------");
		
		/**
		 * 过滤过期数据
		 */
		Integer[] handleCodes = {
				// 倒计时,模式
				PushCode.COUNTDOWNS, PushCode.PATTERN_EXAM
			};
		for (Integer pushCode : handleCodes) {
			BasePushTimed.handleInvalidRecords(pushCode, true);
		}
		
		log.info("----------------------------------------------------------");
		log.info("结束 每天两点定时器");
		log.info("----------------------------------------------------------");
	}
	
}
