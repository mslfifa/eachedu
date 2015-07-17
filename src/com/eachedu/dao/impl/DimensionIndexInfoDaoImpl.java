package com.eachedu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eachedu.dao.DimensionIndexInfoDao;
import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.web.vo.PagerVO;
@Repository("dimensionIndexInfoDao")
public class DimensionIndexInfoDaoImpl extends BaseDaoImpl implements
		DimensionIndexInfoDao {

	@Override
	public List<DimensionIndexInfo> findDiiByDscId(Long dscId) {
		String hql = "from DimensionIndexInfo where dscId=? ";
		return this.findByHql(hql, dscId);
	}

	@Override
	public PagerVO findPage(DimensionIndexInfo dii) {
		StringBuffer sql = new StringBuffer(300);
		List paras = new ArrayList();
		sql.append(" from DimensionIndexInfo where 1=1 ");
		if(dii!=null){
			if(dii.getDscId()!=null){
				sql.append(" and dscId = ? ");
				paras.add(dii.getDscId());
			}
			
			if(StringUtils.isNotEmpty(dii.getFieldDbName())){
				sql.append(" and fieldDbName = ? ");
				paras.add(dii.getFieldDbName());
			}
			if(StringUtils.isNotEmpty(dii.getFieldBusName())){
				sql.append(" and fieldBusName = ? ");
				paras.add(dii.getFieldBusName());
			}
			
			if (StringUtils.isNotEmpty(dii.getFieldType())) {
				sql.append(" and fieldType = ? ");
				paras.add(dii.getFieldType());
			}
		}
		
		return findPaginated(sql.toString(), paras.toArray(new Object[0]));
	}

	@Override
	public List<DimensionIndexInfo> findDiiSiblingsByDiiId(Long diiId,
			String fieldType) {
		StringBuffer hql = new StringBuffer(200);
		List para = new ArrayList();
		hql.append("select dii from DimensionIndexInfo dii where dii.dscId = some(select dii1.dscId from DimensionIndexInfo dii1 where diiId = ? ) ");
		para.add(diiId);
		if(StringUtils.isNotEmpty(fieldType)){
			hql.append(" and fieldType = ? ");
			para.add(fieldType);
		}
		
		return findByHql(hql.toString(), para.toArray(new Object[0]));
	}

}
