package com.http.format.factory.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties配置见工厂类<br>
 * 
 * @Project:JDMHA
 * @file:PropertiesFactory.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月6日
 */
public class PropertiesFactory {
	/** 配置文件地址 */
	private final static String PROPERTIES_PATH = "";
	
	private static Properties properties = null;
	
	/**
	 * 加载Properties配置文件
	 * 
	 * @author:chenssy
	 * @data:2016年1月6日
	 *
	 */
	public static void loadProperties(){
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(PROPERTIES_PATH));
			
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取指定的key值，若不存在则返回null
	 * 
	 * @author:chenssy
	 * @data:2016年1月6日
	 *
	 * @param key
	 * @return
	 */
	public static String getProperties(String key){
		String value = null;
		if(properties != null){
			value = properties.getProperty(key);
		}
		return value;
	}
}
