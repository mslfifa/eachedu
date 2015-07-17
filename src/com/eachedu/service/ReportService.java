package com.eachedu.service;

import java.util.List;

import com.eachedu.dao.pojo.ChartCfg;
import com.eachedu.dao.pojo.LayoutTemplateCfg;
import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.dao.pojo.SummaryCfg;
import com.eachedu.service.vo.ReportInfoVO;
import com.eachedu.web.vo.PagerVO;

public interface ReportService {
	List findReportCascadeById(Long riId);
	
	ReportInfoVO findReportVoByRiId(Long riId);
	
	void saveReport(ReportInfo bean);
	
	void updateReport(ReportInfo bean);

	PagerVO findReportPageByUserId(String userid);
	
	ReportInfo getReport(Long riId);

	void updateCascase(LayoutTemplateCfg layout, ChartCfg chart,
			SummaryCfg summary);
}
