package cn.com.bonc.test.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.eachedu.dao.pojo.ReportInfo;
import com.eachedu.service.ReportService;

import cn.com.bonc.test.service.base.SpringJunitBase;

public class TestReportService extends SpringJunitBase{
	
	private Logger log = LoggerFactory.getLogger(TestReportService.class);
	
	@Autowired
	private ReportService reportSerice;
	
	@Test
	public void testFind(){
		List list  = reportSerice.findReportCascadeById(31l);
		Assert.assertNotNull(list);
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Map map = (Map) iterator.next();
			Set keys = map.keySet();
			for (Iterator iterator2 = keys.iterator(); iterator2.hasNext();) {
				String key = (String) iterator2.next();
				log.debug(key+":"+map.get(key)+"|");
			}
			
		}
	}
	
	@Rollback(false)
	@Test
	public void testSave(){
		ReportInfo bean = new ReportInfo();
		bean.setUserid("u0001");
		bean.setCreateTime(new Date());
		bean.setReportVersion("1.1.1");
		bean.setReportName("test_report");
		bean.setReportDataPeriod("month_type");
		reportSerice.saveReport(bean);
		
		Assert.assertNotNull(bean.getRiId());
		System.out.println("@@@@@@@@@@"+(bean.getRiId()==null?"空":bean.getRiId()));
	}
}
