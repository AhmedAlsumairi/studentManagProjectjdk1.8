package com.student.beans;
public class Student {
	private int studentID;
	private String name;
	private Studentmarks[] studentmarks;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Studentmarks[] getStudentmarks() {
		return studentmarks;
	}
	public void setStudentmarks(Studentmarks[] studentmarks) {
		this.studentmarks = studentmarks;
	}
}
