package com.eachedu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class DateUtils {

	public static String getDateFromFormat(Date date, String formatValue) {
		SimpleDateFormat format = new SimpleDateFormat(formatValue);
		return format.format(date);
	}
	
	public static Date getDateFromFormat(String dateStr, String formatValue){
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatValue);
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new Date();
	}
	
	public static String getLastMonth(String formatValue){
		Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return getDateFromFormat(c.getTime(), formatValue);
	}
	
	public static String getMonth(Date date, String formatValue, int remainMonth){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
        c.add(Calendar.MONTH, remainMonth);
        return getDateFromFormat(c.getTime(), formatValue);
	}
	
	
	public static String getNearByMonthStr(String curMonthStr,int num) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date date = sdf.parse(curMonthStr);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, num);
		return sdf.format(c.getTime());
	}
	
	
	public static void checkVerifyCodeExpire(String code,Map<String,Date>expireMap)throws Exception{
		if(StringUtils.isEmpty(code)){
			throw new Exception("验证码不能为空!");
		}
		
		if(expireMap==null || expireMap.isEmpty()){
			throw new Exception("过期时间集合不能为空!");
		}
		//没有验证码记录
		if (!expireMap.keySet().contains(code)) {
			throw new Exception("过期集合中没有该验证码["+code+"]记录!");
		}
		
		Date d = expireMap.get(code);
		
		Date now = new Date();
		if (now.after(d)) {
			throw new Exception("验证码["+code+"]已经超时,请重新申请验证码!");
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date currentDate = format.parse("201409");
		for (int i = 5; i >=0 ; i--) {
			System.out.println(DateUtils.getMonth(currentDate, "yyyyMM", -i));
		}
		
		System.out.println("@@@@@ getNearbyMonthStr:"+getNearByMonthStr("201412",1));
		System.out.println("@@@@@ getNearbyMonthStr:"+getNearByMonthStr("201401",-1));
		
	}
}
