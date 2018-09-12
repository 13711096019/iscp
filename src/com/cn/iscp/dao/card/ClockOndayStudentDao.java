package com.cn.iscp.dao.card;

import java.util.List;

import com.cn.iscp.entity.card.ClockOndayStudent;
import com.cn.iscp.model.StateModel;

public interface ClockOndayStudentDao {
	
	/**
	 * 终端-学生打卡
	 */
	StateModel insertClockOnDay(ClockOndayStudent model);
	
	/**
	 * PC-根据考勤状态获取学生信息
	 */
	List<ClockOndayStudent> findByDate(ClockOndayStudent model);

	/**
	 * PC-特殊情况录入(忘打卡6,旷课4,早退5)
	 */
	Long handleClockOnDay(ClockOndayStudent model);
	
}
