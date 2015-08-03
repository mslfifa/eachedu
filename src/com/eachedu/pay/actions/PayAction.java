package com.eachedu.pay.actions;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.pay.model.PayMsgPacket;
import com.eachedu.pay.model.PayRecord;
import com.eachedu.pay.service.IPayMsgPacketService;
import com.eachedu.pay.service.IPayRecordService;
import com.eachedu.pay.tenpay.service.WXOrderQuery;
import com.eachedu.pay.tenpay.service.WXPay;
import com.eachedu.pay.tenpay.service.WXPrepay;
import com.eachedu.pay.tenpay.util.OrderUtil;
import com.eachedu.web.actions.BaseAction;
import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;

/**
 * 支付控制类
 * @author wzg
 *
 */
@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(PayAction.class);
	
	private String orderNo;
	
	@Autowired
	private IPayRecordService payRecordService;
	@Autowired
	private IPayMsgPacketService payMsgPacketService;

	/**
	 * 微信支付请求
	 */
	public void WXPay(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			if(orderNo !=null && !"".equals(orderNo)){
				//客户端ip
				String spbill_create_ip = this.getRequest().getRemoteAddr();
				//回调地址
				String notifyUrl = "http://222.216.28.49:8080/eachedu/app/payNotice!WXNotice.action";
				WXPrepay prePay = new WXPrepay();
				prePay.setAppid("wx0dfc013c4b75605a");
				prePay.setBody("来自个个答的微信支付测试2");
				prePay.setPartnerKey("Thenumberofbitsinthedata78902348");
				prePay.setMch_id("1261357801");
				prePay.setNotify_url(notifyUrl);
				prePay.setOut_trade_no(orderNo);
				prePay.setSpbill_create_ip(spbill_create_ip);
				prePay.setTotal_fee("1");
				prePay.setTrade_type("APP");
		        //此处添加获取openid的方法，获取预支付订单需要此参数！！！！！！！！！！！ 
				// 获取预支付订单号
				String prepayid = prePay.submitXmlGetPrepayId();
				//保存发送请求的记录
				PayMsgPacket payMsgPacketReq = new PayMsgPacket(orderNo, new Date(), "微信预支付订单_REQ", WXPrepay.prePayReqMsg.get());
				this.payMsgPacketService.save(payMsgPacketReq);
				if (prepayid != null && prepayid.length() > 10) {
					//返回请求记录生成支付记录
					PayRecord payRecord = this.payRecordService.getByOrderNO(orderNo);
					if(null !=payRecord){
						payRecord.setPayTime(new Date());
						this.payRecordService.update(payRecord);
					}else{
						payRecord =new PayRecord(orderNo, PayRecord.PAY_TYPE_WXPAY,new BigDecimal(Long.parseLong(prePay.getTotal_fee().toString())*0.01), new Date(), PayRecord.PAY_STATUS_NOTPAY);
						this.payRecordService.save(payRecord);
					}
					
					SortedMap<String, String> nativeObj =  WXPay.createPackageValue(prePay.getAppid(), prePay.getMch_id(),
							prepayid, prePay.getPartnerKey());
					// 生成微信支付参数，此处拼接为完整的JSON格式，符合支付调起传入格式
					result.put("http_status", true);
					result.put("http_msg", "微信支付下单成功");
					result.putAll(nativeObj);
				}else{
					result.put("http_status", false);
					result.put("http_msg", "获取prepayid失败");
				}
				PayMsgPacket payMsgPacketRsp = new PayMsgPacket(orderNo, new Date(), "微信预支付订单_RSP", WXPrepay.prePayRspMsg.get());
				this.payMsgPacketService.save(payMsgPacketRsp);
			}else{
				result.put("http_status", false);
				result.put("http_msg", "订单号不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("http_status", false);
			result.put("http_msg", "支付失败:"+e.getMessage());
		}
		
		this.ajaxWriteOutJSON(result);
	}
	
	/**
	 * 微信订单查询请求
	 */
	public void WXOrderQuery(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			//根据订单查找支付记录
			PayRecord payRecord = this.payRecordService.getByOrderNO(orderNo);
			if(null !=payRecord){
				if(null == payRecord.getReceiveTime() || "".equals(payRecord.getReceiveTime())){
					//从微信平台那里取回来
					WXOrderQuery wsOrderQuery = new WXOrderQuery();
					wsOrderQuery.setAppid("wx0dfc013c4b75605a");
					wsOrderQuery.setMch_id("1261357801");
					wsOrderQuery.setNonce_str(OrderUtil.CreateNoncestr());
					//wsOrderQuery.setTransaction_id("wx20150801171430b5305bbf310337943319");
					wsOrderQuery.setOut_trade_no("20150801221454000001");
					wsOrderQuery.setPartnerKey("Thenumberofbitsinthedata78902348");
					Map<String, String> rsMap=wsOrderQuery.reqOrderquery();
					if (rsMap.get("return_code") != null && rsMap.get("return_code").equalsIgnoreCase("SUCCESS")) {
						//支付成功
						if(rsMap.get("trade_state").equalsIgnoreCase("SUCCESS")){
							payRecord.setPayStatus(PayRecord.PAY_STATUS_SUCCESS);
							payRecord.setResultReasons("支付成功");
							payRecord.setReceiveTime(new Date());
						}else if(rsMap.get("trade_state").equalsIgnoreCase("PAYERROR")){
							payRecord.setPayStatus(PayRecord.PAY_STATUS_FAIL);
							payRecord.setResultReasons("支付失败");
							payRecord.setReceiveTime(new Date());
						}else if(rsMap.get("trade_state").equalsIgnoreCase("CLOSED")){
							payRecord.setPayStatus(PayRecord.PAY_STATUS_CLOSED);
							payRecord.setResultReasons("订单已关闭");
							payRecord.setReceiveTime(new Date());
						}
						payRecordService.update(payRecord);
					}
				}
				
				if(payRecord.getPayStatus()==PayRecord.PAY_STATUS_SUCCESS){
					result.put("http_status", true);
					result.put("http_msg", "订单支付成功");
				}else if(payRecord.getPayStatus()==PayRecord.PAY_STATUS_NOTPAY){
					result.put("http_status", false);
					result.put("http_msg", "订单未支付");
				}else{
					result.put("http_status", false);
					result.put("http_msg", "订单支付失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("微信订单查询异常", e);
			result.put("http_status", false);
			result.put("http_msg", "订单查询异常:"+e.getMessage());
		}
		this.ajaxWriteOutJSON(result);
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
