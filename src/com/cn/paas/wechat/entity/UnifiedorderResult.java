package com.cn.paas.wechat.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.cn.common._Tool;
import com.cn.paas.wechat.utils.RandCharsUtil;

/**
 * 统一下单微信返回的参数组
 * @author adonis_1111@163.com
 * 2016-09-07
 */
public class UnifiedorderResult {
	private String appId;//商家在微信开放平台申请的应用APPID
	private String partnerId;//商户号
	private String prepayId;//预支付订单，微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	private String pack;// 扩展字段（固定值Sign=WXPay）
	private String noncestr;//随机字符串
	private String timestamp;// 时间戳，为 1970 年 1 月 1 日 00:00 到请求发起时间的秒数
	private String sign;//签名
	
	private String device_info;//设备号
	private String result_code;//错误码
	private String err_code;//错误代码
	private String err_code_des;//错误返回的信息描述
	private String trade_type;//调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP
	private String code_url;//trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	
	private String return_code;//返回状态码SUCCESS/FAIL此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	private String return_msg;//返回信息
	
	private SortedMap<Object,Object> secoSing;
	private Map<String, Object> wechatMap;
	
	public UnifiedorderResult() {
	}
	
	public UnifiedorderResult(String appId, String partnerId, String prepayId, String sign) {
		this.appId = _Tool.isEmpty(appId) ? "-1" : appId;
		this.partnerId = _Tool.isEmpty(partnerId) ? "-1" : partnerId;
		this.prepayId = _Tool.isEmpty(prepayId) ? "-1" : prepayId;
		this.pack = "Sign=WXPay";
		this.noncestr = RandCharsUtil.getRandomString(32).toLowerCase();
		this.timestamp = String.valueOf(System.currentTimeMillis()).subSequence(0, 10).toString();
		this.sign = _Tool.isEmpty(sign) ? "-1" : sign;
		this.setSecoSing();
		this.setWechatMap();
	}


	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getNoncestr() {
		return noncestr;
	}
	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public SortedMap<Object, Object> getSecoSing() {
		return secoSing;
	}
	public void setSecoSing() {
		secoSing = new TreeMap<Object,Object>();
		secoSing.put("appid", getAppId());
		secoSing.put("partnerid", getPartnerId());
		secoSing.put("prepayid", getPrepayId());
		secoSing.put("noncestr", getNoncestr());
		secoSing.put("timestamp", getTimestamp());
		secoSing.put("package", getPack());
	}
	public void setSecoSing(SortedMap<Object, Object> secoSing) {
		this.secoSing = secoSing;
	}

	public Map<String, Object> getWechatMap() {
		return wechatMap;
	}

	public void setWechatMap(Map<String, Object> wechatMap) {
		this.wechatMap = wechatMap;
	}

	public void setWechatMap() {
		wechatMap = new HashMap<String, Object>();
		wechatMap.put("appId", getAppId());
		wechatMap.put("partnerId", getPartnerId());
		wechatMap.put("prepayId", getPrepayId());
		wechatMap.put("pack", getPack());
		wechatMap.put("noncestr", getNoncestr());
		wechatMap.put("timestamp", getTimestamp());
	}
	
}
