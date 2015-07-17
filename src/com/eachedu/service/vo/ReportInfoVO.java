package com.eachedu.service.vo;

import java.util.List;

import com.eachedu.dao.pojo.ReportInfo;

public class ReportInfoVO extends ReportInfo{
	//章节
	private List<LayoutTemplateCfgVO> layoutTemplateCfgVOs;

	public List<LayoutTemplateCfgVO> getLayoutTemplateCfgVOs() {
		return layoutTemplateCfgVOs;
	}

	public void setLayoutTemplateCfgVOs(
			List<LayoutTemplateCfgVO> layoutTemplateCfgVOs) {
		this.layoutTemplateCfgVOs = layoutTemplateCfgVOs;
	}

	

}
