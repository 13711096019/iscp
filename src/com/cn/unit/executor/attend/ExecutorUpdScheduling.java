package com.cn.unit.executor.attend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.attend.TeacherAttendScheduling;
import com.cn.iscp.service.attend.impl.TeacherAttendSchedulingServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 批量修改考勤排班线程池
 */
public class ExecutorUpdScheduling {
	
	private static Logger log = Logger.getLogger(ExecutorUpdScheduling.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 考勤组编号
	private Long groupId;
	// 修改json数据
	private String shiftJson;
	
	
	public ExecutorUpdScheduling(Long groupId, String shiftJson){
		this.groupId = groupId;
		this.shiftJson = shiftJson;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 批量修改考勤排班线程池");
            	
            	boolean revert = true;
        		List<TeacherAttendScheduling> schedulingList = new ArrayList<TeacherAttendScheduling>();
        		try {
        			JSONArray jsonArray = JSONArray.fromObject(getShiftJson());
        			schedulingList = JSONArray.toList(jsonArray, TeacherAttendScheduling.class);
        		} catch (Exception e) {
        			revert = false;
        		}
        		if(schedulingList == null || schedulingList.size() < 1){
        			revert = false;
        		}
        		if(revert){
        			
        			TeacherAttendSchedulingServiceImpl teacherAttendSchedulingService 
        					= (TeacherAttendSchedulingServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendSchedulingService");
                	
            		// 判断新增
            		for (TeacherAttendScheduling item : schedulingList) {
            			if(!_Tool.isLong(item.getUserId()) || !_Tool.isLong(item.getShiftId()) 
            					|| !_Tool.isDate(item.getAttendDate())){
            				continue;
            			}
            			item.setGroupId(getGroupId());
            			teacherAttendSchedulingService.updateScheduling(item);
            		}
        		}
            	log.info("结束 批量修改考勤排班线程池");
            }
        });
    }

	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getShiftJson() {
		return shiftJson;
	}
	public void setShiftJson(String shiftJson) {
		this.shiftJson = shiftJson;
	}
	
}
