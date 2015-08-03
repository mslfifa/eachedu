package com.eachedu.app.actions;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.dict.ResourceType;
import com.eachedu.service.ResourceInfoService;
import com.eachedu.utils.PropUtils;
import com.eachedu.web.actions.BaseAction;
@Controller("resourcePubAppAction")
@Scope("prototype")
public class ResourcePubAppAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(ResourcePubAppAction.class);
	
	@Resource(name="resourceInfoService")
	private ResourceInfoService resourceInfoService;
	
	private Long riId;
	public Long getRiId() {
		return riId;
	}
	public void setRiId(Long riId) {
		this.riId = riId;
	}

	public void download(){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			log.debug("@@@@ param -> riId:"+riId);
			
			ResourceInfo r = resourceInfoService.get(riId);
			
			if(ResourceType.COURSEWARE_TYPE.name().equals(r.getResourceType()) ){
				throw new Exception("资源ID["+riId+"]是收费资源,请登录后下载.");
			}
			
			String relativeDir = r.getRelativeDir();
			String fileName = r.getResourceRealName();
			String filePath = PropUtils.get("dir_upload_root")+"/"+relativeDir+"/"+fileName;
			log.debug("#### filePath:"+filePath);
			File file = new File(filePath);
			if(!file.exists()){
				throw new Exception("资源ID["+riId+"]对应的文件不存在,请与管理员联系.");
			}
			
			String originName = r.getResouceOriginName();
			originName = StringUtils.isEmpty(originName)?"no_name":originName;
			int contentLength = r.getResourceSize();
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(contentType);
			response.setContentLength(contentLength);
			response.setHeader("Content-Disposition","attachment;fileName="+URLEncoder.encode(originName, "UTF-8"));
			response.addHeader( "Pragma", "no-cache" );
			response.addHeader( "Cache-Control", "no-cache" );
			response.setDateHeader("Expires", 0);
			ServletOutputStream out = response.getOutputStream();
			
			FileInputStream fis = new FileInputStream(file);
			int b=0;
			byte[] buffer = new byte[10*1024];
			while (b!=-1) {
				b = fis.read(buffer);
				out.write(buffer,0,b);
			}
			log.info("@@@@@ 写完文件到输出流");
			
			out.flush();
			out.close();
			log.info("@@@@@ 输出流清理完毕");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.clear();
			result.put("http_status", false);
			result.put("http_msg", "下载文件出错!原因["+e.getMessage()+"]");
		}
		this.ajaxWriteOutJSON(result);
	}
	
}
