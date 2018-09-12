package com.cn.iscp.service.prepare.ince;

import com.cn.iscp.entity.prepare.Report;

public interface ReportService {
	
	/**
	 * 工作-根据课题编号获取总结报告
	 */
	Report findByTopic(Report model);

	/**
	 * 工作-根据备课明细编号获取总结报告
	 */
	Report findByDetail(Report model);

	/**
	 * 工作-处理课后总结报告(新增/编辑)
	 */
	Report handleReport(Report model);
	
	/**
	 * PC-新增
	 */
	boolean insert(Report model);
	
	/**
	 * PC-根据老师编号获取对象
	 */
	Report findByTeacher(Report model);
	
    /*List<Report> findPage(Map<String, Object> map);
	
	Long getPageCount(Map<String, Object> map);
	
	Report findById(Map<String, Object> map);
	
	boolean insert(Report model);
	
	boolean update(Report model);*/
}
