package com.cn.common;

/**
 * 常量类
 * @author 10011037@qq.com
 * 2017-03-15
 */
public class _Const {
	
	/**
	 * 接口返回码
	 */
	/** 成功 */
	public static final int STATECODE_SUCCESS = 1;
	public static final String STATECODE_SUCCESS_HINT = "操作成功";
	/** 操作失败 */
	public static final int STATECODE_ERROR = 1102;
	public static final String STATECODE_ERROR_HINT = "操作失败";
	/** 回话已过期 */
	public static final int STATECODE_OVERDUE = 1109;
	public static final String STATECODE_OVERDUE_HINT = "回话已过期";
	
	
	/**
	 * 数据状态(1正常数据,0已删除,2无效)
	 */
	public static final int STATE_SUCCESS = 1;
	public static final int STATE_ERROR = 0;
	public static final int STATE_INVALID = 2;
	
	
	/**
	 * 固定学校编号
	 */
	public static final Long SCHOOL_ID = 1L;
	/**
	 * 风采作品存在有效期默认值
	 */
	public static final int CAMPUS_VALIDDATE = 1;
	
	/**
	 * 收费中心发布状态（1待发起2正在收费3收费结束）
	 */
	public static final int CHARGE_AWAITSTATUS = 1;
	public static final int CHARGE_INITIATE = 2;
	public static final int CHARGE_FINISH = 3;
	
	/**
	 * 用户类型(1学生,2老师)
	 */
	public static final int ROLE_PATRIARCH = 1;
	public static final int ROLE_TEACHER = 2;
	/**
	 * 家长作业确认(1未完成,2已经完成)
	 */
	public static final int HOME_WORKSCORE_ON = 1;
	public static final int HOME_WORKSCORE_OK = 2;
	
	/**
	 * 荣誉类型(1学生荣誉,2班级荣誉)
	 */
	public static final int HONORS_STUDENT = 1;
	public static final int HONORS_CLASSES = 2;
    /**
     * 风采作品（1，作文比赛2，写字比赛3，绘画比赛）
     */
	public static final int CAMPUS_COMPOSITION = 1;
	public static final int CAMPUS_WRITE = 2;
	public static final int CAMPUS_DRAWING = 3;
	
	/**
	 * 考勤打卡位置编号(1=校门，2=班门口)
	 */
	public static final int CLOCK_LOCATION_SCHOOL_GATE  = 1;
	public static final int CLOCK_LOCATION_CLASS_GATE = 2;
	
	/**
	 * 学年度编号(1第一学年度,2第二学年度)
	 */
	public static final int TERMS_ONE = 1;
	public static final int TERMS_TWO = 2;

	/**
	 * 通知公告编号(1通知,2公告,3清洁巡查)
	 */
	public static final int MESSAGE_NOTICE = 1;
	public static final int MESSAGE_AFFICHE  = 2;
	public static final int MESSAGE_INSPECT  = 3;
	
	/**
	 * 公告程度(1紧急,2紧急,3普通)
	 */
	public static final int MESSAGE_IMPLEVEL_URGENT = 1;
	public static final int MESSAGE_IMPLEVEL_MAJOR  = 2;
	public static final int MESSAGE_IMPLEVEL_COMMON  = 3;
	
	/**
	 * 等级范围(1学校,2年级,3班级)
	 */
	public static final int SCOPE_SCHOOL = 1;
	public static final int SCOPE_GRADE = 2;
	public static final int SCOPE_CLASS = 3;

	/**
	 * 试卷状态(1统计完毕,2待考试,3待评卷,4待统计)
	 */
	public static final int EXAM_STATE_OK = 1;
	public static final int EXAM_STATE_NO = 2;
	public static final int EXAM_STATE_ASSESS = 3;
	public static final int EXAM_STATE_CENSUS = 4;

	/**
	 * 试卷状态(1月考,2期末考,3中段考)
	 */
	public static final int EXAM_TYPE_MONTHLY = 1;
	public static final int EXAM_TYPE_TERMINAL  = 2;
	public static final int EXAM_TYPE_MIDTERM = 3;

	/**
	 * 唯一模式(1考试模式,2升旗模式,3紧急通知模式)
	 */
	public static final int PATTERN_TYPE_EXAM = 1;
	public static final int PATTERN_TYPE_FLAG  = 2;
	public static final int PATTERN_TYPE_URGENT  = 3;

	/**
	 * 请假时段(1上午请假,2下午请假,3全天请假,4连续请假)
	 */
	public static final int LEAVE_AM = 1;
	public static final int LEAVE_PM  = 2;
	public static final int LEAVE_DAY  = 3;
	public static final int LEAVE_DAYS  = 4;

	/**
	 * 新闻表数据类别(1校园新闻,2名人典故,3科普知识)
	 */
	public static final int NEWS_MOLD_ADMINISTRIVIA = 1;
	public static final int NEWS_MOLD_ALLUSION = 2;
	public static final int NEWS_MOLD_KNOWLEDGE = 3;

	/**
	 * 系统类型(1班牌终端,2老师端APP,3家长端APP)
	 */
	public static final int VERSIONTYPE_CLASSCARD  = 1;
	public static final int VERSIONTYPE_TEACHER = 2;
	public static final int VERSIONTYPE_PATRIARCH = 3;
	
	/**
	 * 分类名称
	 */
	/*学历*/
	public static final int ITEMCORD_EDUCATIONAL_LEVEL = 1;
	/*考试类型*/
	public static final int ITEMCORD_EXAM_TYPE = 2;
	/*学生干部分类*/
	public static final int ITEMCORD_CLASS_LEADER = 3;
	/*范围等级*/
	public static final int ITEMCORD_RANGE_LEVEL  = 5;
	/*重要程度*/
	public static final int ITEMCORD_NOTICE_IMPORTANCE = 6;
	/*通知类型*/
	public static final int ITEMCORD_NOTICE_TYPE = 7;
	/*老师标签*/
	public static final int ITEMCORD_TEACHER_LABEL  = 8;
	/*性别*/
	public static final int ITEMCORD_SEX = 9;
	/*新闻分类*/
	public static final int ITEMCORD_NEWS_TYPE = 11;
	/*师生作品分类*/
	public static final int ITEMCORD_WORKS_TYPE = 12;
	/*界面模式类型*/
	public static final int ITEMCORD_MODE = 13;
	/*手机系统版本*/
	public static final int ITEMCORD_VERSION_TYPE = 14;
	/*考勤打卡位置*/
	public static final int ITEMCORD_ATTENDANCE_LOCATION = 15;
	/*请假时段*/
	public static final int ITEMCORD_LEAVE_PERIOD = 16;
	/*出勤类型*/
	public static final int ITEMCORD_ATTENDANCE_TYPE = 17;
	/*风气类型*/
	public static final int ITEMCORD_FASHION_TYPE = 18;
	
	/**
	 * session名称
	 */
	/*session数量*/
	public static final String SESSION_COUNT = "loginUserCount";
	/*新增清洁巡查公告*/
	public static final String SESSIONNAME_INSPECTNOTICEID = "Session_InspectNoticeId";
	/*登录人编号*/
	public static final String SESSIONNAME_LOGINUSERID = "loginUserId";
	/*上传视频状态*/
	public static final String SESSIONNAME_UPLOADVIDEOSTATE = "uploadVideoState";
	/*登录人账号*/
	public static final String SESSIONNAME_LOGINUSERACCOUNT = "loginUserAccount";
	/*错误代码*/
	public static final String SESSIONNAME_ERRORCODE = "Session_ErrorCode";
	/*栏目代码*/
	public static final String SESSIONNAME_CATALOGCODE = "Session_CatalogCode";
	/*边教边研图片*/
	public static final String SESSIONNAME_RESEARCHPIC = "Session_ResearchPic";
	
}
