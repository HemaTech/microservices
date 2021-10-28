package com.student.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Course_completion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*
	 * public Course_completion() {
	 * 
	 * } public Course_completion(int id, boolean course_completed, boolean
	 * tc_issued, Date tc_issued_date) {
	 * 
	 * this.id = id; this.course_completed = course_completed; this.tc_issued =
	 * tc_issued; this.tc_issued_date = tc_issued_date;
	 * 
	 * }
	 */
	
	private boolean course_completed;
	private boolean tc_issued;
	private Date tc_issued_date;
  
	
	
	  
	/*
	 * @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "student_id", nullable = false ) private Student student;
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public boolean isCourse_completed() {
		return course_completed;
	}

	public void setCourse_completed(boolean course_completed) {
		this.course_completed = course_completed;
	}

	public boolean isTc_issued() {
		return tc_issued;
	}

	public void setTc_issued(boolean tc_issued) {
		this.tc_issued = tc_issued;
	}

	public Date getTc_issued_date() {
		return tc_issued_date;
	}

	public void setTc_issued_date(Date tc_issued_date) {
		this.tc_issued_date = tc_issued_date;
	}

	

	/*
	 * public Student getStudent() { return student; }
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 */
}
