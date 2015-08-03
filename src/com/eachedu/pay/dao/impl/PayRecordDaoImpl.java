package com.eachedu.pay.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eachedu.dao.impl.BaseDaoImpl;
import com.eachedu.exception.DaoException;
import com.eachedu.pay.dao.IPayRecordDao;
import com.eachedu.pay.model.PayRecord;

/**
 * 
 * @author wzg
 *
 */
@Repository("payRecordDao")
public class PayRecordDaoImpl extends BaseDaoImpl<PayRecord, Long> implements IPayRecordDao{

	
}
