package com.http.format.factory.exception;

@SuppressWarnings("serial")
public class XmlDefinitionException extends RuntimeException{
	private String fileName;
	
	private String xmlId;
	
	private String exceptionDescription;
	
	XmlDefinitionException(String msg){
		super();
	}
	
	XmlDefinitionException(String msg,Throwable ex){
		super(msg, ex);
	}
	
}
