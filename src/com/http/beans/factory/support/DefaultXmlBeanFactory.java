package com.http.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.http.beans.factory.XmlBeanFactory;
import com.http.beans.factory.bean.XMLDefinition;
import com.http.beans.factory.exception.XmlDefinitionException;
import com.http.utils.Assert;


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
	private final Map<String, XMLDefinition> DEFINITION_MAP = new ConcurrentHashMap<>();

	private static DefaultXmlBeanFactory factory = null;
	
	/** 私有构造器 */
	private DefaultXmlBeanFactory(){
		
	}
	
	public static DefaultXmlBeanFactory getInstance(){
		if(factory == null){
			synchronized (DefaultXmlBeanFactory.class) {
				factory = new DefaultXmlBeanFactory();
			}
		}
		
		return factory;
	}
	
	/**
	 * 注册Definition
	 * 
	 * @author:chenssy
	 * @data:2016年1月15日
	 *
	 * @param definition
	 */
	public void registerXmlDefinition(XMLDefinition definition){
		Assert.notNull(definition, "xmlDefinition must not be null");
		Assert.notNull(definition.getXmlId(), "xml id must not be null");
		
		/*
		 *判断该bean是否已经存在了
		 */
		XMLDefinition oldDefinition = DEFINITION_MAP.get(definition.getXmlId());
		if(oldDefinition != null){
			throw new XmlDefinitionException(definition.getXmlId() + "已经存在了");
		}else{
			this.DEFINITION_MAP.put(definition.getXmlId(), definition);
		}
	}
	
	/**
	 * 取出Definition
	 * 
	 * @author:chenssy
	 * @data:2016年1月15日
	 *
	 * @param definitionName
	 */
	public XMLDefinition getXmlDefinition(String definitionName){
		Assert.notNull(definitionName, "definitionName must not be null");
		XMLDefinition definition = this.DEFINITION_MAP.get(definitionName);
		
		if(definition == null){
			throw new XmlDefinitionException(definitionName + "not be found");
		}
		
		return definition;
	}
}
