package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.web.vo.PagerVO;

public interface DataSourceCfgService {
	
	PagerVO findPage(DataSourceCfg dsc);
	
	List<DataSourceCfg> findAll();
	
	DataSourceCfg getDscById(Long dscId);
	
	Long saveDsc(DataSourceCfg dsc);
	
	void updateDsc(DataSourceCfg dsc);
	
	void delDsc(Long dscId);
}
