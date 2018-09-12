package com.cn.iscp.entity.base;

import com.cn.common._Const;
import com.cn.common._Tool;
import com.cn.iscp.model.BasisModel;

/**
 * 学校信息对象
 * @author 10011037@qq.com
 * 2017-06-30
 */
public class School extends BasisModel{
	
	// 自增编号
    private Long schoolId;
	// 学校名称
    private String schoolName;
	// 学校地址
    private String schoolAddress;
	// 省份
    private String province;
	// 地市
    private String city;
	// 县区
    private String county;
	// 学校电话
    private String schoolTel;
	// 学校传真
    private String schoolFax;
	// 邮政编码
    private String postCode;
	// 联系人姓名
    private String contactMan;
	// 联系人电话
    private String contactMobile;
	// 电子邮箱
    private String email;
	// 营业执照号
    private String businessLicense;
	// 法人姓名
    private String rechargeMan;
	// 法人电话
    private String rechargeMobile;
	// 是公办（学校性质）
    private Integer isPublic;
	// 学校段级（小学、初中、高中、大学）
    private String schoolSection;
	// 备注
    private String note;
	
    /**
     * 无参构造函数
     */
	public School(){};
	
	/**
     * 删除
     */
	public School(Long schoolId){
		super(_Const.STATE_ERROR);
    	this.schoolId = schoolId;
	}
	
	/**
	 * 更新时间戳
	 */
	public School(Long schoolId, Long flagtime){
		super.flagtime = System.currentTimeMillis();
    	this.schoolId = schoolId;
	}
    
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
        this.schoolName = _Tool.toStr(schoolName);
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = _Tool.toStr(schoolAddress);
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
        this.province = _Tool.toStr(province);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
        this.city = _Tool.toStr(city);
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
        this.county = _Tool.toStr(county);
	}
	public String getSchoolTel() {
		return schoolTel;
	}
	public void setSchoolTel(String schoolTel) {
        this.schoolTel = _Tool.toStr(schoolTel);
	}
	public String getSchoolFax() {
		return schoolFax;
	}
	public void setSchoolFax(String schoolFax) {
        this.schoolFax = _Tool.toStr(schoolFax);
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
        this.postCode = _Tool.toStr(postCode);
	}
	public String getContactMan() {
		return contactMan;
	}
	public void setContactMan(String contactMan) {
        this.contactMan = _Tool.toStr(contactMan);
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
        this.contactMobile = _Tool.toStr(contactMobile);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
        this.email = _Tool.toStr(email);
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
        this.businessLicense = _Tool.toStr(businessLicense);
	}
	public String getRechargeMan() {
		return rechargeMan;
	}
	public void setRechargeMan(String rechargeMan) {
        this.rechargeMan = _Tool.toStr(rechargeMan);
	}
	public String getRechargeMobile() {
		return rechargeMobile;
	}
	public void setRechargeMobile(String rechargeMobile) {
        this.rechargeMobile = _Tool.toStr(rechargeMobile);
	}
	public Integer getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}
	public String getSchoolSection() {
		return schoolSection;
	}
	public void setSchoolSection(String schoolSection) {
        this.schoolSection = _Tool.toStr(schoolSection);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
        this.note = _Tool.toStr(note);
	}
	
}