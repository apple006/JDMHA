package com.http.core.io;

import java.util.List;

/**
 * ResourceLoader提供统一的资源加载策略<br>
 * ResourceLoader针对不同的Resource提供不同的资源加载策略
 * 
 * @Project:JDMHA
 * @file:ResourceLoader.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月5日
 */
public interface ResourceLoader {

	/**
	 * 获取资源
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @param location
	 * @return
	 */
	public List<Resource> getResources(String location);
}