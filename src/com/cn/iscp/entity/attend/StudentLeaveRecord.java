package com.cn.iscp.entity.attend;

/**
 * 学生请假记录
 * @author 10011037@qq.com
 * 2018-06-04
 */
public class StudentLeaveRecord {
	
	
	/** 请假状态-0未查阅 */
	public static final int STATE_SOLICIT_CONSULT = 0;
	/** 请假状态-1已查阅 */
	public static final int STATE_AGREE_CONSULT = 1;
	
	// 自增编号
    private Long leaveId;
	// 动态班级编号
    private Long classNum;
	// 学年编号
    private Long schoolYearId;
	// 学年度编号
    private Long termId;
	// 用户编号
    private Long userId;
	// 请假开始日期
    private String leaveStartDate;
	// 请假截止日期
    private String leaveEndDate;
	// 创建时间
    private String createTime;
	// 请假天数(半天算0)
    private Integer leaveDayCount;
	// 请假原因
    private String leaveReason;
	// 请假状态（1班主任已查阅，0班主任未查阅）
    private Integer leaveState;

	// 用户姓名
    private String userName;
    // 班级名称
    private String className;
	// 用户Key
    private String userKey;
	// 用户头像
    private String headPortrait;
	// 分页查询-第几页
    private Integer pageCount;
	// 是否班主任
    private Integer isClassTeacher;
    
    public StudentLeaveRecord(){};
    
    public StudentLeaveRecord(Long leaveId, Long userId){
    	this.leaveId = leaveId;
    	this.userId = userId;
    }
    
    public StudentLeaveRecord(Long classNum, Long userId, Integer leaveState, Integer pageCount){
    	this.classNum = classNum;
    	this.userId = userId;
    	this.leaveState = leaveState;
    	this.pageCount = pageCount;
    }
    
    public StudentLeaveRecord(Long userId, String leaveStartDate, String leaveEndDate, 
    		Integer leaveDayCount, String leaveReason, Integer leaveState){
    	this.userId = userId;
    	this.leaveStartDate = leaveStartDate;
    	this.leaveEndDate = leaveEndDate;
    	this.leaveDayCount = leaveDayCount;
    	this.leaveReason = leaveReason;
    	this.leaveState = leaveState;
    }
    
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getSchoolYearId() {
		return schoolYearId;
	}
	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public String getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getLeaveDayCount() {
		return leaveDayCount;
	}
	public void setLeaveDayCount(Integer leaveDayCount) {
		this.leaveDayCount = leaveDayCount;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public Integer getLeaveState() {
		return leaveState;
	}
	public void setLeaveState(Integer leaveState) {
		this.leaveState = leaveState;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getIsClassTeacher() {
		return isClassTeacher;
	}
	public void setIsClassTeacher(Integer isClassTeacher) {
		this.isClassTeacher = isClassTeacher;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
