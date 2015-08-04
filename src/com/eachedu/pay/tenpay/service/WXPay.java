package com.eachedu.pay.tenpay.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;






import com.eachedu.pay.tenpay.util.MD5;
import com.eachedu.pay.tenpay.util.MD5Util;
import com.eachedu.pay.tenpay.util.OrderUtil;

/**
 * 微信调起支付类
 */
public class WXPay {
	/**
	 * 预付订单号成功返回app的信息
	 * @param appid 微信号
	 * @param partnerId 商户id
	 * @param prepay_id 预付订单号
	 * @param partnerKey 商户密钥
	 * @return
	 */
	public static SortedMap<String, String> createPackageValue(String appid, String partnerId, String prepay_id,String partnerKey)  {
		SortedMap<String, String> nativeObj = new TreeMap<String, String>();
		//微信号
		nativeObj.put("appId", appid);
		//商户id
		nativeObj.put("partnerId", partnerId);
		//预付订单号
		nativeObj.put("prepayId", prepay_id);
		//随机数
		Random random = new Random();
		String randomStr = MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
		nativeObj.put("nonceStr", MD5Util.MD5Encode(randomStr, "utf-8").toLowerCase());
		//时间戳
		nativeObj.put("timeStamp", OrderUtil.GetTimestamp());
		nativeObj.put("package", "Sign=WXPay");
		nativeObj.put("sign", createSign(nativeObj, partnerKey));
		return nativeObj;
	}

	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public static String createSign(SortedMap<String, String> packageParams, String AppKey) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + AppKey);
		System.out.println("返回签名:"+sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;
	}
}
