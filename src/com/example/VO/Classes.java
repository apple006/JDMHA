package com.example.VO;

public class Classes {
	private String classId;
	private String className;
	
	public Classes(String classId,String className){
		this.classId = classId;
		this.className = className;
	}
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
