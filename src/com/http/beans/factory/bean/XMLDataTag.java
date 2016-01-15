package com.http.beans.factory.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 报文模板，数据格式<br>
 * 报文数据主要存在两类，一类是基本的数据，还有一类是集合型的数据
 * 
 * @Project:JDMHA
 * @file:XMLDataTag.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2015年12月30日
 */
public class XMLDataTag {
	/**
	 * tag name
	 */
	private String name;
	
	/** 报文数据：基本数据 */
	private List<XmlField> xmlFields;
	
	/** 报文数据：集合类数据  */
	private List<XmlListField> xmlListFields;
	
	private List<XMLDataTag> xmlDataTags;
	
	public XMLDataTag(){
		this("");
	}
	
	public XMLDataTag(String name){
		this.name = name;
		xmlFields = new ArrayList<XmlField>();
		xmlListFields = new ArrayList<XmlListField>();
		xmlDataTags = new ArrayList<XMLDataTag>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<XmlField> getXmlFields() {
		return xmlFields;
	}

	public void setXmlFields(List<XmlField> xmlFields) {
		this.xmlFields = xmlFields;
	}

	public List<XmlListField> getXmlListFields() {
		return xmlListFields;
	}

	public void setXmlListFields(List<XmlListField> xmlListFields) {
		this.xmlListFields = xmlListFields;
	}

	public List<XMLDataTag> getXmlDataTags() {
		return xmlDataTags;
	}

	public void setXmlDataTags(List<XMLDataTag> xmlDataTags) {
		this.xmlDataTags = xmlDataTags;
	}

	public void addFiled(XmlField xmlField){
		this.xmlFields.add(xmlField);
	}
	
	public void addListField(XmlListField xmlListField){
		this.xmlListFields.add(xmlListField);
	}
	
	public void addDataTags(XMLDataTag xmlDataTag){
		this.xmlDataTags.add(xmlDataTag);
	}
}
