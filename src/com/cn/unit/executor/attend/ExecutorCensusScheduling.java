package com.cn.unit.executor.attend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.service.attend.impl.TeacherAttendSchedulingServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 统计人员排班信息线程池(统计前一天的打卡数据)
 */
public class ExecutorCensusScheduling {
	
	private static Logger log = Logger.getLogger(ExecutorCensusScheduling.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 统计人员排班信息线程池");
            	String attendDate = DateUtil.getDifferentTime(null, -1, DateUtil.YYYY_MM_DD, "date");
            	TeacherAttendSchedulingServiceImpl teacherAttendSchedulingService = (TeacherAttendSchedulingServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendSchedulingService");
            	teacherAttendSchedulingService.censusCountByDate(attendDate);
            	log.info("结束 统计人员排班信息线程池");
            }
        });
    }
	
}
