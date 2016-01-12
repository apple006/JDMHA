package com.http.utils;

/**
 * 工具类
 * 
 * @Project:JDMHA
 * @file:Assert.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月12日
 */
public class Assert {
	
	/**
	 * 
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @param object
	 * @param message
	 */
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
