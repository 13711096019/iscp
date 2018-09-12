package com.cn.unit.executor.attend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.service.attend.impl.TeacherAttendSchedulingServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 生成考勤排班信息线程池(生成下一个月的考勤排班信息)
 */
public class ExecutorCreateScheduling {
	
	private static Logger log = Logger.getLogger(ExecutorCreateScheduling.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 生成考勤排班信息线程池");
            	TeacherAttendSchedulingServiceImpl teacherAttendSchedulingService = (TeacherAttendSchedulingServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendSchedulingService");
            	teacherAttendSchedulingService.createScheduling(null);
            	log.info("结束 生成考勤排班信息线程池");
            }
        });
    }
	
}
