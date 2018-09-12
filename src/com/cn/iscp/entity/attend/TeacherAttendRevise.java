package com.cn.iscp.entity.attend;

/**
 * 补卡申请记录表
 * @author 10011037@qq.com
 * 2018-08-20
 */
public class TeacherAttendRevise {
	
	// 自增编号
    private Long reviseId;
	// 打卡记录编号
    private Long recordId;
	// 打卡日期
    private String attendDate;
	// 打卡时间
    private String attendTime;
	// 补卡原因
    private String reviseCause;
	// 申请人编号
    private Long reviseUserId;
	// 审批人编号
    private Long checkUserId;
	// 审批意见
    private String checkView;
	// 审批状态（1审批同意，2审批不同意，3待审批）
    private Integer checkState;
	// 审批时间
    private String checkTime;
	// 补卡申请时间
    private String createTime;
    
	// 审核老师姓名
    private String checkUserName;
	// 申请老师姓名
    private String reviseUserName;
	// 页数
    private Integer pageCount;
    
    
    public TeacherAttendRevise(){};
    
    /**
     * 分页查询
     */
    public TeacherAttendRevise(Integer checkState, Integer pageCount){
    	this.checkState = checkState;
    	this.pageCount = pageCount;
    }
    
    /**
     * 新增
     */
    public TeacherAttendRevise(Long recordId, String attendDate, 
    		String attendTime, String reviseCause){
    	this.recordId = recordId;
    	this.attendDate = attendDate;
    	this.attendTime = attendTime;
    	this.reviseCause = reviseCause;
    }
    
    /**
     * 审批
     */
    public TeacherAttendRevise(Long recordId, Long checkUserId, 
    		String checkView, Integer checkState){
    	this.recordId = recordId;
    	this.checkUserId = checkUserId;
    	this.checkView = checkView;
    	this.checkState = checkState;
    }

	public Long getReviseId() {
		return reviseId;
	}
	public void setReviseId(Long reviseId) {
		this.reviseId = reviseId;
	}
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public String getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(String attendTime) {
		this.attendTime = attendTime;
	}
	public String getReviseCause() {
		return reviseCause;
	}
	public void setReviseCause(String reviseCause) {
		this.reviseCause = reviseCause;
	}
	public Long getCheckUserId() {
		return checkUserId;
	}
	public void setCheckUserId(Long checkUserId) {
		this.checkUserId = checkUserId;
	}
	public String getCheckView() {
		return checkView;
	}
	public void setCheckView(String checkView) {
		this.checkView = checkView;
	}
	public Integer getCheckState() {
		return checkState;
	}
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckUserName() {
		return checkUserName;
	}
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	public String getReviseUserName() {
		return reviseUserName;
	}
	public void setReviseUserName(String reviseUserName) {
		this.reviseUserName = reviseUserName;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Long getReviseUserId() {
		return reviseUserId;
	}
	public void setReviseUserId(Long reviseUserId) {
		this.reviseUserId = reviseUserId;
	}
    
}
