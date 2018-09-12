package com.cn.iscp.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.common._Const;
import com.cn.iscp.dao.auth.UserDao;
import com.cn.iscp.dao.base.StudentDao;
import com.cn.iscp.dao.card.CensusClassDao;
import com.cn.iscp.dao.dbase.ClassEntityDao;
import com.cn.iscp.entity.auth.User;
import com.cn.iscp.entity.base.Student;
import com.cn.iscp.entity.dbase.ClassEntity;
import com.cn.iscp.entity.dbase.ClassEntityUpgrade;
import com.cn.iscp.model.PageModel;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.base.ince.StudentService;
import com.cn.iscp.service.ligent.BaseSericel;
import com.cn.paas.easemob.IMService;
import com.cn.paas.easemob.model.base.IMUser;

@Service("studentService")
public class StudentServiceImpl extends BaseSericel implements StudentService {
	
	/*@Autowired*/
	@Resource
	private StudentDao studentDao;
	@Resource
	private UserDao userDao;
	@Resource
	private ClassEntityDao classEntityDao;
	@Resource
	private CensusClassDao classCensusDao;
	
	@Override
	public PageModel findPage(Map<String, Object> map) {
		List<List<?>> list = studentDao.findPage(map);
		return getMapByPage(list);
	}
	
	/*@Override
	public List<Student> findPage(Map<String, Object> map) {
		return studentDao.findPage(map);
	}
	
	@Override
	public Long getPageCount(Map<String, Object> map) {
		return studentDao.getPageCount(map);
	}*/
	
	@Override
	public Student findById(Long studentId) {
		return studentDao.findById(studentId);
	}
	
	@Override
	public List<Student> findByClass(Long classNum) {
		ClassEntityUpgrade model = new ClassEntityUpgrade(classNum, null);
		ClassEntity classes = classEntityDao.getClassEntityByKeyId(model);
		Long classEntityId = classes.getClassEntityId();
		return studentDao.findByClass(classEntityId);
	}
	
	@Override
	public String getStudentNamesByClass(Long classNum) {
		ClassEntityUpgrade model = new ClassEntityUpgrade(classNum, null);
		ClassEntity classes = classEntityDao.getClassEntityByKeyId(model);
		Long classEntityId = classes.getClassEntityId();
		return studentDao.getStudentNamesByClass(classEntityId);
	}
	
	@Override
	public List<Student> findByHasCard(Long classNum) {
		ClassEntityUpgrade model = new ClassEntityUpgrade(classNum, null);
		ClassEntity classes = classEntityDao.getClassEntityByKeyId(model);
		Long classEntityId = classes.getClassEntityId();
		return studentDao.findByHasCard(classEntityId);
	}
	
	@Override
	public Student findFinal() {
		return studentDao.findFinal();
	}
	
	@Override
	public boolean update(Student model) {
		return studentDao.update(model);
	}
	
	@Override
	public Student addStudent(Student model){
		Student student = studentDao.addStudent(model);
		if(student != null){
			// 创建环信用户
			IMUser imUser = new IMUser(student.getUserKey(), student.getStudentName(), student.getLogPassword());
			IMService.createUser(imUser);
		}
		return student;
	}
	
	@Override
	public Student insertStudent(Map<String, Object> map) {
		Student student = studentDao.insertStudent(map);
		if(student != null){
			// 创建环信用户
			IMUser imUser = new IMUser(student.getUserKey(), student.getStudentName(), student.getLogPassword());
			IMService.createUser(imUser);
		}
		return student;
	}
	
	@Override
	public boolean delStudent(Long studentId) {
		User user = userDao.findById(studentId);
		boolean revert = studentDao.delStudent(studentId).intValue() > 0;
		if(revert){
			// 删除环信用户
			IMService.deleteUser(user.getMobile());
		}
		return revert;
	}
	
	@Override
	public StateModel login(String account, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", _Const.STATE_SUCCESS);
		map.put("userType", _Const.ROLE_PATRIARCH);
		map.put("account", account);
		map.put("password", password);
		
		List<Student> studentList = studentDao.login(map);
		if(studentList == null || studentList.size() < 1){
			return new StateModel("账号密码不匹配!");
		}else if(studentList.size() > 1){
			return new StateModel("账号异常,请联系管理员!");
		}
		return new StateModel(studentList.get(0));
	}
	
	@Override
	public void changeClass(Map<String, Object> map) {
		studentDao.changeClass(map);
		// 统计本学期学生的情况
		classCensusDao.censusClassCensus();
	}
	
	@Override
	public void emptyStudentByClassNum(Long classNum) {
		studentDao.emptyStudentByClassNum(classNum);
	}
	
	@Override
	public List<Student> findByPatriarch(String mobile) {
		return studentDao.findByPatriarch(mobile);
	}
	
	@Override
	public void handleBindPhone(Student model) {
		studentDao.handleBindPhone(model);
	}
	
	@Override
	public void handleStudentNum(Student model) {
		studentDao.handleStudentNum(model);
	}
	
	@Override
	public List<Student> findByNameAndCard(Student model) {
		return studentDao.findByNameAndCard(model);
	}
	
	@Override
	public void updateStudentInfo(Map<String, Object> map) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", 0);
		map.put("studentName", array[0]);
		map.put("idCard", array[2]);
		map.put("sexId", array[3].equals("男") ? 1 : 0);
		map.put("birthday", array[4]);
		map.put("nation", array[5]);
		map.put("nativePlace", array[6]);
		map.put("contactNumber", array[11]);
		map.put("liveAddress", array[12]);
		map.put("admissionDate", array[19].replaceAll("/", "-"));
		map.put("fatherName", array[7]);
		map.put("fatherCard", array[8]);
		map.put("motherName", array[9]);
		map.put("motherCard", array[10]);*/
		studentDao.updateStudentInfo(map);
	}
	
	@Override
	public PageModel findPageByPay(Map<String, Object> map) {
		List<List<?>> list = studentDao.findPageByPay(map);
		return getMapByPage(list);
	}
	
	@Override
	public void handleAdmissionDate(String studentIds) {
		studentDao.handleAdmissionDate(studentIds);
	}
	
	@Override
	public List<Student> findExcelByPay(int gradeId, int classNum,
			int hasAdmissionDate, int isNewborn) {
		return studentDao.findExcelByPay(gradeId, classNum, hasAdmissionDate, isNewborn);
	}
	
}
