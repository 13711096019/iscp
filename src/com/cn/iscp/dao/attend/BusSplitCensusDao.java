package com.cn.iscp.dao.attend;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.attend.BusSplitCensus;

public interface BusSplitCensusDao {
	
	/**
	 * 处理学生上学放学记录
	 */
	List<BusSplitCensus> handleStudentSplit(Map<String, Object> map);

}
