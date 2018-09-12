package com.cn.paas.wechat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.cn.paas.wechat.entity.Unifiedorder;

/**
 * post提交xml格式的参数
 * @author adonis_1111@163.com
 * 2016-09-07
 */
public class HttpXmlUtil {

	/**
	 * 开始post提交参数到接口
	 * 并接受返回
	 * @param url
	 * @param xml
	 * @param method
	 * @param contentType
	 * @return
	 */
	public static String xmlHttpProxy(String url,String xml,String method,String contentType){
		InputStream is = null;
		OutputStreamWriter os = null;

		try {
			URL _url = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
			conn.setDoInput(true);   
			conn.setDoOutput(true);   
			conn.setRequestProperty("Content-type", "text/xml");
			conn.setRequestProperty("Pragma:", "no-cache");  
			conn.setRequestProperty("Cache-Control", "no-cache");  
			conn.setRequestMethod("POST");
			os = new OutputStreamWriter(conn.getOutputStream());
			os.write(new String(xml.getBytes(contentType)));
			os.flush();

			//返回值
			is = conn.getInputStream();
			return getContent(is, "utf-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(os!=null){os.close();}
				if(is!=null){is.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 解析返回的值
	 * @param is
	 * @param charset
	 * @return
	 */
	public static String getContent(InputStream is, String charset) {
		String pageString = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			pageString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null){
					is.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb = null;
		}
		return pageString;
	}

	/**
	 * 构造xml参数
	 * @param xml
	 * @return
	 */
	public static String xmlInfo(Unifiedorder payWechat){
		if(payWechat!=null){
			StringBuffer bf = new StringBuffer();
			bf.append("<xml>");

			bf.append("<appid><![CDATA[");
			bf.append(payWechat.getApp_id());
			bf.append("]]></appid>");

			bf.append("<mch_id><![CDATA[");
			bf.append(payWechat.getPartner_id());
			bf.append("]]></mch_id>");

			bf.append("<nonce_str><![CDATA[");
			bf.append(payWechat.getNonce_str());
			bf.append("]]></nonce_str>");

			bf.append("<sign><![CDATA[");
			bf.append(payWechat.getSign());
			bf.append("]]></sign>");

			bf.append("<body><![CDATA[");
			bf.append(payWechat.getBody());
			bf.append("]]></body>");

			bf.append("<detail><![CDATA[");
			bf.append(payWechat.getDetail());
			bf.append("]]></detail>");

			bf.append("<attach><![CDATA[");
			bf.append(payWechat.getAttach());
			bf.append("]]></attach>");

			bf.append("<out_trade_no><![CDATA[");
			bf.append(payWechat.getOut_trade_no());
			bf.append("]]></out_trade_no>");

			bf.append("<total_fee><![CDATA[");
			bf.append(payWechat.getTotal_fee());
			bf.append("]]></total_fee>");

			bf.append("<spbill_create_ip><![CDATA[");
			bf.append(payWechat.getSpbill_create_ip());
			bf.append("]]></spbill_create_ip>");

			bf.append("<time_start><![CDATA[");
			bf.append(payWechat.getTime_start());
			bf.append("]]></time_start>");

			bf.append("<time_expire><![CDATA[");
			bf.append(payWechat.getTime_expire());
			bf.append("]]></time_expire>");

			bf.append("<notify_url><![CDATA[");
			bf.append(payWechat.getNotify_url());
			bf.append("]]></notify_url>");

			bf.append("<trade_type><![CDATA[");
			bf.append(payWechat.getTrade_type());
			bf.append("]]></trade_type>");


			bf.append("</xml>");
			return bf.toString();
		}
		return "";
	}



	/**
	 * 构造企业付款xml参数
	 * @param xml
	 * @return
	 */
	public static String xmlEnterpriseInfo(Unifiedorder payWechat){
		if(payWechat!=null){
			StringBuffer bf = new StringBuffer();
			bf.append("<xml>");

			bf.append("<mch_appid><![CDATA[");
			bf.append(payWechat.getApp_id());
			bf.append("]]></mch_appid>");

			bf.append("<mchid><![CDATA[");
			bf.append(payWechat.getPartner_id());
			bf.append("]]></mchid>");

			bf.append("<nonce_str><![CDATA[");
			bf.append(payWechat.getNonce_str());
			bf.append("]]></nonce_str>");

			bf.append("<partner_trade_no><![CDATA[");
			bf.append(payWechat.getOut_trade_no());
			bf.append("]]></partner_trade_no>");

			bf.append("<openid><![CDATA[");
			bf.append(payWechat.getOpenid());
			bf.append("]]></openid>");

			bf.append("<check_name><![CDATA[");
			bf.append(payWechat.getCheck_name());
			bf.append("]]></check_name>");

			/*bf.append("<re_user_name><![CDATA[");
			bf.append(payWechat.getRe_user_name());
			bf.append("]]></re_user_name>");*/

			bf.append("<amount><![CDATA[");
			bf.append(payWechat.getTotal_fee());
			bf.append("]]></amount>");

			bf.append("<desc><![CDATA[");
			bf.append(payWechat.getBody());
			bf.append("]]></desc>");

			bf.append("<spbill_create_ip><![CDATA[");
			bf.append(payWechat.getSpbill_create_ip());
			bf.append("]]></spbill_create_ip>");

			bf.append("<sign><![CDATA[");
			bf.append(payWechat.getSign());
			bf.append("]]></sign>");
			
			bf.append("</xml>");
			return bf.toString();
		}
		return "";
	}
	
	
	/**
	 * post请求并得到返回结果
	 * @param requestUrl
	 * @param requestMethod
	 * @param output
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String requestMethod, String output) {
		try{
			URL url = new URL(requestUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(requestMethod);
			if (null != output) {
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(output.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			connection.disconnect();
			return buffer.toString();
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return "";
	}

	/** 
     * 回调后将结果返回给微信 
     * @param return_code 
     * @param return_msg 
     * @return 
     */  
    public static String backWeixin(String return_code,String return_msg){  
        try{  
            StringBuffer bf = new StringBuffer();
            bf.append("<xml>");
            
            bf.append("<return_code><![CDATA[");
            bf.append(return_code);
            bf.append("]]></return_code>");
            
            if(!return_msg.equals("OK")){
                bf.append("<return_msg><![CDATA[");
                bf.append(return_msg);
                bf.append("]]></return_msg>");
            }
            
            bf.append("</xml>");
            return bf.toString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }  

}
