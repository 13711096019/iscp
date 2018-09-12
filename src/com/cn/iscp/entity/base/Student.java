package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 学生对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class Student extends BasisModel{
	// 状态：0删除,1班级学生,-1已毕业,-2一年级新生,-3新转入学生,-4转出学生
	
	// 自增编号
    private Long studentId;
	// 8位学号
    private String studentNo;
	// 班级学号
    private String studentNum;
	// 姓名
    private String studentName;
	// 性别(1男,2女)
    private Integer sexId;
	// 出生日期
    private String birthday;
	// 身份证号
    private String idCard;
	// 入学身高（cm）
    private Double startHeight;
	// 入学体重（kg）
    private Double startWeight;
	// 班主体编号
    private Integer classEntityId;
	// 居住地址
    private String liveAddress;
	// 备注
    private String note;
	// 学生头像
    private String headPortrait;
	// 考勤卡编号（逻辑编号）
    private String studentCard;
	// 考勤卡编号（物理卡号，依靠读卡器）
    private String studentCardPhy;
	// 定位卡编号（逻辑编号）【可同 studentCard 字段值】
    private String studentCardGPS;
	// 定位卡编号（物理卡号，依靠读卡器）
    private String studentCardGPSPhy;
	// 入学日期
    private String admissionDate;
	// 民族
    private String nation;
	// 籍贯（省市县）
    private String nativePlace;
	// 联系电话，可多个
    private String contactNumber;
    
	// 用户唯一标识
    private String userKey;
	// 年级名称
    private String gradeName;
	// 班级名称
    private String className;
	// 留宿状态(1学校留宿,2非学校留宿)
    private Integer isOnSchool;
	// 是否校车接送(1家长接送,2校车接送)
    private Integer shuttleMode;
	// 动态班级编号
    private Long classNum;
    // 家长手机号码
    private String logAccount;
    // 家长手机密码
    private String logPassword;
    //学生编号集合
    private String studentIds;
	// 缴费工单编号
    private Long orderId;
	// 是否已经缴学费
    private Integer isPay;
    //已缴学杂费
    private String tuitionPrice;
    //已缴早餐费
    private String breakfastPrice;
    //已缴午餐费
    private String lunchPrice;
    //已缴通讯费
    private String communicationPrice;
    //已缴校服费
    private String uniformPrice;
    //已缴校车费
    private String sitePrice;
    //监护人姓名
    private String guardianName;
    //身高（cm）
    private String stature;
    //接送站点
    private String siteName;
    //年级编号
    private Integer gradeId;
    //是否绑定入学时间
    private Integer hasAdmissionDate;
    //是否新生
    private Integer isNewborn;

    /**
     * 无参构造函数
     */
	public Student(){};
	
	/**
     * 删除
     */
	public Student(Long studentId){
		super(_Const.STATE_ERROR);
    	this.studentId = studentId;
	}
	/**
	 * 绑定家长手机号码
	 */
	public Student(String studentIds){
    	this.studentIds = studentIds;
    }
	
	/**
     * 新增
     */
	public void setpayInsert() {
    	this.flagtime = System.currentTimeMillis();
	}
	
	/**
	 * 更新时间戳
	 */
	public Student(Long studentId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.studentId = studentId;
	}
    
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = _Tool.toStr(studentName);
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public String getBirthday() {
		return birthday;
	}
	
	public String getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(String studentIds) {
		this.studentIds = studentIds;
	}

	public String getLogAccount() {
		return logAccount;
	}

	public void setLogAccount(String logAccount) {
		this.logAccount = logAccount;
	}

	public void setBirthday(String birthday) {
		this.birthday = _Tool.toStr(birthday);
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = _Tool.toStr(idCard);
	}
	public Double getStartHeight() {
		return startHeight;
	}
	public void setStartHeight(Double startHeight) {
		this.startHeight = startHeight;
	}
	public Double getStartWeight() {
		return startWeight;
	}
	public void setStartWeight(Double startWeight) {
		this.startWeight = startWeight;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = _Tool.toStr(studentNo);
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = _Tool.toStr(liveAddress);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = _Tool.toStr(note);
	}
	public Integer getClassEntityId() {
		return classEntityId;
	}
	public void setClassEntityId(Integer classEntityId) {
		this.classEntityId = classEntityId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = _Tool.toStr(className);
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = _Tool.toStr(headPortrait);
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = _Tool.toStr(studentNum);
	}
	public Integer getIsOnSchool() {
		return isOnSchool;
	}
	public void setIsOnSchool(Integer isOnSchool) {
		this.isOnSchool = isOnSchool;
	}
	public Integer getShuttleMode() {
		return shuttleMode;
	}
	public void setShuttleMode(Integer shuttleMode) {
		this.shuttleMode = shuttleMode;
	}
	
	public String getStudentCard() {
		return studentCard;
	}
	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}
	public String getStudentCardPhy() {
		return studentCardPhy;
	}
	public void setStudentCardPhy(String studentCardPhy) {
		this.studentCardPhy = studentCardPhy;
	}
	public String getStudentCardGPS() {
		return studentCardGPS;
	}
	public void setStudentCardGPS(String studentCardGPS) {
		this.studentCardGPS = studentCardGPS;
	}
	public String getStudentCardGPSPhy() {
		return studentCardGPSPhy;
	}
	public void setStudentCardGPSPhy(String studentCardGPSPhy) {
		this.studentCardGPSPhy = studentCardGPSPhy;
	}
	public Long getClassNum() {
		return classNum;
	}
	public void setClassNum(Long classNum) {
		this.classNum = classNum;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getLogPassword() {
		return logPassword;
	}
	public void setLogPassword(String logPassword) {
		this.logPassword = logPassword;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public String getTuitionPrice() {
		return tuitionPrice;
	}
	public void setTuitionPrice(String tuitionPrice) {
		this.tuitionPrice = tuitionPrice;
	}
	public String getBreakfastPrice() {
		return breakfastPrice;
	}
	public void setBreakfastPrice(String breakfastPrice) {
		this.breakfastPrice = breakfastPrice;
	}
	public String getLunchPrice() {
		return lunchPrice;
	}
	public void setLunchPrice(String lunchPrice) {
		this.lunchPrice = lunchPrice;
	}
	public String getCommunicationPrice() {
		return communicationPrice;
	}
	public void setCommunicationPrice(String communicationPrice) {
		this.communicationPrice = communicationPrice;
	}
	public String getUniformPrice() {
		return uniformPrice;
	}
	public void setUniformPrice(String uniformPrice) {
		this.uniformPrice = uniformPrice;
	}
	public String getSitePrice() {
		return sitePrice;
	}
	public void setSitePrice(String sitePrice) {
		this.sitePrice = sitePrice;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getStature() {
		return stature;
	}
	public void setStature(String stature) {
		this.stature = stature;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Integer getHasAdmissionDate() {
		return hasAdmissionDate;
	}
	public void setHasAdmissionDate(Integer hasAdmissionDate) {
		this.hasAdmissionDate = hasAdmissionDate;
	}
	public Integer getIsNewborn() {
		return isNewborn;
	}
	public void setIsNewborn(Integer isNewborn) {
		this.isNewborn = isNewborn;
	}
	
}