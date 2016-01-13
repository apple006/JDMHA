package com.http;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.http.core.io.Resource;
import com.http.format.factory.config.ConfigurablePropertiesFactory;

/**
 * 本地文件初始化，继承AbstractFormatInit
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
public class FileSystemXmlFormatInit extends AbstractFormatInit{
	private final String PATH = "classPath.file.path";
	
	@Override
	public void contextInitialized(ServletContextEvent context) {
		super.contextInitialized(context);
	}
	
	public void initalizeXmlFormat(){ 
		//获取context
		ServletContext context = getContextEvent().getServletContext();
		//获取资源路径
		String location = context.getRealPath("/") + ConfigurablePropertiesFactory.getProperties(PATH);;
		
		//资源定位
		List<Resource> resources = getResources(location);
		
		//资源解析
		
	}
}
