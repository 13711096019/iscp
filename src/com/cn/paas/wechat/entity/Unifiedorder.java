package com.cn.paas.wechat.entity;

import java.util.SortedMap;
import java.util.TreeMap;

import com.cn.paas.wechat.utils.RandCharsUtil;
import com.cn.paas.wechat.utils.WeixinConfigUtil;

/**
 * 微信预支付 统一下单提交给微信的参数
 * @author adonis_1111@163.com
 * 2016-09-07
 */
public class Unifiedorder {
	// 应用唯一标识，在微信开放平台提交应用审核通过后获得
	private String key;
	// 应用ID(微信开放平台审核通过的应用APPID)
	private String app_id;
	// 商户号(微信支付分配的商户号)
	private String partner_id;
	// (-1)设备号(终端设备号"门店号或收银设备ID"，默认请传"WEB")
	private String device_info;
	// 随机字符串(随机字符串，不长于32位)
	private String nonce_str;
	// 签名
	private String sign;
	// 商品描述(APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值)
	private String body;
	// (-1)商品详情(商品名称明细列表)
	private String detail;
	// (-1)附加数据(附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据)
	private String attach;
	// 商户订单号(商户系统内部的订单号,32个字符内、可包含字母)
	private String out_trade_no;
	// (-1)货币类型(符合ISO 4217标准的三位字母代码，默认人民币：CNY)
	private String fee_type;
	// 总金额(订单总金额，单位为分)
	private int total_fee;
	// 终端IP(用户端实际ip)
	private String spbill_create_ip;
	// (-1)交易起始时间(订单生成时间，格式为yyyyMMddHHmmss)
	private String time_start;
	// (-1)交易结束时间(订单失效时间，格式为yyyyMMddHHmmss)
	private String time_expire;
	// (-1)商品标记(商品标记，代金券或立减优惠功能的参数)
	private String goods_tag;
	// 通知地址(接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数)
	private String notify_url;
	// 交易类型(支付类型:JSAPI，NATIVE，APP，H5:MWEB)
	private String trade_type;
	// 商品ID
	private String product_id;
	// (-1)指定支付方式(no_credit--指定不能使用信用卡支付)
	private String limit_pay;
	// (-1)trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
	private String openid;
	// 校验用户姓名选项,NO_CHECK：不校验真实姓名,FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
	//OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
	private String check_name;
	// 收款用户姓名
	private String re_user_name;
	// 预支付签名参数
	SortedMap<Object,Object> bindingPrePay;
	// 预支付签名参数
	SortedMap<Object,Object> bindingEnterprisePrePay;
	
	public Unifiedorder(){};
	
	/**
	 * 统一下单
	 * @param body 商品描述
	 * @param total_fee 总金额
	 * @param outTradeNo 商户订单号
	 */
	@SuppressWarnings("static-access")
	public Unifiedorder(String body, int total_fee, String outTradeNo) {
		WeixinConfigUtil config = new WeixinConfigUtil();
		this.key = config.key;
		this.app_id = config.appid;
		this.partner_id = config.mch_id;
		this.spbill_create_ip = config.terminal_ip;
		this.notify_url = config.notify_url;
		
		this.nonce_str = RandCharsUtil.getRandomString(16);
		this.body = body;
		this.detail = body;
		this.attach = body;
		this.out_trade_no = outTradeNo;
		this.total_fee = total_fee;
		this.time_start = RandCharsUtil.timeStart();
		this.time_expire = RandCharsUtil.timeExpire();
		this.trade_type = "APP";
		this.product_id = RandCharsUtil.getRandomString(16);
		this.setBindingPrePay();
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public SortedMap<Object, Object> getBindingPrePay() {
		return bindingPrePay;
	}
	public void setBindingPrePay() {
		this.bindingPrePay = new TreeMap<Object,Object>();
		bindingPrePay.put("appid", getApp_id());
		bindingPrePay.put("mch_id", getPartner_id());
		bindingPrePay.put("nonce_str", getNonce_str());
		bindingPrePay.put("body", getBody());
		bindingPrePay.put("detail", getDetail());
		bindingPrePay.put("attach", getAttach());
		bindingPrePay.put("out_trade_no", getOut_trade_no());
		bindingPrePay.put("total_fee", getTotal_fee());
		bindingPrePay.put("time_start", getTime_start());
		bindingPrePay.put("time_expire", getTime_expire());
		bindingPrePay.put("notify_url", getNotify_url());
		bindingPrePay.put("trade_type", getTrade_type());
		bindingPrePay.put("spbill_create_ip", getSpbill_create_ip());
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getRe_user_name() {
		return re_user_name;
	}
	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}
	public SortedMap<Object, Object> getBindingEnterprisePrePay() {
		return bindingEnterprisePrePay;
	}
	public void setBindingEnterprisePrePay() {
		this.bindingEnterprisePrePay = new TreeMap<Object,Object>();
		bindingEnterprisePrePay.put("mch_appid", getApp_id());
		bindingEnterprisePrePay.put("mchid", getPartner_id());
		bindingEnterprisePrePay.put("nonce_str", getNonce_str());
		bindingEnterprisePrePay.put("partner_trade_no", getOut_trade_no());
		bindingEnterprisePrePay.put("openid", getOpenid());
		bindingEnterprisePrePay.put("check_name", getCheck_name());
		//bindingEnterprisePrePay.put("re_user_name", getRe_user_name());
		bindingEnterprisePrePay.put("amount", getTotal_fee());
		bindingEnterprisePrePay.put("desc", getBody());
		bindingEnterprisePrePay.put("spbill_create_ip", getSpbill_create_ip());
	}
	
}
