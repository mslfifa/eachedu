package com.eachedu.utils;

import java.util.HashMap;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSDK;

public class SmSUtils {
	
	/**
	 * 
	 * @param sendToNumber   测试阶段只能使用  13148856443
	 * @param smsTemplateId  先使用默认模板 "1"
	 * @param smsTemplateParas
	 * @return
	 */
	public static HashMap<String, Object> sendSms(String sendToNumber, String smsTemplateId, String[] smsTemplateParas){
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		//restAPI.init("sandboxapp.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.init(PropUtils.get("sms.domain"), PropUtils.get("sms.port"));
		
		//restAPI.setAccount("8a48b5514ecd7fa8014ece8aa4aa0251", "0a61129849ef421fb91c8b9399b58800");// 初始化主帐号和主帐号TOKEN
		restAPI.setAccount(PropUtils.get("sms.accountSid"), PropUtils.get("sms.accountToken"));
		
		//restAPI.setAppId("8a48b5514ecd7fa8014ece8ace43025a");// 初始化应用ID
		restAPI.setAppId(PropUtils.get("sms.appId"));
		
		result = restAPI.sendTemplateSMS(sendToNumber,smsTemplateId ,smsTemplateParas);

		/*System.out.println("SDKTestSendTemplateSMS result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}*/
		
		return result;
	}
	
	public static void main(String[] args) {
		HashMap<String, Object> result = sendSms("13148856443","1",new String[]{"3567","25"});
		
		System.out.println("SDKTestSendTemplateSMS result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		
	}
}
