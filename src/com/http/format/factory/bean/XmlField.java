package com.http.format.factory.bean;

/**
 * xml报文模板的基本数据
 * 
 * @Project:JDMHA
 * @file:XmlField.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2015年12月30日
 */
public class XmlField {
	/** 
	 * 模板对应的数据名称
	 * 如果是一般的数据集，则该值对应的则是传入参数hashMap的key值
	 * 如果是Java Bean 数据集，则该值对应的则是Java Bean中的属性名
	 */
	private String dataName;
	
	/** 模板对应的标签名称 */
	private String tagName;
	
	/** 
	 * 数据集对应的Java bean name
	 * 如果数据结果集是Java Bean，则该值一定要传入，否则可以为null，或者等于dataName
     */
	private String className;
	
	public XmlField(){
		
	}
	
	public XmlField(String dataName,String tagName,String className){
		this.dataName = dataName;
		this.tagName = tagName;
		this.className = className;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
