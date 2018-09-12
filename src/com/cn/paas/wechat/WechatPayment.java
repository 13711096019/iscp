package com.cn.paas.wechat;

import java.util.Map;

import org.apache.log4j.Logger;

import com.cn.common._Tool;
import com.cn.paas.wechat.entity.Unifiedorder;
import com.cn.paas.wechat.entity.UnifiedorderResult;
import com.cn.paas.wechat.utils.HttpXmlUtil;
import com.cn.paas.wechat.utils.JdomParseXmlUtil;
import com.cn.paas.wechat.utils.WXSignUtil;

public class WechatPayment {
	
	private static Logger log = Logger.getLogger(WechatPayment.class);

	// 总金额
	private Double rechargeMoney;
	// 商户订单号
	private String orderNo;
	// 商品描述
	private String body;
	
	public WechatPayment(Double rechargeMoney, String orderNo, String body) {
		this.rechargeMoney = rechargeMoney;
		this.orderNo = orderNo;
		this.body = body;
	}

	public Map<String, Object> wechatPayment(){
		// 元转换为分
		int money = (int) (getRechargeMoney() * 100);
		
		if(money <= 0){
			return null;
		}
		
		// 1.初始化参数
		Unifiedorder unifiedorder = new Unifiedorder(getBody(), money, getOrderNo());
		
		// 2.生成预支付签名
		String sign = WXSignUtil.createSign(unifiedorder.getKey(), unifiedorder.getBindingPrePay());
		unifiedorder.setSign(sign);
		
		// 4.构造xml参数
		String xmlInfo = HttpXmlUtil.xmlInfo(unifiedorder);
		String wxUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		// 5.开始请求
		String weixinPost = HttpXmlUtil.httpsRequest(wxUrl, "POST", xmlInfo).toString();
		System.out.println(weixinPost);
		log.info("--------------------微信返回参数--------------------");
		log.info(weixinPost);
		log.info("--------------------微信返回参数--------------------");
		
		if(_Tool.isEmpty(weixinPost)){
			return null;
		}

		// 整理预支付返回的参数
		UnifiedorderResult prePayment = JdomParseXmlUtil.getUnifiedorderResult(weixinPost);
		if(prePayment == null){
			return null;
		}
		// 6.生成二次签名
		String newSign = WXSignUtil.createSign(unifiedorder.getKey(), prePayment.getSecoSing());
		
		Map<String, Object> wechatMap = prePayment.getWechatMap();
		wechatMap.put("sign", newSign);
		return wechatMap;
	}

	public Double getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(Double rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
