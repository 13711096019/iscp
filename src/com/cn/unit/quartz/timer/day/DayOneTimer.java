package com.cn.unit.quartz.timer.day;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.iscp.service.card.impl.civilized.CivilizedClassScoreServiceImpl;
import com.cn.unit.executor.attend.ExecutorCensusRecord;
import com.cn.unit.executor.attend.ExecutorHandleRecord;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 每天一点定时器
 * @author 10011037@qq.com
 * 2018-08-08
 */
public class DayOneTimer implements Job {
	
	private static Logger log = Logger.getLogger(DayOneTimer.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		log.info("----------------------------------------------------------");
		log.info("开始 每天一点定时器");
		log.info("----------------------------------------------------------");
		
		// 每天自动生成考勤记录
		ExecutorHandleRecord handleRecord = new ExecutorHandleRecord();
		try {
			handleRecord.asynTask();
		} catch (InterruptedException e) {
			System.out.println("自动生成考勤记录线程池发生异常");
		}
		
		// 统计前一天打卡记录状态
		ExecutorCensusRecord censusRecord = new ExecutorCensusRecord();
		try {
			censusRecord.asynTask();
		} catch (InterruptedException e) {
			System.out.println("统计前一天打卡记录状态线程池发生异常");
		}
		
		log.info("---------开始 初始化班级创文排名----------");
		CivilizedClassScoreServiceImpl civilizedClassScoreService = (CivilizedClassScoreServiceImpl) SpringBeanFactoryUtil.getBean("civilizedClassScoreService");
		civilizedClassScoreService.censusClassScoreByDay(DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD));
		log.info("---------结束 初始化班级创文排名----------");
		
		log.info("----------------------------------------------------------");
		log.info("结束 每天一点定时器");
		log.info("----------------------------------------------------------");
	}
	
}
