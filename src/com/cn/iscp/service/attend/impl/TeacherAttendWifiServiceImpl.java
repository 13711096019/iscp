package com.cn.iscp.service.attend.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.dao.attend.TeacherAttendWifiDao;
import com.cn.iscp.entity.attend.TeacherAttendWifi;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendWifiService;

@Service("teacherAttendWifiService")
public class TeacherAttendWifiServiceImpl implements TeacherAttendWifiService {
	
	@Resource
	private TeacherAttendWifiDao teacherAttendWifiDao;

	@Override
	public List<TeacherAttendWifi> findByGroup(Long groupId) {
		return teacherAttendWifiDao.findByGroup(groupId);
	}

	@Override
	public TeacherAttendWifi insertWifi(TeacherAttendWifi model) {
		return teacherAttendWifiDao.insertWifi(model);
	}

	@Override
	public Integer insertWifis(Long groupId, String wifiJson) {
		Integer revertCount = 0;
		List<TeacherAttendWifi> wifiList = new ArrayList<TeacherAttendWifi>();
		try {
			JSONArray jsonArray = JSONArray.fromObject(wifiJson);
			wifiList = JSONArray.toList(jsonArray, TeacherAttendWifi.class);
		} catch (Exception e) {
        	return revertCount;
		}
		if(wifiList == null || wifiList.size() < 1){
        	return revertCount;
		}
		revertCount = wifiList.size();
		for (TeacherAttendWifi item : wifiList) {
			if(_Tool.isEmpty(item.getWifiName()) || _Tool.isEmpty(item.getWifiMac())){
				continue;
			}
			item.setGroupId(groupId);
			this.insertWifi(item);
		}
    	return revertCount;
	}

	@Override
	public TeacherAttendWifi updateWifi(TeacherAttendWifi model) {
		return teacherAttendWifiDao.updateWifi(model);
	}

	@Override
	public Integer updateWifis(Long groupId, String wifiJson) {
		Integer revertCount = 0;
		List<TeacherAttendWifi> nowList = new ArrayList<TeacherAttendWifi>();
		try {
			JSONArray jsonArray = JSONArray.fromObject(wifiJson);
			nowList = JSONArray.toList(jsonArray, TeacherAttendWifi.class);
		} catch (Exception e) {
        	return revertCount;
		}
		if(nowList == null || nowList.size() < 1){
			this.deleteByGroup(groupId);
        	return revertCount;
		}
		List<TeacherAttendWifi> oldList = this.findByGroup(groupId);
		Long oldSiteId, nowSiteId;
		boolean isExist = false;
		for (TeacherAttendWifi old : oldList) {
			isExist = false;
			oldSiteId = old.getWifiId();
			for (TeacherAttendWifi now : nowList) {
				nowSiteId = now.getWifiId();
				if(_Tool.isLong(nowSiteId) && oldSiteId.intValue()==nowSiteId.intValue()){
					isExist = true;
					this.updateWifi(now);
					revertCount++;
				}
			}
			// 新的list里面不包含，直接删除
			if(!isExist){
				revertCount++;
				this.deleteWifi(oldSiteId);
			}
		}
		
		// 判断新增
		for (TeacherAttendWifi site : nowList) {
			if(!_Tool.isLong(site.getWifiId())){
				if(_Tool.isEmpty(site.getWifiName()) || _Tool.isEmpty(site.getWifiMac())){
					continue;
				}
				site.setGroupId(groupId);
				this.insertWifi(site);
				revertCount++;
			}
		}
		return revertCount;
	}

	@Override
	public StateModel deleteWifi(Long wifiId) {
		TeacherAttendWifi wifi = teacherAttendWifiDao.deleteWifi(wifiId);
		return new StateModel(wifi.getStatus().intValue()==_Const.STATE_ERROR);
	}

	@Override
	public void deleteByGroup(Long groupId) {
		teacherAttendWifiDao.deleteByGroup(groupId);
	}

}
