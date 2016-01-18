package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.http.beans.factory.format.XmlFormatFactory;

@Controller
@RequestMapping(value="test")
public class FormatTestController{

	@RequestMapping(value="formatTest")
	public void formatTest(){
		XmlFormatFactory factory = new XmlFormatFactory();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tellNo", "90001");
		params.put("nodeNo", "#9001$");
		params.put("tranCode", "EC0001");
		params.put("objectId", "2016018171454534534534");
		params.put("tranType",1);
		params.put("submitTime", "2016018171454");
		
		String xml = factory.buildXmlFormFormat(params, "EC0001");
		System.out.println(xml);
		
	}

}