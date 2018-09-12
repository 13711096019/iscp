package com.cn.unit.rsa.model;

/**
 * 前端加密前所需参数
 * @author 10011037@qq.com
 * 2018-03-09
 */
public class RsaModel {

	// 加密模
	private String modulus;
	// 公钥指数
	private String publicExponent;
	// sessionId
	private String sessionId;
	
	public RsaModel(){}
	
	public RsaModel(String modulus, String publicExponent, String sessionId){
		this.modulus = modulus;
		this.publicExponent = publicExponent;
		this.sessionId = sessionId;
	}
	
	public String getModulus() {
		return modulus;
	}
	public void setModulus(String modulus) {
		this.modulus = modulus;
	}
	public String getPublicExponent() {
		return publicExponent;
	}
	public void setPublicExponent(String publicExponent) {
		this.publicExponent = publicExponent;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
