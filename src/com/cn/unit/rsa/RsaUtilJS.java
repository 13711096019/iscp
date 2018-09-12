package com.cn.unit.rsa;

import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.Cipher;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cn.common._Tool;

/**
 * 网页加密工具类
 * @author Adonis_1111@163.com
 * 2016-09-01
 */
public class RsaUtilJS {
	
	private static final Logger log = LoggerFactory.getLogger(RsaUtilJS.class);

    /** 算法名称 */
    private static final String ALGORITHOM = "RSA";
    /** 密钥大小 */
    private static final int KEY_SIZE = 1024;
    /** 默认的安全服务提供者 */
    private static final Provider DEFAULT_PROVIDER = new BouncyCastleProvider();
    /** 缓存的密钥对。 */
    private static KeyPair oneKeyPair = null;
    

	public static void main(String[] args) {
		HashMap<String, Object> map = getDefaultPublicKey();
		if(map == null){
			return;
		}
		 //生成公钥和私钥  
	    RSAPublicKey publicKey = (RSAPublicKey) map.get("publicKey");  
	    RSAPrivateKey privateKey = (RSAPrivateKey) map.get("privateKey");  
	    
	    //模  
	    String modulus = publicKey.getModulus().toString();  
	    //公钥指数  
	    String public_exponent = publicKey.getPublicExponent().toString();  
	    //私钥指数  
	    String private_exponent = privateKey.getPrivateExponent().toString();  
	    
	    System.out.println("模   :"+modulus);
	    System.out.println("公钥指数  :"+public_exponent);
	    System.out.println("私钥指数  :"+private_exponent);
	    
	    //明文  
	    String ming = "{123456789AA_dskjlf_你好}";  
	    System.out.println("加密前:"+ming);
	    //加密后的密文  
	    String mi = RsaUtil.encryptByPublicKey(ming, publicKey);
	    System.out.println("密文:"+mi);
	    if(mi == null){
			return;
		}
	    
	    //解密后的明文  
		ming = RsaUtil.decryptByPrivateKey(mi, privateKey);
	    System.out.println("解密后:"+ming); 
	}
    
    /**
	 * 生成公钥和私钥
     * @throws NoSuchAlgorithmException 
	 * 
	 */
	public static HashMap<String, Object> getDefaultPublicKey() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		KeyPairGenerator keyPairGen = null;
		try {
            keyPairGen = KeyPairGenerator.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
        } catch (NoSuchAlgorithmException ex) {
        	log.error(ex.getMessage());
        }
        try {
            keyPairGen.initialize(KEY_SIZE, new SecureRandom(DateFormatUtils.format(new Date(),"yyyyMMdd").getBytes()));
            oneKeyPair = keyPairGen.generateKeyPair();
    		map.put("publicKey", oneKeyPair.getPublic());
    		map.put("privateKey", oneKeyPair.getPrivate());
            return map;
        } catch (InvalidParameterException ex) {
        	log.error("KeyPairGenerator does not support a key length of " + KEY_SIZE + ".", ex);
        } catch (NullPointerException ex) {
        	log.error("RSAUtils#KEY_PAIR_GEN is null, can not generate KeyPairGenerator instance.",
                    ex);
        }
        return null;
	}
    
	/**
     * 使用默认的私钥解密给定的字符串。
     * <p />
     * 若{@code encrypttext} 为 {@code null}或空字符串则返回 {@code null}。
     * 私钥不匹配时，返回 {@code null}。
     * 
     * @param encrypttext 密文。
     * @return 原文字符串。
     */
	public static String decryptString(String encrypttext, RSAPrivateKey keyPrivate) {
        /*if(StringUtils.isBlank(encrypttext)) {
            return null;
        }
        try {
            byte[] en_data = Hex.decodeHex(encrypttext.toCharArray());
            byte[] data = decrypt(keyPrivate, en_data);
            return StringUtils.reverse(new String(data));
        } catch(NullPointerException ex) {
        	log.error("keyPair cannot be null.");
        } catch (Exception ex) {
        	log.error(String.format("\"%s\" Decryption failed. Cause: %s", encrypttext, ex.getMessage()));
        }
        return null;*/
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
			cipher.init(Cipher.DECRYPT_MODE, keyPrivate);
			// 模长
			int key_len = keyPrivate.getModulus().bitLength() / 8;
			byte[] bytes = encrypttext.getBytes();
			byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
			// 如果密文长度大于模长则要分组解密
			//String ming = "name:jjj";
			StringBuffer ming = new StringBuffer();
			byte[][] arrays = splitArray(bcd, key_len);
			String str = null;
			for (byte[] arr : arrays) {
				str = new String(cipher.doFinal(arr), "UTF-8");
				ming.append(_Tool.isEmpty(str) ? "" : str.trim());
			}
			return StringUtils.reverse(ming.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * 加密后转json
	 * @param encrypttext
	 * @param keyPair
	 * @return
	 */
	public static JSONObject decrypt(RSAPrivateKey privateKey, String ciphertext) {
		// 解密后的明文
		String content = "";
		String[] array = ciphertext.split(",");
		for (String str : array) {
			try {
				content += decryptString(str, privateKey) + ",";
			} catch (Exception e1) {
				e1.printStackTrace();
				return null;
			}
		}
		
		JSONObject jsonObject = null;
		if(_Tool.isEmpty(content)){
			return jsonObject;
		}
		content = content.substring(0, content.length()-1);
		try {
			jsonObject = new JSONObject("{"+content+"}");
		} catch (JSONException e) {
			return jsonObject;
		}
		return jsonObject;
	}
	
	/**
     * 使用指定的私钥解密数据。
     * 
     * @param privateKey 给定的私钥。
     * @param data 要解密的数据。
     * @return 原数据。
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] data) throws Exception {
        Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
        ci.init(Cipher.DECRYPT_MODE, privateKey);
        return ci.doFinal(data);
    }

	/**
	 * ASCII码转BCD码
	 * 
	 */
	public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
		int len = (asc_len) / 2;
		byte[] bcd = new byte[len];
		int j = 0;
		for (int i = 0; i < (asc_len + 1) / 2; i++) {
			int k = j++;
			bcd[i] = asc_to_bcd(ascii[k]);
			bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
		}
		return bcd;
	}

	public static byte asc_to_bcd(byte asc) {
		byte bcd;

		if ((asc >= '0') && (asc <= '9'))
			bcd = (byte) (asc - '0');
		else if ((asc >= 'A') && (asc <= 'F'))
			bcd = (byte) (asc - 'A' + 10);
		else if ((asc >= 'a') && (asc <= 'f'))
			bcd = (byte) (asc - 'a' + 10);
		else
			bcd = (byte) (asc - 48);
		return bcd;
	}

	/**
	 * BCD转字符串
	 */
	public static String bcd2Str(byte[] bytes) {
		char temp[] = new char[bytes.length * 2], val;

		for (int i = 0; i < bytes.length; i++) {
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}

	/**
	 * 拆分字符串
	 */
	public static String[] splitString(String string, int len) {
		int x = string.length() / len;
		int y = string.length() % len;
		int z = 0;
		if (y != 0) {
			z = 1;
		}
		String[] strings = new String[x + z];
		String str = "";
		for (int i = 0; i < x + z; i++) {
			if (i == x + z - 1 && y != 0) {
				str = string.substring(i * len, i * len + y);
			} else {
				str = string.substring(i * len, i * len + len);
			}
			strings[i] = str;
		}
		return strings;
	}

	/**
	 * 拆分数组
	 */
	public static byte[][] splitArray(byte[] data, int len) {
		int x = data.length / len;
		int y = data.length % len;
		int z = 0;
		if (y != 0) {
			z = 1;
		}
		byte[][] arrays = new byte[x + z][];
		byte[] arr;
		for (int i = 0; i < x + z; i++) {
			arr = new byte[len];
			if (i == x + z - 1 && y != 0) {
				System.arraycopy(data, i * len, arr, 0, y);
			} else {
				System.arraycopy(data, i * len, arr, 0, len);
			}
			arrays[i] = arr;
		}
		return arrays;
	}
}
