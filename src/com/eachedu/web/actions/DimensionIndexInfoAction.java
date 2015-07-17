package com.eachedu.web.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.DataSourceCfg;
import com.eachedu.dao.pojo.DimensionIndexInfo;
import com.eachedu.service.DataSourceCfgService;
import com.eachedu.service.DimensionIndexInfoService;
import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.LoginInfoVO;
import com.eachedu.web.vo.PagerVO;

@Controller("dimensionIndexInfoAction")
@Scope("prototype")
public class DimensionIndexInfoAction extends BaseAction {
	@Autowired
	private DataSourceCfgService dscService;
	@Autowired
	private DimensionIndexInfoService service;
	
	private DimensionIndexInfo dii;
	

	public DimensionIndexInfo getDii() {
		return dii;
	}

	public void setDii(DimensionIndexInfo dii) {
		this.dii = dii;
	}
	

	/**
	 * 根据数据源ID查找维度指标对象
	 */
	public void findDiiByDscId(){
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			List<DimensionIndexInfo> dimensions = new ArrayList<DimensionIndexInfo>();
			List<DimensionIndexInfo> indexs = new ArrayList<DimensionIndexInfo>();
			
			List<DimensionIndexInfo> diis = service.findDiiByDscId(dii.getDscId());
			for (Iterator iterator = diis.iterator(); iterator.hasNext();) {
				DimensionIndexInfo dii = (DimensionIndexInfo) iterator.next();
				// dimensioned:维度  indexed:指标
				if("dimensioned".equals(dii.getFieldType())){
					dimensions.add(dii);
				}else if("indexed".equals(dii.getFieldType())){
					indexs.add(dii);
				}
			}
			
			result.put("status", true);
			result.put("info", "构造成功!");
			result.put("dimensions", dimensions);
			result.put("indexs", indexs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status", false);
			result.put("info", "构造失败!原因["+e.getMessage()+"]");
		}finally{
			this.ajaxWriteOutJSON(result);
		}
		
	}
	
	/**
	 * 转向新增修改页面
	 * @return
	 */
	public String modifyDiiPage(){
		if(dii!=null && dii.getDiiId()!=null){
			dii = service.getDiiById(dii.getDiiId());
		}
		setAttribute("dii",dii);
		return "edit_dii_page";
	}
	
	/**
	 * 新增修改操作
	 * @throws IOException
	 */
	public void persistDii() throws IOException{
		boolean flag = false;
		String msg = "";
		
		try {
			
			dii.setCreateTime(new Date());
			LoginInfoVO userVO = (LoginInfoVO)getSession(ConstUtils.USER_LOGIN);
			dii.setCreateId(userVO.getUserid());
			if (dii.getDiiId()==null) {
				service.saveDii(dii);
			}else{
				service.updateDii(dii);
			}
			flag = true;
			msg = "操作成功!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			flag=false;
			msg="操作失败!原因["+e.getMessage()+"]";
		}finally{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setContentType("text/html; charset=UTF-8");
			String scriptStr = "<script type='text/javascript'>";
			if(flag==true){
				scriptStr += " window.opener.reloadDii();";
			}
			
			scriptStr += " alert('"+msg+"'); window.close(); ";
			scriptStr += "</script>";
			ServletActionContext.getResponse().getWriter().println(scriptStr);
			ServletActionContext.getResponse().getWriter().flush();
		}
		
	}
	
	/**
	 * 删除 DimensionIndexInfo 操作
	 * @throws IOException
	 */
	public void delDii() throws IOException{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			
			if(dii==null || dii.getDiiId()==null){
				throw new Exception("不能删除空ID实体!");
			}
			
			service.delDii(dii.getDiiId());
			result.put("status", true);
			result.put("info", "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("info", "删除失败!原因["+e.getMessage()+"]");
		}
		ajaxWriteOutJSON(result);
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String listDiiPage(){
		DataSourceCfg dsc = dscService.getDscById(dii.getDscId());
		setAttribute("dsc", dsc);
		PagerVO page = service.findPage(dii);
		setAttribute("pv", page);
		return "list_dii_page";
	}
	
}
