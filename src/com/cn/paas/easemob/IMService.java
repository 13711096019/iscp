package com.cn.paas.easemob;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.cn.paas.easemob.model.TalkChat;
import com.cn.paas.easemob.model.TalkChatBody;
import com.cn.paas.easemob.model.TalkChatPayload;
import com.cn.paas.easemob.model.TalkMsg;
import com.cn.paas.easemob.model.TalkNode;
import com.cn.paas.easemob.model.base.IMUser;
import com.cn.paas.easemob.service.TalkDataService;
import com.cn.paas.easemob.service.impl.TalkDataServiceImpl;
import com.cn.paas.easemob.service.impl.TalkHttpServiceImplApache;
import com.cn.paas.easemob.tool.JsonTool;
import com.cn.paas.easemob.tool._Tool;

public class IMService {
	
	private static Logger log = Logger.getLogger(IMService.class);
	
	/**
	 * 创建环信用户(单个)
	 * @param mobdel 用户对象
	 * @return 创建状态
	 */
	public static boolean createUser(IMUser mobdel) {
		TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());
		String mobile = mobdel.getUserNum();
		try {
			TalkNode talkNode = service.userSave(mobile, mobdel.getPassword(), mobdel.getUserName());
			log.info("环信返回:" + mobile + "-" + talkNode.getStatusCode());
			// + "\n"  + JSON.toJSONString(talkNode)
			if(talkNode.getStatusCode() == 200){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 创建环信用户(多个)
	 * @param mobdel 用户对象
	 * @return 创建状态
	 */
	public static boolean createUser(String[] username, String[] password, String[] nickname) {
		TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());
		try {
			TalkNode talkNode = service.userSave(username, password, nickname);
			log.info("环信返回:" + talkNode.getStatusCode());
			if(talkNode.getStatusCode() == 200){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 删除环信用户
	 * @param mobile 手机号
	 * @return 删除状态
	 */
	public static boolean deleteUser(String mobile) {
		TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());
		try {
			TalkNode talkNode = service.userDrop(mobile);
			log.info("环信返回:" + mobile + "-" + talkNode.getStatusCode());
			if(talkNode.getStatusCode() == 200){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 修改环信用户密码
	 * @param mobdel 用户对象
	 * @return 修改态
	 */
	public static boolean updateUserPwd(IMUser mobdel) {
		TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());
		String mobile = mobdel.getUserNum();
		try {
			TalkNode talkNode = service.userModifyPassword(mobile, mobdel.getPassword());
			log.info("环信返回:" + mobile + "-" + talkNode.getStatusCode());
			if(talkNode.getStatusCode() == 200){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 发送透传消息
	 * @param mobdel 消息对象
	 * @return 发送状态
	 */
	public static boolean SendCommandMessage(TalkMsg talkMsg) {
		TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());
		try {
			TalkNode talkNode = service.messageSave(talkMsg);
			log.info("发送透传消息:" + talkNode.getStatusCode() + "\n" 
					+ JSON.toJSONString(talkNode));
			if(talkNode.getStatusCode() == 200){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取聊天记录
	 * @param start 开始时间
	 * @return 聊天记录
	 */
	public static TalkNode getTalkChatLog(Long start) {
		TalkDataService service = new TalkDataServiceImpl(new TalkHttpServiceImplApache());
		//Long start = System.currentTimeMillis() - 25 * 24 * 60 * 60 * 1000;
		try {
			TalkNode talkNode = service.chatList(null, null, start);
			log.info("获取聊天记录:" + talkNode.getStatusCode() + "\n" 
					+ JSON.toJSONString(talkNode));
			if(talkNode.getStatusCode() == 200){
				return talkNode;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		/*IMUser mobdel = new IMUser("WUNNyIMKMJJHHGG", "医师WUNNyIMKMJJHHGG", "1234");
		createUser(mobdel);*/
		
		/*TalkMsg mobdel = new TalkMsg(5, "WUNNyIMKMJJHHGG", 1, "admin", "1234");
		SendCommandMessage(mobdel);*/

		//TalkNode talkNode = getTalkChatLog(1481671000415L);
		
		String json = "{\"action\":\"get\",\"count\":10,\"cursor\":\"MTQzNjgyOTEyMDpnR2tBQVFNQWdHa0FCZ0ZZOGRTNjBRQ0FkUUFRbVVVMUdzQTRFZWFnN0gzOGQtRmJUQUNBZFFBUW1VVTFFTUE0RWVhakpLRmVsOWE2ZndB\",\"data_chat_list\":[{\"chat_type\":\"chat\",\"created\":1481506604671,\"from\":\"8201611160001\",\"modified\":1481506604671,\"msg_id\":\"274627959778707488\",\"payload\":{\"bodies\":[{\"msg\":\"考虑考虑\",\"type\":\"txt\"}],\"ext\":{\"hospitalizeId\":480}},\"timestamp\":1481506604659,\"to\":\"6201612090001\",\"type\":\"chatmessage\",\"uuid\":\"708b00fa-c00b-11e6-8b52-c35cb6301bd6\"},{\"chat_type\":\"chat\",\"created\":1481506616831,\"from\":\"8201611160001\",\"modified\":1481506616831,\"msg_id\":\"274628011989403680\",\"payload\":{\"bodies\":[{\"msg\":\"摸摸\",\"type\":\"txt\"}],\"ext\":{\"hospitalizeId\":480}},\"timestamp\":1481506616820,\"to\":\"6201612090001\",\"type\":\"chatmessage\",\"uuid\":\"77ca78fa-c00b-11e6-9f82-5525e8f7a14a\"},{\"chat_type\":\"chat\",\"created\":1481506618288,\"from\":\"8201611160001\",\"modified\":1481506618288,\"msg_id\":\"274628018301831200\",\"payload\":{\"bodies\":[{\"msg\":\"我\",\"type\":\"txt\"}],\"ext\":{\"hospitalizeId\":480}},\"timestamp\":1481506618277,\"to\":\"6201612090001\",\"type\":\"chatmessage\",\"uuid\":\"78a8cb0a-c00b-11e6-9d2f-b5e940b4617f\"},{\"chat_type\":\"chat\",\"created\":1481506633394,\"from\":\"6201612090001\",\"modified\":1481506633394,\"msg_id\":\"274628083191912420\",\"payload\":{\"bodies\":[{\"file_length\":1059,\"filename\":\"620161209000120161212T093709.amr\",\"length\":1,\"secret\":\"gZ-3CsALEeagCw-5UrkYVGluSNNPRQaky8uPGMFY4qIeojfT\",\"type\":\"audio\",\"url\":\"https://a1.easemob.com/1162161108115156/regd/chatfiles/819fb700-c00b-11e6-96a0-fb21816d6816\"}],\"ext\":{\"hospitalizeId\":480}},\"timestamp\":1481506633388,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"81a9c92a-c00b-11e6-ac3f-a73205bc84ff\"},{\"chat_type\":\"chat\",\"created\":1481506829727,\"from\":\"admin\",\"modified\":1481506829727,\"msg_id\":\"274628926477702228\",\"payload\":{\"bodies\":[{\"action\":\"1601\",\"type\":\"cmd\"}]},\"timestamp\":1481506829736,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"f6afd2fa-c00b-11e6-9505-53c06ffee4de\"},{\"chat_type\":\"chat\",\"created\":1481506832563,\"from\":\"6201612090001\",\"modified\":1481506832563,\"msg_id\":\"274628938565683172\",\"payload\":{\"bodies\":[{\"msg\":\"身体不舒服\",\"type\":\"txt\"}],\"ext\":{\"hospitalizeId\":490}},\"timestamp\":1481506832552,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"f860903a-c00b-11e6-b595-35a428a352a4\"},{\"chat_type\":\"chat\",\"created\":1481508289416,\"from\":\"admin\",\"modified\":1481508289416,\"msg_id\":\"274635195783586900\",\"payload\":{\"bodies\":[{\"action\":\"1602\",\"type\":\"cmd\"}]},\"timestamp\":1481508289415,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"5cbab08a-c00f-11e6-a4a8-53e8e015fe0f\"},{\"chat_type\":\"chat\",\"created\":1481509802333,\"from\":\"admin\",\"modified\":1481509802333,\"msg_id\":\"274641693725172832\",\"payload\":{\"bodies\":[{\"action\":\"1602\",\"type\":\"cmd\"}]},\"timestamp\":1481509802334,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"e27f80da-c012-11e6-8c15-85429ebf725b\"},{\"chat_type\":\"chat\",\"created\":1481525401851,\"from\":\"admin\",\"modified\":1481525401851,\"msg_id\":\"274708693088478292\",\"payload\":{\"bodies\":[{\"action\":\"1602\",\"type\":\"cmd\"}]},\"timestamp\":1481525401850,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"34890cba-c037-11e6-a51a-97be65e1a50f\"},{\"chat_type\":\"chat\",\"created\":1481526000353,\"from\":\"admin\",\"modified\":1481526000353,\"msg_id\":\"274711263622214744\",\"payload\":{\"bodies\":[{\"action\":\"1602\",\"type\":\"cmd\"}]},\"timestamp\":1481526000337,\"to\":\"8201611160001\",\"type\":\"chatmessage\",\"uuid\":\"9945351a-c038-11e6-a0ec-7dfc77e15b4c\"}],\"duration\":30,\"params\":{\"ql\":[\"select * where timestamp > 1481506594803\"]},\"path\":\"/chatmessages\",\"statusCode\":200,\"timestamp\":1481693651134,\"uri\":\"http://a1.easemob.com/1162161108115156/regd/chatmessages\"}";
		TalkNode talkNode = (TalkNode) JsonTool.read(json, TalkNode.class);
		List<TalkChat> chatList = talkNode.getData_chat_list();
		if(chatList == null || chatList.size() < 1){
			return;
		}
		
		TalkChatPayload payload;
		TalkChatBody bodies;
		String sendContent, fileName;
		Long fileSize, length;
		Integer sendType;
		
		for (TalkChat talkChat : chatList) {
			payload = talkChat.getPayload();
			if(payload.getBodies() == null || payload.getBodies().size() < 1){
				return;
			}
			bodies = payload.getBodies().get(0);
			
			sendContent=null;
			fileName=null;
			fileSize=null;
			length=null;
			sendType=null;
			
			sendType = _Tool.getTypeId(talkChat.getTo());
			
			if (sendType != null) {
				switch (sendType) {
				case 1:// 文字
					sendContent = bodies.getMsg();
				case 2:// 图片
					fileSize = bodies.getFile_length();
				case 3:// 语音
					fileSize = bodies.getFile_length();
					length = bodies.getLength();
				case 4:// 视频
					return;
				case 5:// 透传
					return;
				}
			}

			/*if(fileSize!=null){
				// 处理语音文件
				String url = bodies.getUrl();
				fileName = url.substring(url.lastIndexOf("/")+1, url.length());
				String relativelyPath=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
				relativelyPath = relativelyPath.replaceAll("/WEB-INF/classes/", "/");
				String savePath = relativelyPath + Const.PATH_TALKCHAT;
				DownLoad.downLoadFromUrl(url, fileName, savePath);
			}
			
			TalkChatLog talkChatLog = new TalkChatLog(talkChat.getUuid(), talkChat.getFrom(), talkChat.getTo(), 
					_Tool.getSenderMark(talkChat.getFrom()), sendType, sendContent, fileName, length, fileSize, 
					payload.getExt().getHospitalizeId(), talkChat.getTimestamp(), 
					DateUtil.longToString(talkChat.getTimestamp(), DateUtil.YYYY_MM_DD_HH_MM_SS));
			
			*/
			
		}
		
	}
}
