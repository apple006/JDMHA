package com.http.format.factory.bean;

import java.util.List;

public class XmlListField {
	private String tagName;
	
	private List<XmlField> xmlFields;
	
	public XmlListField(){
		
	}
	
	public XmlListField(String tagName,List<XmlField> xmlFields){
		this.tagName = tagName;
		this.xmlFields = xmlFields;
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
	
}
