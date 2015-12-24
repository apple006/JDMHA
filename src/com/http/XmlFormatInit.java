package com.http;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * XmlFormatInit初始化xml文件的入口<br>
 * 
 * @Project:JDMHA
 * @file:XmlFormatInit.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2015年12月22日
 */
public class XmlFormatInit extends ContextLoaderListener{
	/**
	 * xml配置文件的文件路径
	 */
	private final String XML_PATH = "/WEB-INF/formats/";
	
	private	final Logger logger = Logger.getLogger(XmlFormatInit.class);
	
	private static ApplicationContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent context) {
		try {
			super.contextInitialized(context);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		setContext(WebApplicationContextUtils.getRequiredWebApplicationContext(context.getServletContext()));
	
		/*
		 * 初始化xml配置文件
		 * xml配置文件初始化主要分三个阶段：资源定位、资源解析、资源注入
		 * 资源定位：
		 * 资源解析：
		 * 资源注入
		 */
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
}
