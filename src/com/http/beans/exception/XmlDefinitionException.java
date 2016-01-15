package com.http.beans.exception;

@SuppressWarnings("serial")
public class XmlDefinitionException extends RuntimeException{
	public XmlDefinitionException(String msg){
		super();
	}
	
	public XmlDefinitionException(String msg,Throwable ex){
		super(msg, ex);
	}
	
}
