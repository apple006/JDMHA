package com.http.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件服务工具类
 * 
 * @Project:JDMHA
 * @file:FileUtils.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月13日
 */
public class FileUtils {
	/**
	 * 递归获取某个路径下的所有文件
	 * 
	 * @author:chenssy
	 * @data:2016年1月13日
	 *
	 * @param location	资源路径
	 * @return
	 */
	public static List<File> getFiles(String location){
		List<File> lists = new ArrayList<>();
		
		File root = new File(location);
		File[] files = root.listFiles();
		
		if(files != null){		//目录存在，且不为空
			for(File file : files){
				//仅接受xml文件
				if(!file.isDirectory() && file.getName().toLowerCase().endsWith(".xml")){	
					lists.add(file);
				}else{//目录，递归调用
					getFiles(file.getAbsolutePath());
				}
			}
		}
		return lists;
	}
}
