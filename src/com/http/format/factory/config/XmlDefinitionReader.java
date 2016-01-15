package com.http.format.factory.config;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.http.core.io.Resource;
import com.http.format.factory.bean.XMLDataTag;
import com.http.format.factory.bean.XMLDefinition;
import com.http.format.factory.bean.XMLFormatElement;
import com.http.format.factory.bean.XMLHead;
import com.http.format.factory.bean.XmlField;
import com.http.format.factory.bean.XmlListField;
import com.http.utils.FileUtils;
import com.http.utils.XmlReaderUtils;

/**
 * xml解析器；负责xml 模板文件的解析工作，将xml统一封装成XMLBeanDefinition
 * 
 * @Project:JDMHA
 * @file:ConfigurableXmlReader.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月13日
 */
public class XmlDefinitionReader {
	
	/**
	 * 
	 * 加载Resource，解析xml模板文件
	 * 
	 * @author:chenssy
	 * @data:2016年1月13日
	 *
	 * @param resource
	 * @throws IOException 
	 */
	public void loadxmlDefinition(Resource resource){
		try {
			File file = resource.getFile();
			
			//解析Xml文件
			doLoadXmlDefinition(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解析Xml 模板文件
	 * 
	 * @author:chenssy
	 * @data:2016年1月13日
	 *
	 * @param file
	 */
	@SuppressWarnings("unchecked")
	private void doLoadXmlDefinition(File file) {
		SAXReader saxReader = new SAXReader();
		//构建XMLDefinition
		XMLDefinition definition = new XMLDefinition(FileUtils.getFileName(file));
		try {
			Document document = saxReader.read(file);
			Element root = document.getRootElement();
			Iterator<Element> iterator = root.elementIterator();
			while(iterator.hasNext()){
				Element element = iterator.next();
				String name = element.getName();
				if(XmlReaderUtils.XML_FORMAT.equalsIgnoreCase(name)){		//模板开始
					String elementId = element.attributeValue("id");  	//获取id属性值
					XMLFormatElement xmlElement = new XMLFormatElement(elementId);
					
					//迭代里面的标签
					Iterator<Element> eIterator = element.elementIterator();
					while(eIterator.hasNext()){
						Element eElement = eIterator.next();
						//解析标签头
						if(XmlReaderUtils.XML_HEAD.equalsIgnoreCase(eElement.getName())){
							xmlElement.setXmlHead(xmlHeadReader(eElement));
						}
						//解析数据标签
						else if(XmlReaderUtils.XML_DATA_TAG.equalsIgnoreCase(eElement.getName())){
							xmlElement.setXmlDataTag(xmlDataTagReader(eElement));
						}
					}
					
					if(xmlElement.getName().endsWith("Send")){				//发送模板标签
						definition.setSentFormatElement(xmlElement);
					}else if(xmlElement.getName().endsWith("Receive")){		//接收模板标签
						definition.setReceiveFormatElement(xmlElement);
					}
				}
			}
			//标签解析完毕，进行注册处理
			
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 解析模板文件数据标签
	 * 
	 * @author:chenssy
	 * @data:2016年1月14日
	 *
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private XMLDataTag xmlDataTagReader(Element element) {
		XMLDataTag dataTag = new XMLDataTag(element.attributeValue("tagName"));
		Iterator<Element> iterator = element.elementIterator();
		Element item = null;
		XmlField xmlField = null;
		XmlListField xmlListField = null;
		while(iterator.hasNext()){
			item = iterator.next();
			if(XmlReaderUtils.XML_DATA_TAG_XMLFIELD.equalsIgnoreCase(item.getName())){
				dataTag.addFiled(xmlFieldReader(item,xmlField));
			}
			else if(XmlReaderUtils.XML_DATA_TAG.equalsIgnoreCase(item.getName())){
				dataTag.addDataTags(xmlDataTagReader(element));
			}
			else if(XmlReaderUtils.XML_DATA_TAG_LIST.equalsIgnoreCase(item.getName())){
				dataTag.addListField(xmlListFieldReader(item,xmlListField));
			}
		}
		
		return dataTag;
	}
	
	/**
	 * 解析模板文件标签头
	 * 
	 * @author:chenssy
	 * @data:2016年1月14日
	 *
	 * @param element
	 * @return
	 */
	private XMLHead xmlHeadReader(Element element){
		String version = element.attributeValue(XmlReaderUtils.XML_HEAD_VERSION);
		String encoding = element.attributeValue(XmlReaderUtils.XML_HEAD_ENCODING);
		
		return new XMLHead(version, encoding);
	}
	
	/**
	 * 解析数据标签-集合
	 * @author:chenssy
	 * @data:2016年1月14日
	 *
	 * @param element
	 * @param xmlListField
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private XmlListField xmlListFieldReader(Element element,XmlListField xmlListField) {
		xmlListField = new XmlListField(
				element.attributeValue(XmlReaderUtils.XML_DATA_TAG_TAG_NAME),
				element.attributeValue(XmlReaderUtils.XML_DATA_TAG_CLASS_NAME));
		
		//解析子节点
		Iterator<Element> iterator = element.elementIterator();
		Element item = null;
		XmlField xmlField = null;
		while(iterator.hasNext()){
			item = iterator.next();
			if(XmlReaderUtils.XML_DATA_TAG_XMLFIELD.equalsIgnoreCase(item.getName())){
				xmlListField.addField(xmlFieldReader(item, xmlField));
			}
			else if(XmlReaderUtils.XML_DATA_TAG_LIST.equalsIgnoreCase(item.getName())){
				xmlListField.addXmlListField(xmlListFieldReader(item, xmlListField));
			}
		}
		
		return xmlListField;
	}

	/**
	 * 解析数据标签基本数据列
	 * 
	 * @author:chenssy
	 * @data:2016年1月14日
	 *
	 * @param item
	 * @param xmlField
	 * @return
	 */
	private XmlField xmlFieldReader(Element item,XmlField xmlField){
		xmlField = new XmlField();
		xmlField.setClassName(item.attributeValue(XmlReaderUtils.XML_DATA_TAG_CLASS_NAME));
		xmlField.setDataName(item.attributeValue(XmlReaderUtils.XML_DATA_TAG_DATA_NAME));
		xmlField.setTagName(item.attributeValue(XmlReaderUtils.XML_DATA_TAG_TAG_NAME));
		
		return xmlField;
	}
}
