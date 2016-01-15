package com.http.beans.bean;

/**
 * 报文模板头部信息
 * 
 * @Project:JDMHA
 * @file:XMLHead.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2015年12月30日
 */
public class XMLHead {
	/** 版本号 */
	private String version;
	
	/** 编码 */
	private String encoding;
	
	public XMLHead(){
		this(null, null);
	}
	
	public XMLHead(String version,String encoding){
		this.version = version;
		this.encoding = encoding;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
