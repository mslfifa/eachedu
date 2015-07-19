package com.eachedu.test.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import com.eachedu.dao.pojo.OperatorInfo;
import com.eachedu.exception.ServiceException;
import com.eachedu.service.OperatorInfoService;
import com.eachedu.test.service.base.SpringJunitBase;

public class TestOperatorService extends SpringJunitBase {
	@Resource(name="operatorInfoService")
	private OperatorInfoService service;
	
	@Test
	public void testSave(){
		OperatorInfo pojo = new OperatorInfo();
		pojo.setAccount("chenyun");
		pojo.setName("陈云");
		pojo.setPassWord("123456");
		pojo.setEmail("chenyun@163.com");
		pojo.setQq("34564567");
		pojo.setMobile("13958470976");
		pojo.setCreateTime(new Date());
		
		try {
			service.save(pojo);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.notNull(pojo.getOiId());
		
	}
	
	@Test
	public void testUpdate(){
		try {
			OperatorInfo pojo = (OperatorInfo)service.get(1l);
			String newMobile = "15863798455";
			pojo.setMobile(newMobile );
			Date newDay = new Date();
			pojo.setCreateTime(newDay);
			service.update(pojo);
			OperatorInfo bean = (OperatorInfo)service.get(pojo.getOiId());
			Assert.isTrue(newMobile.equals(bean.getMobile()));
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
