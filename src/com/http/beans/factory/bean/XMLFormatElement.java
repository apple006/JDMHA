package com.http.beans.factory.bean;

/**
 * 报文模板<br>
 * 一个报文模板文件包括两个报文模板，一个是发送报文模板，一个接收报文模板<br>
 * 模板中主要包括两个元素：报文头head、报文数据标签dataTag<br>
 * 报文头head主要包括版本号（version）、编码（encoding）;报文数据标签dataTag主要是报文的数据报文部分
 * 
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
	
	/** 
	 * 报文模板名称 <br>
	 * 发送报文模板名称为****Send(如：JK00001Send)；接收报文模板名称为****Receive（如：JK00001Reveive）
	 */
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
