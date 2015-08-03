package com.eachedu.pay.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.exception.ServiceException;
import com.eachedu.pay.model.PayMsgPacket;
import com.eachedu.pay.model.PayRecord;
import com.eachedu.pay.service.IPayMsgPacketService;
import com.eachedu.pay.service.IPayRecordService;
import com.eachedu.pay.tenpay.service.WXPay;
import com.eachedu.pay.tenpay.util.XMLUtil;
import com.eachedu.web.actions.BaseAction;

/**
 * 支付成功服务端回调接口
 * @author wzg
 *
 */
@Controller("payNoticeAction")
@Scope("prototype")
public class PayNoticeAction extends BaseAction{
	@Autowired
	private IPayRecordService payRecordService;
	@Autowired
	private IPayMsgPacketService payMsgPacketService;

	/**
	 * 微信通知回调方法
	 */
	public void WXNotice(){
		try {
			PrintWriter out = getResponse().getWriter();
			InputStream inStream = getRequest().getInputStream();
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			outSteam.close();
			inStream.close();
			String result = new String(outSteam.toByteArray(), "utf-8");
			if(result.length()>0){
				PayMsgPacket payMsgPacketRsp = new PayMsgPacket();
				payMsgPacketRsp.setMsgType("微信支付回调通知");
				payMsgPacketRsp.setMsgPacket(result);
				payMsgPacketService.save(payMsgPacketRsp);
				
				SortedMap<String, String> map= (SortedMap<String, String>) XMLUtil.doXMLParse(result);
				String noticeStr ="";
				if(isWXSuccess(map)){
					noticeStr =setWXXML("SUCCESS", "OK");
				}else{
					noticeStr =setWXXML("FAIL", "签名失败");
				}
				out.print(new ByteArrayInputStream(noticeStr.getBytes(Charset.forName("UTF-8"))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证微信是否交易成功
	 * @param map
	 * @return
	 * @throws ServiceException 
	 */
	private boolean isWXSuccess(SortedMap<String, String> map) throws ServiceException{
		if (map.get("return_code") != null && map.get("return_code").equalsIgnoreCase("SUCCESS")) {
			//传递过来的
			String rspSign=map.get("sign");
			//密钥
			String key="Thenumberofbitsinthedata78902348";
			String newSign=WXPay.createSign(map, key);
			String orderNo=map.get("out_trade_no");
			//验证签名
			if(rspSign.equals(newSign)){
				PayRecord payRecord = this.payRecordService.getByOrderNO(orderNo);
				payRecord.setReceiveTime(new Date());
				payRecord.setTransactionId(map.get("transaction_id"));
				//处理结果
				if(map.get("result_code").equalsIgnoreCase("SUCCESS")){
					payRecord.setPayStatus(PayRecord.PAY_STATUS_SUCCESS);
					payRecord.setResultReasons("支付成功");
				}else{
					payRecord.setPayStatus(PayRecord.PAY_STATUS_FAIL);
					payRecord.setResultReasons(map.get("err_code_des"));
				}
				this.payRecordService.update(payRecord);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 返回给微信信息
	 * @param return_code
	 * @param return_msg
	 * @return
	 */
	public  String setWXXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
	}
}
