package com.http.beans.factory;

import com.http.beans.factory.bean.XMLDefinition;

public interface XmlBeanFactory {
	public void registerXmlDefinition(XMLDefinition definition);
	
	public XMLDefinition getXmlDefinition(String definitionName);
}
