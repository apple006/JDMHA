package com.http.format.factory.exception;

@SuppressWarnings("serial")
public class XmlDefinitionException extends RuntimeException{
	private String fileName;
	
	private String xmlId;
	
	private String exceptionDescription;
	
	public XmlDefinitionException(String msg){
		super();
	}
	
	public XmlDefinitionException(String msg,Throwable ex){
		super(msg, ex);
	}
	
}
