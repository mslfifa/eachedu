package com.eachedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.DataSourceCfgDao;
import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.service.DataSourceCfgService;
import com.eachedu.web.vo.PagerVO;
@Service("dataSourceCfgService")
public class DataSourceCfgServiceImpl implements DataSourceCfgService {
	@Autowired
	private DataSourceCfgDao dao;
	@Override
	public List<DataSourceCfg> findAll() {
		return dao.findAll(DataSourceCfg.class);
	}

	@Override
	public PagerVO findPage(DataSourceCfg dsc) {
		return dao.findPage(dsc);
	}

	@Override
	public DataSourceCfg getDscById(Long dscId) {
		return dao.findById(DataSourceCfg.class, dscId);
	}

	@Override
	public Long saveDsc(DataSourceCfg dsc) {
		dao.save(dsc);
		return dsc.getDscId();
	}

	@Override
	public void updateDsc(DataSourceCfg dsc) {
		dao.update(dsc);
	}

	@Override
	public void delDsc(Long dscId) {
		dao.del(dao.findById(DataSourceCfg.class, dscId));
	}

}
