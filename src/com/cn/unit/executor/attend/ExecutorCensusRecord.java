package com.cn.unit.executor.attend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.service.attend.impl.TeacherAttendRecordServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;
import com.cn.unit.utils.DateUtil;

/**
 * 统计打卡记录状态线程池(统计前一天的打卡数据)
 */
public class ExecutorCensusRecord {
	
	private static Logger log = Logger.getLogger(ExecutorCensusRecord.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 统计打卡记录状态线程池");
            	String attendDate = DateUtil.getDifferentTime(null, -1, DateUtil.YYYY_MM_DD, "date");
            	TeacherAttendRecordServiceImpl teacherAttendRecordService = (TeacherAttendRecordServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendRecordService");
            	teacherAttendRecordService.censusRecord(attendDate);
            	log.info("结束 统计打卡记录状态线程池");
            }
        });
    }
	
}
