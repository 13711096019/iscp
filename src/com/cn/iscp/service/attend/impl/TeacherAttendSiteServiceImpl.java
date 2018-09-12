package com.cn.iscp.service.attend.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.attend.TeacherAttendSiteDao;
import com.cn.iscp.entity.attend.TeacherAttendSite;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendSiteService;

@Service("teacherAttendSiteService")
public class TeacherAttendSiteServiceImpl implements TeacherAttendSiteService {
	
	@Resource
	private TeacherAttendSiteDao teacherAttendSiteDao;

	@Override
	public List<TeacherAttendSite> findByGroup(Long groupId) {
		return teacherAttendSiteDao.findByGroup(groupId);
	}

	@Override
	public TeacherAttendSite insertSite(TeacherAttendSite model) {
		return teacherAttendSiteDao.insertSite(model);
	}

	@Override
	public Integer insertSites(Long groupId, String siteJson) {
		Integer revertCount = 0;
		List<TeacherAttendSite> siteList = new ArrayList<TeacherAttendSite>();
		try {
			JSONArray jsonArray = JSONArray.fromObject(siteJson);
			siteList = JSONArray.toList(jsonArray, TeacherAttendSite.class);
		} catch (Exception e) {
        	return revertCount;
		}
		if(siteList == null || siteList.size() < 1){
        	return revertCount;
		}
		revertCount = siteList.size();
		// 判断新增
		for (TeacherAttendSite site : siteList) {
			if(_Tool.isEmpty(site.getSiteName()) || _Tool.isEmpty(site.getAddress())
					|| !_Tool.isDouble(site.getSiteLng()) || !_Tool.isDouble(site.getSiteLat())
					|| !_Tool.isInt(site.getAvailableIn())){
				continue;
			}
			site.setGroupId(groupId);
			this.insertSite(site);
		}
		return revertCount;
	}
	
	@Override
	public TeacherAttendSite updateSite(TeacherAttendSite model) {
		return teacherAttendSiteDao.updateSite(model);
	}

	@Override
	public Integer updateSites(Long groupId, String siteJson) {
		Integer revertCount = 0;
		List<TeacherAttendSite> nowList = new ArrayList<TeacherAttendSite>();
		try {
			JSONArray jsonArray = JSONArray.fromObject(siteJson);
			nowList = JSONArray.toList(jsonArray, TeacherAttendSite.class);
		} catch (Exception e) {
        	return revertCount;
		}
		if(nowList == null || nowList.size() < 1){
			this.deleteByGroup(groupId);
        	return revertCount;
		}
		
		List<TeacherAttendSite> oldList = this.findByGroup(groupId);
		Long oldSiteId, nowSiteId;
		boolean isExist = false;
		for (TeacherAttendSite old : oldList) {
			isExist = false;
			oldSiteId = old.getSiteId();
			for (TeacherAttendSite now : nowList) {
				nowSiteId = now.getSiteId();
				if(_Tool.isLong(nowSiteId) && oldSiteId.intValue()==nowSiteId.intValue()){
					isExist = true;
					this.updateSite(now);
					revertCount++;
				}
			}
			// 新的list里面不包含，直接删除
			if(!isExist){
				revertCount++;
				this.deleteSite(oldSiteId);
			}
		}
		
		// 判断新增
		for (TeacherAttendSite site : nowList) {
			if(!_Tool.isLong(site.getSiteId())){
				if(_Tool.isEmpty(site.getSiteName()) || _Tool.isEmpty(site.getAddress())
						|| !_Tool.isDouble(site.getSiteLng()) || !_Tool.isDouble(site.getSiteLat())
						|| !_Tool.isInt(site.getAvailableIn())){
					continue;
				}
				site.setGroupId(groupId);
				this.insertSite(site);
				revertCount++;
			}
		}
		return revertCount;
	}
	
	@Override
	public StateModel deleteSite(Long siteId) {
		TeacherAttendSite site = teacherAttendSiteDao.deleteSite(siteId);
		return new StateModel(site.getStatus().intValue()==_Const.STATE_ERROR);
	}

	@Override
	public void deleteByGroup(Long groupId) {
		teacherAttendSiteDao.deleteByGroup(groupId);
	}
	
}
