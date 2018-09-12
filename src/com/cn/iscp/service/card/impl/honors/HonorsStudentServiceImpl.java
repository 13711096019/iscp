package com.cn.iscp.service.card.impl.honors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.base.HonorsCriteriaDao;
import com.cn.iscp.dao.base.HonorsDao;
import com.cn.iscp.dao.card.honors.HonorsStudentDao;
import com.cn.iscp.entity.base.Honors;
import com.cn.iscp.entity.card.honors.HonorsStudent;
import com.cn.iscp.service.card.ince.honors.HonorsStudentService;
import com.cn.paas.jiguang.push.PushCode;
import com.cn.paas.jiguang.push.PushInvite;
import com.cn.paas.jiguang.push.PushKey;

@Service("honorsStudentService")
public class HonorsStudentServiceImpl implements HonorsStudentService {
	
	@Resource
	private HonorsStudentDao honorsStudentDao;
	@Resource
	private HonorsDao honorsDao;
	@Resource
	private HonorsCriteriaDao honorsCriteriaDao;
	
	@Override
	public List<HonorsStudent> findByMonty(Long classNum) {
		return honorsStudentDao.findByMonty(classNum);
	}	

	@Override
	public List<Map<String, Object>> findByTerm(Long classNum) {
		List<HonorsStudent> list = honorsStudentDao.findByTerm(classNum);
		if(list == null || list.size() < 1){
			return null;
		}
		
		List<Map<String, Object>> mapList= new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HonorsStudent> honorsList = new ArrayList<HonorsStudent>();

		Integer yearOld = list.get(0).getYear();
		Integer yearNew = 0;
		Integer monthOld = list.get(0).getMonth();
		Integer monthNew = 0;
		for (HonorsStudent honors : list) {
			yearNew = honors.getYear();
			monthNew = honors.getMonth();
			if(monthOld.intValue()==monthNew.intValue()){
				honorsList.add(honors);
			}else{
				map.put("year", yearOld);
				map.put("month", monthOld);
				map.put("childList", honorsList);
				mapList.add(map);
				
				// 下一轮
				map = new HashMap<String, Object>();
				honorsList = new ArrayList<HonorsStudent>();
				honorsList.add(honors);
				monthOld = monthNew;
				yearOld = yearNew;
			}
		}
		map.put("year", yearOld);
		map.put("month", monthOld);
		map.put("childList", honorsList);
		mapList.add(map);
		return mapList;
	}

	@Override
	public List<Honors> findByType(Long classNum) {
		// 需要移除的列表
		List<Honors> removeList = new ArrayList<Honors>();
		// 返回列表
		List<Honors> list = honorsDao.findBySection(_Const.HONORS_STUDENT);
		HonorsStudent model = new HonorsStudent();
		model.setClassNum(classNum);
		Long honorsId = null;
		List<HonorsStudent> temStudentHonorsList = null;
		for (Honors honors : list) {
			honorsId = honors.getHonorsId();
			model.setHonorsId(honorsId);
			temStudentHonorsList = honorsStudentDao.findByType(model);
			// 如果该荣誉类型的学生标兵为空就移除该荣誉类型
			if(temStudentHonorsList == null || temStudentHonorsList.size() < 1){
				removeList.add(honors);
				continue;
			}
			honors.setStudentHonorsList(temStudentHonorsList);
			honors.setCriteriaList(honorsCriteriaDao.findByHonors(honorsId));
		}
		
		// 开始移除
		for (Honors honors : removeList) {
			list.remove(honors);
		}
		return list;
	}

	@Override
	public void handleStudentHonors(HonorsStudent model) {
		honorsStudentDao.handleStudentHonors(model);
		// 推送到终端
		PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, model.getClassNum(), PushCode.STUDENT_HONORS);
		jdpust.buildPushNotAlert();
	}

	@Override
	public List<HonorsStudent> findByFresh() {
		return honorsStudentDao.findByFresh();
	}

	@Override
	public boolean update(HonorsStudent model) {
		boolean revert = honorsStudentDao.update(model);
		if(revert){
			// 推送到终端
			PushInvite jdpust = new PushInvite(PushKey.CODE_TERMINAL, model.getClassNum(), PushCode.STUDENT_HONORS);
			jdpust.buildPushNotAlert();
		}
		return revert;
	}

}
