package com.eachedu.dao;

import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.web.vo.PagerVO;

public interface DataSourceCfgDao extends BaseDao {

	PagerVO findPage(DataSourceCfg dsc);

}
