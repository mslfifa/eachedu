package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.web.vo.PagerVO;

public interface DimensionIndexInfoService {
	List<DimensionIndexInfo> findDiiByDscId(Long dscId);
	
	/**
	 * 查维度同数据源的兄弟结点
	 * @param diiId
	 * @param fieldType
	 * @return
	 */
	List<DimensionIndexInfo> findDiiSiblingsByDiiId(Long diiId, String fieldType);

	PagerVO findPage(DimensionIndexInfo dii);
	
	DimensionIndexInfo getDiiById(Long diiId);
	
	Long saveDii(DimensionIndexInfo dii);
	
	void updateDii(DimensionIndexInfo dii);
	
	void delDii(Long diiId);
	
}
