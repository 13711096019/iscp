package com.cn.iscp.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.iscp.dao.base.PatriarchDao;
import com.cn.iscp.dao.base.StudentDao;
import com.cn.iscp.entity.base.Patriarch;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.base.ince.PatriarchService;

@Service("patriarchService")
public class PatriarchServiceImpl implements PatriarchService {
	
	@Resource
	private PatriarchDao patriarchDao;
	@Resource
	private StudentDao studentDao;

	@Override
	public StateModel login(Patriarch model) {
		List<Patriarch> teacherList = patriarchDao.login(model);
		if(teacherList == null || teacherList.size() < 1){
			return new StateModel("账号密码不匹配!");
		}
		Patriarch patriarch = teacherList.get(0);
		patriarch.setStudentList(studentDao.findByPatriarch(patriarch.getMobile()));
		return new StateModel(patriarch);
	}

	@Override
	public List<Patriarch> findByClassNum(Long classNum) {
		return patriarchDao.findByClassNum(classNum);
	}
	
	/*@Override
	public Patriarch handleByTeacher(Patriarch model) {
		return patriarchDao.handleByTeacher(model);
	}
	
	@Override
	public StateModel handleByPatriarch(Patriarch model) {
		return patriarchDao.handleByPatriarch(model);
	}*/

	@Override
	public Patriarch findById(Long patriarchId) {
		return patriarchDao.findById(patriarchId);
	}

	@Override
	public Patriarch findByAccount(String logAccount) {
		return patriarchDao.findByAccount(logAccount);
	}

	@Override
	public boolean updateHeadPortrait(Patriarch model) {
		return patriarchDao.updateHeadPortrait(model);
	}
	
}
