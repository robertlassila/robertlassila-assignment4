package com.coderscampus.assignment4;

public class Student {
	private String id;
	private String name;
	private String course;
	private String grade;
	
	private String courseAbbreviation;
	private String courseNumber;
	
	public Student(String id, String name, String course, String grade) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
	
	public String getDetails() {
		return id + " " + name + " " +  course + " " + grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourseAbbreviation() {
		return courseAbbreviation;
	}
	public void setCourseAbbreviation(String courseAbbreviation) {
		this.courseAbbreviation = courseAbbreviation;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
}
