package com.http;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.http.format.factory.XmlBeanFactory;
import com.http.format.factory.config.DefaultXmlBeanFactory;
import com.http.format.factory.config.PropertiesFactory;

/**
 * 
 * xml模板初始化入口<br>
 * 
 * 
 * @Project:JDMHA
 * @file:AbStractFormatInit.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月5日
 */
public abstract class AbstractFormatInit extends ContextLoaderListener{
	private	final Logger logger = Logger.getLogger(AbstractFormatInit.class);
	
	private static ApplicationContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent context) {
		try {
			super.contextInitialized(context);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		setContext(WebApplicationContextUtils.getRequiredWebApplicationContext(context.getServletContext()));
		
		//解析properties配置文件
		PropertiesFactory.loadProperties();
		
		/*
		 * 调用初始化方法
		 * 采用模板方法模式，该方法由具体的子类来实现
		 */
		initalizeXmlFormat();
	}

	/**
	 * 
	 * 初始化入口；由子类来实现<br>
	 * 初始化过程主要包括三个步骤：1资源定位、2资源解析、3注入<br>
	 * 1资源定位。Resource接口提供统一的资源、ResourceLoader提供统一的资源加载策略。资源定位返回为File[]<br>
	 * 2资源解析。采用SAX来完成对xml文件的解析，全部解析为统一的数据结构XMLDefinition<br>
	 * 3注入。将XMLDefinition注入容器当中，容器其本身就是一个HashMap的数据结构
	 * 
	 * @author:chenssy
	 * @data:2016年1月5日
	 *
	 */
	public abstract void initalizeXmlFormat();
	
	/**
	 * 
	 * 
	 * @author:chenssy
	 * @data:2016年1月11日
	 *
	 * @return
	 */
	protected XmlBeanFactory createBeanFactory(){
		return new DefaultXmlBeanFactory();
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
}
