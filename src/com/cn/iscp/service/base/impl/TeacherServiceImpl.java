package com.cn.iscp.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.auth.RoleUserDao;
import com.cn.iscp.dao.base.QualificationDao;
import com.cn.iscp.dao.base.TeacherDao;
import com.cn.iscp.dao.dbase.SubjectGroupDao;
import com.cn.iscp.dao.ligent.PositionDao;
import com.cn.iscp.entity.base.Teacher;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.base.ince.TeacherService;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.paas.easemob.IMService;
import com.cn.paas.easemob.model.base.IMUser;

@Service("teacherService")
public class TeacherServiceImpl extends BaseSericel implements TeacherService{

	private static Logger log = Logger.getLogger(TeacherServiceImpl.class);
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private QualificationDao qualificationDao;
	@Resource
	private SubjectGroupDao groupSubjectDao;
	@Resource
	private RoleUserDao roleUserDao;
	@Resource
	private PositionDao positionDao;

	@Override
	public PageModel findPage(Map<String, Object> map) {
		List<List<?>> list = teacherDao.findPage(map);
		return getMapByPage(list);
	}

	/*@Override
	public List<Teacher> findPage(Map<String, Object> map) {
		return teacherDao.findPage(map);
	}

	@Override
	public Long getPageCount(Map<String, Object> map) {
		return teacherDao.getPageCount(map);
	}*/

	@Override
	public Teacher findById(Long teacherId) {
		return teacherDao.findById(teacherId);
	}

	@Override
	public List<Teacher> findBySubject(Long subjectId) {
		return teacherDao.findBySubject(subjectId);
	}

	@Override
	public Teacher addTeacher(Teacher model) {
		Teacher teacher = teacherDao.addTeacher(model);
		if(teacher != null){
			// 创建环信用户
			IMUser imUser = new IMUser(model.getUserKey(), model.getTeacherName(), model.getPassWord());
			IMService.createUser(imUser);
		}
		return teacher;
	}

	@Override
	public Teacher editTeacher(Teacher model) {
		return teacherDao.editTeacher(model);
	}

	@Override
	public boolean delTeacher(Long teacherId) {
		Teacher teacher = teacherDao.findById(teacherId);
		boolean revert = teacherDao.delTeacher(teacherId).intValue() > 0;
		if(revert){
			// 删除环信用户
			IMService.deleteUser(teacher.getMobile());
		}
		return revert;
	}

	@Override
	public boolean updateFlagtime(Teacher model) {
		return teacherDao.updateFlagtime(model);
	}

	@Override
	public boolean updateHeadPortrait(Teacher model) {
		return teacherDao.updateHeadPortrait(model);
	}

	@Override
	public void handleTeacherSubject(Teacher model) {
		teacherDao.handleTeacherSubject(model);
	}

	@Override
	public List<Teacher> login(String account, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", _Const.STATE_SUCCESS);
		map.put("userType", _Const.ROLE_TEACHER);
		map.put("account", account);
		map.put("password", password);
		List<Teacher> teacherList = teacherDao.login(map);
		return teacherList;
	}

	@Override
	public StateModel mt_login(String account, String password) {
		List<Teacher> teacherList = this.login(account, password);
		if(teacherList == null || teacherList.size() < 1){
			return new StateModel("账号密码不匹配!");
		}else if(teacherList.size() > 1){
			log.info("存在多个账号,请联系管理员!");
		}
		Teacher teacher = teacherList.get(0);
		teacher.setGroupList(groupSubjectDao.findByTeacher(teacher.getTeacherId()));
		teacher.setPosition(positionDao.findUserPosition(teacher.getTeacherId()));
		return new StateModel(teacher);
	}
	
	@Override
	public Teacher pc_login(String account, String password) {
		List<Teacher> teacherList = this.login(account, password);
		if(teacherList == null || teacherList.size() < 1){
			return null;
		}else if(teacherList.size() > 1){
			log.info("存在多个账号,请联系管理员!");
		}
		return teacherList.get(0);
	}

	@Override
	public List<Teacher> findPhoneBook(Long roleId) {
		return teacherDao.findPhoneBook(roleId);
	}

	@Override
	public List<Teacher> findBytotal() {
		return teacherDao.findBytotal();
	}

	@Override
	public Teacher findNameByIds(String userIds) {
		return teacherDao.findNameByIds(userIds);
	}

	
}
