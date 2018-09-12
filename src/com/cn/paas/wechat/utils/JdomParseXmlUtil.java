package com.cn.paas.wechat.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.cn.common._Tool;
import com.cn.paas.wechat.entity.UnifiedorderResult;
import com.cn.paas.wechat.entity.WXPayResult;

/**
 * 微信解析xml(带CDATA格式)
 * @author adonis_1111@163.com
 * 2016-09-07
 */
public class JdomParseXmlUtil {
	
	/**
	 * 1、统一下单获取微信返回
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static UnifiedorderResult getUnifiedorderResult(String xml){
		UnifiedorderResult unifieorderResult = null;
		try {
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc;
			doc = (Document) sb.build(source);

			Element root = doc.getRootElement();// 指向根节点
			List<Element> list = root.getChildren();

			if(list!=null&&list.size()>0){
				String appId = null; 
				String partnerId = null; 
				String prepayId = null; 
				String sign = null; 
				for (Element element : list) {
					String keyName = element.getName();
					String value = element.getText();
					if("appid".equals(keyName)){
						appId = value;
					}
					if("mch_id".equals(keyName)){
						partnerId = value;
					}
					if("prepay_id".equals(keyName)){
						prepayId = value;
					}
					if("sign".equals(keyName)){
						sign = value;
					}
					/*if("return_code".equals(element.getName())){
						unifieorderResult.setReturn_code(element.getText());
					}
					if("return_msg".equals(element.getName())){
						unifieorderResult.setReturn_msg(element.getText());
					}
					if("sign".equals(element.getName())){
						unifieorderResult.setSign(element.getText());
					}
					if("result_code".equals(element.getName())){
						unifieorderResult.setResult_code(element.getText());
					}
					if("trade_type".equals(element.getName())){
						unifieorderResult.setTrade_type(element.getText());
					}*/
				}
				unifieorderResult = new UnifiedorderResult(appId, partnerId, prepayId, sign);
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return unifieorderResult;
	}
	
	
	/**
	 * 2、微信回调后参数解析
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static WXPayResult getWXPayResult(String xml){
		WXPayResult wXPayResult = new WXPayResult();
		try { 
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc;
			doc = (Document) sb.build(source);

			Element root = doc.getRootElement();// 指向根节点
			List<Element> list = root.getChildren();

			if(list!=null&&list.size()>0){
				for (Element element : list) {
					String keyName = element.getName();
					String value = element.getText();
					if("return_code".equals(keyName)){
						wXPayResult.setReturn_code(value);
					}
					if("return_msg".equals(keyName)){
						wXPayResult.setReturn_msg(value);
					}
					if("appid".equals(keyName)){
						wXPayResult.setAppid(value);
					}
					if("attach".equals(keyName)){
						wXPayResult.setAttach(value);
					}
					if("bank_type".equals(keyName)){
						wXPayResult.setBank_type(value);
					}
					if("cash_fee".equals(keyName) && _Tool.isInt(value)){
						wXPayResult.setCash_fee(Integer.parseInt(value));
					}
					if("fee_type".equals(keyName)){
						wXPayResult.setFee_type(value);
					}
					if("is_subscribe".equals(keyName)){
						wXPayResult.setIs_subscribe(value);
					}
					if("mch_id".equals(keyName)){
						wXPayResult.setMch_id(value);
					}
					if("nonce_str".equals(keyName)){
						wXPayResult.setNonce_str(value);
					}
					if("openid".equals(keyName)){
						wXPayResult.setOpenid(value);
					}
					if("out_trade_no".equals(keyName)){
						wXPayResult.setOut_trade_no(value);
					}
					if("result_code".equals(keyName)){
						wXPayResult.setResult_code(value);
					}
					if("err_code_des".equals(keyName)){
						wXPayResult.setErr_code_des(value);
					}
					if("time_end".equals(keyName)){
						wXPayResult.setTime_end(value);
					}
					if("total_fee".equals(keyName) && _Tool.isInt(value)){
						wXPayResult.setTotal_fee(Integer.parseInt(value));
					}
					if("trade_type".equals(keyName)){
						wXPayResult.setTrade_type(value);
					}
					if("transaction_id".equals(keyName)){
						wXPayResult.setTransaction_id(value);
					}
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return wXPayResult;
	}

	/**
	 * 3、企业付款返回参数解析
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static WXPayResult getEnterpriseResult(String xml){
		WXPayResult wXPayResult = new WXPayResult();
		try { 
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc;
			doc = (Document) sb.build(source);

			Element root = doc.getRootElement();// 指向根节点
			List<Element> list = root.getChildren();

			if(list!=null&&list.size()>0){
				for (Element element : list) {
					String keyName = element.getName();
					String value = element.getText();
					if("return_code".equals(keyName)){
						wXPayResult.setReturn_code(value);
					}
					if("result_code".equals(keyName)){
						wXPayResult.setResult_code(value);
					}
					if("partner_trade_no".equals(keyName)){
						wXPayResult.setOut_trade_no(value);
					}
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return wXPayResult;
	}
}
