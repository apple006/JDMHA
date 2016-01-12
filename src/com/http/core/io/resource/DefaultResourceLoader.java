package com.http.core.io.resource;

import java.util.List;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.http.core.io.Resource;
import com.http.core.io.ResourceLoader;
import com.http.utils.Assert;

public class DefaultResourceLoader extends ContextLoaderListener implements ResourceLoader {

	@Override
	public void contextInitialized(ServletContextEvent context) {
		super.contextInitialized(context);
	}
	
	@Override
	public List<Resource> getResources(String location) {
		Assert.notNull(location, "location must be not null");
		if(location.startsWith("/")){		// '/'开头，File System
			return getResourcesByFileSystem(location);
		}else{		//URL system
			return getResourcesByUrlSystem(location);
		}
	}

	/**
	 * 获取File Resource
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @param location
	 * @return
	 */
	private List<Resource> getResourcesByFileSystem(String location) {
		FileSystemResourceLoader loader = new FileSystemResourceLoader(location);
		
		return null;
	}

	/**
	 * 获取URL Resource
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @param location
	 * @return
	 */
	private List<Resource> getResourcesByUrlSystem(String location) {
		return null;
	}
}
