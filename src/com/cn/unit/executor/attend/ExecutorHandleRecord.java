package com.cn.unit.executor.attend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.cn.iscp.entity.attend.TeacherAttendGroup;
import com.cn.iscp.service.attend.impl.TeacherAttendGroupServiceImpl;
import com.cn.iscp.service.attend.impl.TeacherAttendRecordServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 自动生成考勤记录线程池
 */
public class ExecutorHandleRecord {
	
	private static Logger log = Logger.getLogger(ExecutorHandleRecord.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 自动生成考勤记录线程池");
            	TeacherAttendGroupServiceImpl teacherAttendGroupService = (TeacherAttendGroupServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendGroupService");
            	TeacherAttendGroup group = teacherAttendGroupService.findByLast();
            	if(group != null){
            		Long groupId = group.getGroupId();
            		TeacherAttendRecordServiceImpl teacherAttendRecordService = (TeacherAttendRecordServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendRecordService");
            		teacherAttendRecordService.handleRecord(groupId);
            	}
            	log.info("结束 自动生成考勤记录线程池");
            }
        });
    }
	
	
}
