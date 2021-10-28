package com.student.dto;

import java.util.Date;

public class Student_ReportDTO {
	
   private String student_name;
	
	public String getStudent_name() {
	return student_name;
}

public void setStudent_name(String student_name) {
	this.student_name = student_name;
}

public String getFather_name() {
	return father_name;
}

public void setFather_name(String father_name) {
	this.father_name = father_name;
}

public String getUid_no() {
	return uid_no;
}

public void setUid_no(String uid_no) {
	this.uid_no = uid_no;
}

public String getCourse_name() {
	return course_name;
}

public void setCourse_name(String course_name) {
	this.course_name = course_name;
}

public String getBranch_name() {
	return branch_name;
}

public void setBranch_name(String branch_name) {
	this.branch_name = branch_name;
}

public String getMedium_name() {
	return medium_name;
}

public void setMedium_name(String medium_name) {
	this.medium_name = medium_name;
}

public String getGender_name() {
	return gender_name;
}

public void setGender_name(String gender_name) {
	this.gender_name = gender_name;
}

public int getAdmission_year() {
	return admission_year;
}

public void setAdmission_year(int admission_year) {
	this.admission_year = admission_year;
}

public Date getRegistered_on() {
	return registered_on;
}

public void setRegistered_on(Date registered_on) {
	this.registered_on = registered_on;
}

	private String father_name;
	
	private String uid_no;
	
	private String course_name;
	
	private String branch_name;
	
	private String medium_name;
	
	
	private String gender_name;
	
	private int admission_year;
	
	private Date registered_on;
	
	
	
}
