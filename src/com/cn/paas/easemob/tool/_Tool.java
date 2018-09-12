package com.cn.paas.easemob.tool;

public class _Tool {
	
	/**
	 * 获取发送人标志（1医师,2用户）
	 * @param senderNum 发送人卡号
	 * @return 发送人标志
	 */
	public static Integer getSenderMark(String senderNum) {
		if(senderNum != null){
			return "8".equals(senderNum.substring(0, 1)) ? 1 : 2;
		}
		return null;
	}
	
	/**
	 * 信息类型（1文字,2图片,3语音,4视频,5透传）
	 * @param typeName 类型名称
	 * @return 类型编号
	 */
	public static Integer getTypeId(String typeName) {
		if (typeName != null) {
			if("txt".equals(typeName)){
				return 1;
			}else if("img".equals(typeName)){
				return 2;
			}else if("audio".equals(typeName)){
				return 3;
			}else if("video".equals(typeName)){
				return 4;
			}else if("cmd".equals(typeName)){
				return 5;
			}
		}
		return null;
	}
	
}
