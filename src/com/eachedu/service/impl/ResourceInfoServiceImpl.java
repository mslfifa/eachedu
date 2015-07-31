package com.eachedu.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.eachedu.dao.BaseDao;
import com.eachedu.dao.pojo.ResourceInfo;
import com.eachedu.dict.ResourceType;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.ResourceInfoService;
import com.eachedu.utils.PropUtils;
@Service("resourceInfoService")
public class ResourceInfoServiceImpl extends BaseServiceImpl<ResourceInfo, Long>implements ResourceInfoService {
	@Resource(name="resourceInfoDao")
	@Override
	public void setDao(BaseDao<ResourceInfo, Long> dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Override
	public Long saveResourceByFile(String resourceType, File file, String fileName, String contentType)
			throws ServiceException {
		try {
			ResourceType[] rArr = ResourceType.values();
			boolean containVal = false;
			for (int i = 0; i < ResourceType.values().length; i++) {
				ResourceType r = rArr[i];
				if(rArr[i].name().equals(resourceType)){
					containVal = true;
					break;
				}
			}
			
			if(containVal==false){
				throw new Exception("resourceType["+resourceType+"]不在值域范围内，请与管理员联系");
			}
			
			if(file==null){
				throw new Exception("上传文件为空，请重新选择文件再上传.");
			}
			
			ResourceInfo pojo = new ResourceInfo();
			pojo.setResourceType(resourceType);
			pojo.setResouceOriginName(fileName);
			
			String uploadDir = PropUtils.get("dir_upload_root");
			
			/*dir_head_short_pic=head_short
					dir_certificate_pic=certificate
					dir_question_pic=question
					dir_answer_pic=answer
					dir_courseware_pic=courseware*/
			
			String busDir = "";
			
			if(ResourceType.HEAD_SHORT_TYPE.equals(resourceType)){
				busDir = PropUtils.get("dir_head_short_pic");
			}else if(ResourceType.CERTIFICATE_TYPE.equals(resourceType)){
				busDir = PropUtils.get("dir_certificate_pic");
			}else if(ResourceType.ANSWER_PIC_TYPE.equals(resourceType)){
				busDir = PropUtils.get("dir_answer_pic");
			}else if(ResourceType.QUESTION_PIC_TYPE.equals(resourceType)){
				busDir = PropUtils.get("dir_question_pic");
			}else if(ResourceType.COURSEWARE_TYPE.equals(resourceType)){
				busDir = PropUtils.get("dir_courseware_pic");
			}
			
			fileName= (StringUtils.isEmpty(fileName))?file.getName():fileName;
			String relativeDir = uploadDir+"/"+busDir;
			pojo.setRelativeDir(relativeDir);
			String resourceRealName = UUID.randomUUID().toString()+fileName.substring(fileName.indexOf("."), fileName.length());
			pojo.setResourceRealName(resourceRealName);
			FileInputStream fis = new FileInputStream(file);
			pojo.setResourceSize(fis.available());
			pojo.setCreateTime(new Date());
			dao.save(pojo);
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e.getCause());
		}
	}
}
