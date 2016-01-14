package com.http.format.factory.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.http.format.factory.XmlBeanFactory;
import com.http.format.factory.bean.XMLDefinition;


/**
 * XmlBeanFactory的默认实现
 * 
 * @Project:JDMHA
 * @file:DefaultXmlBeanFactory.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月11日
 */
public class DefaultXmlBeanFactory implements XmlBeanFactory{
	/**
	 * XMLDefinition的数据池
	 */
	private static final Map<String, XMLDefinition> DEFINITION_MAP = new ConcurrentHashMap<>();

	
}
