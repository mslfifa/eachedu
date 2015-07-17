package com.eachedu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eachedu.dao.DataSourceCfgDao;
import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.web.vo.PagerVO;
@Repository("dataSourceCfgDao")
public class DataSourceCfgDaoImpl extends BaseDaoImpl implements
		DataSourceCfgDao {

	@Override
	public PagerVO findPage(DataSourceCfg dsc) {
		StringBuffer hql = new StringBuffer("from DataSourceCfg t where 1=1 ");
		List para = new ArrayList();
		if(dsc!=null){
			if(StringUtils.isNotEmpty(dsc.getTableDbName())){
				hql.append(" and t.tableDbName like ? ");
				para.add("%"+dsc.getTableDbName()+"%");
			}
			if(StringUtils.isNotEmpty(dsc.getTableBusName())){
				hql.append(" and t.tableBusName like ? ");
				para.add("%"+dsc.getTableBusName()+"%");
			}
		}
		
		return findPaginated(hql.toString(),para.toArray(new Object[0]));
	}

}
