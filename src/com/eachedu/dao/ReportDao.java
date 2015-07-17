package com.eachedu.dao;

import java.util.List;

import com.eachedu.web.vo.PagerVO;

public interface ReportDao extends BaseDao {
	List findReportCascadeById(Long riId);

	PagerVO findReportPageByUserId(String userid);
	
}
