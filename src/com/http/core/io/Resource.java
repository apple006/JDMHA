package com.http.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * Resource对资源的抽象，提供统一的资源访问策略
 * 
 * @Project:JDMHA
 * @file:Resource.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月5日
 */
public interface Resource {
	/**
	 * 资源是否存在
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @return
	 */
	boolean exists();
	
	/**
	 * 资源是否可读
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @return
	 */
	boolean isReadable();
	
	/**
	 * 
	 * 用于判断当前资源是否代表一个已打开的输入流，如果结果为 true ，则表示当前资源的输入流不可多次读取，
	 * 而且在读取以后需要对它进行关闭，以防止内存泄露。<br>
	 * 该方法主要针对于 InputStreamResource ，实现类中只有它的返回结果为 true ，其他都为 false 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @return
	 */
	boolean isOpen();
	
	/**
	 * 返回当前资源对应的 URL
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @return
	 * @throws IOException
	 */
	URL getURL() throws IOException;
	
	/**
	 * 返回当前资源对应的 URI
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @return
	 * @throws IOException
	 */
	URI getURI() throws IOException;
	
	/**
	 * 返回当前资源对应的 File
	 * 
	 * @author:chenssy
	 * @data:2016年1月12日
	 *
	 * @return
	 * @throws IOException
	 */
	File getFile() throws IOException;
}
