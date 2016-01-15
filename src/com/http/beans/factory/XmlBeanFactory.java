package com.http.beans.factory;

import com.http.beans.bean.XMLDefinition;

/**
 * xml Bean 的核心接口
 * @Project:JDMHA
 * @file:XmlBeanFactory.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月15日
 */
public interface XmlBeanFactory {
	
	/**
	 * 注册Definition
	 * 
	 * @author:chenssy
	 * @data:2016年1月15日
	 *
	 * @param definition
	 */
	public void registerXmlDefinition(XMLDefinition definition);
	
	/**
	 * 读取Definition
	 * 
	 * @author:chenssy
	 * @data:2016年1月15日
	 *
	 * @param definitionName
	 * @return
	 */
	public XMLDefinition getXmlDefinition(String definitionName);
}
