package com.http.utils;

import java.lang.reflect.Field;

public class XmlFormatUtils {
	
	/**
	 * 判断object是为对象、String还是基本类型
	 * @author:chenssy
	 * @data:2016年1月15日
	 *
	 * @param object
	 * @return
	 */
	public static boolean valueIsObject(Object object){
		boolean flag = true;
		if(object  instanceof String || object instanceof Integer || object instanceof Double ||
		   object instanceof Long || object instanceof Float ){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 获取对象的属性值
	 * @author:chenssy
	 * @data:2016年1月18日
	 *
	 * @param object		目标对象
	 * @param dataName		目标属性值
	 * @return
	 * @throws Exception 
	 */
	public static String getObjectValue(Object object,String dataName) throws Exception{
		Assert.notNull(dataName, "DataName must not be null");
		String value = "";
		Class<?> cls = object.getClass();
		//获取该对象的所有属性
		String name = null;
		Field[] fields = cls.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);		//设置可以访问
			name = field.getName();		//属性的名称
			if(name.equals(dataName)){
				try {
					value = String.valueOf(field.get(object));
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return value;
	}
}
