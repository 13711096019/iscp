package com.cn.iscp.service.prepare.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.prepare.ReportDao;
import com.cn.iscp.entity.prepare.Report;
import com.cn.iscp.service.prepare.ince.ReportService;

@Service("ReportService")
public class ReportServiceImpl implements ReportService{
	
    @Resource
    private ReportDao reportDao;

	@Override
	public Report findByTopic(Report model) {
		return reportDao.findByTopic(model);
	}
	
	@Override
	public Report findByDetail(Report model) {
		return reportDao.findByDetail(model);
	}

	@Override
	public Report handleReport(Report model) {
		return reportDao.handleReport(model);
	}


	@Override
	public boolean insert(Report model) {
		return reportDao.insert(model);
	}

	@Override
	public Report findByTeacher(Report model) {
		return reportDao.findByTeacher(model);
	}


    
	/*@Override
	public List<Report> findPage(Map<String, Object> map) {
		return reportDao.findPage(map);
	}
	
	@Override
	public Long getPageCount(Map<String, Object> map) {
		return reportDao.getPageCount(map);
	}

	@Override
	public Report findById(Map<String, Object> map) {
		return reportDao.findById(map);
	}

	@Override
	public boolean insert(Report model) {
		return reportDao.insert(model);
	}

	@Override
	public boolean update(Report model) {
		return reportDao.update(model);
	}*/

}
