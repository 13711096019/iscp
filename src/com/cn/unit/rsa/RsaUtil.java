package com.cn.unit.rsa;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;

import javax.crypto.Cipher;

import org.json.JSONException;
import org.json.JSONObject;

import com.cn.common._Tool;

/**
 * APP加密工具类
 * @author Adonis_1111@163.com
 * 2016-09-01
 */
public class RsaUtil {
	
	private static final String RSA = "RSA"; // RSA/ECB/PKCS1Padding
	private static final String NOPADDING = "RSA/ECB/NoPadding"; // RSA/ECB/PKCS1Padding
	
	public static void main(String[] args) {
		HashMap<String, Object> map = RsaUtil.getKeys();
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

	    	/*	
模   :136236723379613222169320459409421862662125920073951416564499020977435416957839160538749174345200823534120600278159499960555447112144328516035186900412428283304306613279739638059103287498639974933228530764181226526479762772486283952206277606442266430256268480385907481619832287543780168287010211081094089970719
公钥指数  :65537
私钥指数  :84001247463978984308712184632731556957349990147066585164942565858632341484189429455274354732673452831076786191619195781102050175544199017417121129419500641724113415108272769181013489298166129808530005451165062915125502808751762448330239326637584402988311275316216960963699824639874409841033905776610143786681
加密前:{123456789AA}
136236723379613222169320459409421862662125920073951416564499020977435416957839160538749174345200823534120600278159499960555447112144328516035186900412428283304306613279739638059103287498639974933228530764181226526479762772486283952206277606442266430256268480385907481619832287543780168287010211081094089970719
65537
密文:69C87CB9A8F5DEB6F001861B79FA291E115323873D1F000F2493EB1E2A9646C889D121B329DB5D25403B3C68958C631170CB67AD4EF734ECD572472ED15962E56BD3D5F4559919DA735DDE908C6D801D2FB570F8E69D29D74C4F7E8AC811497B4F517CD30E2A9F2A736818987BC600C7509137153AEF451F6036C0EFF661AD39
解密后:{123456789AA}

	
	     */
	    
	    System.out.println("模   :"+modulus);
	    System.out.println("公钥指数  :"+public_exponent);
	    System.out.println("私钥指数  :"+private_exponent);
	    
	    //明文  
	    String ming = "{123456789AA_dskjlf_你好}";  
	    System.out.println("加密前:"+ming);
	    //使用模和指数生成公钥和私钥  
	    RSAPublicKey pubKey = RsaUtil.getPublicKey(modulus, public_exponent);  
	    System.out.println(modulus);
	    System.out.println(public_exponent);
	    RSAPrivateKey priKey = RsaUtil.getPrivateKey(modulus, private_exponent);  
	    //加密后的密文  
	    String mi = RsaUtil.encryptByPublicKey(ming, pubKey);
	    System.out.println("密文:"+mi);
	    if(mi == null){
			return;
		}
	    
	    //解密后的明文  
		ming = RsaUtil.decryptByPrivateKey(mi, priKey);
	    System.out.println("解密后:"+ming); 
	}
	
	/**
	 * 生成公钥和私钥
	 * 
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	public static HashMap<String, Object> getKeys() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance(RSA);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		map.put("publicKey", publicKey);
		map.put("privateKey", privateKey);
		return map;
	}

	/**
	 * 使用模和指数生成RSA公钥
	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
	 * /None/NoPadding】
	 * 
	 * @param modulus 模
	 * @param exponent 指数
	 * @return
	 */
	public static RSAPublicKey getPublicKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus);
			BigInteger b2 = new BigInteger(exponent);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 使用模和指数生成RSA私钥
	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA/None/NoPadding】
	 * 
	 * @param modulus
	 *            模
	 * @param exponent
	 *            指数
	 * @return
	 */
	public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus);
			BigInteger b2 = new BigInteger(exponent);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA,
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String encryption(String modulus, String exponent, String data){
		RSAPublicKey pubKey = getPublicKey(modulus, exponent);  
		return encryptByPublicKey(data, pubKey);
	}

	/**
	 * 公钥加密
	 * 
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data, RSAPublicKey publicKey) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(NOPADDING);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			// 模长
			int key_len = publicKey.getModulus().bitLength() / 8;
			// 加密数据长度 <= 模长-11
			String[] datas = splitString(data, key_len - 11);
			String mi = "";
			// 如果明文长度大于模长-11则要分组加密
			for (String s : datas) {
				mi += bcd2Str(cipher.doFinal(s.getBytes()));
			}
			return mi;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 私钥解密
	 * 
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey) {
		try {
			Cipher cipher = Cipher.getInstance(NOPADDING);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			// 模长
			int key_len = privateKey.getModulus().bitLength() / 8;
			byte[] bytes = data.getBytes();
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
			return ming.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ASCII码转BCD码
	 * 
	 */
	public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
		byte[] bcd = new byte[asc_len / 2];
		int j = 0;
		for (int i = 0; i < (asc_len + 1) / 2; i++) {
			bcd[i] = asc_to_bcd(ascii[j++]);
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

	/**
	 * 解密方法
	 * 
	 * @param privateKey
	 * @param ciphertext
	 * @return
	 */
	public static JSONObject decrypt(RSAPrivateKey privateKey, String ciphertext) {
		/*// 模
		String modulus = privateKey.getModulus().toString();
		// 私钥指数
		String private_exponent = privateKey.getPrivateExponent().toString();
		// 使用模和指数生成私钥
		RSAPrivateKey priKey = getPrivateKey(modulus, private_exponent);*/
		// 解密后的明文
		JSONObject jsonObject = null;
		String content = null;
		try {
			content = decryptByPrivateKey(ciphertext, privateKey);
		} catch (Exception e1) {
			e1.printStackTrace();
			return jsonObject;
		}
		if(_Tool.isEmpty(content)){
			return jsonObject;
		}
		try {
			jsonObject = new JSONObject(content);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
