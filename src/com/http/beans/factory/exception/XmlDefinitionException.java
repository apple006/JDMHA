package com.http.beans.factory.exception;

@SuppressWarnings("serial")
public class XmlDefinitionException extends RuntimeException{
	public XmlDefinitionException(String msg){
		super();
	}
	
	public XmlDefinitionException(String msg,Throwable ex){
		super(msg, ex);
	}
	
}
