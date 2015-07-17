package com.eachedu.web.actions;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.service.DataSourceCfgService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.LoginInfoVO;
import com.eachedu.web.vo.PagerVO;

@Controller("dataSourceCfgAct")
@Scope("prototype")
public class DataSourceCfgAction extends BaseAction{
	@Autowired
	private DataSourceCfgService service;
	
	private DataSourceCfg dsc;
	
	private Long[] dscIds;
	
	public DataSourceCfg getDsc() {
		return dsc;
	}

	public void setDsc(DataSourceCfg dsc) {
		this.dsc = dsc;
	}

	public Long[] getDscIds() {
		return dscIds;
	}

	public void setDscIds(Long[] dscIds) {
		this.dscIds = dscIds;
	}

	public String listDscPage(){
		PagerVO page = service.findPage(dsc);
		setAttribute("pv", page);
		return "list_dsc_page";
	}
	
	
	public String modifyDscPage(){
		DataSourceCfg bean = null;
		if(dsc.getDscId()!=null){
			bean = service.getDscById(dsc.getDscId());
		}else{
			bean = new DataSourceCfg();
		}
		
		setAttribute("dsc", bean);
		return "data_sorce_edit_page";
	}
	
	public void persistDsc() throws IOException{
		String msg = "";
		boolean flag=false;
		try {
			dsc.setCreateTime(new Date());
			LoginInfoVO userVO = (LoginInfoVO)getSession(ConstUtils.USER_LOGIN);
			dsc.setCreateId(userVO.getUserid());
			if(dsc.getDscId()==null){
				service.saveDsc(dsc);
			}else{
				service.updateDsc(dsc);
			}
			
			msg="操作成功!";
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			msg="操作失败!原因["+e.getMessage()+"]";
			flag=false;
		}finally{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setContentType("text/html; charset=UTF-8");
			String scriptStr = "<script type='text/javascript'>";
			if(flag==true){
				scriptStr += " window.opener.reloadDataSource();";
			}
			
			scriptStr += " alert('"+msg+"'); window.close(); ";
			scriptStr += "</script>";
			ServletActionContext.getResponse().getWriter().println(scriptStr);
			ServletActionContext.getResponse().getWriter().flush();
		}
		
		
	}
	
	
	public void deleteDsc(){
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			if(dsc.getDscId()==null){
				throw new Exception("不能删除空主键实体!");
			}
			service.delDsc(dsc.getDscId());
			result.put("status", true);
			result.put("info", "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", true);
			result.put("info", "删除失败!原因["+e.getMessage()+"]");
		}
		
		ajaxWriteOutJSON(result);
		
	}
	
}
