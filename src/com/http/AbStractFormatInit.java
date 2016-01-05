package com.http;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AbStractFormatInit extends ContextLoaderListener{
private	final Logger logger = Logger.getLogger(AbStractFormatInit.class);
	
	private static ApplicationContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent context) {
		try {
			super.contextInitialized(context);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		setContext(WebApplicationContextUtils.getRequiredWebApplicationContext(context.getServletContext()));
	
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
}
