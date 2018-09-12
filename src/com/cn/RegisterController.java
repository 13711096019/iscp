package com.cn.iscp.controller.mobile;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.entity.attend.TeacherAttendRecord;
import com.cn.iscp.entity.attend.TeacherAttendScheduling;
import com.cn.iscp.entity.attend.TeacherAttendSite;
import com.cn.iscp.entity.base.Teacher;
import com.cn.iscp.model.StateModel;
import com.cn.iscp.service.attend.ince.TeacherAttendRecordService;
import com.cn.iscp.service.attend.ince.TeacherAttendReviseService;
import com.cn.iscp.service.attend.ince.TeacherAttendSchedulingService;
import com.cn.iscp.service.attend.ince.TeacherAttendSiteService;
import com.cn.iscp.service.attend.ince.TeacherAttendWifiService;
import com.cn.iscp.service.auth.ince.RoleService;
import com.cn.iscp.service.auth.ince.UserService;
import com.cn.iscp.service.base.ince.TeacherService;
import com.cn.iscp.service.ligent.ince.SmsService;
import com.cn.unit.location.AMapUtils;
import com.cn.unit.location.LngLat;
import com.cn.unit.utils.DateUtil;

/**
 * 手机考勤
 * @author xz
 * 2018-08-24
 */
@Controller
@RequestMapping("/mobile/register")
public class RegisterController {
	
	private static Logger log = Logger.getLogger(RegisterController.class);
	@Resource
	private TeacherService teacherService;
	@Resource
	private TeacherAttendSchedulingService teacherAttendSchedulingService;
	@Resource
	private TeacherAttendReviseService teacherAttendReviseService;
	@Resource
	private TeacherAttendSiteService teacherAttendSiteService;
	@Resource
	private TeacherAttendWifiService teacherAttendWifiService;
	@Resource
	private TeacherAttendRecordService teacherAttendRecordService;
	@Resource
	private TeacherService baseTeacherService;
	@Resource
	private RoleService roleService;
	@Resource
	private UserService userService;
	@Resource
	private SmsService smsService;
	
	private static String MODEL_KEY = "mobile/register";
	private static String MODEL_NAME = "考勤登录";
	
	   /**
		 * 手机考勤登录页
		 */
	    @RequestMapping("/mobilelogin")
	    public String mobilelogin(HttpServletRequest request, Model model) throws Exception{
	    	log.info("手机考勤登陆页");
			request.getSession(true).invalidate();
	        return "mobile/login";
	    }
	    
	    /**
		 * 手机考勤登录验证
		 */
	    @RequestMapping(value = "/phonelogon", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	    public @ResponseBody String phonelogon(HttpServletRequest request, HttpServletResponse response) {
	    	String userNum = request.getParameter("userNum");
	    	String userPwd = request.getParameter("userPwd");
	        
	    	if(_Tool.isEmpty(userNum) || _Tool.isEmpty(userPwd)){
	    		log.error("登录验证:参数错误");
				return _Tool.toJson(new StateModel(0, "账号密码不正确!"));
	    	}
	    	Teacher teacher = teacherService.pc_login(userNum, userPwd);
	    	String json = "";
	    	if(teacher != null){
	    		request.getSession().setAttribute(_Const.SESSIONNAME_LOGINUSERID, teacher.getTeacherId());
	    		request.getSession().setAttribute(_Const.SESSIONNAME_LOGINUSERACCOUNT, teacher.getMobile());
	        	json = _Tool.toJson(new StateModel(true));
	    	}else{
	    		json = _Tool.toJson(new StateModel(0, "账号密码不匹配!"));
	    	}
	    	log.info("登录验证["+userNum+"]："+json);
	    	return json;
	    }
	    
	
	/**
	 * 考勤页面
	 */
    @RequestMapping("/clocking")
    public String clocking(HttpServletRequest request, Model model) throws Exception{
    	//判断位置是否获取成功
    	String tip = request.getParameter("tip");
		// 获取登录人编号
		Long userId =_Tool.toLong(request.getSession().getAttribute(_Const.SESSIONNAME_LOGINUSERID));
		String attendDate=DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
		// 获取登录人信息
		Teacher loginUser = baseTeacherService.findById(userId);
		log.info("登录人信息:"+JSON.toJSONString(loginUser, SerializerFeature.WriteMapNullValue));
		
		TeacherAttendScheduling scheduling = new TeacherAttendScheduling(_Tool.toLong(userId), null, attendDate);
		Map<String, Object> record = teacherAttendSchedulingService.findByDate(scheduling);
		Long groupID = _Tool.toLong(record.get("groupId"));
		Long schedulingId = _Tool.toLong(record.get("schedulingId"));
		List<Map<String, Object>> recordList = teacherAttendRecordService.findByScheduling(schedulingId);
		List<TeacherAttendSite> siteList=null;
		if(_Tool.toLong(tip)==1){
    		//获取经纬度
        	String lng = request.getParameter("lng");
        	String lat = request.getParameter("lat");
        	double longitude;//经度
        	double latitude;//纬度
        	siteList = teacherAttendSiteService.findByGroup(groupID);
			for (int i = 0; i < siteList.size(); i++) {
				latitude=siteList.get(i).getSiteLat();
				longitude=siteList.get(i).getSiteLng();
				LngLat start = new LngLat(_Tool.toDouble(lng),_Tool.toDouble(lat));
			    LngLat end = new LngLat(_Tool.toDouble(longitude), _Tool.toDouble(latitude));
			    double distance=AMapUtils.calculateLineDistance(start, end);//距离计算
			    DecimalFormat df = new DecimalFormat("#.00");
			    siteList.get(i).setDistance(_Tool.toDouble(df.format(distance/10)));
			}
			model.addAttribute("lng", lng);
			model.addAttribute("lat", lat);
    	}else {
    		return "main/mobilelogin";
		}
		
		//判断上下班中间值开始
		Map<String, Object> middleMap1 = null;
		Map<String, Object> middleMap2 = null;
		Map<String, Object> axisTypeis = null;
		String timedifference =null;
		for (int i = 0; i < recordList.size(); i++) {
			middleMap1 = null;
			middleMap2 = null;
			axisTypeis = recordList.get(i);
			//上班中间时间
		    if(_Tool.toInt(axisTypeis.get("axisType"))==1){
			  middleMap1 = recordList.get(i);
			  if(i != recordList.size() - 1){
				middleMap2 = recordList.get(i+1);
			  }
			  String middletime1 = middleMap1 != null ? _Tool.toStr(middleMap1.get("normalTime")) : "";
			  String middletime2 = middleMap2 != null ? _Tool.toStr(middleMap2.get("normalTime")) : "";
			  int transitiontime = DateUtil.getTimeDifferent(middletime1,middletime2,"minute");
			  timedifference  = DateUtil.getDifferentTime(middletime1, (transitiontime/2), DateUtil.H_M, "minute");
			  recordList.get(i).put("timedifference", timedifference);
		    }
		    //下班中间时间
		    if(_Tool.toInt(axisTypeis.get("axisType"))==2){
		      axisTypeis = null;
			  middleMap1 = recordList.get(i);
			  if(i != 0){
				middleMap2 = recordList.get(i-1);
			  }
			  String middletime1 = middleMap1 != null ? _Tool.toStr(middleMap1.get("normalTime")) : "";
			  String middletime2 = middleMap2 != null ? _Tool.toStr(middleMap2.get("normalTime")) : "";
			  int transitiontime = DateUtil.getTimeDifferent(middletime1,middletime2,"minute");
			  timedifference  = DateUtil.getDifferentTime(middletime1, (transitiontime/2), DateUtil.H_M, "minute");
			  recordList.get(i).put("timedifference", timedifference);
		    }
		}
		//判断上下班中间值结束
		
		for (Map<String, Object> item : recordList) {
			/////////// 开始 生成上班最早打卡时间、下班最晚打卡时间
			// 标准时间
			String normalTime = _Tool.toStr(item.get("normalTime"));
			// 时段（上班最早打卡分钟数，下班最晚打卡分钟数）
			Integer timeInterval = _Tool.toInt(item.get("timeInterval"));
			if(timeInterval.intValue() == -1){
				item.put("nimbleTime", normalTime);
			}else{
				// 打卡类型（1上班，2下班）
				Integer axisType = _Tool.toInt(item.get("axisType"));
				timeInterval = axisType.intValue() == 1 ? (0 - timeInterval) : timeInterval;
				normalTime = DateUtil.getDifferentTime(normalTime, timeInterval, DateUtil.H_M, "minute");
				item.put("nimbleTime", normalTime);
			}
			/////////// 结束 生成上班最早打卡时间、下班最晚打卡时间
			Integer attendType = _Tool.toInt("attendType");
			if(_Tool.isInt(attendType) && _Tool.toInt(attendType).intValue() != 1){
				Long recordId = _Tool.toLong(item.get("recordId"));
				item.put("reviseList", teacherAttendReviseService.findByRecord(recordId));
			}
		}
		record.put("recordList", recordList);
		record.put("siteList", siteList);
		record.put("wifiList", teacherAttendWifiService.findByGroup(groupID));
		model.addAttribute("record", record);
		model.addAttribute("loginUser", loginUser);
        return "mobile/clocking";
    }
    
    /**
	 * 新增考勤记录
	 */
	@RequestMapping(value = "/insertRecord", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String insertRecord(HttpServletRequest request, HttpServletResponse response) {
		// 获取登录人编号
		Long userId =_Tool.toLong(request.getSession().getAttribute(_Const.SESSIONNAME_LOGINUSERID));		
		String groupId = request.getParameter("groupId");
		String axisId = request.getParameter("axisId");
		String siteId = request.getParameter("siteId");
		String wifiId = request.getParameter("wifiId");
		String attendDate = DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD);
		String attendTime = DateUtil.getStrByDate(null, DateUtil.H_M);
		String attendLng = request.getParameter("lng");
		String attendLat = request.getParameter("lat");
		String attendType = "1";
		String attendState ="1";
		//状态（1正常，2迟到，3严重迟到，4早退，5缺卡）
		String belateId = request.getParameter("belateId");
		String normalTime = request.getParameter("normalTime");
		DateFormat df = new SimpleDateFormat("hh:mm");
		try {
			Date dt1 = df.parse(attendTime);
			Date dt2 = df.parse(normalTime);
			if(_Tool.toLong(belateId)==1 && dt1.getTime() > dt2.getTime()){
			  attendState ="2";
			}else if(_Tool.toLong(belateId)==2 && dt1.getTime() < dt2.getTime()) {
				attendState ="4";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String exteriorAttend = "0";
		// 参数校验
    	log.info("新增考勤记录:userId["+userId+"],groupId["+groupId+"],axisId["+axisId
    			+"],siteId["+siteId+"],wifiId["+wifiId+"],attendDate["+attendDate
    			+"],attendTime["+attendTime+"],attendLng["+attendLng+"],attendLat["+attendLat
    			+"],attendType["+attendType+"],attendState["+attendState+"],exteriorAttend["+exteriorAttend+"]");
		if(!_Tool.isLong(userId) || !_Tool.isLong(groupId) || !_Tool.isLong(axisId) 
				|| !_Tool.isDate(attendDate) || _Tool.isEmpty(attendTime)
				|| !_Tool.isInt(attendType) || !_Tool.isInt(attendState)
				|| !_Tool.isInt(exteriorAttend)){
        	log.error("新增考勤记录:参数错误");
			return _Tool.toJson(new StateModel(false));
		}
		// 非外勤打卡，siteId与wifiId必选其一(优先选择wifiId)
		if(_Tool.toInt(exteriorAttend).intValue() == 0 && (!_Tool.isLong(siteId) && !_Tool.isLong(wifiId))){
        	log.error("新增考勤记录:参数错误");
			return _Tool.toJson(new StateModel(false));
		}
		
		TeacherAttendRecord record = new TeacherAttendRecord(_Tool.toLong(userId), 
				_Tool.toLong(groupId), _Tool.toLong(axisId), _Tool.toLong(siteId), 
				_Tool.toLong(wifiId), attendDate, attendTime, _Tool.toDouble(attendLng), 
				_Tool.toDouble(attendLat), _Tool.toInt(attendType), 
				_Tool.toInt(attendState), _Tool.toInt(exteriorAttend));
		record = teacherAttendRecordService.insertRecord(record);
		
		String json = _Tool.toJson(new StateModel(record));
		log.info("新增考勤记录:"+json);
		return json;
	}
    
}
