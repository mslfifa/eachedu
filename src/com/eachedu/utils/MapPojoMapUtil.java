package com.eachedu.utils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eachedu.dao.pojo.CoursewareInfo;
import com.eachedu.dao.pojo.StudentInfo;

public class MapPojoMapUtil {
	private static final Logger log = LoggerFactory.getLogger(MapPojoMapUtil.class);

	public static Map<String,Object> copyPojoToMap(Object source) throws Exception{
		Map<String,Object> result= new HashMap<String,Object>();
		Class clazz = source.getClass();
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if(!"getClass".equals(methodName) && methodName.startsWith("get")){
				log.debug("### getter:"+methodName);
				String prop = methodName.substring(3, 4).toLowerCase()+methodName.substring(4,methodName.length());
				Object val = method.invoke(source);
				result.put(prop, val);
			}
		}
		return result;
	}
	
	
	public static Object copyMapToPojo(Map<String,Object> source,Class clazz) throws Exception{
		Object pojo = clazz.newInstance();
		Set<String> props = source.keySet();
		for (Iterator iterator = props.iterator(); iterator.hasNext();) {
			String prop = (String) iterator.next();
			Object val = source.get(prop);
			String setterName = "set"+prop.substring(0, 1).toUpperCase()+ prop.substring(1, prop.length());
			log.debug("@@@ setterName:"+setterName);
			Method method = clazz.getMethod(setterName, val.getClass());
			method.invoke(pojo, val);
		}
		return pojo;
	}
	
	public static void main(String[] args) throws Exception {
		StudentInfo s = new StudentInfo();
		s.setSiId(1l);
		s.setAccount("liming");
		s.setQq("47326455");
		s.setEmail("liming@163.com");
		s.setHeadShortId(5l);
		s.setSex("MALE");
		s.setCreateTime(new Date());
		
		Map<String, Object> sMap = copyPojoToMap(s);
		
		Iterator<String> ir = sMap.keySet().iterator();
		for (Iterator iterator =sMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			System.out.println("key:"+key+"|val:"+sMap.get(key));
		}
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ciId", 3l);
		map.put("gciId", 7l);
		map.put("courseTitle", "期中测试考试");
		map.put("introduce", "考核同学这段时间的学习成果!");
		map.put("picPath", "resource/pic/4875473.jpg");
		map.put("prise", new BigDecimal(30.6));
		
		CoursewareInfo pojo = (CoursewareInfo) copyMapToPojo(map,CoursewareInfo.class);
		
		System.out.println("getCiId:"+pojo.getCiId()+"|getGciId:"+pojo.getGciId()+"|getCourseTitle:"+pojo.getCourseTitle()+"|getIntroduce:"+pojo.getIntroduce()+"|getLegendId:"+pojo.getLegendId()+"|getPrise:"+pojo.getPrise());
	}
}
