package com.http.utils;

/**
 * xml 解析工具类
 * 
 * @Project:JDMHA
 * @file:XmlUtils.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月14日
 */
public class XmlReaderUtils {
	/**
	 * 报文模板
	 */
	public static final String XML_FORMAT = "xmlFmtElement";
	
	/** 报文头 */
	public static final String XML_HEAD = "xmlHead";
	
	/** 报文数据标签 */
	public static final String XML_DATA_TAG = "xmlDataTag";
	
	public static final String XML_DATA_TAG_LIST = "xmlList";
	
	/** 报文头---版本号 */
	public static final String XML_HEAD_VERSION = "version";
	
	/** 报文头---编码 */
	public static final String XML_HEAD_ENCODING = "encoding";
	
	/** 数据标签 */
	public static final String XML_DATA_TAG_XMLFIELD = "xmlField";
	
	public static final String XML_DATA_TAG_DATA_NAME = "dataName";
	
	public static final String XML_DATA_TAG_TAG_NAME = "tagName";
	
	public static final String XML_DATA_TAG_CLASS_NAME = "className";
}
