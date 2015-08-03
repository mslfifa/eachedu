package com.eachedu.pay.tenpay.service;

import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jdom2.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eachedu.pay.tenpay.util.MD5Util;
import com.eachedu.pay.tenpay.util.OrderUtil;
import com.eachedu.pay.tenpay.util.XMLUtil;


/**
 * 支付成功后订单查询
 * @author Sunlight
 *
 */
public class WXOrderQuery {
	private static final Logger logger = LoggerFactory.getLogger(WXOrderQuery.class);
	private String partnerKey;
	private String appid;
	private String mch_id;
	private String transaction_id;
	private String out_trade_no;
	private String nonce_str;
	private String sign;
	
	//请求订单查询接口
	@SuppressWarnings("unchecked")
	public Map<String, String> reqOrderquery(){
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/pay/orderquery");
		String xml = getPackage();
		System.out.println(xml);
		StringEntity entity;
		Map<String, String> map = null;
		try {
			entity = new StringEntity(xml, "utf-8");
			httpPost.setEntity(entity);

			HttpResponse httpResponse;
			// post请求
			httpResponse = closeableHttpClient.execute(httpPost);

			// getEntity()
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				// 打印响应内容
				String result = EntityUtils.toString(httpEntity, "UTF-8");
				// 过滤
				result = result.replaceAll("<![CDATA[|]]>", "");
				try {
					map = XMLUtil.doXMLParse(result);
				} catch (JDOMException e) {
					e.printStackTrace();
				}
				logger.info("微信订单查询:"+result);
			}
			// 释放资源
			closeableHttpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public String getPackage() {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("appid", this.appid);
		treeMap.put("mch_id", this.mch_id);
		if(this.transaction_id != null && !"".equals(this.transaction_id)){
			treeMap.put("transaction_id", this.transaction_id);
		}
		treeMap.put("nonce_str", this.nonce_str);
		if(this.out_trade_no != null && !"".equals(this.out_trade_no)){
			treeMap.put("out_trade_no", this.out_trade_no);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (String key : treeMap.keySet()) {
			sb.append(key).append("=").append(treeMap.get(key)).append("&");
		}
		sb.append("key=" + partnerKey);
		sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
		treeMap.put("sign", sign);

		StringBuilder xml = new StringBuilder();
		xml.append("<xml>\n");

		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			if ("body".equals(entry.getKey()) || "sign".equals(entry.getKey())) {
				xml.append("<" + entry.getKey() + "><![CDATA[").append(entry.getValue()).append("]]></" + entry.getKey() + ">\n");
			} else {
				xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
			}
		}
		xml.append("</xml>");
		return xml.toString();
	}
	
	
	public static void main(String[] args) {
		WXOrderQuery wsOrderQuery = new WXOrderQuery();
		wsOrderQuery.setAppid("wx0dfc013c4b75605a");
		wsOrderQuery.setMch_id("1261357801");
		wsOrderQuery.setNonce_str(OrderUtil.CreateNoncestr());
		//wsOrderQuery.setTransaction_id("wx20150801171430b5305bbf310337943319");
		wsOrderQuery.setOut_trade_no("20150801221454000001");
		wsOrderQuery.setPartnerKey("Thenumberofbitsinthedata78902348");
		wsOrderQuery.reqOrderquery();
	}
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mchId) {
		mch_id = mchId;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transactionId) {
		transaction_id = transactionId;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonceStr) {
		nonce_str = nonceStr;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPartnerKey() {
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}
	
}
