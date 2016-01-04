package com.http.format.factory.bean;

/**
 * 报文模板<br>
 * 模板中主要包括两个元素：报文头head、报文标签tag
 * @Project:JDMHA
 * @file:XMLFormatElement.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2015年12月30日
 */
public class XMLFormatElement {
	
	/** 报文模板名称  */
	private String name;
	
	/** 报文模板的头部信息，主要包括版本、编码 */
	private XMLHead xmlHead;
	
	/** 报文模板的数据标签  */
	private XMLDataTag xmlDataTag;
	
	public XMLFormatElement(String name){
		this(name, null, null);
	}
	
	public XMLFormatElement(String name,XMLHead xmlHead,XMLDataTag xmlDataTag){
		this.name = name;
		this.xmlHead = xmlHead;
		this.xmlDataTag = xmlDataTag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public XMLHead getXmlHead() {
		return xmlHead;
	}

	public void setXmlHead(XMLHead xmlHead) {
		this.xmlHead = xmlHead;
	}

	public XMLDataTag getXmlDataTag() {
		return xmlDataTag;
	}

	public void setXmlDataTag(XMLDataTag xmlDataTag) {
		this.xmlDataTag = xmlDataTag;
	}

}
