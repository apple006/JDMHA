package com.http.beans.factory.bean;


/**
 * JDMHA 报文模板容器的内部数据结构，相当于 IoC容器的BeanDefinition
 * 
 * @Project:JDMHA
 * @file:XMLDefinition.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2015年12月29日
 */
public class XMLDefinition {
	/** xml文件编号 */
	private String xmlId;
	
	/** xml 发送报文模板 */
	private XMLFormatElement sentFormatElement;
	
	/** xml 接收报文模板  */
	private XMLFormatElement receiveFormatElement;
	
	public XMLDefinition(){
		
	}
	
	public XMLDefinition(String xmlId){
		this.xmlId = xmlId;
	}

	public String getXmlId() {
		return xmlId;
	}

	public void setXmlId(String xmlId) {
		this.xmlId = xmlId;
	}

	public XMLFormatElement getSentFormatElement() {
		return sentFormatElement;
	}

	public void setSentFormatElement(XMLFormatElement sentFormatElement) {
		this.sentFormatElement = sentFormatElement;
	}

	public XMLFormatElement getReceiveFormatElement() {
		return receiveFormatElement;
	}

	public void setReceiveFormatElement(XMLFormatElement receiveFormatElement) {
		this.receiveFormatElement = receiveFormatElement;
	}
}
