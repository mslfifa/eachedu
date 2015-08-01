package com.eachedu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.eachedu.dict.CodeType;
import com.eachedu.dict.CommunicateWay;



public class GenerateStrUtils {
	/**
	 * 生成订单号 规则 订单号,规则沟通方式(TW/DH)+8位年月日时分秒毫秒+6位按照先后顺序数字  TW是图文,电话用DH 如:TW20150722083124001 DH20150501654321
	 * @param codeType TODO
	 * @return
	 */
	public static String generateOrderNo(String codeType)throws Exception{
		String orderNo = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date now = new Date();
		String prefix = "";
		if(CodeType.MOBILE_ASK.name().equals(codeType)){
			prefix="TW";
		}else if (CodeType.TEXT_ASK.name().equals(codeType)) {
			prefix="DH";
		}else if (CodeType.COURSEWARE_DOWN.name().equals(codeType)) {
			prefix="KJ";
		}else{
			throw new Exception("值域不在范围内");
		}
		orderNo+=prefix;
		orderNo+=sdf.format(now);
		Random random = new Random();
		int num = random.nextInt(10000);
		String numStr=num+"0000";
		orderNo+=numStr.substring(0, 4);
		return orderNo;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("图文类型:"+generateOrderNo(CodeType.MOBILE_ASK.name()));
		System.out.println("电话类型:"+generateOrderNo(CodeType.TEXT_ASK.name()));
		System.out.println("课件类型:"+generateOrderNo(CodeType.COURSEWARE_DOWN.name()));
	}
	
	
}
