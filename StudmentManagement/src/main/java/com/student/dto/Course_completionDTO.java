package com.student.dto;

import java.util.Date;



public class Course_completionDTO {

	
	
	private boolean course_completed;
	private boolean tc_issued;
	private Date tc_issued_date;

	
	
	
	/*
	 * private int student_id;
	 * 
	 * public int getStudent_id() { return student_id; }
	 * 
	 * public void setStudent_id(int student_id) { this.student_id = student_id; }
	 */
	 

	

	

	public Date getTc_issued_date() {
		return tc_issued_date;
	}

	public void setTc_issued_date(Date tc_issued_date) {
		this.tc_issued_date = tc_issued_date;
	}

	public boolean getCourse_completed() {
		return course_completed;
	}

	public void setCourse_completed(boolean course_completed) {
		this.course_completed = course_completed;
	}

	public boolean getTc_issued() {
		return tc_issued;
	}

	public void setTc_issued(boolean tc_issued) {
		this.tc_issued = tc_issued;
	}
}
