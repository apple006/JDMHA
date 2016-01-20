package com.http.beans.factory.format;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.StringUtils;

import com.http.beans.bean.XMLDataTag;
import com.http.beans.bean.XMLFormatElement;
import com.http.beans.bean.XmlField;
import com.http.beans.bean.XmlListField;
import com.http.beans.factory.config.ConfigurableDefaultXmlBeanFactory;
import com.http.utils.XmlFormatUtils;

/**
 * 报文模板和报文之间相互转化<br>
 * 实现原理：<br>
 * <li>根据XMLBeanName获取从容器池中获取相应的XMLDefinition</li>
 * <li>根据传入的参数(hashMap)和相应的XMLDefinition模板，根据反射构建相应的xml 报文模板</li>
 * <li>xmlFmtElement标签定义format</li>
 * <li>xmlHead定义报文头</li>
 * <li>xmlDataTag定义数据列。里面包含了XMLField、xmlListField</li>
 * <li>xmlField定义一个原子的xml标签域。其中dataName表示获取对象值的方法，tagName是xml中相应的标签名，className是HashMap中对应的Key</li>
 * <li>xmlListField定义集合数据列，一个XmlListField中包含多个XMLFiled和多个XmlListField</li>
 *
 * @Project:JDMHA
 * @file:XmlFormatFactory.java
 *
 * @Author:chenssy
 * @email:chenssy995812509@163.com
 * @url : <a href="http://cmsblogs.com">http://cmsblogs.com</a>
 * @qq : 122448894
 *
 * @data:2016年1月15日
 */
public class XmlFormatFactory {
	private Logger logger = Logger.getLogger(XmlFormatFactory.class);
	
	private static XmlFormatFactory formatFactory;
	
	private XmlFormatFactory(){
	}
	
	public static XmlFormatFactory getInstance(){
		if(formatFactory == null){
			synchronized (XmlFormatFactory.class) {
				formatFactory = new XmlFormatFactory();
			}
		}
		
		return formatFactory;
	}
	
	public Document buildXmlFormFormat(Map<String, Object> params,String definitionName){
		//获取发送模板文件
		XMLFormatElement element = ConfigurableDefaultXmlBeanFactory.getXmlFormatElement(definitionName ,"Send");
		//创建Document文档
		Document document = DocumentHelper.createDocument();
		//设置文档编码
		String encoding = StringUtils.isEmpty(element.getXmlHead().getEncoding()) ? element.getXmlHead().getEncoding() : "GBK";
		document.setXMLEncoding(encoding);
		
		//提取模板的数据标签xmlDataTag
		XMLDataTag dataTag = element.getXmlDataTag();
		//加入根元素
		Element root = document.addElement(dataTag.getName());
		
		//解析数据标签，根据传入的参数params和相应的模板构建xml
		buildXmlDataTagFormat(dataTag,params,root);
		
		return document;
	}

	/**
	 * 解析数据标签，依照数据标签和参数构建xml<br>
	 * 因为XMLDataTag标签已经在解析XMLDataTag之间创建，所以解析时只需要解析XMLDataTag下面的节点即可<br>
	 * 在数据标签中主要有两类标签：基本数据列XMLField、集合数据列XMLListField。所以先解析XMLField然后在解析XMLListField<br>
	 * 对于基本数据列而言，其解析过程较为简单；但是对于集合数据列而言就稍微复杂些。集合数据列一般都是由第二层的xmlDataTag包裹着，
	 * 其标签为XMLList，所以在解析过程中需要先获取第二层的XmlDataTag
	 * @author:chenssy
	 * @data:2016年1月15日
	 *
	 * @param dataTag
	 * @param params
	 * @param root
	 */
	private void buildXmlDataTagFormat(XMLDataTag dataTag,
			Map<String, Object> params, Element root) {
		
		//解析数据标签下所有的XMLField标签
		List<XmlField> xmlFields = dataTag.getXmlFields();
		formatXmlField(xmlFields,root,params);
		
		//解析数据标签下所有的xmlListField标签
		//xmlListField是包含在第二层的xmlDataTag里面的
		List<XMLDataTag> dataTags = dataTag.getXmlDataTags();
		formatXmlDataTags(dataTags,root,params);
	}
	
	/**
	 * 解析数据标签里面
	 * @author:chenssy
	 * @data:2016年1月19日
	 *
	 * @param dataTags
	 * @param root
	 * @param params
	 */
	@SuppressWarnings("unchecked")
	private void formatXmlDataTags(List<XMLDataTag> dataTags, Element root,
			Map<String, Object> params) {
		String tagName = null;		//标签名
		Element tagItem = null;		//标签
		List<XmlField> xmlFields = null;	//基本数据列
		List<XmlListField> xmlListFields = null;	//集合数据列
		List<XMLDataTag> xmlDataTags = null;		//数据标签
		List<Map<String, Object>> list = null;	//集合数据列的数据集
		for(XMLDataTag dataTag : dataTags){
			tagName = dataTag.getName();
			tagItem = root.addElement(tagName);
			
			//构建基本数据列
			xmlFields = dataTag.getXmlFields();
			formatXmlField(xmlFields, tagItem, params);
			
			//构建集合数据列
			xmlListFields = dataTag.getXmlListFields();
			for(XmlListField xmlListField : xmlListFields){
				list = (List<Map<String, Object>>) params.get(xmlListField.getClassName());
				formatXmlListField(xmlListField, tagItem, list);
			}
			
			//构建数据标签
			xmlDataTags = dataTag.getXmlDataTags();
			formatXmlDataTags(xmlDataTags,tagItem,params);
		}
	}

	/**
	 * 解析数据标签下的xmlField标签
	 * @author:chenssy
	 * @data:2016年1月18日
	 *
	 * @param xmlFields
	 * @param root
	 * @param params
	 */
	private void formatXmlField(List<XmlField> xmlFields, Element root,Map<String, Object> params) {
		String dataName = null;		//数据列明
		String tagName = null;		//xml标签名
		String className = null;	//对应的VO名
		String value = null;		//value值
		
		Element fieldItem = null;
		Object object = null;
		for(XmlField xmlField : xmlFields){
			//获取XMLField中的标签
			dataName = xmlField.getDataName();
			tagName = xmlField.getTagName();
			className = xmlField.getClassName();
			
			//新建一个节点
			fieldItem = root.addElement(tagName);
			//获取参数中className的值
			object = params.get(className);
			//获取属性值
			if(object == null){			//为null，表示没有该值，value设置为""
				value = "";
			}else if(!XmlFormatUtils.valueIsObject(object)){		//不是对象，转换为String
				value = String.valueOf(object);
			}else{		//对象，通过反射。这里object是一个对象，那么根据dataName来获取相应的属性值
				try {
					value = XmlFormatUtils.getObjectValue(object, dataName);
				} catch (Exception e) {
					logger.error("获取对象" + className + "的" + dataName + "属性值失败..");
				}
			}
			fieldItem.setText(value); 	//设置节点值
		}
	}

	/**
	 * 解析数据标签下所有的xmlListField标签
	 * @author:chenssy
	 * @data:2016年1月18日
	 *
	 * @param xmlListFields
	 * @param root
	 * @param params
	 */
	@SuppressWarnings("unchecked")
	private void formatXmlListFields(List<XmlListField> xmlListFields,
			Element root, Map<String, Object> params) {
		List<Map<String, Object>> list =  null;
		for(XmlListField xmlListField : xmlListFields){
			//获取参数中的className值，该值时一个list集合，一个元素代表了一个xmlListField
			list =  (List<Map<String, Object>>) params.get(xmlListField.getClassName());
			formatXmlListField(xmlListField,root,list);
		}
	}

	/**
	 * 根据参数list构建XMLListField标签
	 * @author:chenssy
	 * @data:2016年1月18日
	 *
	 * @param xmlListField
	 * @param root
	 * @param list
	 */
	private void formatXmlListField(XmlListField xmlListField, Element root,List<Map<String, Object>> list) {
		List<XmlField> xmlFields = null;
		List<XmlListField> xmlListFields = null; 
		Element tagElement = null; 	//element域
		for(Map<String, Object> map : list){
			tagElement = root.addElement(xmlListField.getTagName());		//添加循环域
			
			//获取所有的xmlField
			xmlFields = xmlListField.getXmlFields();
			formatXmlField(xmlFields, tagElement, map); 		//解析xmlField
			
			//获取所有的xmlListField
			xmlListFields = xmlListField.getXmlListFields();
			formatXmlListFields(xmlListFields, tagElement, map);
		}
	}
	
}