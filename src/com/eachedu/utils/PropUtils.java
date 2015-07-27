package com.eachedu.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropUtils {
	
	private static final Properties prop = new Properties();
	
	
	static{
		try {
			prop.load(PropUtils.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static String get(String key){
		return prop.getProperty(key, "");
	}
	

}
