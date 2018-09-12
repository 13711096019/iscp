package com.cn.unit.executor.attend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.service.attend.impl.TeacherAttendCycleServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 自动生成模板和排班线程池
 */
public class ExecutorIsFirstCycle {
	
	private static Logger log = Logger.getLogger(ExecutorIsFirstCycle.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 考勤组编号
	private Long groupId;
	
	
	public ExecutorIsFirstCycle(Long groupId){
		this.groupId = groupId;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 自动生成模板和排班线程池");
            	TeacherAttendCycleServiceImpl teacherAttendCycleService = (TeacherAttendCycleServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendCycleService");
            	teacherAttendCycleService.isFirstCycle(getGroupId());
            	log.info("结束 自动生成模板和排班线程池");
            }
        });
    }

	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	
}
