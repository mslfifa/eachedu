package com.eachedu.dao;

import com.eachedu.dao.pojo.SummaryCfg;

public interface SummaryCfgDao extends BaseDao {

	Long saveSummaryCfg(SummaryCfg bean);

	void delByLtcId(Long ltcId);

	void delByCcId(Long ccId);

}
