package com.cn.iscp.entity.attend;

/**
 * 老师请假记录
 * @author 10011037@qq.com
 * 2018-07-04
 */
public class TeacherLeaveRecord {
	
	
	/** 请假状态-0已拒绝 */
	public static final int STATE_REFUSE = 0;
	/** 请假状态-1已通过 */
	public static final int STATE_ADOPT = 1;
	/** 请假状态-2待审核 */
	public static final int STATE_CHECK = 2;
	
	/** 审核方式-1初级审批 */
	public static final int WAY_INITIAL = 1;
	/** 审核方式-2高级审批 */
	public static final int WAY_SENIOR = 2;
	
	// 自增编号
    private Long leaveId;
	// 学年编号
    private Long schoolYearId;
	// 学年度编号
    private Long termId;
	// 老师编号
    private Long teacherId;
	// 请假老师最高角色编号
    private Long maxRoleId;
	// 审核方式（1初级审批，2高级审批）
    private Integer checkWay;
	// 请假开始日期
    private String leaveStartDate;
	// 请假截止日期
    private String leaveEndDate;
	// 创建时间
    private String createTime;
	// 请假天数(半天算0)
    private Integer leaveDayCount;
	// 请假小时数(不包含天数的小时)
    private Integer leaveHourCount;
	// 请假原因
    private String leaveReason;
	// 请假状态（0已拒绝，1已通过，2待审核）
    private Integer leaveState;
    // 状态 1=有效，0=无效
    private Integer status;
    
	// 老师姓名
    private String teacherName;
	// 老师头像
    private String headPortrait;
	// 老师最高角色
    private String roleName;
	// 分页查询-第几页
    private Integer pageCount;
	// 审核人姓名
    private String auditorName;
	// 审核描述内容
    private String checkContent;
	// 审核时间
    private String checkTime;
    //年度
    private String year;
    //学期
    private String termName;
	// 时间范围
    private String timeFrame;
    // 审批结果状态审批状态（1通过，2拒绝）
    private Integer checkState;
    
    public TeacherLeaveRecord(){};

    /**
     * 查询
     */
    public TeacherLeaveRecord(Long teacherId, Integer pageCount, String leaveStartDate, String leaveEndDate){
    	this.teacherId = teacherId;
    	this.pageCount = pageCount;
    	this.leaveStartDate = leaveStartDate;
    	this.leaveEndDate = leaveEndDate;
    }
    
    /**
     * 新增
     */
    public TeacherLeaveRecord(Long leaveId, Long teacherId, String leaveStartDate, 
    		String leaveEndDate, Integer leaveDayCount, 
    		Integer leaveHourCount, String leaveReason){
    	this.leaveId = leaveId;
    	this.teacherId = teacherId;
    	this.leaveStartDate = leaveStartDate;
    	this.leaveEndDate = leaveEndDate;
    	this.leaveDayCount = leaveDayCount;
    	this.leaveHourCount = leaveHourCount;
    	this.leaveReason = leaveReason;
    }
    
    /**
     * 请假申请审核
     * @param leaveId 请假记录编号
     * @param auditorId 审核人
     * @param leaveState 是否同意(1同意，2拒绝)
     * @param content 审批内容
     */
    public TeacherLeaveRecord(Long leaveId, Long auditorId, Integer leaveState, String content){
    	this.leaveId = leaveId;
    	this.teacherId = auditorId;
    	this.leaveState = leaveState;
    	this.leaveReason = content;
    }
    
    /**
     * 删除
     * @param leaveId 请假记录编号
     * @param teacherId 登录人编号
     */
    public TeacherLeaveRecord(Long leaveId, Long loginUserId){
    	this.leaveId = leaveId;
    	this.teacherId = loginUserId;
    }
    
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
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
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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
	public Integer getLeaveState() {
		return leaveState;
	}
	public void setLeaveState(Integer leaveState) {
		this.leaveState = leaveState;
	}
	public Integer getCheckWay() {
		return checkWay;
	}
	public void setCheckWay(Integer checkWay) {
		this.checkWay = checkWay;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Long getMaxRoleId() {
		return maxRoleId;
	}
	public void setMaxRoleId(Long maxRoleId) {
		this.maxRoleId = maxRoleId;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public String getCheckContent() {
		return checkContent;
	}
	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public Integer getLeaveHourCount() {
		return leaveHourCount;
	}
	public void setLeaveHourCount(Integer leaveHourCount) {
		this.leaveHourCount = leaveHourCount;
	}
	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	public Integer getCheckState() {
		return checkState;
	}
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
