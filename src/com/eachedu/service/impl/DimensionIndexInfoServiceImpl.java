package com.eachedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eachedu.dao.DimensionIndexInfoDao;
import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.service.DimensionIndexInfoService;
import com.eachedu.web.vo.PagerVO;
@Service("dimensionIndexInfoService")
public class DimensionIndexInfoServiceImpl implements DimensionIndexInfoService {
	@Autowired
	private DimensionIndexInfoDao dao;
	
	@Override
	public List<DimensionIndexInfo> findDiiByDscId(Long dscId) {
		return dao.findDiiByDscId(dscId);
	}

	@Override
	public PagerVO findPage(DimensionIndexInfo dii) {
		// TODO Auto-generated method stub
		return dao.findPage(dii);
	}

	@Override
	public DimensionIndexInfo getDiiById(Long diiId) {
		// TODO Auto-generated method stub
		return dao.findById(DimensionIndexInfo.class, diiId);
	}

	@Override
	public Long saveDii(DimensionIndexInfo dii) {
		dao.save(dii);
		return dii.getDiiId();
	}

	@Override
	public void updateDii(DimensionIndexInfo dii) {
		dao.update(dii);
	}

	@Override
	public void delDii(Long diiId) {
		dao.del(this.getDiiById(diiId));
	}

	@Override
	public List<DimensionIndexInfo> findDiiSiblingsByDiiId(Long diiId, String fieldType) {
		return dao.findDiiSiblingsByDiiId(diiId, fieldType);
	}

}
