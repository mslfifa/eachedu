package com.eachedu.pay.service;

import com.eachedu.pay.model.PayRecord;
import com.eachedu.service.BaseService;

/**
 * 支付服务业务处理接口
 * @author wzg
 *
 */
public interface IPayRecordService extends BaseService<PayRecord, Long>{

	/**
	 * 根据定单号获得支付记录
	 * @param orderNo
	 * @return
	 */
	public PayRecord getByOrderNO(String orderNo);
}
