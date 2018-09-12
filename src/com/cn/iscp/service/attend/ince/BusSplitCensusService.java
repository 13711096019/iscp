package com.cn.iscp.service.attend.ince;


public interface BusSplitCensusService {
	
	/**
	 * 处理学生上学放学记录
	 */
	void handleStudentSplit(String studentCardPhys, String attendTimes, Integer attendType);

}
