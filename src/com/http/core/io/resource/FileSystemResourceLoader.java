package com.http.core.io.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.http.core.io.Resource;
import com.http.utils.FileUtils;

public class FileSystemResourceLoader extends DefaultResourceLoader{
	/** 资源路径 */
	private String location;
	
	public FileSystemResourceLoader(String location){
		this.location = location;
	}
	
	/**
	 * 获取资源，资源统一封装为Resource
	 * 
	 * @author:chenssy
	 * @data:2016年1月13日
	 *
	 * @return
	 */
	public List<Resource> getResource(){
		//对路径进行处理，防止不合法路径
		location = location.replace('\\', '/');	
		int idx = location.lastIndexOf( '/');
		if (location.lastIndexOf('/') != -1) {
			location = location.substring(0, idx + 1);
		}
		//获取该路径下所有的xml资源
		FileSystemResource resource = null;
		List<Resource> resources = new ArrayList<Resource>();
		
		List<File> files = FileUtils.getFiles(location);
 		for(File file : files){
			resource = new FileSystemResource(file);
			resources.add(resource);
		}
		return resources;
	}
}	
