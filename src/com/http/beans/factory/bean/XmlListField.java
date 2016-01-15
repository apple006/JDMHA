package com.http.beans.factory.bean;

import java.util.ArrayList;
import java.util.List;

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
