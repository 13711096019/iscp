package com.cn.iscp.entity.attend;

/**
 * 学生上学放学统计
 * @author 10011037@qq.com
 * 2018-06-08
 */
public class BusSplitCensus {
	
	// 自增编号
    private Long splitId;
	// 动态班级编号
    private Long classNum;
	// 学生编号
    private Long studentId;
	// 考勤日期
    private String attendDate;
	// 上学-出发时间
    private String startTimeSchool;
	// 上学-到校时间
    private String leaveTimeSchool;
	// 上学状态（1=准时，2=迟到，3=未知）
    private Integer attendStateSchool;
	// 放学-出发时间
    private String startTimeGohome;
	// 放学-到家时间
    private String leaveTimeGohome;
	// 放学状态（1=准时，2=迟到，3=未知）
    private Integer attendStateGohome;

	// 用户Key
    private String userKey;
	// 用户姓名
    private String userName;
    
	public Long getSplitId() {
		return splitId;
	}
	public void setSplitId(Long splitId) {
		this.splitId = splitId;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public String getStartTimeSchool() {
		return startTimeSchool;
	}
	public void setStartTimeSchool(String startTimeSchool) {
		this.startTimeSchool = startTimeSchool;
	}
	public String getLeaveTimeSchool() {
		return leaveTimeSchool;
	}
	public void setLeaveTimeSchool(String leaveTimeSchool) {
		this.leaveTimeSchool = leaveTimeSchool;
	}
	public Integer getAttendStateSchool() {
		return attendStateSchool;
	}
	public void setAttendStateSchool(Integer attendStateSchool) {
		this.attendStateSchool = attendStateSchool;
	}
	public String getStartTimeGohome() {
		return startTimeGohome;
	}
	public void setStartTimeGohome(String startTimeGohome) {
		this.startTimeGohome = startTimeGohome;
	}
	public String getLeaveTimeGohome() {
		return leaveTimeGohome;
	}
	public void setLeaveTimeGohome(String leaveTimeGohome) {
		this.leaveTimeGohome = leaveTimeGohome;
	}
	public Integer getAttendStateGohome() {
		return attendStateGohome;
	}
	public void setAttendStateGohome(Integer attendStateGohome) {
		this.attendStateGohome = attendStateGohome;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPushContent(Integer attendType){
    	// 考勤类型（1上学上车，2上学下车，3放学上车，4放学下车）
    	if(attendType.intValue()==1){
    		return "上学啦，您的孩子%s已经登上校车！";
    	}else if(attendType.intValue()==2){
    		return "上学啦，您的孩子%s已经到达学校！";
    	}else if(attendType.intValue()==3){
    		return "放学啦，您的孩子%s已经启程回家！";
    	}else if(attendType.intValue()==4){
    		return "放学啦，您的孩子%s已经到达站点！";
    	}
    	return "";
    }
    
}
