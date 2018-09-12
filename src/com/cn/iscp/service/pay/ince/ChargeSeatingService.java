package com.cn.iscp.service.pay.ince;

import java.util.List;
import java.util.Map;

import com.cn.iscp.entity.pay.ChargeSeating;

public interface ChargeSeatingService {

	/**
	 * 根据学生获取班级缴费座位表
	 */
	List<ChargeSeating> findByStudent(ChargeSeating model);

	// 分页获取列表数据
	List<ChargeSeating> findPage(Map<String, Object> map);

	// 获取分页总数
	Long getPageCount(Map<String, Object> map);

	// 根据编号获取列表
	ChargeSeating findById(Long seatingId);

	// 根据学生编号工单编号获取详情--没用
	ChargeSeating findparticularsById(Long studentId, Long orderId);

	// 根据学生编号获取列表
	ChargeSeating findstudentById(Long studentId);
}
