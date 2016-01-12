package com.http.core.io.resource;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import com.http.core.io.Resource;
import com.http.utils.Assert;


public class FileSystemResource implements Resource{
	/**
	 * 资源
	 */
	private File file;
	
	FileSystemResource(File file){
		Assert.notNull(file, "File must not be null");
		this.file = file;
	}
	
	FileSystemResource(String path){
		Assert.notNull(path, "Path must not be null");
		this.file = new File(path);
	}
	
	
	@Override
	public boolean exists() {
		return file.exists();
	}

	@Override
	public boolean isReadable() {
		return (this.file.canRead() && !this.file.isDirectory());
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public URL getURL() throws IOException {
		return this.file.toURI().toURL();
	}

	@Override
	public URI getURI() throws IOException {
		return this.file.toURI();
	}

	@Override
	public File getFile() throws IOException {
		return this.file;
	}

}
