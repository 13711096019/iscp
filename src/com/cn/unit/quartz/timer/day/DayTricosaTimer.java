package com.cn.unit.quartz.timer.day;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cn.iscp.service.card.impl.civilized.CivilizedClassScoreServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 每天二十三点定时器
 * @author 10011037@qq.com
 * 2017-07-21
 */
public class DayTricosaTimer implements Job {

	private static Logger log = Logger.getLogger(DayTricosaTimer.class);
	
	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		log.info("----------------------------------------------------------");
		log.info("开始 每天二十三点定时器");
		log.info("----------------------------------------------------------");
		
		log.info("---------开始 统计班级创文排名----------");
		CivilizedClassScoreServiceImpl civilizedClassScoreService = (CivilizedClassScoreServiceImpl) SpringBeanFactoryUtil.getBean("civilizedClassScoreService");
		civilizedClassScoreService.censusClassScore();
		log.info("---------结束 统计班级创文排名----------");
		
		log.info("----------------------------------------------------------");
		log.info("结束 每天二十三点定时器");
		log.info("----------------------------------------------------------");
		
	}
}
