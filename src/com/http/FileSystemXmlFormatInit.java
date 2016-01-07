package com.http;

import javax.servlet.ServletContextEvent;

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
	
	@Override
	public void contextInitialized(ServletContextEvent context) {
		super.contextInitialized(context);
	}
	
	public void initalizeXmlFormat(){
		
	}
}
