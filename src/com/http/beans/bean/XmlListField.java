package com.http.beans.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板文件的集合列数据<br>
 * 一个XmlListField包含多个xmlFields、xmlListFields
 * @Project:JDMHA
 * @file:XmlListField.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月15日
 */
public class XmlListField {
	private String tagName;
	
	private String className;
	
	private List<XmlField> xmlFields;
	
	private List<XmlListField> xmlListFields;
	
	public XmlListField(){
		this("", "", new ArrayList<XmlField>(),new ArrayList<XmlListField>());
	}
	
	public XmlListField(String tagName,String className){
		this(tagName,className,new ArrayList<XmlField>(),new ArrayList<XmlListField>());
	}
	
	
	public XmlListField(String tagName,String className,List<XmlField> xmlFields,List<XmlListField> xmlListFields){
		this.tagName = tagName;
		this.className = className;
		this.xmlFields = xmlFields;
		this.xmlListFields = xmlListFields;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<XmlField> getXmlFields() {
		return xmlFields;
	}

	public void setXmlFields(List<XmlField> xmlFields) {
		this.xmlFields = xmlFields;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public List<XmlListField> getXmlListFields() {
		return xmlListFields;
	}

	public void setXmlListFields(List<XmlListField> xmlListFields) {
		this.xmlListFields = xmlListFields;
	}

	public void addField(XmlField xmlField){
		this.xmlFields.add(xmlField);
	}
	
	public void addXmlListField(XmlListField xmlListField){
		this.xmlListFields.add(xmlListField);
	}
}
