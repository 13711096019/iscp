package com.cn.unit.executor.attend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.iscp.entity.attend.TeacherAttendTemplet;
import com.cn.iscp.service.attend.impl.TeacherAttendTempletServiceImpl;
import com.cn.unit.frame.SpringBeanFactoryUtil;

/**
 * 批量修改考勤班次模板线程池
 */
public class ExecutorUpdTemplet {
	
	private static Logger log = Logger.getLogger(ExecutorUpdTemplet.class);
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	// 考勤组编号
	private Long groupId;
	// 修改json数据
	private String shiftJson;
	// 是否更新排班表
	private Integer isUpdScheduling;
	
	
	public ExecutorUpdTemplet(Long groupId, String shiftJson, Integer isUpdScheduling){
		this.groupId = groupId;
		this.shiftJson = shiftJson;
		this.isUpdScheduling = isUpdScheduling;
	}
	
	public void asynTask() throws InterruptedException {
        executor.submit(new Runnable() {
            @Override
            public void run() {
            	log.info("开始 批量修改考勤班次模板线程池");
            	
            	boolean revert = true;
        		List<TeacherAttendTemplet> templetList = new ArrayList<TeacherAttendTemplet>();
        		try {
        			JSONArray jsonArray = JSONArray.fromObject(getShiftJson());
        			templetList = JSONArray.toList(jsonArray, TeacherAttendTemplet.class);
        		} catch (Exception e) {
        			revert = false;
        		}
        		if(templetList == null || templetList.size() < 1){
        			revert = false;
        		}
        		if(revert){
        			
        			TeacherAttendTempletServiceImpl teacherAttendTempletService = (TeacherAttendTempletServiceImpl) SpringBeanFactoryUtil.getBean("teacherAttendTempletService");
                	
            		Integer[] weekNumArray = new Integer[]{1, 2, 3, 4, 5, 6, 7};
            		// 判断新增
            		for (TeacherAttendTemplet item : templetList) {
            			if(!_Tool.isLong(item.getUserId()) || _Tool.isEmpty(item.getShiftIds())){
            				continue;
            			}
            			String[] shiftIdArray = item.getShiftIds().split(",");
            			for (int i = 0; i < shiftIdArray.length; i++) {
            				if(!_Tool.isLong(shiftIdArray[i])){
            					continue;
            				}
            				item = new TeacherAttendTemplet(item.getUserId(), getGroupId(), 
            						_Tool.toLong(shiftIdArray[i]), weekNumArray[i], getIsUpdScheduling());
            				teacherAttendTempletService.updateTemplet(item);
            			}
            		}
        		}
            	log.info("结束 批量修改考勤班次模板线程池");
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
	public Integer getIsUpdScheduling() {
		return isUpdScheduling;
	}
	public void setIsUpdScheduling(Integer isUpdScheduling) {
		this.isUpdScheduling = isUpdScheduling;
	}
	
}
