package com.cn.iscp.dao.card.exam;

import java.util.List;

import com.cn.iscp.entity.card.exam.ExamInfo;
import com.cn.iscp.model.StateModel;

public interface ExamInfoDao {
	
	/**
	 * 获取考试信息列表
	 */
	List<ExamInfo> findAll(Long userId);
	
	/**
	 * 根据编号获取对象
	 */
	ExamInfo findById(Long examInfoId);

	/**
	 * PC-判断考试信息是否存在重复
	 */
	Long judgeRepeat(ExamInfo model);
	
	/**
	 * 添加考试信息
	 */
	ExamInfo insertExamInfo(ExamInfo model);

	/**
	 * 删除考试信息
	 */
	StateModel deleteExamInfo(Long examInfoId);
	
}
