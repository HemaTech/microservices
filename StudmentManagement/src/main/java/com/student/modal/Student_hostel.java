package com.student.modal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Columns;
@Entity
public class Student_hostel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date availed_from;
	private Date discontinued_on;
	@Column(nullable = false,columnDefinition = "int default 0")
	private int hostel_fee;
	
	@Column(nullable = false,columnDefinition = "int default 0")
	private int hostel_prev_fee;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Date getAvailed_from() {
		return availed_from;
	}

	public void setAvailed_from(Date availed_from) {
		this.availed_from = availed_from;
	}

	public Date getDiscontinued_on() {
		return discontinued_on;
	}

	public void setDiscontinued_on(Date discontinued_on) {
		this.discontinued_on = discontinued_on;
	}

	public int getHostel_fee() {
		return hostel_fee;
	}

	public void setHostel_fee(int hostel_fee) {
		this.hostel_fee = hostel_fee;
	}

	public int getHostel_prev_fee() {
		return hostel_prev_fee;
	}

	public void setHostel_prev_fee(int hostel_prev_fee) {
		this.hostel_prev_fee = hostel_prev_fee;
	}
}
