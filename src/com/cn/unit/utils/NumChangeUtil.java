package com.cn.unit.utils;

import com.cn.common._Tool;

/**
 * 阿拉伯数字转换为汉语工具(-1)
 * @author adonis_xin@hotmail.com
 * 2016-02-12
 */
public class NumChangeUtil {
	
	public static final int BIG = 1;
	public static final int SMALL = 2;

	public static final String[] BIG_ARRAY = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	public static final String[] SMALL_ARRAY = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	
	/**
	 * 阿拉伯数字转换为大写汉字
	 */
	public static String NumToCC(String num, int type){
		String[] arr = type==BIG ? BIG_ARRAY : SMALL_ARRAY;
        char[] c = num.toCharArray();
        StringBuffer cn = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
        	if(_Tool.isInt(String.valueOf(c[i]))){
                int a = Integer.parseInt(String.valueOf(c[i]));
                cn.append(arr[a]);
        	}else{
        		cn.append(String.valueOf(c[i]));
        	}
        }
        return cn.toString();
	}
	
}
