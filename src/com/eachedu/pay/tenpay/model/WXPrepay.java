package com.eachedu.pay.tenpay.model;

import com.eachedu.pay.tenpay.AccessTokenRequestHandler;
import com.eachedu.pay.tenpay.util.TenpayUtil;

/**
 * 生成预支付订单号
 * @author wzg
 *
 */
public class WXPrepay {
	/**预付定单地址**/
	private static String unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder"; 
	/**定单查询地址**/
    private static String orderquery = "https://api.mch.weixin.qq.com/pay/orderquery";  
    /**公众账号ID**/
    private String appid;  
    /**商户号**/
    private String mch_id; 
    /**随机字符串 不长于32位**/
    private String nonce_str; 
    /**商品描述**/
    private String body;  
    /**商户订单号**/
    private String out_trade_no; 
    /**总金额 单位：分**/
    private Integer total_fee;
    /**终端IP**/
    private String spbill_create_ip;
    /**交易类型 取值如下：JSAPI，NATIVE，APP，WAP**/
    private String trade_type;
    /**接收微信支付异步通知回调地址**/
    private String notify_url;
    /**签名**/
    private String sign; 
    /**商户密钥**/
    private String partnerKey;
    
    /** 
     * 生成预支付订单 
     *  
     * @return 支付订单号
     */  
    public String submitXmlGetPrepayId(){
    	return "";
    }
    
    /**
     * 获得订单号
     * @return
     */
    public static String getOrderNum(){
    	//当前时间 yyyyMMddHHmmss
    	String currTime = TenpayUtil.getCurrTime();
    	//8位日期
    	String strTime = currTime.substring(0, 8);
    	//四位随机数
    	String strRandom = TenpayUtil.buildRandom(4) + "";
    	//10位序列号,可以自行调整。
    	String strReq = strTime + strRandom;
    	return strReq;
    }
    
    public static void main(String[] args) {
    	String token = AccessTokenRequestHandler.getAccessToken();
		System.out.println(token);
	}
    //******************************************
	public static String getUnifiedorder() {
		return unifiedorder;
	}
	public static void setUnifiedorder(String unifiedorder) {
		WXPrepay.unifiedorder = unifiedorder;
	}
	public static String getOrderquery() {
		return orderquery;
	}
	public static void setOrderquery(String orderquery) {
		WXPrepay.orderquery = orderquery;
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
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
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
