package com.cn.paas.wechat.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * 微信支付签名生成类
 * @author adonis_1111@163.com
 * 2016-09-07
 */
public class WXSignUtil {
	//http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
	//商户Key：改成公司申请的即可
	//32位密码设置地址：http://www.sexauth.com/  jdex1hvufnm1sdcb0e81t36k0d0f15nc
	//private static String Key = "你们的Key";

	/**
	 * 微信支付签名算法sign
	 * @param characterEncoding
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(String key, SortedMap<Object,Object> parameters){
		StringBuffer sb = new StringBuffer();
		// 所有参与传递的参数按照accsii排序（升序）
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		// 拼接上key值
		sb.append("key=" + key);
		// MD5加密，转换大写
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;
	}

}
