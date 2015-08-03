package com.eachedu.pay.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.exception.DaoException;
import com.eachedu.exception.ServiceException;
import com.eachedu.pay.dao.IPayRecordDao;
import com.eachedu.pay.model.PayRecord;
import com.eachedu.pay.service.IPayRecordService;
import com.eachedu.service.impl.BaseServiceImpl;

@Service("payRecordService")
public class PayRecordServiceImpl extends BaseServiceImpl<PayRecord, Long> implements IPayRecordService {

	
	@Resource(name="payRecordDao")
	@Override
	public void setDao(BaseDao<PayRecord, Long> dao) {
		this.dao=dao;
	}
	
	/**
	 * 根据定单号获得支付记录
	 * @param orderNo
	 * @return
	 */
	public PayRecord getByOrderNO(String orderNo){
		String hql="from PayRecord where orderNo=?";
		try {
			List<PayRecord> list = dao.findByHql(hql, orderNo);
			if(list.size()>0){
				return list.get(0);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
