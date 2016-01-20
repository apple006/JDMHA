package com.http.beans.factory.config;

import java.util.Map;

import org.dom4j.Document;

import com.http.beans.factory.format.XmlFormatFactory;

/**
 * xml格式化工厂调度工厂
 * @Project:JDMHA
 * @file:ConfigurableXmlFormatFactory.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月19日
 */
public class ConfigurableXmlFormatFactory {
	
	/**
	 * 构建xml模板
	 * @author:chenssy
	 * @data:2016年1月19日
	 *
	 * @param params
	 * @param definitionName
	 * @return
	 */
	public static String buildXmlStringFormFormat(Map<String, Object> params,String definitionName){
		return buildXmlDocumentFormFormat(params, definitionName).asXML();
	}
	
	/**
	 * 构建xml模板
	 * @author:chenssy
	 * @data:2016年1月19日
	 *
	 * @param params
	 * @param definitionName
	 * @return
	 */
	public static Document buildXmlDocumentFormFormat(Map<String, Object> params,String definitionName){
		XmlFormatFactory formatFactory = XmlFormatFactory.getInstance();
		return formatFactory.buildXmlFormFormat(params, definitionName);
	}
}
