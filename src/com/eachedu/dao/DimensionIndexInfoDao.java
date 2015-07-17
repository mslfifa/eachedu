package com.eachedu.dao;

import java.util.List;

import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.web.vo.PagerVO;

public interface DimensionIndexInfoDao extends BaseDao{

	List<DimensionIndexInfo> findDiiByDscId(Long dscId);

	PagerVO findPage(DimensionIndexInfo dii);

	List<DimensionIndexInfo> findDiiSiblingsByDiiId(Long diiId, String fieldType);

}
