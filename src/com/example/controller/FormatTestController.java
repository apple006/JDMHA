package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.VO.Classes;
import com.example.VO.Student;
import com.http.beans.factory.config.ConfigurableXmlFormatFactory;

@Controller
@RequestMapping(value="test")
public class FormatTestController{

	@RequestMapping(value="formatTest")
	public void formatTest(){
		//测试EC0001
		formatTestEC0001();
		
		//测试EC1023
		formatTestEC1023();
	}

	private void formatTestEC1023() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tellNo", "90001");
		params.put("nodeNo", "#9001$");
		params.put("tranCode", "EC1023");
		
		Classes classes = new Classes("201601191234", "网络工程001");
		params.put("classes", classes);
		
		List<Map<String, Student>> studentes = new ArrayList<Map<String, Student>>();
		for(int i = 1 ;i <= 5 ; i++){
			Student student = new Student();
			student.setStudentId("201601190000" + i);
			student.setStudentName("chenssy_"+i);
			student.setStudentSex(i % 2 == 0 ? "1" : "2");
			student.setStudentBirthday("2016011" + i);
			Map<String, Student> map = new HashMap<>();
			map.put("student", student);
			studentes.add(map);
		}
		
		params.put("studentes", studentes);
		
		System.out.println(ConfigurableXmlFormatFactory.buildXmlStringFormFormat(params, "EC1023"));
	}

	private void formatTestEC0001() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tellNo", "90001");
		params.put("nodeNo", "#9001$");
		params.put("tranCode", "EC0001");
		params.put("objectId", "2016018171454534534534");
		params.put("tranType",1);
		params.put("submitTime", "2016018171454");
		
		System.out.println(ConfigurableXmlFormatFactory.buildXmlStringFormFormat(params, "EC0001"));
	}

}