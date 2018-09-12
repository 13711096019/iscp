package com.cn.paas.jiguang.push;

/**
 * 极光推送常量推送码
 * @author 10011037@qq.com
 * 2016-02-12
 */
public class PushCode {
	
	/*
	 * 班牌终端
	 */
	/** 通知 */
	public static final Integer NOTICE = 1001;
	/** 视频 */
	public static final Integer VIDEO = 1002;
	/** 弹屏 */
	public static final Integer WINDOW = 1003;
	/** 终端登录 */
	public static final Integer LOGIN = 1004;
	/** 班级课程表 */
	public static final Integer COURSE_TABLE = 1005;
	/** 班级值日 */
	public static final Integer ONDUTY_TODAY = 1006;
	/** 班级功课 */
	public static final Integer CLASS_HOMEWORK = 1007;
	/** 默认视频 */
	public static final Integer DEFAULT_VIDEO = 1008;
	/** 学生荣誉 */
	public static final Integer STUDENT_HONORS = 1009;
	/** 班级荣誉 */
	public static final Integer CLASS_HONORS = 1010;
	/** 班级图片 */
	public static final Integer CLASS_PICTURE = 1011;
	/** 班级动态 
	public static final Integer CLASS_DYNAMIC = 1012;*/
	/** 班级考勤 */
	public static final Integer CLASS_CLOCKONDAY = 1013;
	/** 班级座位表 */
	public static final Integer CLASS_SEATING = 1014;
	/** 课堂信息(关闭*10) */
	public static final Integer CLASS_ROOM = 1015;
	/** 公告 */
	public static final Integer CLASS_ANNOUNCEMENT = 1016;
	/** 班干部 */
	public static final Integer CLASS_ESLEADER = 1017;
	/** 班风班训 */
	public static final Integer CLASS_MOTTO = 1023;
	/** 班级表扬 */
	public static final Integer CLASS_PRAISE = 1024;
	/** 校园新闻 */
	public static final Integer CAMPUS_NEWS = 1025;
	/** 风采作品 */
	public static final Integer CAMPUS_WORKS = 1026;
	/** 倒计时 */
	public static final Integer COUNTDOWNS = 1027;
	/** 学生信息 */
	public static final Integer STUDENT = 1028;
	/** 提醒上传学生打卡记录 */
	public static final Integer STUDENT_PUNCH_THE_CLOCK = 1029;
	/** 班级学生卡列表 */
	public static final Integer STUDENT_CARD = 1030;
	/** 学校菜谱 */
	public static final Integer COOK_BOOK = 1031;
	/** 三风简讯 */
	public static final Integer SPIRIT = 1032;
	/** 名人典故 */
	public static final Integer CAMPUS_ALLUSION = 1033;
	/** 科普知识 */
	public static final Integer CAMPUS_KNOWLEDGE = 1034;
	/** 创文评分 */
	public static final Integer CIVILIZED = 1035;
	/** 月考统计*/
	public static final Integer EXAM_RESULT = 1036;
	
	/** 考试模式(关闭*10) */
	public static final Integer PATTERN_EXAM = 1601;
	/** 升旗模式(关闭*10) */
	public static final Integer PATTERN_HOISTAFLAG = 1602;
	/** 紧急模式(关闭*10) */
	public static final Integer PATTERN_URGENT = 1603;
	
	/** 班牌终端系统更新 */
	public static final Integer VERSION_APK = 2601;
	
	/*
	 * 班牌老师端
	 */
	/** 提醒老师上课 */
	public static final Integer REMIND_TEACHERCLASS = 5001;
	/** 提醒老师有学生请假 */
	public static final Integer REMIND_STUDENTSLEAVE = 5002;
	/** 日程提醒 */
	public static final Integer REMIND_CALENDAR = 5003;
	/** 边教边研 */
	public static final Integer REMIND_RESEARCH = 5004;
	/** 群信息更改通知 */
	public static final Integer REMIND_GROUPCHAT = 5005;
	/** 校信通知 */
	public static final Integer REMIND_NOTIFY = 5006;
	/** 没查看作业通知 */
	public static final Integer REMIND_NOTCHECKHOMEWORK = 5007;
	/** 老师收到学生请假通知 */
	public static final Integer REMIND_STUDENT_LEAVE = 5008;
	/** 家长收到老师查阅请假通知 */
	public static final Integer REMIND_TEACHER_CONSULT_LEAVE = 5009;
	/** 家长收到学生上学放学通知 */
	public static final Integer REMIND_STUDENT_ATTEND = 5010;
	/** 审判员收到老师请假通知 */
	public static final Integer REMIND_TEACHER_LEAVE = 5011;
	/** 请假者收到请假审批通知 */
	public static final Integer REMIND_TEACHER_CHECK = 5012;
	/** 高管收到老师请假通知(通知查看) */
	public static final Integer REMIND_TEACHER_SEE = 5013;
	/** 出勤报表通知(通知查看) */
	public static final Integer ATTEND_DAILY_STATISTICS = 5014;
	
	
	/** 接口路径 *//*
	public final static Map<Integer, String> INTERFACE_PATH = new HashMap<Integer, String>();  
	static {
		*//** 通知 *//*
		INTERFACE_PATH.put(NOTICE, "/iscp/card/display/findNotice");
		*//** 视频 *//*
		INTERFACE_PATH.put(VIDEO, "/iscp/card/display/findVideo");
		*//** 弹屏 *//*
		INTERFACE_PATH.put(WINDOW, "/iscp/card/display/findWindow");
		*//** 终端登录 *//*
		INTERFACE_PATH.put(LOGIN, "/iscp/card/display/login");
		*//** 班级课程 *//*
		INTERFACE_PATH.put(COURSE_TABLE, "/iscp/card/display/findCourseTable");
		*//** 班级值日 *//*
		INTERFACE_PATH.put(ONDUTY_TODAY, "/iscp/card/display/getOndutyToday");
		*//** 班级功课 *//*
		INTERFACE_PATH.put(CLASS_HOMEWORK, "/iscp/card/display/getHomeworkToday");
		*//** 默认视频 *//*
		INTERFACE_PATH.put(DEFAULT_VIDEO, "/iscp/card/display/getDefaultVideo");
		*//** 学生荣誉 *//*
		INTERFACE_PATH.put(STUDENT_HONORS, "/iscp/card/display/findStudentHonors");
		*//** 班级荣誉 *//*
		INTERFACE_PATH.put(CLASS_HONORS, "/iscp/card/display/findClassHonors");
		*//** 班级图片 *//*
		INTERFACE_PATH.put(CLASS_PICTURE, "/iscp/mt/card/album/findClassPicture");
		*//** 班级动态 
		INTERFACE_PATH.put(CLASS_DYNAMIC, "/iscp/card/display/findClassDynamic");*//*
		*//** 班级考勤 *//*
		INTERFACE_PATH.put(CLASS_CLOCKONDAY, "/iscp/mt/card/class/getClassClockOnday");
		*//** 班级座位表 *//*
		INTERFACE_PATH.put(CLASS_SEATING, "/iscp/card/display/getSeatingChart");
		*//** 课堂信息 *//*
		INTERFACE_PATH.put(CLASS_ROOM, "/iscp/card/display/getCurrentLesson");
		*//** 公告 *//*
		INTERFACE_PATH.put(CLASS_ANNOUNCEMENT, "/iscp/card/display/findAnnouncement");
		*//** 班干部 *//*
		INTERFACE_PATH.put(CLASS_ESLEADER, "/iscp/card/display/findClassesLeader");
		*//** 班风班训 *//*
		INTERFACE_PATH.put(CLASS_MOTTO, "/iscp/card/display/getClassMotto");
		*//** 班级表扬 *//*
		INTERFACE_PATH.put(CLASS_PRAISE, "/iscp/card/display/findClassPraise");
		*//** 校园新闻 *//*
		INTERFACE_PATH.put(CAMPUS_NEWS, "/iscp/card/index/findCampusNews");
		*//** 风采作品 *//*
		INTERFACE_PATH.put(CAMPUS_WORKS, "/iscp/card/index/findCampusWorks");
		*//** 倒计时 *//*
		INTERFACE_PATH.put(COUNTDOWNS, "/iscp/mt/card/countdown/findCountdown");
		*//** 学生信息 *//*
		INTERFACE_PATH.put(STUDENT, "/iscp/mt/card/student/findStudent");
		*//** 学生打卡记录 *//*
		INTERFACE_PATH.put(STUDENT_PUNCH_THE_CLOCK, "/iscp/mt/card/student/uploadPunchTheClock");
		*//** 班级学生卡列表 *//*
		INTERFACE_PATH.put(STUDENT_CARD, "/iscp/mt/card/student/findStudentCard");
		*//** 学校菜谱 *//*
		INTERFACE_PATH.put(COOK_BOOK, "/iscp/mt/card/cook/findCookBook");
		
		*//** 考试模式 *//*
		INTERFACE_PATH.put(PATTERN_EXAM, "考试模式");
		*//** 升旗模式*//*
		INTERFACE_PATH.put(PATTERN_HOISTAFLAG, "升旗模式");
		*//** 紧急模式*//*
		INTERFACE_PATH.put(PATTERN_URGENT, "紧急模式");

		*//** 班牌终端系统更新 *//*
		INTERFACE_PATH.put(VERSION_APK, "/mt/card/apk/getVersionUpdatesContent");
		
		*//** 提醒老师上课*//*
		INTERFACE_PATH.put(REMIND_TEACHERCLASS, "还有5分钟就要上课了，别忘记准备哦！");
		*//** 提醒老师有学生请假*//*
		INTERFACE_PATH.put(REMIND_STUDENTSLEAVE, "收到学生请假申请！");
	}*/
	
}
