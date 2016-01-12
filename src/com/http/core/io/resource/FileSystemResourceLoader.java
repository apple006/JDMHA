package com.http.core.io.resource;

import java.util.List;

import com.http.core.io.Resource;

public class FileSystemResourceLoader extends DefaultResourceLoader{
	/** 资源路径 */
	private String fileLocation;
	
	public FileSystemResourceLoader(String location){
		this.fileLocation = location;
	}
	
	private List<Resource> getResource(){
		
		return null;
	}
}	
